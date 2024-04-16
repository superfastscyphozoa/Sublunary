package net.superfastscyphozoa.sublunary.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.FuzzyTargeting;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.superfastscyphozoa.sublunary.entity.variant.PasserineVariant;
import net.superfastscyphozoa.sublunary.registry.RegisterEntities;
import org.jetbrains.annotations.Nullable;

public class PasserineEntity extends AnimalEntity{
    private static final Ingredient TEMPT_INGREDIENT = Ingredient.ofItems(Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS);

    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState flyAnimationState = new AnimationState();
    public final AnimationState hopAnimationState = new AnimationState();

    public PasserineEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);

        this.moveControl = new FlightMoveControl(this, 10, false);
        this.setPathfindingPenalty(PathNodeType.DANGER_FIRE, -1.0F);
        this.setPathfindingPenalty(PathNodeType.DAMAGE_FIRE, -1.0F);
    }

    private void updateAnimations(){
        var idle = this.idleAnimationState;
        var fly = this.flyAnimationState;
        var hop = this.hopAnimationState;

        if (this.getY() == this.prevY) {
            if(this.getX() == this.prevX && this.getZ() == this.prevZ) {

                if (!idle.isAnimating()) {
                    idle.start(this.age);
                }
                if (fly.isAnimating() || hop.isAnimating()) {
                    fly.stop();
                    hop.stop();
                }

            } else {

                if (!hop.isAnimating()) {
                    hop.start(this.age);
                }
                if (fly.isAnimating() || idle.isAnimating()) {
                    fly.stop();
                    idle.stop();
                }
            }
        } else {

            if (!fly.isAnimating()) {
                fly.start(this.age);
            }
            if (idle.isAnimating() || hop.isAnimating()) {
                idle.stop();
                hop.stop();
            }
        }
    }

    @Override
    protected void updateLimbs(float posDelta) {

        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;

        this.limbData.updateLimbs(f, 0.3f);
    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient()){
            updateAnimations();
        }
    }

    @Override
    public void tickMovement() {
        super.tickMovement();

        Vec3d vec3d = this.getVelocity();
        if (!this.isOnGround() && vec3d.y < 0.0D) {
            this.setVelocity(vec3d.multiply(1.0D, 0.6D, 1.0D));
        }
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 1.25));
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.0));
        this.goalSelector.add(3, new TemptGoal(this, 1.2, TEMPT_INGREDIENT, false));
        this.goalSelector.add(4, new FollowParentGoal(this, 1.1));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6.0f));
        this.goalSelector.add(7, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createPasserineAttributes(){
        return MobEntity.createAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.1)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.4);
    }

    @Override
    protected EntityNavigation createNavigation(World world) {
        BirdNavigation birdNavigation = new BirdNavigation(this, world);
        birdNavigation.setCanPathThroughDoors(false);
        birdNavigation.setCanSwim(true);
        birdNavigation.setCanEnterOpenDoors(true);
        return birdNavigation;
    }

    @Override
    protected void fall(double heightDifference, boolean onGround, BlockState state, BlockPos landedPosition) {

    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.WHEAT_SEEDS);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        PasserineEntity baby = RegisterEntities.PASSERINE.create(world);
        PasserineVariant variant = Util.getRandom(PasserineVariant.values(), this.random);
        assert baby != null;
        baby.setVariant(variant);
        return baby;
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, nbt.getInt("Variant"));
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(DATA_ID_TYPE_VARIANT, 0);
    }

    //variants

    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(PasserineEntity.class, TrackedDataHandlerRegistry.INTEGER);

    @Override
    public EntityData initialize(
            ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        PasserineVariant variant = Util.getRandom(PasserineVariant.values(), this.random);
        setVariant(variant);
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }

    public PasserineVariant getVariant() {
        return PasserineVariant.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return this.dataTracker.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(PasserineVariant variant) {
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }
}

package net.superfastscyphozoa.sublunary.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import net.superfastscyphozoa.sublunary.registry.RegisterItems;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SkeletonEntity.class)
public abstract class SkeletonMixin extends AbstractSkeletonEntity {

    protected SkeletonMixin(EntityType<? extends AbstractSkeletonEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initEquipment(RandomGenerator random, LocalDifficulty localDifficulty) {
        if (random.nextFloat() > 0.75f){
			if (random.nextBoolean()){
				this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD));
			} else this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_AXE));
        } else this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
    }
}

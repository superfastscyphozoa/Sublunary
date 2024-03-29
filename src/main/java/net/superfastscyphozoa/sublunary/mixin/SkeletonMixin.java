package net.superfastscyphozoa.sublunary.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
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
    protected void initEquipment(Random random, LocalDifficulty localDifficulty) {
        if (random.nextFloat() > 0.75f){
            this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(RegisterItems.RUSTED_SWORD));
        } else this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
    }
}

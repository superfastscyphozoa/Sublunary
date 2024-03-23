package net.superfastscyphozoa.sublunary.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.superfastscyphozoa.sublunary.registry.RegisterItems;

public class FlourItem extends Item {

    public FlourItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {

        BlockHitResult blockHitResult = raycast(world, player, RaycastContext.FluidHandling.SOURCE_ONLY);
        ItemStack itemStack = player.getStackInHand(hand);

        if (blockHitResult.getType() != HitResult.Type.MISS) {

            if (blockHitResult.getType() == HitResult.Type.BLOCK) {

                BlockPos blockPos = blockHitResult.getBlockPos();

                if (!world.canPlayerModifyAt(player, blockPos)) {
                    return TypedActionResult.pass(itemStack);
                }

                if (world.getFluidState(blockPos).isIn(FluidTags.WATER)) {

                    world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_AXOLOTL_SPLASH, SoundCategory.NEUTRAL, 1.0F, 1.0F);

                    if (itemStack.getCount() != 1) {

                        itemStack.decrement(1);

                        if (!player.getInventory().insertStack(new ItemStack(RegisterItems.DOUGH))) {
                            player.dropItem(new ItemStack(RegisterItems.DOUGH), false);
                        }

                    }
                    else {

                        if (player.getInventory().contains(new ItemStack(RegisterItems.DOUGH))) {

                            itemStack.decrement(1);
                            player.getInventory().insertStack(new ItemStack(RegisterItems.DOUGH));

                        }
                        else {
                            player.setStackInHand(hand, new ItemStack(RegisterItems.DOUGH));
                        }
                    }

                    return TypedActionResult.success(itemStack);

                }
            }

        }
        return TypedActionResult.pass(itemStack);
    }
}
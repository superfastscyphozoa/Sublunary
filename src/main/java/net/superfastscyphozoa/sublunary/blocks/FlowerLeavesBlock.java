package net.superfastscyphozoa.sublunary.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;

public class FlowerLeavesBlock extends Block {
    public static final BooleanProperty LEAFFUL;

    public FlowerLeavesBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(LEAFFUL, false));
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return direction == Direction.UP ? (BlockState)state.with(LEAFFUL, areLeaves(neighborState)) : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos().up());
        return (BlockState)this.getDefaultState().with(LEAFFUL, areLeaves(blockState));
    }

    private static boolean areLeaves(BlockState state) {
        return state.isOf(null);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LEAFFUL);
    }

    static {
        LEAFFUL = SublunaryBlockProperties.LEAFFUL;
    }

}

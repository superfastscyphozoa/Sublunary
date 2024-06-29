package net.superfastscyphozoa.sublunary.blocks;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.block.sapling.SaplingBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;
import net.superfastscyphozoa.sublunary.util.SublunaryTags;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class HickoryNutBlock extends SaplingBlock {
	public static final MapCodec<HickoryNutBlock> CODEC = RecordCodecBuilder.mapCodec(objectInstance -> objectInstance.group(
			WoodTypes.CODEC.fieldOf("tree").forGetter((HickoryNutBlock b) -> b.generator),
			method_54096()
	).apply(objectInstance, HickoryNutBlock::new));

	public static final IntProperty AGE_4;
	public static final int MAX_AGE = 4;
	private static final VoxelShape[] SHAPES;
	public static final BooleanProperty HANGING;

	public MapCodec<HickoryNutBlock> getCodec() {
		return CODEC;
	}

	public HickoryNutBlock(WoodTypes generator, Settings settings) {
		super(generator, settings);
		this.setDefaultState(this.stateManager.getDefaultState().with(STAGE, 0).with(AGE_4, 0).with(HANGING, false));
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(new Property[]{STAGE}).add(new Property[]{AGE_4}).add(HANGING);
	}

	@Nullable
	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		return Objects.requireNonNull(super.getPlacementState(ctx)).with(AGE_4, 4);
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		Vec3d vec3d = state.getModelOffset(world, pos);
		VoxelShape voxelShape;
		if (!(Boolean)state.get(HANGING)) {
			voxelShape = SHAPES[4];
		} else {
			voxelShape = SHAPES[state.get(AGE_4)];
		}

		return voxelShape.offset(vec3d.x, vec3d.y, vec3d.z);
	}

	@Override
	public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
		return isHanging(state) ? world.getBlockState(pos.up()).isIn(SublunaryTags.Blocks.HICKORY_LEAVES) : super.canPlaceAt(state, world, pos);
	}

	@Override
	public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
		return direction == Direction.UP && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
	}

	@Override
	public void randomTick(BlockState state, ServerWorld world, BlockPos pos, RandomGenerator random) {
		if (!isHanging(state)) {
			if (random.nextInt(7) == 0) {
				this.generate(world, pos, state, random);
			}

		} else {
			if (isNotFullyGrown(state)) {
				world.setBlockState(pos, state.cycle(AGE_4), 2);
			}
		}
	}

	@Override
	public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
		return !isHanging(state) || isNotFullyGrown(state);
	}

	@Override
	public boolean canFertilize(World world, RandomGenerator random, BlockPos pos, BlockState state) {
		return isHanging(state) ? isNotFullyGrown(state) : super.canFertilize(world, random, pos, state);
	}

	@Override
	public void fertilize(ServerWorld world, RandomGenerator random, BlockPos pos, BlockState state) {
		if (isHanging(state) && isNotFullyGrown(state)) {
			world.setBlockState(pos, state.cycle(AGE_4), 2);
		} else {
			super.fertilize(world, random, pos, state);
		}
	}

	private static boolean isHanging(BlockState state) {
		return state.get(HANGING);
	}

	private static boolean isNotFullyGrown(BlockState state) {
		return state.get(AGE_4) != 4;
	}

	public static BlockState getHangingState() {
		return getHangingState(0);
	}

	public static BlockState getHangingState(int age) {
		return RegisterBlocks.HICKORY_NUT.getDefaultState().with(HANGING, true).with(AGE_4, age);
	}

	static {
		AGE_4 = Properties.AGE_4;
		SHAPES = new VoxelShape[]{
				Block.createCuboidShape(7.0D, 13.0D, 7.0D, 9.0D, 16.0D, 9.0D),
				Block.createCuboidShape(7.0D, 10.0D, 7.0D, 9.0D, 16.0D, 9.0D),
				Block.createCuboidShape(7.0D, 7.0D, 7.0D, 9.0D, 16.0D, 9.0D),
				Block.createCuboidShape(7.0D, 3.0D, 7.0D, 9.0D, 16.0D, 9.0D),
				Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D)};
		HANGING = Properties.HANGING;
	}
}

package net.superfastscyphozoa.sublunary.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.client.util.ParticleUtil;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;

public class HickoryLeavesBlock extends LeavesBlock implements Fertilizable {
	public static final MapCodec<HickoryLeavesBlock> CODEC = method_54094(HickoryLeavesBlock::new);

	public MapCodec<HickoryLeavesBlock> getCodec() {
		return CODEC;
	}

	public HickoryLeavesBlock(Settings settings) {
		super(settings);
	}

	@Override
	public void randomDisplayTick(BlockState state, World world, BlockPos pos, RandomGenerator random) {
		super.randomDisplayTick(state, world, pos, random);
		if(state.isOf(RegisterBlocks.AUTUMNAL_HICKORY_LEAVES)) {
			if (random.nextInt(10) == 0) {
				BlockPos blockPos = pos.down();
				BlockState blockState = world.getBlockState(blockPos);
				if (!isFaceFullSquare(blockState.getCollisionShape(world, blockPos), Direction.UP)) {
					ParticleUtil.spawnParticle(world, pos, random, ParticleTypes.CHERRY_LEAVES);
				}
			}
		}
	}

	@Override
	public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
		return world.getBlockState(pos.down()).isAir();
	}

	@Override
	public boolean canFertilize(World world, RandomGenerator random, BlockPos pos, BlockState state) {
		return true;
	}

	@Override
	public void fertilize(ServerWorld world, RandomGenerator random, BlockPos pos, BlockState state) {
		world.setBlockState(pos.down(), HickoryNutBlock.getHangingState(), 2);
	}
}

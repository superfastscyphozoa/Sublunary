package net.superfastscyphozoa.sublunary.world.tree.trunk;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class StraightBranchedTrunkPlacer extends TrunkPlacer {
    public static final Codec<StraightBranchedTrunkPlacer> CODEC = RecordCodecBuilder.create(objectInstance ->
            fillTrunkPlacerFields(objectInstance).apply(objectInstance, StraightBranchedTrunkPlacer::new));

    public StraightBranchedTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return SublunaryTrunkPlacerTypes.STRAIGHT_BRANCHED_TRUNK_PLACER;
    }

	@Override
	public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, RandomGenerator random, int height, BlockPos startPos, TreeFeatureConfig config) {
		setToDirt(world, replacer, random, startPos.down(), config);
		int height_ = height + random.range(0, firstRandomHeight) + random.range(0, secondRandomHeight);

		for(int i = 0; i < height_; i++) {
			this.placeTrunkBlock(world, replacer, random, startPos.up(i), config);

			int t = (height_ - 3);
			int l = (t % 2);

			if (l == 0 && random.nextBoolean()){

				if (random.nextFloat() > 0.75f){

					if (random.nextBoolean()) {
						if (random.nextBoolean()) {
							for (int x = 1; x <= 1; x++) {
								replacer.accept(startPos.up(i).offset(Direction.NORTH, x), (BlockState) Function.identity().apply(config.trunkProvider
										.getBlockState(random, startPos.up(i).offset(Direction.NORTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
							}
						} else {
							for (int x = 1; x <= 1; x++) {
								replacer.accept(startPos.up(i).offset(Direction.EAST, x), (BlockState) Function.identity().apply(config.trunkProvider
										.getBlockState(random, startPos.up(i).offset(Direction.EAST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
							}
						}
					} else {
						if (random.nextBoolean()) {
							for (int x = 1; x <= 1; x++) {
								replacer.accept(startPos.up(i).offset(Direction.SOUTH, x), (BlockState) Function.identity().apply(config.trunkProvider
										.getBlockState(random, startPos.up(i).offset(Direction.SOUTH, x)).with(PillarBlock.AXIS, Direction.Axis.Z)));
							}
						} else {
							for (int x = 1; x <= 1; x++) {
								replacer.accept(startPos.up(i).offset(Direction.WEST, x), (BlockState) Function.identity().apply(config.trunkProvider
										.getBlockState(random, startPos.up(i).offset(Direction.WEST, x)).with(PillarBlock.AXIS, Direction.Axis.X)));
							}
						}
					}
				}
			}
		}

		return ImmutableList.of(new FoliagePlacer.TreeNode(startPos.up(height_), 0, false));
	}
}

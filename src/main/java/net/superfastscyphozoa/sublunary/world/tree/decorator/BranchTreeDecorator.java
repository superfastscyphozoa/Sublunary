package net.superfastscyphozoa.sublunary.world.tree.decorator;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.Pair;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class BranchTreeDecorator extends TreeDecorator {
	public static final Codec<BranchTreeDecorator> CODEC = RecordCodecBuilder.create(objectInstance -> objectInstance.group(
			Codec.floatRange(0.0F, 1.0F).fieldOf("chance").forGetter((BranchTreeDecorator c) -> c.chance),
			BlockStateProvider.TYPE_CODEC.fieldOf("blockstate").forGetter((BranchTreeDecorator b) -> b.blockState),
			Codec.intRange(0, 15).fieldOf("lowestpos").forGetter((BranchTreeDecorator l) -> l.lowestPos)
	).apply(objectInstance, BranchTreeDecorator::new));

	private final float chance;
	private final BlockStateProvider blockState;
	private final int lowestPos;

	public BranchTreeDecorator(float chance, BlockStateProvider blockState, int lowestPos) {
		this.chance = chance;
		this.blockState = blockState;
		this.lowestPos = lowestPos;
	}

	@Override
	protected TreeDecoratorType<?> getType() {
		return SublunaryTreeDecoratorTypes.BRANCH_TREE_DECORATOR;
	}

	@Override
	public void generate(Placer placer) {
		RandomGenerator randomGenerator = placer.getRandom();
		if (!(randomGenerator.nextFloat() >= this.chance)) {

			final int[] amount = {1};

			List<BlockPos> list = placer.getLogPositions();
			int i = list.get(0).getY();

			list.stream().filter((pos) -> pos.getY() - i > randomGenerator.range(lowestPos, lowestPos+4)).forEach((pos) -> {

				for (Direction direction : Direction.Type.HORIZONTAL) {

					Direction direction2 = direction.getOpposite();
					BlockPos blockPos = pos.add(direction2.getOffsetX(), 0, direction2.getOffsetZ());

					boolean tooClose = !placer.isAir(blockPos.down()) || !placer.isAir(blockPos.up());

					if (placer.isAir(blockPos) && amount[0] <= 2 && !tooClose) {

						if (randomGenerator.nextBoolean() && randomGenerator.nextFloat() <= 0.25) {

							placer.replace(blockPos, this.blockState.getBlockState(placer.getRandom(), blockPos)
									.with(PillarBlock.AXIS, direction.getAxis()));

							amount[0]++;
						}
					}
				}
			});
		}
	}
}

package net.superfastscyphozoa.sublunary.world.tree.decorator;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.List;
import java.util.function.Function;

public class BranchTreeDecorator extends TreeDecorator {
	public static final Codec<BranchTreeDecorator> CODEC = RecordCodecBuilder.create(objectInstance -> objectInstance.group(
			Codec.floatRange(0.0F, 1.0F).fieldOf("chance").forGetter((BranchTreeDecorator c) -> c.chance),
			BlockStateProvider.TYPE_CODEC.fieldOf("blockstate").forGetter((BranchTreeDecorator b) -> b.blockState),
			Codec.intRange(0, 15).fieldOf("lowerpos").forGetter((BranchTreeDecorator l) -> l.lowerPos),
			Codec.intRange(0, 15).fieldOf("upperpos").forGetter((BranchTreeDecorator u) -> u.upperPos)
	).apply(objectInstance, BranchTreeDecorator::new));

	private final float chance;
	private final BlockStateProvider blockState;
	private final int lowerPos;
	private final int upperPos;

	public BranchTreeDecorator(float chance, BlockStateProvider blockState, int lowerPos, int upperPos) {
		this.chance = chance;
		this.blockState = blockState;
		this.lowerPos = lowerPos;
		this.upperPos = upperPos;
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
			list.stream().filter((pos) -> pos.getY() - i > randomGenerator.range(lowerPos, upperPos)).forEach((pos) -> {

				for (Direction direction : Direction.Type.HORIZONTAL) {
					if (randomGenerator.nextFloat() <= 0.25F) {

						Direction direction2 = direction.getOpposite();
						BlockPos blockPos = pos.add(direction2.getOffsetX(), 0, direction2.getOffsetZ());

						if (placer.isAir(blockPos) && amount[0] <= 1) {

							placer.replace(blockPos, this.blockState.getBlockState(placer.getRandom(), pos)
									.with(PillarBlock.AXIS, direction.getAxis()));

							amount[0] += 1;
						}
					}
				}
			});
		}
	}
}

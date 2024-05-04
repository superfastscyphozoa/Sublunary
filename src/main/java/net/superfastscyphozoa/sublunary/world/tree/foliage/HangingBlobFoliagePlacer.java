package net.superfastscyphozoa.sublunary.world.tree.foliage;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.util.math.int_provider.IntProvider;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.superfastscyphozoa.sublunary.world.tree.SublunaryFoliagePlacerTypes;


public class HangingBlobFoliagePlacer extends FoliagePlacer {
    public static final Codec<HangingBlobFoliagePlacer> CODEC = RecordCodecBuilder.create(hangingBlobFoliagePlacerInstance ->
            fillFoliagePlacerFields(hangingBlobFoliagePlacerInstance).and(Codec.intRange(0, 12).fieldOf("height")
                    .forGetter(instance -> instance.height)).apply(hangingBlobFoliagePlacerInstance, HangingBlobFoliagePlacer::new));
    private final int height;

    public HangingBlobFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return SublunaryFoliagePlacerTypes.HANGING_BLOB_FOLIAGE_PLACER;
    }

	@Override
	protected void method_23448(TestableWorld world, C_pwcqvmho placer, RandomGenerator random, TreeFeatureConfig treeFeatureConfig, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {
		for (int i = offset; i >= offset - foliageHeight; i--) {
			int j = Math.max(radius + treeNode.getFoliageRadius() - 1 - i / 2, 0);
			generateSquare(world, placer, random, treeFeatureConfig, treeNode.getCenter().up(0), j, i, treeNode.isGiantTrunk());
		}
		method_49247(world, placer, random, treeFeatureConfig, treeNode.getCenter().up(0), radius, offset - foliageHeight, treeNode.isGiantTrunk(),
				0.5f, 0f);
	}

	@Override
	public int getRandomHeight(RandomGenerator random, int trunkHeight, TreeFeatureConfig config) {
		return this.height;
	}

	@Override
	protected boolean isInvalidForLeaves(RandomGenerator random, int dx, int y, int dz, int radius, boolean giantTrunk) {
		return dx == radius && dz == radius && (random.nextInt(2) == 0 || y == 0);
	}
}

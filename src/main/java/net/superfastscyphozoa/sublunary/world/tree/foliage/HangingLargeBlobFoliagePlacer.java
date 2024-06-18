package net.superfastscyphozoa.sublunary.world.tree.foliage;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.int_provider.IntProvider;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.superfastscyphozoa.sublunary.world.tree.SublunaryFoliagePlacerTypes;


public class HangingLargeBlobFoliagePlacer extends FoliagePlacer {
    public static final Codec<HangingLargeBlobFoliagePlacer> CODEC = RecordCodecBuilder.create(hangingLargeBlobFoliagePlacerInstance ->
            fillFoliagePlacerFields(hangingLargeBlobFoliagePlacerInstance).and(Codec.intRange(0, 12).fieldOf("height")
                    .forGetter(instance -> instance.height)).apply(hangingLargeBlobFoliagePlacerInstance, HangingLargeBlobFoliagePlacer::new));
    private final int height;

    public HangingLargeBlobFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return SublunaryFoliagePlacerTypes.HANGING_LARGE_BLOB_FOLIAGE_PLACER;
    }

	@Override
	protected void method_23448(TestableWorld world, C_pwcqvmho placer, RandomGenerator random, TreeFeatureConfig treeFeatureConfig, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {
		for (int m = offset; m >= offset - foliageHeight; m--) {
			int n = radius + (m != offset && m != offset - foliageHeight ? 1 : 0);
			generateSquare(world, placer, random, treeFeatureConfig, treeNode.getCenter().up(0), n, m, treeNode.isGiantTrunk());
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
		return MathHelper.square((float)dx + 0.5F) + MathHelper.square((float)dz + 0.5F) > (float)(radius * radius);
	}
}

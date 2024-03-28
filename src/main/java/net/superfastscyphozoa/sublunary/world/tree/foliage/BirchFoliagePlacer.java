package net.superfastscyphozoa.sublunary.world.tree.foliage;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.superfastscyphozoa.sublunary.world.tree.SublunaryFoliagePlacerTypes;


public class BirchFoliagePlacer extends FoliagePlacer {
    public static final Codec<BirchFoliagePlacer> CODEC = RecordCodecBuilder.create(birchFoliagePlacerInstance ->
            fillFoliagePlacerFields(birchFoliagePlacerInstance).and(Codec.intRange(0, 12).fieldOf("height")
                    .forGetter(instance -> instance.height)).apply(birchFoliagePlacerInstance, BirchFoliagePlacer::new));
    private final int height;

    public BirchFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return SublunaryFoliagePlacerTypes.BIRCH_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {
        for (int i = offset; i >= offset - foliageHeight; --i) {
            int j = Math.max(radius + treeNode.getFoliageRadius() - 1 - i / 2, 0);
            generateSquareWithHangingLeaves(world, placer, random, config, treeNode.getCenter().up(0), j, i, treeNode.isGiantTrunk(),
                    0.5f, 0.5f);
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return this.height;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return dx == radius && dz == radius && (random.nextInt(2) == 0 || y == 0);
    }
}

package net.superfastscyphozoa.sublunary.world;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import static net.superfastscyphozoa.sublunary.world.SublunaryConfiguredFeatures.registerKey;

public class SubTreeConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?,?>> BIRCHIER_BIRCH_KEY = registerKey("birchier_birch");
    public static final RegistryKey<ConfiguredFeature<?,?>> OAKIER_OAK_KEY = registerKey("oakier_oak");

    public static void bootstrap(Registerable<ConfiguredFeature<?,?>> context) {
        //trees
        //vanilla trees
        SublunaryConfiguredFeatures.register(context, OAKIER_OAK_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.OAK_LOG),
                new LargeOakTrunkPlacer(4, 11, 0),
                BlockStateProvider.of(Blocks.OAK_LEAVES),
                new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(4), 4),
                new TwoLayersFeatureSize(0, 0, 0)).dirtProvider(BlockStateProvider.of(Blocks.ROOTED_DIRT)).forceDirt().build());

        SublunaryConfiguredFeatures.register(context, BIRCHIER_BIRCH_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.BIRCH_LOG),
                new StraightTrunkPlacer(5, 2, 6),
                BlockStateProvider.of(Blocks.BIRCH_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(0, 0, 0)).dirtProvider(BlockStateProvider.of(Blocks.ROOTED_DIRT)).forceDirt().build());

    }
}

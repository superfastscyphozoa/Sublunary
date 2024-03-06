package net.superfastscyphozoa.sublunary.world.feature.configured;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;
import java.util.OptionalInt;

import static net.superfastscyphozoa.sublunary.world.feature.configured.SublunaryConfiguredFeatures.registerKey;

public class SubTreeConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?,?>> OAKIER_OAK_KEY = registerKey("oakier_oak");
    public static final RegistryKey<ConfiguredFeature<?,?>> OAKIER_OAK_BEES = registerKey("oakier_oak_bees");

    public static final RegistryKey<ConfiguredFeature<?,?>> LARGE_OAKIER_OAK_KEY = registerKey("large_oakier_oak");
    public static final RegistryKey<ConfiguredFeature<?,?>> LARGE_OAKIER_OAK_BEES = registerKey("large_oakier_oak_bees");

    public static final RegistryKey<ConfiguredFeature<?,?>> BIRCHIER_BIRCH_KEY = registerKey("birchier_birch");
    public static final RegistryKey<ConfiguredFeature<?,?>> BIRCHIER_BIRCH_BEES = registerKey("birchier_birch_bees");

    public static final RegistryKey<ConfiguredFeature<?,?>> SUPER_BIRCHIER_BIRCH_KEY = registerKey("super_birchier_birch");
    public static final RegistryKey<ConfiguredFeature<?,?>> SUPER_BIRCHIER_BIRCH_BEES = registerKey("super_birchier_birch_bees");

    private static TreeFeatureConfig.Builder oak() {
        return (new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.OAK_LOG),
                new StraightTrunkPlacer(6, 2, 0),
                BlockStateProvider.of(Blocks.OAK_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(0, 0, 0))
                .dirtProvider(BlockStateProvider.of(Blocks.ROOTED_DIRT)).forceDirt());
    }

    private static TreeFeatureConfig.Builder birch() {
        return (new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.BIRCH_LOG),
                new StraightTrunkPlacer(6, 4, 0),
                BlockStateProvider.of(Blocks.BIRCH_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(0, 0, 0))
                .dirtProvider(BlockStateProvider.of(Blocks.ROOTED_DIRT)).forceDirt());
    }

    private static TreeFeatureConfig.Builder superBirch() {
        return (new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.BIRCH_LOG),
                new StraightTrunkPlacer(6, 2, 5),
                BlockStateProvider.of(Blocks.BIRCH_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(0, 0, 0))
                .dirtProvider(BlockStateProvider.of(Blocks.ROOTED_DIRT)).forceDirt());
    }

    private static TreeFeatureConfig.Builder fancyOak() {
        return (new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.OAK_LOG),
                new LargeOakTrunkPlacer(4, 11, 0),
                BlockStateProvider.of(Blocks.OAK_LEAVES),
                new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))))
                .ignoreVines().dirtProvider(BlockStateProvider.of(Blocks.ROOTED_DIRT)).forceDirt();
    }

    public static void bootstrap(Registerable<ConfiguredFeature<?,?>> context) {

        //beehives
        BeehiveTreeDecorator beehiveTreeDecorator = new BeehiveTreeDecorator(0.04F);

        //trees
        //vanilla trees
        SublunaryConfiguredFeatures.register(context, OAKIER_OAK_KEY, Feature.TREE, oak().build());
        SublunaryConfiguredFeatures.register(context, OAKIER_OAK_BEES, Feature.TREE, oak().decorators(List.of(beehiveTreeDecorator)).build());

        SublunaryConfiguredFeatures.register(context, LARGE_OAKIER_OAK_KEY, Feature.TREE, fancyOak().build());
        SublunaryConfiguredFeatures.register(context, LARGE_OAKIER_OAK_BEES, Feature.TREE, fancyOak().decorators(List.of(beehiveTreeDecorator)).build());

        SublunaryConfiguredFeatures.register(context, BIRCHIER_BIRCH_KEY, Feature.TREE, birch().build());
        SublunaryConfiguredFeatures.register(context, BIRCHIER_BIRCH_BEES, Feature.TREE, birch().decorators(List.of(beehiveTreeDecorator)).build());

        SublunaryConfiguredFeatures.register(context, SUPER_BIRCHIER_BIRCH_KEY, Feature.TREE, superBirch().build());
        SublunaryConfiguredFeatures.register(context, SUPER_BIRCHIER_BIRCH_BEES, Feature.TREE, superBirch().decorators(ImmutableList.of(beehiveTreeDecorator)).build());
    }
}

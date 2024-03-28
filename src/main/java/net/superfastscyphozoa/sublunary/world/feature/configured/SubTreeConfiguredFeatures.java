package net.superfastscyphozoa.sublunary.world.feature.configured;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.superfastscyphozoa.sublunary.world.tree.foliage.BirchFoliagePlacer;
import net.superfastscyphozoa.sublunary.world.tree.trunk.StraightBranchedTrunkPlacer;

import java.util.List;
import java.util.OptionalInt;

import static net.superfastscyphozoa.sublunary.world.feature.configured.SublunaryConfiguredFeatures.registerKey;

public class SubTreeConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?,?>> OAKIER_OAK = registerKey("oakier_oak");
    public static final RegistryKey<ConfiguredFeature<?,?>> LARGE_OAKIER_OAK = registerKey("large_oakier_oak");
    public static final RegistryKey<ConfiguredFeature<?,?>> BIRCHIER_BIRCH = registerKey("birchier_birch");

    public static final RegistryKey<ConfiguredFeature<?,?>> SMALL_OAK = registerKey("small_oak");
    public static final RegistryKey<ConfiguredFeature<?,?>> SMALL_BIRCH = registerKey("small_birch");

    public static final RegistryKey<ConfiguredFeature<?,?>> FOREST_OAK = registerKey("forest_oak");
    public static final RegistryKey<ConfiguredFeature<?,?>> LARGE_FOREST_OAK = registerKey("large_forest_oak");
    public static final RegistryKey<ConfiguredFeature<?,?>> FOREST_BIRCH = registerKey("forest_birch");

    public static final RegistryKey<ConfiguredFeature<?,?>> FLOWER_FOREST_OAK = registerKey("flower_forest_oak");
    public static final RegistryKey<ConfiguredFeature<?,?>> LARGE_FLOWER_FOREST_OAK = registerKey("large_flower_forest_oak");
    public static final RegistryKey<ConfiguredFeature<?,?>> FLOWER_FOREST_BIRCH = registerKey("flower_forest_birch");

    public static final RegistryKey<ConfiguredFeature<?,?>> PLAINS_OAK = registerKey("plains_oak");
    public static final RegistryKey<ConfiguredFeature<?,?>> LARGE_PLAINS_OAK = registerKey("large_plains_oak");

    public static final RegistryKey<ConfiguredFeature<?,?>> OLD_GROWTH_BIRCH = registerKey("old_growth_birch");

    public static final RegistryKey<ConfiguredFeature<?,?>> MEADOW_OAK = registerKey("meadow_oak");
    public static final RegistryKey<ConfiguredFeature<?,?>> MEADOW_BIRCH = registerKey("meadow_birch");

    public static final RegistryKey<ConfiguredFeature<?,?>> VINY_OAK = registerKey("viny_oak");
    public static final RegistryKey<ConfiguredFeature<?,?>> LARGE_VINY_OAK = registerKey("large_viny_oak");
    public static final RegistryKey<ConfiguredFeature<?,?>> VINY_BIRCH = registerKey("viny_birch");
    public static final RegistryKey<ConfiguredFeature<?,?>> VINY_OLD_GROWTH_BIRCH = registerKey("viny_old_growth_birch");

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
                new StraightBranchedTrunkPlacer(6, 3, 0),
                BlockStateProvider.of(Blocks.BIRCH_LEAVES),
                new BirchFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(0, 0, 0))
                .dirtProvider(BlockStateProvider.of(Blocks.ROOTED_DIRT)).forceDirt());
    }

    private static TreeFeatureConfig.Builder superBirch() {
        return (new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.BIRCH_LOG),
                new StraightBranchedTrunkPlacer(7, 3, 5),
                BlockStateProvider.of(Blocks.BIRCH_LEAVES),
                new BirchFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
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
        BeehiveTreeDecorator ForestBeehive = new BeehiveTreeDecorator(0.004F);
        BeehiveTreeDecorator FlowerForestBeehive = new BeehiveTreeDecorator(0.02F);
        BeehiveTreeDecorator PlainsBeehive = new BeehiveTreeDecorator(0.05F);
        BeehiveTreeDecorator MeadowBeehive = new BeehiveTreeDecorator(1.0F);

        //trees
        SublunaryConfiguredFeatures.register(context, OAKIER_OAK, Feature.TREE, oak().build());
        SublunaryConfiguredFeatures.register(context, LARGE_OAKIER_OAK, Feature.TREE, fancyOak().build());
        SublunaryConfiguredFeatures.register(context, BIRCHIER_BIRCH, Feature.TREE, birch().build());

        SublunaryConfiguredFeatures.register(context, SMALL_OAK, Feature.TREE, (new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.OAK_LOG),
                new StraightTrunkPlacer(4, 2, 0),
                BlockStateProvider.of(Blocks.OAK_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(0, 0, 0))
                .dirtProvider(BlockStateProvider.of(Blocks.ROOTED_DIRT)).forceDirt()).build());

        SublunaryConfiguredFeatures.register(context, SMALL_BIRCH, Feature.TREE, (new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.BIRCH_LOG),
                new StraightTrunkPlacer(6, 1, 0),
                BlockStateProvider.of(Blocks.BIRCH_LEAVES),
                new BirchFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(0, 0, 0))
                .dirtProvider(BlockStateProvider.of(Blocks.ROOTED_DIRT)).forceDirt()).build());

        SublunaryConfiguredFeatures.register(context, FOREST_OAK, Feature.TREE, oak().decorators(List.of(ForestBeehive)).build());
        SublunaryConfiguredFeatures.register(context, LARGE_FOREST_OAK, Feature.TREE, fancyOak().decorators(List.of(ForestBeehive)).build());
        SublunaryConfiguredFeatures.register(context, FOREST_BIRCH, Feature.TREE, birch().decorators(List.of(ForestBeehive)).build());

        SublunaryConfiguredFeatures.register(context, FLOWER_FOREST_OAK, Feature.TREE, oak().decorators(List.of(FlowerForestBeehive)).build());
        SublunaryConfiguredFeatures.register(context, LARGE_FLOWER_FOREST_OAK, Feature.TREE, fancyOak().decorators(List.of(FlowerForestBeehive)).build());
        SublunaryConfiguredFeatures.register(context, FLOWER_FOREST_BIRCH, Feature.TREE, birch().decorators(List.of(FlowerForestBeehive)).build());

        SublunaryConfiguredFeatures.register(context, PLAINS_OAK, Feature.TREE, oak().decorators(List.of(PlainsBeehive)).build());
        SublunaryConfiguredFeatures.register(context, LARGE_PLAINS_OAK, Feature.TREE, fancyOak().decorators(List.of(PlainsBeehive)).build());

        SublunaryConfiguredFeatures.register(context, OLD_GROWTH_BIRCH, Feature.TREE, superBirch().decorators(List.of(FlowerForestBeehive)).build());

        SublunaryConfiguredFeatures.register(context, MEADOW_OAK, Feature.TREE, fancyOak().decorators(List.of(MeadowBeehive)).build());
        SublunaryConfiguredFeatures.register(context, MEADOW_BIRCH, Feature.TREE, superBirch().decorators(List.of(MeadowBeehive)).build());

        //tree variants
        SublunaryConfiguredFeatures.register(context, VINY_OAK, Feature.TREE, oak().decorators(List.of(TrunkVineTreeDecorator.INSTANCE)).build());
        SublunaryConfiguredFeatures.register(context, LARGE_VINY_OAK, Feature.TREE, fancyOak().decorators(List.of(TrunkVineTreeDecorator.INSTANCE)).build());
        SublunaryConfiguredFeatures.register(context, VINY_BIRCH, Feature.TREE, birch().decorators(List.of(TrunkVineTreeDecorator.INSTANCE)).build());
        SublunaryConfiguredFeatures.register(context, VINY_OLD_GROWTH_BIRCH, Feature.TREE, superBirch().decorators(List.of(TrunkVineTreeDecorator.INSTANCE)).build());

    }
}

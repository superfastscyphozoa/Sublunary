package net.superfastscyphozoa.sublunary.world.feature.configured;

import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.int_provider.ConstantIntProvider;
import net.minecraft.util.math.int_provider.IntProvider;
import net.minecraft.util.math.int_provider.UniformIntProvider;
import net.minecraft.util.math.int_provider.WeightedListIntProvider;
import net.minecraft.world.gen.BootstrapContext;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.ThreeLayersFeatureSize;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.trunk.CherryTrunkPlacer;
import net.minecraft.world.gen.trunk.DarkOakTrunkPlacer;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;
import net.superfastscyphozoa.sublunary.world.tree.foliage.HangingBlobFoliagePlacer;
import net.superfastscyphozoa.sublunary.world.tree.trunk.StraightBranchedTrunkPlacer;

import java.util.List;
import java.util.OptionalInt;

import static net.superfastscyphozoa.sublunary.world.feature.configured.SublunaryConfiguredFeatures.registerKey;

public class SubTreeConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?,?>> OAK = registerKey("oak");
    public static final RegistryKey<ConfiguredFeature<?,?>> LARGE_OAK = registerKey("large_oak");
    public static final RegistryKey<ConfiguredFeature<?,?>> BIRCH = registerKey("birch");

    public static final RegistryKey<ConfiguredFeature<?,?>> FOREST_OAK = registerKey("forest_oak");
    public static final RegistryKey<ConfiguredFeature<?,?>> LARGE_FOREST_OAK = registerKey("large_forest_oak");
    public static final RegistryKey<ConfiguredFeature<?,?>> FOREST_BIRCH = registerKey("forest_birch");

    public static final RegistryKey<ConfiguredFeature<?,?>> HICKORY = registerKey("hickory");

    public static final RegistryKey<ConfiguredFeature<?,?>> FLOWER_FOREST_OAK = registerKey("flower_forest_oak");
    public static final RegistryKey<ConfiguredFeature<?,?>> LARGE_FLOWER_FOREST_OAK = registerKey("large_flower_forest_oak");
    public static final RegistryKey<ConfiguredFeature<?,?>> FLOWER_FOREST_BIRCH = registerKey("flower_forest_birch");

    public static final RegistryKey<ConfiguredFeature<?,?>> PLAINS_OAK = registerKey("plains_oak");
    public static final RegistryKey<ConfiguredFeature<?,?>> LARGE_PLAINS_OAK = registerKey("large_plains_oak");

    public static final RegistryKey<ConfiguredFeature<?,?>> OLD_GROWTH_BIRCH = registerKey("old_growth_birch");

    public static final RegistryKey<ConfiguredFeature<?,?>> MEADOW_OAK = registerKey("meadow_oak");
    public static final RegistryKey<ConfiguredFeature<?,?>> MEADOW_BIRCH = registerKey("meadow_birch");

    public static final RegistryKey<ConfiguredFeature<?,?>> DARK_OAK = registerKey("dark_oak");

    public static final RegistryKey<ConfiguredFeature<?,?>> SPRUCE_FULL = registerKey("spruce_full");
    public static final RegistryKey<ConfiguredFeature<?,?>> SPRUCE_SPARSE = registerKey("spruce_sparse");
    public static final RegistryKey<ConfiguredFeature<?,?>> DYING_SPRUCE = registerKey("dying_spruce");

    public static final RegistryKey<ConfiguredFeature<?,?>> VINY_OAK = registerKey("viny_oak");
    public static final RegistryKey<ConfiguredFeature<?,?>> LARGE_VINY_OAK = registerKey("large_viny_oak");

    public static final RegistryKey<ConfiguredFeature<?,?>> VINY_BIRCH = registerKey("viny_birch");
    public static final RegistryKey<ConfiguredFeature<?,?>> VINY_OLD_GROWTH_BIRCH = registerKey("viny_old_growth_birch");

    public static final RegistryKey<ConfiguredFeature<?,?>> VINY_DARK_OAK = registerKey("viny_dark_oak");

    public static final RegistryKey<ConfiguredFeature<?,?>> VINY_SPRUCE = registerKey("viny_spruce");

    private static TreeFeatureConfig.Builder oak() {
        return (new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.OAK_LOG),
                new StraightTrunkPlacer(4, 4, 0),
                BlockStateProvider.of(Blocks.OAK_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(0, 0, 0)).forceDirt());
    }

    private static TreeFeatureConfig.Builder birch() {
        return (new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.BIRCH_LOG),
                new StraightTrunkPlacer(6, 5, 3),
                BlockStateProvider.of(Blocks.BIRCH_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(0, 0, 0)).forceDirt());
    }

    private static TreeFeatureConfig.Builder superBirch() {
        return (new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.BIRCH_LOG),
                new StraightTrunkPlacer(9, 6, 2),
                BlockStateProvider.of(Blocks.BIRCH_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(0, 0, 0))
                .dirtProvider(BlockStateProvider.of(Blocks.ROOTED_DIRT)).forceDirt());
    }

    private static TreeFeatureConfig.Builder fancyOak() {
		return (new TreeFeatureConfig.Builder(
				BlockStateProvider.of(Blocks.OAK_LOG),
				new LargeOakTrunkPlacer(6, 12, 0),
				BlockStateProvider.of(Blocks.OAK_LEAVES),
				new CherryFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(1), ConstantIntProvider.create(5),
						0.25F, 0.5F, 0.16666667F, 0.33333334F),
				new TwoLayersFeatureSize(1, 0, 2)))
				.ignoreVines().dirtProvider(BlockStateProvider.of(Blocks.ROOTED_DIRT)).forceDirt();
    }

	private static TreeFeatureConfig.Builder fancyOak2() {
		return (new TreeFeatureConfig.Builder(
				BlockStateProvider.of(Blocks.OAK_LOG),
				new LargeOakTrunkPlacer(4, 11, 0),
				BlockStateProvider.of(Blocks.OAK_LEAVES),
				new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(4), 4),
				new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))))
				.ignoreVines().dirtProvider(BlockStateProvider.of(Blocks.ROOTED_DIRT)).forceDirt();
	}

    private static TreeFeatureConfig.Builder hickory() {
        return (new TreeFeatureConfig.Builder(
                BlockStateProvider.of(RegisterBlocks.HICKORY_LOG),
                new LargeOakTrunkPlacer(6, 12, 0),
                BlockStateProvider.of(RegisterBlocks.HICKORY_LEAVES),
                new CherryFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(1), ConstantIntProvider.create(5),
                        0.25F, 0.5F, 0.16666667F, 0.33333334F),
                new TwoLayersFeatureSize(1, 0, 2)))
                .ignoreVines().dirtProvider(BlockStateProvider.of(Blocks.ROOTED_DIRT)).forceDirt();
    }

    private static TreeFeatureConfig.Builder dark_oak() {
        return (new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.DARK_OAK_LOG),
                new DarkOakTrunkPlacer(8, 3, 1),
                BlockStateProvider.of(Blocks.DARK_OAK_LEAVES),
                new DarkOakFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0)),
                new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())))
                .ignoreVines().dirtProvider(BlockStateProvider.of(Blocks.ROOTED_DIRT));
    }

    private static TreeFeatureConfig.Builder spruce_sparse() {
        return (new TreeFeatureConfig.Builder(
            BlockStateProvider.of(Blocks.SPRUCE_LOG),
            new StraightTrunkPlacer(2, 7, 0),
                BlockStateProvider.of(Blocks.SPRUCE_LEAVES),
            new PineFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(1), UniformIntProvider.create(3, 4)),
            new TwoLayersFeatureSize(2, 0, 2)))
            .ignoreVines();
    }

    private static TreeFeatureConfig.Builder cherry() {
        return (new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.CHERRY_LOG),
                new CherryTrunkPlacer(7, 1, 0,
                        new WeightedListIntProvider(new DataPool.Builder<IntProvider>().method_34975(ConstantIntProvider.create(2), 1)
                                .method_34975(ConstantIntProvider.create(3), 1).build()),
                        UniformIntProvider.create(2, 4), UniformIntProvider.create(-4, -3), UniformIntProvider.create(-1, 0)),
                BlockStateProvider.of(Blocks.CHERRY_LEAVES),
                new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(5),
                        0.25F, 0.5F, 0.16666667F, 0.33333334F),
                new TwoLayersFeatureSize(1, 0, 2)))
                .ignoreVines();
    }

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        //beehives
        BeehiveTreeDecorator ForestBeehive = new BeehiveTreeDecorator(0.004F);
        BeehiveTreeDecorator FlowerForestBeehive = new BeehiveTreeDecorator(0.02F);
        BeehiveTreeDecorator PlainsBeehive = new BeehiveTreeDecorator(0.05F);
        BeehiveTreeDecorator MeadowBeehive = new BeehiveTreeDecorator(1.0F);

        //trees
        SublunaryConfiguredFeatures.register(context, OAK, Feature.TREE, oak().build());
        SublunaryConfiguredFeatures.register(context, LARGE_OAK, Feature.TREE, fancyOak().build());
        SublunaryConfiguredFeatures.register(context, BIRCH, Feature.TREE, birch().build());

        SublunaryConfiguredFeatures.register(context, FOREST_OAK, Feature.TREE, oak().decorators(List.of(ForestBeehive)).build());
        SublunaryConfiguredFeatures.register(context, LARGE_FOREST_OAK, Feature.TREE, fancyOak().decorators(List.of(ForestBeehive)).build());
        SublunaryConfiguredFeatures.register(context, FOREST_BIRCH, Feature.TREE, birch().decorators(List.of(ForestBeehive)).build());

        SublunaryConfiguredFeatures.register(context, HICKORY, Feature.TREE, hickory().build());

        SublunaryConfiguredFeatures.register(context, FLOWER_FOREST_OAK, Feature.TREE, oak().decorators(List.of(FlowerForestBeehive)).build());
        SublunaryConfiguredFeatures.register(context, LARGE_FLOWER_FOREST_OAK, Feature.TREE, fancyOak().decorators(List.of(FlowerForestBeehive)).build());
        SublunaryConfiguredFeatures.register(context, FLOWER_FOREST_BIRCH, Feature.TREE, birch().decorators(List.of(FlowerForestBeehive)).build());

        SublunaryConfiguredFeatures.register(context, PLAINS_OAK, Feature.TREE, oak().decorators(List.of(PlainsBeehive)).build());
        SublunaryConfiguredFeatures.register(context, LARGE_PLAINS_OAK, Feature.TREE, fancyOak().decorators(List.of(PlainsBeehive)).build());

        SublunaryConfiguredFeatures.register(context, OLD_GROWTH_BIRCH, Feature.TREE, superBirch().decorators(List.of(FlowerForestBeehive)).build());

        SublunaryConfiguredFeatures.register(context, MEADOW_OAK, Feature.TREE, fancyOak().decorators(List.of(MeadowBeehive)).build());
        SublunaryConfiguredFeatures.register(context, MEADOW_BIRCH, Feature.TREE, superBirch().decorators(List.of(MeadowBeehive)).build());

        SublunaryConfiguredFeatures.register(context, DARK_OAK, Feature.TREE, dark_oak().build());

        SublunaryConfiguredFeatures.register(context, SPRUCE_FULL, Feature.TREE, (new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.SPRUCE_LOG),
                new StraightTrunkPlacer(3, 8, 4),
                BlockStateProvider.of(Blocks.SPRUCE_LEAVES),
                new SpruceFoliagePlacer(UniformIntProvider.create(2, 3), UniformIntProvider.create(0, 2), UniformIntProvider.create(1, 2)),
                new TwoLayersFeatureSize(2, 0, 2)))
                .ignoreVines().build());

        SublunaryConfiguredFeatures.register(context, SPRUCE_SPARSE, Feature.TREE, spruce_sparse().build());

        SublunaryConfiguredFeatures.register(context, VINY_OAK, Feature.TREE, oak().decorators(List.of(TrunkVineTreeDecorator.INSTANCE)).build());
        SublunaryConfiguredFeatures.register(context, LARGE_VINY_OAK, Feature.TREE, fancyOak().decorators(List.of(TrunkVineTreeDecorator.INSTANCE)).build());

        SublunaryConfiguredFeatures.register(context, VINY_BIRCH, Feature.TREE, birch().decorators(List.of(TrunkVineTreeDecorator.INSTANCE)).build());
        SublunaryConfiguredFeatures.register(context, VINY_OLD_GROWTH_BIRCH, Feature.TREE, superBirch().decorators(List.of(TrunkVineTreeDecorator.INSTANCE)).build());

        SublunaryConfiguredFeatures.register(context, VINY_DARK_OAK, Feature.TREE, dark_oak().decorators(List.of(TrunkVineTreeDecorator.INSTANCE)).build());

        SublunaryConfiguredFeatures.register(context, VINY_SPRUCE, Feature.TREE, spruce_sparse().decorators(List.of(TrunkVineTreeDecorator.INSTANCE)).build());
    }
}

package net.superfastscyphozoa.sublunary.world.feature.configured;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.collection.Weighted;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BushFoliagePlacer;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.NoiseBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;
import net.superfastscyphozoa.sublunary.world.feature.placed.SubTreePlacedFeatures;
import org.spongepowered.include.com.google.common.collect.ImmutableList;

import java.util.List;

import static net.superfastscyphozoa.sublunary.world.feature.configured.SublunaryConfiguredFeatures.registerKey;

public class SubVegetationConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?,?>> FOREST_TREES_CONFIGURED = registerKey("forest_trees_configured");
    public static final RegistryKey<ConfiguredFeature<?,?>> BIRCH_FOREST_TREES_CONFIGURED = registerKey("birch_forest_trees_configured");
    public static final RegistryKey<ConfiguredFeature<?,?>> FLOWER_FOREST_TREES_CONFIGURED = registerKey("flower_forest_trees_configured");
    public static final RegistryKey<ConfiguredFeature<?,?>> PLAINS_TREES_CONFIGURED = registerKey("plains_trees_configured");
    public static final RegistryKey<ConfiguredFeature<?,?>> OLD_GROWTH_BIRCH_TREES_CONFIGURED = registerKey("old_growth_birch_trees_configured");
    public static final RegistryKey<ConfiguredFeature<?,?>> MEADOW_TREES_CONFIGURED = registerKey("meadow_trees_configured");
    public static final RegistryKey<ConfiguredFeature<?,?>> DARK_FOREST_TREES_CONFIGURED = registerKey("dark_forest_trees_configured");
    public static final RegistryKey<ConfiguredFeature<?,?>> TAIGA_TREES_CONFIGURED = registerKey("taiga_trees_configured");
    public static final RegistryKey<ConfiguredFeature<?,?>> SNOWY_PLAINS_TREES_CONFIGURED = registerKey("snowy_plains_trees_configured");

    public static final RegistryKey<ConfiguredFeature<?,?>> GRASS_PATCH_CONFIGURED = registerKey("grass_patch_configured");
    public static final RegistryKey<ConfiguredFeature<?,?>> GRASS_FERNS_PATCH_CONFIGURED = registerKey("grass_ferns_patch_configured");

    public static final RegistryKey<ConfiguredFeature<?,?>> TALL_GRASS_PATCH_CONFIGURED = registerKey("tall_grass_patch_configured");
    public static final RegistryKey<ConfiguredFeature<?,?>> TALL_FERNS_PATCH_CONFIGURED = registerKey("tall_ferns_patch_configured");

    public static final RegistryKey<ConfiguredFeature<?,?>> PLAINS_FLOWER_PATCH_CONFIGURED = registerKey("plains_flower_patch_configured");

    private static RandomPatchFeatureConfig createRandomPatchFeatureConfig(BlockStateProvider block, int tries) {
        return ConfiguredFeatures.createRandomPatchFeatureConfig(tries, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(block)));
    }

    public static void bootstrap(Registerable<ConfiguredFeature<?,?>> context) {
        var placedFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        RegistryEntry<PlacedFeature> oakierOak = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.OAKIER_OAK_PLACED);
        RegistryEntry<PlacedFeature> largeOakierOak = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.LARGE_OAKIER_OAK_PLACED);
        RegistryEntry<PlacedFeature> birchierBirch = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.BIRCHIER_BIRCH_PLACED);

        RegistryEntry<PlacedFeature> smallOak = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.SMALL_OAK_PLACED);
        RegistryEntry<PlacedFeature> smallBirch = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.SMALL_BIRCH_PLACED);

        RegistryEntry<PlacedFeature> forestOak = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.FOREST_OAK_PLACED);
        RegistryEntry<PlacedFeature> largeForestOak = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.LARGE_FOREST_OAK_PLACED);
        RegistryEntry<PlacedFeature> forestBirch = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.FOREST_BIRCH_PLACED);

        RegistryEntry<PlacedFeature> flowerForestOak = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.FLOWER_FOREST_OAK_PLACED);
        RegistryEntry<PlacedFeature> largeFlowerForestOak = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.LARGE_FLOWER_FOREST_OAK_PLACED);
        RegistryEntry<PlacedFeature> flowerForestBirch = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.FLOWER_FOREST_BIRCH_PLACED);

        RegistryEntry<PlacedFeature> plainsOak = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.PLAINS_OAK_PLACED);
        RegistryEntry<PlacedFeature> largePlainsOak = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.LARGE_PLAINS_OAK_PLACED);

        RegistryEntry<PlacedFeature> oldGrowthBirch = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.OLD_GROWTH_BIRCH_PLACED);

        RegistryEntry<PlacedFeature> meadowOak = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.MEADOW_OAK_PLACED);
        RegistryEntry<PlacedFeature> meadowBirch = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.MEADOW_BIRCH_PLACED);

        RegistryEntry<PlacedFeature> darkOak = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.DARK_OAK_PLACED);

        RegistryEntry<PlacedFeature> spruceFull = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.SPRUCE_FULL_PLACED);
        RegistryEntry<PlacedFeature> spruceSparse = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.SPRUCE_SPARSE_PLACED);
        RegistryEntry<PlacedFeature> dyingSpruce = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.DYING_SPRUCE_PLACED);

        RegistryEntry<PlacedFeature> vinyOak = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.VINY_OAK_PLACED);
        RegistryEntry<PlacedFeature> largeVinyOak = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.LARGE_VINY_OAK_PLACED);

        RegistryEntry<PlacedFeature> vinyBirch = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.VINY_BIRCH_PLACED);
        RegistryEntry<PlacedFeature> vinyOldGrowthBirch = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.VINY_OLD_GROWTH_BIRCH_PLACED);

        RegistryEntry<PlacedFeature> vinyDarkOak = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.VINY_DARK_OAK_PLACED);

        SublunaryConfiguredFeatures.register(context, FOREST_TREES_CONFIGURED, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                new RandomFeatureEntry(vinyOak, 0.03F),
                new RandomFeatureEntry(largeVinyOak, 0.02F),

                new RandomFeatureEntry(smallOak, 0.15F),
                new RandomFeatureEntry(smallBirch, 0.15F),

                new RandomFeatureEntry(forestBirch, 0.15F),

                new RandomFeatureEntry(largeForestOak, 0.9F)),
                forestOak));

        SublunaryConfiguredFeatures.register(context, FLOWER_FOREST_TREES_CONFIGURED, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                new RandomFeatureEntry(vinyOak, 0.02F),
                new RandomFeatureEntry(vinyBirch, 0.02F),
                new RandomFeatureEntry(largeVinyOak, 0.02F),

                new RandomFeatureEntry(flowerForestOak, 0.15F),
                new RandomFeatureEntry(largeFlowerForestOak, 0.7F)),
                flowerForestBirch));

        SublunaryConfiguredFeatures.register(context, BIRCH_FOREST_TREES_CONFIGURED, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                new RandomFeatureEntry(vinyBirch, 0.015F),

                new RandomFeatureEntry(smallBirch, 0.1F)),
                forestBirch));

        SublunaryConfiguredFeatures.register(context, OLD_GROWTH_BIRCH_TREES_CONFIGURED, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                new RandomFeatureEntry(vinyOldGrowthBirch, 0.01F),
                new RandomFeatureEntry(vinyBirch, 0.01F),

                new RandomFeatureEntry(forestBirch, 0.1F)),
                oldGrowthBirch));

        SublunaryConfiguredFeatures.register(context, PLAINS_TREES_CONFIGURED, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                new RandomFeatureEntry(largePlainsOak, 0.5F)),
                plainsOak));

        SublunaryConfiguredFeatures.register(context, MEADOW_TREES_CONFIGURED, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                new RandomFeatureEntry(meadowOak, 0.5F)),
                meadowBirch));

        SublunaryConfiguredFeatures.register(context, DARK_FOREST_TREES_CONFIGURED, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                new RandomFeatureEntry(darkOak, 0.7F),
                new RandomFeatureEntry(birchierBirch, 0.2F),
                new RandomFeatureEntry(largeOakierOak, 0.2F),
                new RandomFeatureEntry(vinyDarkOak, 0.2F)),
                oakierOak));

        SublunaryConfiguredFeatures.register(context, TAIGA_TREES_CONFIGURED, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                new RandomFeatureEntry(dyingSpruce, 0.002F),
                new RandomFeatureEntry(spruceSparse, 0.34F)),
                spruceFull));

        SublunaryConfiguredFeatures.register(context, SNOWY_PLAINS_TREES_CONFIGURED, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                new RandomFeatureEntry(spruceSparse, 0.05F)),
                spruceFull));

        SublunaryConfiguredFeatures.register(context, GRASS_PATCH_CONFIGURED, Feature.RANDOM_PATCH,
                createRandomPatchFeatureConfig(BlockStateProvider.of(Blocks.SHORT_GRASS), 32));

        SublunaryConfiguredFeatures.register(context, GRASS_FERNS_PATCH_CONFIGURED, Feature.RANDOM_PATCH,
                createRandomPatchFeatureConfig(new WeightedBlockStateProvider(new DataPool.Builder<BlockState>()
                        .add(Blocks.SHORT_GRASS.getDefaultState(), 4).add(Blocks.FERN.getDefaultState(), 1)), 32));

        SublunaryConfiguredFeatures.register(context, TALL_GRASS_PATCH_CONFIGURED, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig
                        (Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.TALL_GRASS))));

        SublunaryConfiguredFeatures.register(context, TALL_FERNS_PATCH_CONFIGURED, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig
                        (Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.LARGE_FERN))));

        SublunaryConfiguredFeatures.register(context, PLAINS_FLOWER_PATCH_CONFIGURED, Feature.FLOWER,
                new RandomPatchFeatureConfig(96, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig
                        (new NoiseBlockStateProvider(2345L, new DoublePerlinNoiseSampler.NoiseParameters(0, 1.0), 0.020833334f,
                                List.of(Blocks.DANDELION.getDefaultState(), Blocks.ALLIUM.getDefaultState(), Blocks.POPPY.getDefaultState(),
                                        Blocks.AZURE_BLUET.getDefaultState(), Blocks.OXEYE_DAISY.getDefaultState(), Blocks.CORNFLOWER.getDefaultState()))))));
    }
}

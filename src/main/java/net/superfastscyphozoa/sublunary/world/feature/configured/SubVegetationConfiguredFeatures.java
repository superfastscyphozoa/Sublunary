package net.superfastscyphozoa.sublunary.world.feature.configured;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BushFoliagePlacer;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;
import net.superfastscyphozoa.sublunary.world.feature.placed.SubTreePlacedFeatures;

import java.util.List;

import static net.superfastscyphozoa.sublunary.world.feature.configured.SublunaryConfiguredFeatures.registerKey;

public class SubVegetationConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?,?>> FOREST_TREES_CONFIGURED = registerKey("forest_trees_configured");
    public static final RegistryKey<ConfiguredFeature<?,?>> BIRCH_FOREST_TREES_CONFIGURED = registerKey("birch_forest_trees_configured");
    public static final RegistryKey<ConfiguredFeature<?,?>> FLOWER_FOREST_TREES_CONFIGURED = registerKey("flower_forest_trees_configured");
    public static final RegistryKey<ConfiguredFeature<?,?>> PLAINS_TREES_CONFIGURED = registerKey("plains_trees_configured");
    public static final RegistryKey<ConfiguredFeature<?,?>> OLD_GROWTH_BIRCH_TREES_CONFIGURED = registerKey("old_growth_birch_trees_configured");
    public static final RegistryKey<ConfiguredFeature<?,?>> MEADOW_TREES_CONFIGURED = registerKey("meadow_trees_configured");

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

        RegistryEntry<PlacedFeature> vinyOak = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.VINY_OAK_PLACED);
        RegistryEntry<PlacedFeature> largeVinyOak = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.LARGE_VINY_OAK_PLACED);
        RegistryEntry<PlacedFeature> vinyBirch = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.VINY_BIRCH_PLACED);
        RegistryEntry<PlacedFeature> vinyOldGrowthBirch = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.VINY_OLD_GROWTH_BIRCH_PLACED);

        SublunaryConfiguredFeatures.register(context, FOREST_TREES_CONFIGURED, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                new RandomFeatureEntry(vinyOak, 0.03F),
                new RandomFeatureEntry(vinyBirch, 0.01F),
                new RandomFeatureEntry(largeVinyOak, 0.02F),

                new RandomFeatureEntry(smallOak, 0.1F),
                new RandomFeatureEntry(smallBirch, 0.1F),

                new RandomFeatureEntry(forestBirch, 0.2F),
                new RandomFeatureEntry(largeForestOak, 0.7F)),
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
    }
}

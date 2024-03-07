package net.superfastscyphozoa.sublunary.world.feature.configured;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BushFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;
import net.superfastscyphozoa.sublunary.world.feature.placed.SubTreePlacedFeatures;

import java.util.List;

import static net.superfastscyphozoa.sublunary.world.feature.configured.SublunaryConfiguredFeatures.registerKey;

public class SubVegetationConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?,?>> LAVENDER_PATCH_KEY = registerKey("lavender_patch");

    public static final RegistryKey<ConfiguredFeature<?,?>> FOREST_BUSH = registerKey("forest_bush");

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

        RegistryEntry<PlacedFeature> forestOak = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.FOREST_OAK_PLACED);
        RegistryEntry<PlacedFeature> largeForestOak = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.LARGE_FOREST_OAK_PLACED);
        RegistryEntry<PlacedFeature> forestBirch = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.FOREST_BIRCH_PLACED);

        RegistryEntry<PlacedFeature> flowerForestOak = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.FLOWER_FOREST_OAK_PLACED);
        RegistryEntry<PlacedFeature> largeFlowerForestOak = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.LARGE_FLOWER_FOREST_OAK_PLACED);
        RegistryEntry<PlacedFeature> flowerForestBirch = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.FLOWER_FOREST_BIRCH_PLACED);

        RegistryEntry<PlacedFeature> plainsOak = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.PLAINS_OAK_PLACED);

        RegistryEntry<PlacedFeature> oldGrowthBirch = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.OLD_GROWTH_BIRCH_PLACED);

        RegistryEntry<PlacedFeature> meadowOak = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.MEADOW_OAK_PLACED);
        RegistryEntry<PlacedFeature> meadowBirch = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.MEADOW_BIRCH_PLACED);

        RegistryEntry<PlacedFeature> vinyOak = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.VINY_OAK_PLACED);
        RegistryEntry<PlacedFeature> largeVinyOak = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.LARGE_VINY_OAK_PLACED);
        RegistryEntry<PlacedFeature> vinyBirch = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.VINY_BIRCH_PLACED);
        RegistryEntry<PlacedFeature> vinyOldGrowthBirch = placedFeatureRegistryEntryLookup.getOrThrow(SubTreePlacedFeatures.VINY_OLD_GROWTH_BIRCH_PLACED);

        SublunaryConfiguredFeatures.register(context, FOREST_TREES_CONFIGURED, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                new RandomFeatureEntry(forestBirch, 0.2F),
                new RandomFeatureEntry(largeForestOak, 0.6F),
                new RandomFeatureEntry(vinyOak, 0.08F),
                new RandomFeatureEntry(vinyBirch, 0.04F),
                new RandomFeatureEntry(largeVinyOak, 0.06F)),
                forestOak));

        SublunaryConfiguredFeatures.register(context, BIRCH_FOREST_TREES_CONFIGURED, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                new RandomFeatureEntry(vinyBirch, 0.05F)),
                forestBirch));

        SublunaryConfiguredFeatures.register(context, OLD_GROWTH_BIRCH_TREES_CONFIGURED, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                new RandomFeatureEntry(vinyOldGrowthBirch, 0.05F),
                new RandomFeatureEntry(forestBirch, 0.1F)),
                oldGrowthBirch));



        SublunaryConfiguredFeatures.register(context, FOREST_BUSH, Feature.TREE,
                (new TreeFeatureConfig.Builder(
                        BlockStateProvider.of(Blocks.OAK_LOG),
                        new StraightTrunkPlacer(1, 0, 0),
                        BlockStateProvider.of(Blocks.OAK_LEAVES),
                        new BushFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                        new TwoLayersFeatureSize(0, 0, 0))).build());

        SublunaryConfiguredFeatures.register(context, LAVENDER_PATCH_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(
                128, 6, 4, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(RegisterBlocks.LAVENDER)))));
    }
}

package net.superfastscyphozoa.sublunary.world.feature.placed;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;
import net.superfastscyphozoa.sublunary.world.feature.configured.SubVegetationConfiguredFeatures;
import net.superfastscyphozoa.sublunary.world.feature.configured.SublunaryConfiguredFeatures;

import static net.minecraft.world.gen.feature.VegetationPlacedFeatures.treeModifiersWithWouldSurvive;
import static net.superfastscyphozoa.sublunary.world.feature.placed.SublunaryPlacedFeatures.registerKey;

public class SubVegetationPlacedFeatures {
    public static final RegistryKey<PlacedFeature> FOREST_TREES = registerKey("forest_trees");
    public static final RegistryKey<PlacedFeature> BIRCH_FOREST_TREES = registerKey("birch_forest_trees");
    public static final RegistryKey<PlacedFeature> FLOWER_FOREST_TREES = registerKey("flower_forest_trees");
    public static final RegistryKey<PlacedFeature> PLAINS_TREES = registerKey("plains_trees");
    public static final RegistryKey<PlacedFeature> OLD_GROWTH_BIRCH_TREES = registerKey("old_growth_birch_trees");
    public static final RegistryKey<PlacedFeature> MEADOW_TREES = registerKey("meadow_trees");
    public static final RegistryKey<PlacedFeature> DARK_FOREST_TREES = registerKey("dark_forest_trees");
    public static final RegistryKey<PlacedFeature> TAIGA_TREES = registerKey("taiga_trees");
    public static final RegistryKey<PlacedFeature> SNOWY_PLAINS_TREES = registerKey("snowy_plains_trees");

    public static final RegistryKey<PlacedFeature> GRASS_PATCH = registerKey("grass_patch");
    public static final RegistryKey<PlacedFeature> GRASS_FERNS_PATCH = registerKey("grass_ferns_patch");

    public static final RegistryKey<PlacedFeature> TALL_GRASS_PATCH = registerKey("tall_grass_patch");
    public static final RegistryKey<PlacedFeature> TALL_FERNS_PATCH = registerKey("tall_ferns_patch");

    public static final RegistryKey<PlacedFeature> PLAINS_FLOWER_PATCH = registerKey("plains_flower_patch");


    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        RegistryEntry<ConfiguredFeature<?, ?>> forestTrees = configuredFeatureRegistryEntryLookup.getOrThrow(SubVegetationConfiguredFeatures.FOREST_TREES_CONFIGURED);
        RegistryEntry<ConfiguredFeature<?, ?>> flowerForestTrees = configuredFeatureRegistryEntryLookup.getOrThrow(SubVegetationConfiguredFeatures.FLOWER_FOREST_TREES_CONFIGURED);
        RegistryEntry<ConfiguredFeature<?, ?>> birchForestTrees = configuredFeatureRegistryEntryLookup.getOrThrow(SubVegetationConfiguredFeatures.BIRCH_FOREST_TREES_CONFIGURED);
        RegistryEntry<ConfiguredFeature<?, ?>> oldGrowthBirchTrees = configuredFeatureRegistryEntryLookup.getOrThrow(SubVegetationConfiguredFeatures.OLD_GROWTH_BIRCH_TREES_CONFIGURED);
        RegistryEntry<ConfiguredFeature<?, ?>> plainsTrees = configuredFeatureRegistryEntryLookup.getOrThrow(SubVegetationConfiguredFeatures.PLAINS_TREES_CONFIGURED);
        RegistryEntry<ConfiguredFeature<?, ?>> meadowTrees = configuredFeatureRegistryEntryLookup.getOrThrow(SubVegetationConfiguredFeatures.MEADOW_TREES_CONFIGURED);
        RegistryEntry<ConfiguredFeature<?, ?>> darkForestTrees = configuredFeatureRegistryEntryLookup.getOrThrow(SubVegetationConfiguredFeatures.DARK_FOREST_TREES_CONFIGURED);
        RegistryEntry<ConfiguredFeature<?, ?>> taigaTrees = configuredFeatureRegistryEntryLookup.getOrThrow(SubVegetationConfiguredFeatures.TAIGA_TREES_CONFIGURED);
        RegistryEntry<ConfiguredFeature<?, ?>> snowyPlainsTrees = configuredFeatureRegistryEntryLookup.getOrThrow(SubVegetationConfiguredFeatures.SNOWY_PLAINS_TREES_CONFIGURED);

        RegistryEntry<ConfiguredFeature<?, ?>> grassPatch = configuredFeatureRegistryEntryLookup.getOrThrow(SubVegetationConfiguredFeatures.GRASS_PATCH_CONFIGURED);
        RegistryEntry<ConfiguredFeature<?, ?>> grassFernsPatch = configuredFeatureRegistryEntryLookup.getOrThrow(SubVegetationConfiguredFeatures.GRASS_FERNS_PATCH_CONFIGURED);

        RegistryEntry<ConfiguredFeature<?, ?>> tallGrassPatch = configuredFeatureRegistryEntryLookup.getOrThrow(SubVegetationConfiguredFeatures.TALL_GRASS_PATCH_CONFIGURED);
        RegistryEntry<ConfiguredFeature<?, ?>> tallFernsPatch = configuredFeatureRegistryEntryLookup.getOrThrow(SubVegetationConfiguredFeatures.TALL_FERNS_PATCH_CONFIGURED);

        RegistryEntry<ConfiguredFeature<?, ?>> plainsFlowerPatch = configuredFeatureRegistryEntryLookup.getOrThrow(SubVegetationConfiguredFeatures.PLAINS_FLOWER_PATCH_CONFIGURED);


        SublunaryPlacedFeatures.register(context, FOREST_TREES, forestTrees,
                treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(9, 0.1F, 4), Blocks.OAK_SAPLING));

        SublunaryPlacedFeatures.register(context, FLOWER_FOREST_TREES, flowerForestTrees,
                treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(8, 0.1F, 4), Blocks.OAK_SAPLING));

        SublunaryPlacedFeatures.register(context, BIRCH_FOREST_TREES, birchForestTrees,
                treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(9, 0.1F, 2), Blocks.BIRCH_SAPLING));

        SublunaryPlacedFeatures.register(context, OLD_GROWTH_BIRCH_TREES, oldGrowthBirchTrees,
                treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(8, 0.1F, 3), Blocks.BIRCH_SAPLING));

        SublunaryPlacedFeatures.register(context, PLAINS_TREES, plainsTrees,
                treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(0, 0.05F, 1), Blocks.OAK_SAPLING));

        SublunaryPlacedFeatures.register(context, MEADOW_TREES, meadowTrees,
                treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(100), Blocks.OAK_SAPLING));

        SublunaryPlacedFeatures.register(context, DARK_FOREST_TREES, darkForestTrees,
                CountPlacementModifier.of(16), SquarePlacementModifier.of(),
                SurfaceWaterDepthFilterPlacementModifier.of(0), PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP, BiomePlacementModifier.of());

        SublunaryPlacedFeatures.register(context, TAIGA_TREES, taigaTrees,
                treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(9, 0.1F, 1), Blocks.OAK_SAPLING));

        SublunaryPlacedFeatures.register(context, SNOWY_PLAINS_TREES, snowyPlainsTrees,
                treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(0, 0.1F, 1), Blocks.SPRUCE_SAPLING));


        SublunaryPlacedFeatures.register(context, GRASS_PATCH, grassPatch, VegetationPlacedFeatures.modifiers(20));
        SublunaryPlacedFeatures.register(context, GRASS_FERNS_PATCH, grassFernsPatch, VegetationPlacedFeatures.modifiers(20));

        SublunaryPlacedFeatures.register(context, TALL_GRASS_PATCH, tallGrassPatch,
                NoiseThresholdCountPlacementModifier.of(-0.8, 0, 7), RarityFilterPlacementModifier.of(20),
                SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        SublunaryPlacedFeatures.register(context, TALL_FERNS_PATCH, tallFernsPatch,
                NoiseThresholdCountPlacementModifier.of(-0.8, 0, 7), RarityFilterPlacementModifier.of(20),
                SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());


        SublunaryPlacedFeatures.register(context, PLAINS_FLOWER_PATCH, plainsFlowerPatch,
                CountPlacementModifier.of(3), RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    }
}

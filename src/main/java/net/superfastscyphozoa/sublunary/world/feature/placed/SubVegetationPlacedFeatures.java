package net.superfastscyphozoa.sublunary.world.feature.placed;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
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

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        RegistryEntry<ConfiguredFeature<?, ?>> forestTrees = configuredFeatureRegistryEntryLookup.getOrThrow(SubVegetationConfiguredFeatures.FOREST_TREES_CONFIGURED);
        RegistryEntry<ConfiguredFeature<?, ?>> flowerForestTrees = configuredFeatureRegistryEntryLookup.getOrThrow(SubVegetationConfiguredFeatures.FLOWER_FOREST_TREES_CONFIGURED);
        RegistryEntry<ConfiguredFeature<?, ?>> birchForestTrees = configuredFeatureRegistryEntryLookup.getOrThrow(SubVegetationConfiguredFeatures.BIRCH_FOREST_TREES_CONFIGURED);
        RegistryEntry<ConfiguredFeature<?, ?>> oldGrowthBirchTrees = configuredFeatureRegistryEntryLookup.getOrThrow(SubVegetationConfiguredFeatures.OLD_GROWTH_BIRCH_TREES_CONFIGURED);
        RegistryEntry<ConfiguredFeature<?, ?>> plainsTrees = configuredFeatureRegistryEntryLookup.getOrThrow(SubVegetationConfiguredFeatures.PLAINS_TREES_CONFIGURED);

        SublunaryPlacedFeatures.register(context, FOREST_TREES, forestTrees,
                treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(10, 0.1F, 4), Blocks.OAK_SAPLING));

        SublunaryPlacedFeatures.register(context, FLOWER_FOREST_TREES, flowerForestTrees,
                treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(8, 0.1F, 4), Blocks.OAK_SAPLING));

        SublunaryPlacedFeatures.register(context, BIRCH_FOREST_TREES, birchForestTrees,
                treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(9, 0.1F, 2), Blocks.OAK_SAPLING));

        SublunaryPlacedFeatures.register(context, OLD_GROWTH_BIRCH_TREES, oldGrowthBirchTrees,
                treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(8, 0.1F, 3), Blocks.OAK_SAPLING));

        SublunaryPlacedFeatures.register(context, PLAINS_TREES, plainsTrees,
                treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(0, 0.05F, 1), Blocks.OAK_SAPLING));
    }
}

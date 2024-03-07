package net.superfastscyphozoa.sublunary.world.feature.placed;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.superfastscyphozoa.sublunary.world.feature.configured.SubTreeConfiguredFeatures;

import static net.superfastscyphozoa.sublunary.world.feature.placed.SublunaryPlacedFeatures.registerKey;

public class SubTreePlacedFeatures {

    public static final RegistryKey<PlacedFeature> FOREST_OAK_PLACED = registerKey("forest_oak_placed");
    public static final RegistryKey<PlacedFeature> LARGE_FOREST_OAK_PLACED = registerKey("large_forest_oak_placed");
    public static final RegistryKey<PlacedFeature> FOREST_BIRCH_PLACED = registerKey("forest_birch_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        //trees

        SublunaryPlacedFeatures.register(context, FOREST_OAK_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.FOREST_OAK),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(6, 0.1f, 4),
                        Blocks.OAK_SAPLING));

        SublunaryPlacedFeatures.register(context, LARGE_FOREST_OAK_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.LARGE_FOREST_OAK),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(6, 0.1f, 4),
                        Blocks.OAK_SAPLING));

        SublunaryPlacedFeatures.register(context, FOREST_BIRCH_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.FOREST_BIRCH),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(6, 0.1f, 4),
                        Blocks.OAK_SAPLING));

    }

}

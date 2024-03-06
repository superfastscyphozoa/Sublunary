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

    public static final RegistryKey<PlacedFeature> BIRCHIER_BIRCH_PLACED_KEY = registerKey("birchier_birch_placed");
    public static final RegistryKey<PlacedFeature> OAKIER_OAK_PLACED_KEY = registerKey("oakier_oak_placed");
    public static final RegistryKey<PlacedFeature> LARGE_OAKIER_OAK_PLACED_KEY = registerKey("large_oakier_oak_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        //trees

        SublunaryPlacedFeatures.register(context, OAKIER_OAK_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.OAKIER_OAK_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(6, 0.1f, 4),
                        Blocks.OAK_SAPLING));

        SublunaryPlacedFeatures.register(context, LARGE_OAKIER_OAK_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.LARGE_OAKIER_OAK_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(6, 0.1f, 4),
                        Blocks.OAK_SAPLING));

        SublunaryPlacedFeatures.register(context, BIRCHIER_BIRCH_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.BIRCHIER_BIRCH_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(6, 0.5f, 4),
                        Blocks.OAK_SAPLING));

    }

}

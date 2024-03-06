package net.superfastscyphozoa.sublunary.world.feature.placed;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.superfastscyphozoa.sublunary.world.feature.configured.SubVegetationConfiguredFeatures;

import static net.superfastscyphozoa.sublunary.world.feature.placed.SublunaryPlacedFeatures.registerKey;

public class SubVegetationPlacedFeatures {

    public static final RegistryKey<PlacedFeature> LAVENDER_PATCH_PLACED_KEY = registerKey("lavender_patch_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        //flowers
        SublunaryPlacedFeatures.register(context, LAVENDER_PATCH_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(SubVegetationConfiguredFeatures.LAVENDER_PATCH_KEY),
                RarityFilterPlacementModifier.of(10), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    }

}

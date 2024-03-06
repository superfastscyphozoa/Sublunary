package net.superfastscyphozoa.sublunary.world;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.superfastscyphozoa.sublunary.Sublunary;

import java.util.List;

public class SublunaryPlacedFeatures {
    public static final RegistryKey<PlacedFeature> BIRCHIER_BIRCH_PLACED_KEY = registerKey("birchier_birch_placed");
    public static final RegistryKey<PlacedFeature> OAKIER_OAK_PLACED_KEY = registerKey("oakier_oak_placed");
    public static final RegistryKey<PlacedFeature> LAVENDER_PATCH_PLACED_KEY = registerKey("lavender_patch_placed");

    public static void bootstrap(Registerable<PlacedFeature> context){
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        //trees
        register(context, OAKIER_OAK_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.OAKIER_OAK_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(6, 0.1f, 4),
                        Blocks.OAK_SAPLING));

        register(context, BIRCHIER_BIRCH_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.BIRCHIER_BIRCH_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(6, 0.5f, 4),
                        Blocks.OAK_SAPLING));

        //flowers
        register(context, LAVENDER_PATCH_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(SubVegetationConfiguredFeatures.LAVENDER_PATCH_KEY),
                RarityFilterPlacementModifier.of(10), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    }


    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Sublunary.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}

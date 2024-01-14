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
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;

import java.util.List;

public class SublunaryPlacedFeatures {
    public static final RegistryKey<PlacedFeature> MAPLE_PLACED_KEY = registerKey("maple_placed");
    public static final RegistryKey<PlacedFeature> YELLOW_BIRCH_PLACED_KEY = registerKey("yellow_birch_placed");
    public static final RegistryKey<PlacedFeature> OAKIER_OAK_PLACED_KEY = registerKey("oakier_oak_placed");
    public static final RegistryKey<PlacedFeature> LAVENDER_PATCH_PLACED_KEY = registerKey("lavender_patch_placed");

    public static void bootstrap(Registerable<PlacedFeature> context){
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        //trees
        register(context, MAPLE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(SublunaryConfiguredFeatures.MAPLE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(0, 0.2f, 1),
                        Blocks.OAK_SAPLING));

        register(context, OAKIER_OAK_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(SublunaryConfiguredFeatures.OAKIER_OAK_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(8, 0.1f, 4),
                        Blocks.OAK_SAPLING));

        register(context, YELLOW_BIRCH_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(SublunaryConfiguredFeatures.YELLOW_BIRCH_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.5f, 3),
                        Blocks.OAK_SAPLING));

        //flowers
        register(context, LAVENDER_PATCH_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(SublunaryConfiguredFeatures.LAVENDER_PATCH_KEY),
                RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
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

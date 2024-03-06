package net.superfastscyphozoa.sublunary.world.feature.placed;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.superfastscyphozoa.sublunary.Sublunary;

import java.util.List;

public class SublunaryPlacedFeatures {

    public static void bootstrap(Registerable<PlacedFeature> context){
        SubTreePlacedFeatures.bootstrap(context);
        SubVegetationPlacedFeatures.bootstrap(context);
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Sublunary.MOD_ID, name));
    }

    public static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                           RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                           PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}

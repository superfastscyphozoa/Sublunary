package net.superfastscyphozoa.sublunary.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.superfastscyphozoa.sublunary.Sublunary;

public class SublunaryConfiguredFeatures {

    public static void bootstrap(Registerable<ConfiguredFeature<?,?>> context) {
        SubTreeConfiguredFeatures.bootstrap(context);
        SubVegetationConfiguredFeatures.bootstrap(context);
    }

    public static RegistryKey<ConfiguredFeature<?,?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Sublunary.MOD_ID, name));
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                           RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

package net.superfastscyphozoa.sublunary.world.feature.placed;

import net.minecraft.registry.Holder;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.BootstrapContext;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacementModifier;
import net.superfastscyphozoa.sublunary.Sublunary;

import java.util.List;

public class SublunaryPlacedFeatures {

    public static void bootstrap(BootstrapContext<PlacedFeature> context){
        SubTreePlacedFeatures.bootstrap(context);
        SubVegetationPlacedFeatures.bootstrap(context);
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Sublunary.MOD_ID, name));
    }

    public static void register(BootstrapContext<PlacedFeature> context, RegistryKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

     static void register(BootstrapContext<PlacedFeature> context, RegistryKey<PlacedFeature> key,
						  Holder<ConfiguredFeature<?, ?>> configuration,
                          PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }

}

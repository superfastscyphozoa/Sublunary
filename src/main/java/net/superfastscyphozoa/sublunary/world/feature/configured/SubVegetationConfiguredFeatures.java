package net.superfastscyphozoa.sublunary.world.feature.configured;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;

import static net.superfastscyphozoa.sublunary.world.feature.configured.SublunaryConfiguredFeatures.registerKey;

public class SubVegetationConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?,?>> LAVENDER_PATCH_KEY = registerKey("lavender_patch");

    public static void bootstrap(Registerable<ConfiguredFeature<?,?>> context) {
        //flowers
        //lavender patch
        SublunaryConfiguredFeatures.register(context, LAVENDER_PATCH_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(
                128, 6, 4, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(RegisterBlocks.LAVENDER)))));
    }
}

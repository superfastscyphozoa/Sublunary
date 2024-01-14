package net.superfastscyphozoa.sublunary.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.superfastscyphozoa.sublunary.world.SublunaryPlacedFeatures;

public class SublunaryFloraGeneration {
    public static void generateFlora(){
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.PLAINS),
                GenerationStep.Feature.VEGETAL_DECORATION, SublunaryPlacedFeatures.LAVENDER_PATCH_PLACED_KEY);
    }
}

package net.superfastscyphozoa.sublunary.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.superfastscyphozoa.sublunary.world.feature.placed.SubVegetationPlacedFeatures;

public class SublunaryFloraGeneration {
    public static void generateFlora(){
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS),
                GenerationStep.Feature.VEGETAL_DECORATION, SubVegetationPlacedFeatures.LAVENDER_PATCH_PLACED_KEY);
    }
}

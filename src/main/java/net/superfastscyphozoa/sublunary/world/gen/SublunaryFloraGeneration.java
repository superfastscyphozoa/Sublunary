package net.superfastscyphozoa.sublunary.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.superfastscyphozoa.sublunary.Sublunary;
import net.superfastscyphozoa.sublunary.world.feature.placed.SubVegetationPlacedFeatures;

public class SublunaryFloraGeneration {
    public static void generateFlora(){

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS),
                GenerationStep.Feature.VEGETAL_DECORATION, SubVegetationPlacedFeatures.LAVENDER_PATCH_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, SubVegetationPlacedFeatures.FOREST_BUSH_PLACED_KEY);

    }

    public static void removeFlora(){

        RegistryKey<PlacedFeature> PLAINS_FLOWERS = VegetationPlacedFeatures.FLOWER_PLAIN;

        BiomeModifications.create(new Identifier(Sublunary.MOD_ID, "remove_vanilla_trees"))
                .add(ModificationPhase.REMOVALS, BiomeSelectors.includeByKey(BiomeKeys.PLAINS),
                        (context) ->
                        {
                            context.getGenerationSettings().removeFeature(PLAINS_FLOWERS);
                        });

    }
}

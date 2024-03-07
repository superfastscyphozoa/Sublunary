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

public class SublunaryTreeGeneration {

    public static void generateTrees(){

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, SubVegetationPlacedFeatures.FOREST_TREES);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BIRCH_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, SubVegetationPlacedFeatures.BIRCH_FOREST_TREES);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_BIRCH_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, SubVegetationPlacedFeatures.OLD_GROWTH_BIRCH_TREES);

    }

    public static void removeTrees(){

        RegistryKey<PlacedFeature> VANILLA_FOREST_TREES = VegetationPlacedFeatures.TREES_BIRCH_AND_OAK;
        RegistryKey<PlacedFeature> VANILLA_BIRCH_FOREST_TREES = VegetationPlacedFeatures.TREES_BIRCH;
        RegistryKey<PlacedFeature> VANILLA_OLD_GROWTH_BIRCH_TREES = VegetationPlacedFeatures.BIRCH_TALL;

        BiomeModifications.create(new Identifier(Sublunary.MOD_ID, "remove_vanilla_trees"))
                .add(ModificationPhase.REMOVALS, BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST),
                        (context) ->
                        {
                            context.getGenerationSettings().removeFeature(VANILLA_FOREST_TREES);
                            context.getGenerationSettings().removeFeature(VANILLA_BIRCH_FOREST_TREES);
                            context.getGenerationSettings().removeFeature(VANILLA_OLD_GROWTH_BIRCH_TREES);
                        });

    }

}

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
import net.superfastscyphozoa.sublunary.world.feature.placed.SubTreePlacedFeatures;

public class SublunaryTreeGeneration {

    public static void generateTrees(){

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, SubTreePlacedFeatures.OAKIER_OAK_PLACED_KEY);

    }

    public static void replaceTrees(){

        RegistryKey<PlacedFeature> VANILLA_FOREST_TREES = VegetationPlacedFeatures.TREES_BIRCH_AND_OAK;

        BiomeModifications.create(new Identifier(Sublunary.MOD_ID, "remove_forest_trees"))
                .add(ModificationPhase.REMOVALS, BiomeSelectors.includeByKey(BiomeKeys.FOREST),
                        (context) ->
                        {
                            context.getGenerationSettings().removeFeature(VANILLA_FOREST_TREES);
                        });

    }

}

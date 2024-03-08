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

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomeKeys.DARK_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, SubVegetationPlacedFeatures.FOREST_GRASS);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                        BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomeKeys.DARK_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, SubVegetationPlacedFeatures.TALL_GRASS_PATCH);

    }

    public static void removeFlora(){

        RegistryKey<PlacedFeature> VANILLA_PLAINS_FLOWERS = VegetationPlacedFeatures.FLOWER_PLAIN;
        RegistryKey<PlacedFeature> VANILLA_DEFAULT_FLOWERS = VegetationPlacedFeatures.FLOWER_DEFAULT;

        RegistryKey<PlacedFeature> VANILLA_FOREST_GRASS = VegetationPlacedFeatures.PATCH_GRASS_FOREST;

        BiomeModifications.create(new Identifier(Sublunary.MOD_ID, "remove_vanilla_flowers"))
                .add(ModificationPhase.REMOVALS, BiomeSelectors.foundInOverworld(),
                        (context) ->
                        {
                            context.getGenerationSettings().removeFeature(VANILLA_PLAINS_FLOWERS);
                            context.getGenerationSettings().removeFeature(VANILLA_DEFAULT_FLOWERS);
                        });

        BiomeModifications.create(new Identifier(Sublunary.MOD_ID, "remove_vanilla_grass"))
                .add(ModificationPhase.REMOVALS, BiomeSelectors.includeByKey(
                        BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST),
                        (context) ->
                        {
                            context.getGenerationSettings().removeFeature(VANILLA_FOREST_GRASS);
                        });

    }
}

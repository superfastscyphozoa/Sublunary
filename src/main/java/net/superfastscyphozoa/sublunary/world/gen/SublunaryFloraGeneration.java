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

        RegistryKey<PlacedFeature> VANILLA_PLAINS_FLOWERS = VegetationPlacedFeatures.FLOWER_PLAIN;
        RegistryKey<PlacedFeature> VANILLA_DEFAULT_FLOWERS = VegetationPlacedFeatures.FLOWER_DEFAULT;
        RegistryKey<PlacedFeature> VANILLA_WARM_FLOWERS = VegetationPlacedFeatures.FLOWER_WARM;

        RegistryKey<PlacedFeature> VANILLA_FOREST_GRASS = VegetationPlacedFeatures.PATCH_GRASS_FOREST;
        RegistryKey<PlacedFeature> VANILLA_NORMAL_GRASS = VegetationPlacedFeatures.PATCH_GRASS_NORMAL;

        BiomeModifications.create(new Identifier(Sublunary.MOD_ID, "replace_plains_flowers"))
                .add(ModificationPhase.REPLACEMENTS, BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.SUNFLOWER_PLAINS),
                        biomeModificationContext -> {
                    biomeModificationContext.getGenerationSettings().removeFeature(GenerationStep.Feature.VEGETAL_DECORATION, VANILLA_PLAINS_FLOWERS);
                    biomeModificationContext.getGenerationSettings().addFeature(GenerationStep.Feature.VEGETAL_DECORATION, SubVegetationPlacedFeatures.PLAINS_FLOWER_PATCH);
                        });

        BiomeModifications.create(new Identifier(Sublunary.MOD_ID, "remove_default_flowers"))
                .add(ModificationPhase.REMOVALS, BiomeSelectors.foundInOverworld(),
                        biomeModificationContext -> {
                            biomeModificationContext.getGenerationSettings().removeFeature(GenerationStep.Feature.VEGETAL_DECORATION, VANILLA_DEFAULT_FLOWERS);
                        });

        BiomeModifications.create(new Identifier(Sublunary.MOD_ID, "remove_warm_flowers"))
                .add(ModificationPhase.REMOVALS, BiomeSelectors.foundInOverworld(),
                        biomeModificationContext -> {
                            biomeModificationContext.getGenerationSettings().removeFeature(GenerationStep.Feature.VEGETAL_DECORATION, VANILLA_WARM_FLOWERS);
                        });


        BiomeModifications.create(new Identifier(Sublunary.MOD_ID, "replace_forest_grass_ferns"))
                .add(ModificationPhase.REPLACEMENTS, BiomeSelectors.includeByKey(
                        BiomeKeys.FOREST, BiomeKeys.DARK_FOREST, BiomeKeys.WINDSWEPT_FOREST),
                        biomeModificationContext -> {
                            biomeModificationContext.getGenerationSettings().removeFeature(GenerationStep.Feature.VEGETAL_DECORATION, VANILLA_FOREST_GRASS);
                            biomeModificationContext.getGenerationSettings().removeFeature(GenerationStep.Feature.VEGETAL_DECORATION, VANILLA_NORMAL_GRASS);

                            biomeModificationContext.getGenerationSettings()
                                    .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, SubVegetationPlacedFeatures.GRASS_FERNS_PATCH);
                            biomeModificationContext.getGenerationSettings()
                                    .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, SubVegetationPlacedFeatures.TALL_GRASS_PATCH);
                        });

        BiomeModifications.create(new Identifier(Sublunary.MOD_ID, "replace_forest_grass"))
                .add(ModificationPhase.REPLACEMENTS, BiomeSelectors.includeByKey(
                        BiomeKeys.FLOWER_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomeKeys.WINDSWEPT_HILLS, BiomeKeys.WINDSWEPT_GRAVELLY_HILLS),
                        biomeModificationContext -> {
                            biomeModificationContext.getGenerationSettings().removeFeature(GenerationStep.Feature.VEGETAL_DECORATION, VANILLA_FOREST_GRASS);
                            biomeModificationContext.getGenerationSettings().removeFeature(GenerationStep.Feature.VEGETAL_DECORATION, VANILLA_NORMAL_GRASS);

                            biomeModificationContext.getGenerationSettings()
                                    .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, SubVegetationPlacedFeatures.GRASS_PATCH);
                            biomeModificationContext.getGenerationSettings()
                                    .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, SubVegetationPlacedFeatures.TALL_GRASS_PATCH);
                        });
    }
}

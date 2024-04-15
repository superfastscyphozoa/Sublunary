package net.superfastscyphozoa.sublunary.world.gen;

import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.superfastscyphozoa.sublunary.Sublunary;
import net.superfastscyphozoa.sublunary.world.feature.placed.SubVegetationPlacedFeatures;
import org.quiltmc.qsl.worldgen.biome.api.BiomeModifications;
import org.quiltmc.qsl.worldgen.biome.api.BiomeSelectors;
import org.quiltmc.qsl.worldgen.biome.api.ModificationPhase;

public class SublunaryFloraGeneration {
    public static void generateFlora(){

        RegistryKey<PlacedFeature> VANILLA_PLAINS_FLOWERS = VegetationPlacedFeatures.FLOWER_PLAINS;
        RegistryKey<PlacedFeature> VANILLA_DEFAULT_FLOWERS = VegetationPlacedFeatures.FLOWER_DEFAULT;
        RegistryKey<PlacedFeature> VANILLA_WARM_FLOWERS = VegetationPlacedFeatures.FLOWER_WARM;

        RegistryKey<PlacedFeature> VANILLA_FOREST_GRASS = VegetationPlacedFeatures.PATCH_GRASS_FOREST;
        RegistryKey<PlacedFeature> VANILLA_TAIGA_GRASS_1 = VegetationPlacedFeatures.PATCH_GRASS_TAIGA;
        RegistryKey<PlacedFeature> VANILLA_TAIGA_GRASS_2 = VegetationPlacedFeatures.PATCH_GRASS_TAIGA_2;
        RegistryKey<PlacedFeature> VANILLA_NORMAL_GRASS = VegetationPlacedFeatures.PATCH_GRASS_NORMAL;

        RegistryKey<PlacedFeature> VANILLA_LARGE_FERNS = VegetationPlacedFeatures.PATCH_LARGE_FERN;

		BiomeModifications.create(new Identifier(Sublunary.MOD_ID, "replace_plains_flowers"))
                .add(ModificationPhase.REPLACEMENTS, BiomeSelectors.includeByKey(Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS),
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
								Biomes.FOREST, Biomes.DARK_FOREST, Biomes.WINDSWEPT_FOREST),
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
								Biomes.FLOWER_FOREST, Biomes.BIRCH_FOREST, Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS),
                        biomeModificationContext -> {
                            biomeModificationContext.getGenerationSettings().removeFeature(GenerationStep.Feature.VEGETAL_DECORATION, VANILLA_FOREST_GRASS);
                            biomeModificationContext.getGenerationSettings().removeFeature(GenerationStep.Feature.VEGETAL_DECORATION, VANILLA_NORMAL_GRASS);

                            biomeModificationContext.getGenerationSettings()
                                    .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, SubVegetationPlacedFeatures.GRASS_PATCH);
                            biomeModificationContext.getGenerationSettings()
                                    .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, SubVegetationPlacedFeatures.TALL_GRASS_PATCH);
                        });

        BiomeModifications.create(new Identifier(Sublunary.MOD_ID, "replace_taiga_grass"))
                .add(ModificationPhase.REPLACEMENTS, BiomeSelectors.includeByKey(
								Biomes.TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA),
                        biomeModificationContext -> {
                            biomeModificationContext.getGenerationSettings().removeFeature(GenerationStep.Feature.VEGETAL_DECORATION, VANILLA_TAIGA_GRASS_1);
                            biomeModificationContext.getGenerationSettings().removeFeature(GenerationStep.Feature.VEGETAL_DECORATION, VANILLA_TAIGA_GRASS_2);
                            biomeModificationContext.getGenerationSettings().removeFeature(GenerationStep.Feature.VEGETAL_DECORATION, VANILLA_LARGE_FERNS);

                            biomeModificationContext.getGenerationSettings()
                                    .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, SubVegetationPlacedFeatures.GRASS_FERNS_PATCH);
                            biomeModificationContext.getGenerationSettings()
                                    .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, SubVegetationPlacedFeatures.TALL_FERNS_PATCH);
                        });
    }
}

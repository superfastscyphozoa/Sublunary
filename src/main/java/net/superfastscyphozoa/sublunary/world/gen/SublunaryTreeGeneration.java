package net.superfastscyphozoa.sublunary.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.superfastscyphozoa.sublunary.Sublunary;
import net.superfastscyphozoa.sublunary.registry.RegisterEntities;
import net.superfastscyphozoa.sublunary.world.feature.placed.SubVegetationPlacedFeatures;

public class SublunaryTreeGeneration {

    public static void generateTrees(){

        RegistryKey<PlacedFeature> VANILLA_FOREST_TREES = VegetationPlacedFeatures.TREES_BIRCH_AND_OAK;
        RegistryKey<PlacedFeature> VANILLA_FLOWER_FOREST_TREES = VegetationPlacedFeatures.TREES_FLOWER_FOREST;
        RegistryKey<PlacedFeature> VANILLA_BIRCH_FOREST_TREES = VegetationPlacedFeatures.TREES_BIRCH;
        RegistryKey<PlacedFeature> VANILLA_OLD_GROWTH_BIRCH_TREES = VegetationPlacedFeatures.BIRCH_TALL;
        RegistryKey<PlacedFeature> VANILLA_PLAINS_TREES = VegetationPlacedFeatures.TREES_PLAINS;
        RegistryKey<PlacedFeature> VANILLA_MEADOW_TREES = VegetationPlacedFeatures.TREES_MEADOW;
        RegistryKey<PlacedFeature> VANILLA_DARK_FOREST_TREES = VegetationPlacedFeatures.DARK_FOREST_VEGETATION;
        RegistryKey<PlacedFeature> VANILLA_TAIGA_TREES = VegetationPlacedFeatures.TREES_TAIGA;
        RegistryKey<PlacedFeature> VANILLA_SNOWY_PLAINS_TREES = VegetationPlacedFeatures.TREES_SNOWY;

        BiomeModifications.create(new Identifier(Sublunary.MOD_ID, "replace_forest_trees"))
                .add(ModificationPhase.REPLACEMENTS, BiomeSelectors.includeByKey(BiomeKeys.FOREST),
                        biomeModificationContext -> {
                            biomeModificationContext.getGenerationSettings()
                                    .removeFeature(GenerationStep.Feature.VEGETAL_DECORATION, VANILLA_FOREST_TREES);
                            biomeModificationContext.getGenerationSettings()
                                    .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, SubVegetationPlacedFeatures.FOREST_TREES);}
                );

        BiomeModifications.create(new Identifier(Sublunary.MOD_ID, "replace_flower_forest_trees"))
                .add(ModificationPhase.REPLACEMENTS, BiomeSelectors.includeByKey(BiomeKeys.FLOWER_FOREST),
                        biomeModificationContext -> {
                            biomeModificationContext.getGenerationSettings()
                                    .removeFeature(GenerationStep.Feature.VEGETAL_DECORATION, VANILLA_FLOWER_FOREST_TREES);
                            biomeModificationContext.getGenerationSettings()
                                    .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, SubVegetationPlacedFeatures.FLOWER_FOREST_TREES);}
                );

        BiomeModifications.create(new Identifier(Sublunary.MOD_ID, "replace_birch_forest_trees"))
                .add(ModificationPhase.REPLACEMENTS, BiomeSelectors.includeByKey(BiomeKeys.BIRCH_FOREST),
                        biomeModificationContext -> {
                            biomeModificationContext.getGenerationSettings()
                                    .removeFeature(GenerationStep.Feature.VEGETAL_DECORATION, VANILLA_BIRCH_FOREST_TREES);
                            biomeModificationContext.getGenerationSettings()
                                    .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, SubVegetationPlacedFeatures.BIRCH_FOREST_TREES);}
                );

        BiomeModifications.create(new Identifier(Sublunary.MOD_ID, "replace_old_growth_birch_trees"))
                .add(ModificationPhase.REPLACEMENTS, BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_BIRCH_FOREST),
                        biomeModificationContext -> {
                            biomeModificationContext.getGenerationSettings()
                                    .removeFeature(GenerationStep.Feature.VEGETAL_DECORATION, VANILLA_OLD_GROWTH_BIRCH_TREES);
                            biomeModificationContext.getGenerationSettings()
                                    .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, SubVegetationPlacedFeatures.OLD_GROWTH_BIRCH_TREES);}
                );

        BiomeModifications.create(new Identifier(Sublunary.MOD_ID, "replace_plains_trees"))
                .add(ModificationPhase.REPLACEMENTS, BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.SUNFLOWER_PLAINS),
                        biomeModificationContext -> {
                            biomeModificationContext.getGenerationSettings()
                                    .removeFeature(GenerationStep.Feature.VEGETAL_DECORATION, VANILLA_PLAINS_TREES);
                            biomeModificationContext.getGenerationSettings()
                                    .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, SubVegetationPlacedFeatures.PLAINS_TREES);}
                );

        BiomeModifications.create(new Identifier(Sublunary.MOD_ID, "replace_meadow_trees"))
                .add(ModificationPhase.REPLACEMENTS, BiomeSelectors.includeByKey(BiomeKeys.MEADOW),
                        biomeModificationContext -> {
                            biomeModificationContext.getGenerationSettings()
                                    .removeFeature(GenerationStep.Feature.VEGETAL_DECORATION, VANILLA_MEADOW_TREES);
                            biomeModificationContext.getGenerationSettings()
                                    .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, SubVegetationPlacedFeatures.MEADOW_TREES);}
                );

        BiomeModifications.create(new Identifier(Sublunary.MOD_ID, "replace_dark_forest_trees"))
                .add(ModificationPhase.REPLACEMENTS, BiomeSelectors.includeByKey(BiomeKeys.DARK_FOREST),
                        biomeModificationContext -> {
                            biomeModificationContext.getGenerationSettings()
                                    .removeFeature(GenerationStep.Feature.VEGETAL_DECORATION, VANILLA_DARK_FOREST_TREES);
                            biomeModificationContext.getGenerationSettings()
                                    .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, SubVegetationPlacedFeatures.DARK_FOREST_TREES);}
                );

        BiomeModifications.create(new Identifier(Sublunary.MOD_ID, "replace_taiga_trees"))
                .add(ModificationPhase.REPLACEMENTS, BiomeSelectors.includeByKey(BiomeKeys.TAIGA, BiomeKeys.SNOWY_TAIGA),
                        biomeModificationContext -> {
                            biomeModificationContext.getGenerationSettings()
                                    .removeFeature(GenerationStep.Feature.VEGETAL_DECORATION, VANILLA_TAIGA_TREES);
                            biomeModificationContext.getGenerationSettings()
                                    .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, SubVegetationPlacedFeatures.TAIGA_TREES);}
                );

        BiomeModifications.create(new Identifier(Sublunary.MOD_ID, "replace_snowy_plains_trees"))
                .add(ModificationPhase.REPLACEMENTS, BiomeSelectors.includeByKey(BiomeKeys.SNOWY_PLAINS),
                        biomeModificationContext -> {
                            biomeModificationContext.getGenerationSettings()
                                    .removeFeature(GenerationStep.Feature.VEGETAL_DECORATION, VANILLA_SNOWY_PLAINS_TREES);
                            biomeModificationContext.getGenerationSettings()
                                    .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, SubVegetationPlacedFeatures.SNOWY_PLAINS_TREES);}
                );
    }
}

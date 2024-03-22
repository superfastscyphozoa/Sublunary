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

        BiomeModifications.create(new Identifier(Sublunary.MOD_ID, "remove_plains_flowers"))
                .add(ModificationPhase.REMOVALS, BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.SUNFLOWER_PLAINS),
                        biomeModificationContext -> {
                    biomeModificationContext.getGenerationSettings().removeFeature(GenerationStep.Feature.VEGETAL_DECORATION, VANILLA_PLAINS_FLOWERS);
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
    }
}

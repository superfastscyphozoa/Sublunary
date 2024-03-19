package net.superfastscyphozoa.sublunary.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.SpawnSettings;
import net.superfastscyphozoa.sublunary.Sublunary;
import net.superfastscyphozoa.sublunary.registry.RegisterEntities;

public class SublunaryEntityGeneration {

    public static void generateEntities(){

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FOREST),
                SpawnGroup.CREATURE, EntityType.RABBIT, 12, 3, 5);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FOREST),
                SpawnGroup.CREATURE, EntityType.FOX, 14, 2, 3);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.PLAINS),
                SpawnGroup.CREATURE, RegisterEntities.CROW, 12, 3, 5);

        BiomeModifications.create(new Identifier(Sublunary.MOD_ID,"replace_forest_creatures")).add
                (ModificationPhase.REPLACEMENTS, BiomeSelectors.includeByKey(BiomeKeys.FOREST), biomeModificationContext -> {

                    if (biomeModificationContext.getSpawnSettings().removeSpawnsOfEntityType(EntityType.COW)){
                        biomeModificationContext.getSpawnSettings()
                                .addSpawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.MULE, 16, 1, 4));
                    }

                    if (biomeModificationContext.getSpawnSettings().removeSpawnsOfEntityType(EntityType.CHICKEN)){
                        biomeModificationContext.getSpawnSettings()
                                .addSpawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(RegisterEntities.CROW, 10, 3, 5));
                    }
                });
    }
}

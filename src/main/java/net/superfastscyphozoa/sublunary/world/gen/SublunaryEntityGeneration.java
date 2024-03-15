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

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.PLAINS),
                SpawnGroup.CREATURE, RegisterEntities.CROW, 8, 3, 5);

        BiomeModifications.create(new Identifier(Sublunary.MOD_ID, "replace_forest_creaturas"))
                .add(ModificationPhase.REPLACEMENTS, BiomeSelectors.includeByKey(BiomeKeys.FOREST),
                        (context) ->
                        {
                            if (context.getSpawnSettings().removeSpawnsOfEntityType(EntityType.SHEEP)){
                                context.getSpawnSettings().addSpawn(SpawnGroup.CREATURE,
                                        new SpawnSettings.SpawnEntry(EntityType.MULE, 12, 1, 4));
                            }

                            if (context.getSpawnSettings().removeSpawnsOfEntityType(EntityType.CHICKEN)){
                                context.getSpawnSettings().addSpawn(SpawnGroup.CREATURE,
                                        new SpawnSettings.SpawnEntry(EntityType.RABBIT, 10, 3, 6));
                            }

                            if (context.getSpawnSettings().removeSpawnsOfEntityType(EntityType.PIG)){
                                context.getSpawnSettings().addSpawn(SpawnGroup.CREATURE,
                                        new SpawnSettings.SpawnEntry(RegisterEntities.CROW, 10, 3, 5));
                            }

                            if (context.getSpawnSettings().removeSpawnsOfEntityType(EntityType.COW)){
                                context.getSpawnSettings().addSpawn(SpawnGroup.CREATURE,
                                        new SpawnSettings.SpawnEntry(EntityType.FOX, 8, 2, 3));
                            }
                        });
    }
}

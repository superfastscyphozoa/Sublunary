package net.superfastscyphozoa.sublunary.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import net.superfastscyphozoa.sublunary.Sublunary;
import net.superfastscyphozoa.sublunary.registry.RegisterEntities;

public class SublunaryEntityGeneration {

    public static void generateEntities(){

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FOREST),
                SpawnGroup.CREATURE, EntityType.MULE, 12, 1, 4);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FOREST),
                SpawnGroup.CREATURE, EntityType.RABBIT, 10, 3, 6);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FOREST),
                SpawnGroup.CREATURE, RegisterEntities.CROW, 10, 1, 2);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FOREST),
                SpawnGroup.CREATURE, EntityType.FOX, 8, 2, 3);

    }

    public static void removeEntities(){

        BiomeModifications.create(new Identifier(Sublunary.MOD_ID, "remove_forest_creaturas"))
                .add(ModificationPhase.REMOVALS, BiomeSelectors.includeByKey(BiomeKeys.FOREST),
                        (context) ->
                        {
                            context.getSpawnSettings().removeSpawnsOfEntityType(EntityType.COW);
                            context.getSpawnSettings().removeSpawnsOfEntityType(EntityType.PIG);
                            context.getSpawnSettings().removeSpawnsOfEntityType(EntityType.SHEEP);
                            context.getSpawnSettings().removeSpawnsOfEntityType(EntityType.CHICKEN);
                        });

    }
}

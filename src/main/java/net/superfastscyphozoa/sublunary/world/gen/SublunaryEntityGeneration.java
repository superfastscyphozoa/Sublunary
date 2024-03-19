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
                SpawnGroup.CREATURE, EntityType.MULE, 16, 1, 4);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FOREST),
                SpawnGroup.CREATURE, EntityType.RABBIT, 12, 3, 5);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FOREST),
                SpawnGroup.CREATURE, EntityType.FOX, 14, 2, 3);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.FOREST),
                SpawnGroup.CREATURE, RegisterEntities.CROW, 16, 3, 5);
    }
}

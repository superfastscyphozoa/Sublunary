package net.superfastscyphozoa.sublunary.world.gen;


import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biomes;
import org.quiltmc.qsl.worldgen.biome.api.BiomeModifications;
import org.quiltmc.qsl.worldgen.biome.api.BiomeSelectors;

public class SublunaryEntityGeneration {

    public static void generateEntities(){

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.FOREST),
                SpawnGroup.CREATURE, EntityType.RABBIT, 12, 3, 5);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.FOREST),
                SpawnGroup.CREATURE, EntityType.FOX, 14, 2, 3);
    }
}

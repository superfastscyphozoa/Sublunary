package net.superfastscyphozoa.sublunary.world.gen;

public class SublunaryWorldGeneration {
    public static void generateSublunaryWorldGen(){
        SublunaryTreeGeneration.generateTrees();
        SublunaryFloraGeneration.generateFlora();
        SublunaryEntityGeneration.generateEntities();
    }
}

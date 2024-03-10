package net.superfastscyphozoa.sublunary.world.gen;

public class SublunaryWorldGeneration {
    public static void generateSublunaryWorldGen(){
        SublunaryTreeGeneration.generateTrees();
        SublunaryTreeGeneration.removeTrees();

        SublunaryFloraGeneration.generateFlora();
        SublunaryFloraGeneration.removeFlora();

        SublunaryEntityGeneration.generateEntities();
        SublunaryEntityGeneration.removeEntities();
    }
}

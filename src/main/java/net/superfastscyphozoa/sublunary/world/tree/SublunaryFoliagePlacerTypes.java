package net.superfastscyphozoa.sublunary.world.tree;

import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.superfastscyphozoa.sublunary.Sublunary;
import net.superfastscyphozoa.sublunary.mixin.FoliagePlacerTypeInvoker;
import net.superfastscyphozoa.sublunary.world.tree.foliage.BirchFoliagePlacer;

public class SublunaryFoliagePlacerTypes {
    public static final FoliagePlacerType<?> BIRCH_FOLIAGE_PLACER =
            FoliagePlacerTypeInvoker.callRegister("birch_foliage_placer", BirchFoliagePlacer.CODEC);

    public static void register(){
        Sublunary.LOGGER.info("Registering foliage placer for " + Sublunary.MOD_ID);
    }
}

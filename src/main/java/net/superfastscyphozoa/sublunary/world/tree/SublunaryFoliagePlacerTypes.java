package net.superfastscyphozoa.sublunary.world.tree;

import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.superfastscyphozoa.sublunary.Sublunary;
import net.superfastscyphozoa.sublunary.mixin.FoliagePlacerTypeInvoker;
import net.superfastscyphozoa.sublunary.world.tree.foliage.HangingBlobFoliagePlacer;
import net.superfastscyphozoa.sublunary.world.tree.foliage.HangingLargeBlobFoliagePlacer;

public class SublunaryFoliagePlacerTypes {
    public static final FoliagePlacerType<?> HANGING_BLOB_FOLIAGE_PLACER =
            FoliagePlacerTypeInvoker.callRegister("hanging_blob_foliage_placer", HangingBlobFoliagePlacer.CODEC);
	public static final FoliagePlacerType<?> HANGING_LARGE_BLOB_FOLIAGE_PLACER =
			FoliagePlacerTypeInvoker.callRegister("hanging_large_blob_foliage_placer", HangingLargeBlobFoliagePlacer.CODEC);

    public static void register(){
        Sublunary.LOGGER.info("Registering foliage placer for " + Sublunary.MOD_ID);
    }
}

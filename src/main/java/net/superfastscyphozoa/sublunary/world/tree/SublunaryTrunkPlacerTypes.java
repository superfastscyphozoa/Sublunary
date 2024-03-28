package net.superfastscyphozoa.sublunary.world.tree;

import net.minecraft.world.gen.trunk.TrunkPlacerType;
import net.superfastscyphozoa.sublunary.Sublunary;
import net.superfastscyphozoa.sublunary.mixin.TrunkPlacerTypeInvoker;
import net.superfastscyphozoa.sublunary.world.tree.trunk.StraightBranchedTrunkPlacer;

public class SublunaryTrunkPlacerTypes {
    public static final TrunkPlacerType<?> STRAIGHT_BRANCHED_TRUNK_PLACER =
            TrunkPlacerTypeInvoker.callRegister("straight_branched_trunk_placer", StraightBranchedTrunkPlacer.CODEC);

    public static void register() {
        Sublunary.LOGGER.info("registering trunk placers for " + Sublunary.MOD_ID);
    }
}

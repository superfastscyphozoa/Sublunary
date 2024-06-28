package net.superfastscyphozoa.sublunary.world.tree;

import net.minecraft.block.WoodTypes;
import net.superfastscyphozoa.sublunary.world.feature.configured.SubTreeConfiguredFeatures;

import java.util.Optional;

public class SublunarySaplings {
    public static final WoodTypes HICKORY =
            new WoodTypes("hickory", 0.5f ,Optional.empty(), Optional.empty(),
                    Optional.of(SubTreeConfiguredFeatures.HICKORY),
					Optional.of(SubTreeConfiguredFeatures.SUMMERY_HICKORY),
					Optional.empty(),
                    Optional.empty());
}

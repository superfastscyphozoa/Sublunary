package net.superfastscyphozoa.sublunary.world.tree;

import net.minecraft.block.SaplingGenerator;
import net.superfastscyphozoa.sublunary.world.feature.configured.SubTreeConfiguredFeatures;
import net.superfastscyphozoa.sublunary.world.feature.configured.SubVegetationConfiguredFeatures;

import java.util.Optional;

public class SublunarySaplings {
    public static final SaplingGenerator HICKORY =
            new SaplingGenerator("hickory", 0f ,Optional.empty(), Optional.empty(),
                    Optional.of(SubTreeConfiguredFeatures.HICKORY),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty());

}

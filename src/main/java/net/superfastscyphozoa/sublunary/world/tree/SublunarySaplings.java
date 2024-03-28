package net.superfastscyphozoa.sublunary.world.tree;

import net.minecraft.block.SaplingGenerator;
import net.superfastscyphozoa.sublunary.world.feature.configured.SubTreeConfiguredFeatures;
import net.superfastscyphozoa.sublunary.world.feature.configured.SubVegetationConfiguredFeatures;

import java.util.Optional;

public class SublunarySaplings {
    public static final SaplingGenerator MAPLE =
            new SaplingGenerator("maple", 0f ,Optional.empty(), Optional.empty(),
                    Optional.of(SubTreeConfiguredFeatures.FLOWER_FOREST_OAK),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty());

}

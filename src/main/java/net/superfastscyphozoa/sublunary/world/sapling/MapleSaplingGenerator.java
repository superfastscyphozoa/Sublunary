package net.superfastscyphozoa.sublunary.world.sapling;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.superfastscyphozoa.sublunary.world.feature.configured.SubTreeConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

public class MapleSaplingGenerator extends SaplingGenerator {
    @Nullable
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return SubTreeConfiguredFeatures.OAKIER_OAK_KEY;
    }
}

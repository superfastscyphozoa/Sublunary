package net.superfastscyphozoa.sublunary.blocks;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;

public class SublunaryFlammableBlocks {
    public static void registerFlammableBlocks() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(RegisterBlocks.MAPLE_LOG, 5, 5);
        registry.add(RegisterBlocks.MAPLE_WOOD, 5, 5);
        registry.add(RegisterBlocks.STRIPPED_MAPLE_LOG, 5, 5);
        registry.add(RegisterBlocks.STRIPPED_MAPLE_WOOD, 5, 5);

        registry.add(RegisterBlocks.RED_MAPLE_LEAVES, 30, 60);

        registry.add(RegisterBlocks.MAPLE_PLANKS, 5, 20);
    }
}

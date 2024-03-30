package net.superfastscyphozoa.sublunary.blocks;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;

public class SublunaryFlammableBlocks {
    public static void registerFlammableBlocks() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(RegisterBlocks.HICKORY_LOG, 5, 5);
        registry.add(RegisterBlocks.HICKORY_WOOD, 5, 5);
        registry.add(RegisterBlocks.STRIPPED_HICKORY_LOG, 5, 5);
        registry.add(RegisterBlocks.STRIPPED_HICKORY_WOOD, 5, 5);

        registry.add(RegisterBlocks.HICKORY_LEAVES, 30, 60);

        registry.add(RegisterBlocks.HICKORY_PLANKS, 5, 20);
    }
}

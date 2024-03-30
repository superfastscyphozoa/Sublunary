package net.superfastscyphozoa.sublunary.blocks;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;

public class SublunaryStrippableBlocks {
    public static void registerStrippableBlocks() {
        StrippableBlockRegistry.register(RegisterBlocks.HICKORY_LOG, RegisterBlocks.STRIPPED_HICKORY_LOG);
        StrippableBlockRegistry.register(RegisterBlocks.HICKORY_WOOD, RegisterBlocks.STRIPPED_HICKORY_WOOD);
    }
}

package net.superfastscyphozoa.sublunary.blocks;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.state.property.BooleanProperty;
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;

public class SublunaryStrippableBlocks {
    public static void registerStrippableBlocks() {
        StrippableBlockRegistry.register(RegisterBlocks.MAPLE_LOG, RegisterBlocks.STRIPPED_MAPLE_LOG);
        StrippableBlockRegistry.register(RegisterBlocks.MAPLE_WOOD, RegisterBlocks.STRIPPED_MAPLE_WOOD);
    }
}

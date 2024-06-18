package net.superfastscyphozoa.sublunary.blocks;

import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;
import org.quiltmc.qsl.block.content.registry.api.BlockContentRegistries;

public class SublunaryStrippableBlocks {
    public static void registerStrippableBlocks() {
		BlockContentRegistries.STRIPPABLE.put(RegisterBlocks.HICKORY_LOG, RegisterBlocks.STRIPPED_HICKORY_LOG);
		BlockContentRegistries.STRIPPABLE.put(RegisterBlocks.HICKORY_WOOD, RegisterBlocks.STRIPPED_HICKORY_WOOD);
    }
}

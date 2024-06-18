package net.superfastscyphozoa.sublunary.blocks;

import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;
import org.quiltmc.qsl.block.content.registry.api.BlockContentRegistries;
import org.quiltmc.qsl.block.content.registry.api.FlammableBlockEntry;

public class SublunaryFlammableBlocks {
    public static void registerFlammableBlocks() {
		BlockContentRegistries.FLAMMABLE.put(RegisterBlocks.HICKORY_LOG, new FlammableBlockEntry(5, 5));
		BlockContentRegistries.FLAMMABLE.put(RegisterBlocks.HICKORY_WOOD, new FlammableBlockEntry(5, 5));
		BlockContentRegistries.FLAMMABLE.put(RegisterBlocks.STRIPPED_HICKORY_LOG, new FlammableBlockEntry(5, 5));
		BlockContentRegistries.FLAMMABLE.put(RegisterBlocks.STRIPPED_HICKORY_WOOD, new FlammableBlockEntry(5, 5));

		BlockContentRegistries.FLAMMABLE.put(RegisterBlocks.HICKORY_LEAVES, new FlammableBlockEntry(30, 60));

		BlockContentRegistries.FLAMMABLE.put(RegisterBlocks.HICKORY_PLANKS, new FlammableBlockEntry(5, 20));
    }
}

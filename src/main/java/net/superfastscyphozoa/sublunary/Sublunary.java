package net.superfastscyphozoa.sublunary;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.superfastscyphozoa.sublunary.blocks.SublunaryFlammableBlocks;
import net.superfastscyphozoa.sublunary.blocks.SublunaryStrippableBlocks;
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;
import net.superfastscyphozoa.sublunary.registry.RegisterItems;
import net.superfastscyphozoa.sublunary.world.gen.SublunaryWorldGeneration;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sublunary implements ModInitializer {
	public static final String MOD_ID = "sublunary";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@NotNull
	public static Identifier id(@NotNull String path) {
		return new Identifier(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		LOGGER.info("Goo Goobie!");

		RegisterItems.registerSublunaryItems();
		RegisterBlocks.registerSublunaryBlocks();

		SublunaryWorldGeneration.generateSublunaryWorldGen();

		SublunaryFlammableBlocks.registerFlammableBlocks();
		SublunaryStrippableBlocks.registerStrippableBlocks();
	}
}
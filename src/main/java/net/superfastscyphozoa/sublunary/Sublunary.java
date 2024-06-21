package net.superfastscyphozoa.sublunary;

import net.superfastscyphozoa.sublunary.blocks.SublunaryFlammableBlocks;
import net.superfastscyphozoa.sublunary.blocks.SublunaryStrippableBlocks;
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;
import net.superfastscyphozoa.sublunary.registry.RegisterItems;
import net.superfastscyphozoa.sublunary.world.gen.SublunaryWorldGeneration;
import net.superfastscyphozoa.sublunary.world.tree.SublunaryFoliagePlacerTypes;
import net.superfastscyphozoa.sublunary.world.tree.SublunaryTreeDecoratorTypes;
import net.superfastscyphozoa.sublunary.world.tree.SublunaryTrunkPlacerTypes;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sublunary implements ModInitializer {
	public static final String MOD_ID = "sublunary";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Goo Goobie!");

		RegisterItems.registerSublunaryItems();
		RegisterBlocks.registerSublunaryBlocks();

		SublunaryWorldGeneration.generateSublunaryWorldGen();

		SublunaryFlammableBlocks.registerFlammableBlocks();
		SublunaryStrippableBlocks.registerStrippableBlocks();

		SublunaryTrunkPlacerTypes.register();
		SublunaryFoliagePlacerTypes.register();
		SublunaryTreeDecoratorTypes.register();
	}
}

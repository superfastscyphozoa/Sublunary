package net.superfastscyphozoa.sublunary;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.superfastscyphozoa.sublunary.blocks.SublunaryFlammableBlocks;
import net.superfastscyphozoa.sublunary.blocks.SublunaryStrippableBlocks;
import net.superfastscyphozoa.sublunary.entity.PasserineEntity;
import net.superfastscyphozoa.sublunary.registry.RegisterEntities;
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;
import net.superfastscyphozoa.sublunary.registry.RegisterItems;
import net.superfastscyphozoa.sublunary.world.gen.SublunaryWorldGeneration;
import net.superfastscyphozoa.sublunary.world.tree.SublunaryFoliagePlacerTypes;
import net.superfastscyphozoa.sublunary.world.tree.SublunaryTrunkPlacerTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sublunary implements ModInitializer {
	public static final String MOD_ID = "sublunary";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Goo Goobie!");

		RegisterItems.registerSublunaryItems();
		RegisterBlocks.registerSublunaryBlocks();

		SublunaryWorldGeneration.generateSublunaryWorldGen();

		SublunaryFlammableBlocks.registerFlammableBlocks();
		SublunaryStrippableBlocks.registerStrippableBlocks();

		SublunaryTrunkPlacerTypes.register();
		SublunaryFoliagePlacerTypes.register();

        FabricDefaultAttributeRegistry.register(RegisterEntities.PASSERINE, PasserineEntity.createPasserineAttributes());
	}
}
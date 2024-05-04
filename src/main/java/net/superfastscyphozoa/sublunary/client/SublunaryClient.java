package net.superfastscyphozoa.sublunary.client;

import net.minecraft.client.render.RenderLayer;
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.block.extensions.api.client.BlockRenderLayerMap;

public class SublunaryClient implements ClientModInitializer {

	@Override
	public void onInitializeClient(ModContainer mod) {

		//render types
		BlockRenderLayerMap.put(RenderLayer.getCutout(), RegisterBlocks.LAVENDER);
		BlockRenderLayerMap.put(RenderLayer.getCutout(), RegisterBlocks.CLOVERS);
		BlockRenderLayerMap.put(RenderLayer.getCutout(), RegisterBlocks.HICKORY_SAPLING);

		//ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 7979098, RegisterBlocks.CLOVERS);

		//ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 7979098, RegisterBlocks.SHORT_GRASS.asItem());
	}
}

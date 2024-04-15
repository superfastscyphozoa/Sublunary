package net.superfastscyphozoa.sublunary.client;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.superfastscyphozoa.sublunary.entity.client.PasserineModel;
import net.superfastscyphozoa.sublunary.entity.client.PasserineRenderer;
import net.superfastscyphozoa.sublunary.entity.client.SublunaryModelLayers;
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;
import net.superfastscyphozoa.sublunary.registry.RegisterEntities;
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

		//render mobs
		EntityRendererRegistry.register(RegisterEntities.PASSERINE, PasserineRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(SublunaryModelLayers.PASSERINE, PasserineModel::getTexturedModelData);

		ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 7979098, RegisterBlocks.CLOVERS);

		//ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 7979098, RegisterBlocks.SHORT_GRASS.asItem());
	}
}

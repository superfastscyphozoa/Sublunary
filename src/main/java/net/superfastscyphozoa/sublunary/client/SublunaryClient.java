package net.superfastscyphozoa.sublunary.client;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.GrassColors;
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
		BlockRenderLayerMap.put(RenderLayer.getCutout(), RegisterBlocks.POTTED_LAVENDER);

		BlockRenderLayerMap.put(RenderLayer.getCutout(), RegisterBlocks.CALLA_LILY);
		BlockRenderLayerMap.put(RenderLayer.getCutout(), RegisterBlocks.POTTED_CALLA_LILY);

		BlockRenderLayerMap.put(RenderLayer.getCutout(), RegisterBlocks.CLOVERS);

		BlockRenderLayerMap.put(RenderLayer.getCutout(), RegisterBlocks.HICKORY_NUT);

		ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
					if (world == null || pos == null) {
						return GrassColors.getDefault();
					}
					return BiomeColors.getGrassColor(world, pos);
				}, RegisterBlocks.CLOVERS);
	}
}

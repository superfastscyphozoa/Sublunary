package net.superfastscyphozoa.sublunary.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.superfastscyphozoa.sublunary.registry.RegisterEntities;
import net.superfastscyphozoa.sublunary.entity.client.PasserineModel;
import net.superfastscyphozoa.sublunary.entity.client.PasserineRenderer;
import net.superfastscyphozoa.sublunary.entity.client.SublunaryModelLayers;
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;

public class SublunaryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        //render types
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.LAVENDER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.CLOVERS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.SHORT_GRASS, RenderLayer.getCutout());

        //render mobs
        EntityRendererRegistry.register(RegisterEntities.PASSERINE, PasserineRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(SublunaryModelLayers.PASSERINE, PasserineModel::getTexturedModelData);
    }
}

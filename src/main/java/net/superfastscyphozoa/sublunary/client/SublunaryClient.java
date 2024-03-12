package net.superfastscyphozoa.sublunary.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.RenderLayer;
import net.superfastscyphozoa.sublunary.entity.SublunaryEntities;
import net.superfastscyphozoa.sublunary.entity.client.BadgerModel;
import net.superfastscyphozoa.sublunary.entity.client.BadgerRenderer;
import net.superfastscyphozoa.sublunary.entity.client.SublunaryModelLayers;
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;

import java.util.Objects;

public class SublunaryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        //render types
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.LAVENDER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.CLOVERS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.SHORT_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.TURKEY_TAIL, RenderLayer.getCutout());


        //render mobs
        EntityRendererRegistry.register(SublunaryEntities.BADGER, BadgerRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(SublunaryModelLayers.BADGER, BadgerModel::getTexturedModelData);

        //register block and item colours

        int itemGrassColour = 7979098;
        int itemFoliageColour = 5877296;

        ColorProviderRegistry.BLOCK.register(((state, level, pos, tintIndex) ->
                        BiomeColors.getGrassColor(Objects.requireNonNull(level), Objects.requireNonNull(pos))),
                RegisterBlocks.CLOVERS, RegisterBlocks.SHORT_GRASS);

        ColorProviderRegistry.ITEM.register(((state, tintIndex) -> itemGrassColour),
                RegisterBlocks.SHORT_GRASS);
    }
}

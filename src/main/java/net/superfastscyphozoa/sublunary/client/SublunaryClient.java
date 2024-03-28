package net.superfastscyphozoa.sublunary.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
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

        //render mobs
        EntityRendererRegistry.register(RegisterEntities.PASSERINE, PasserineRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(SublunaryModelLayers.PASSERINE, PasserineModel::getTexturedModelData);

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 7979098, RegisterBlocks.CLOVERS);

        //ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 7979098, RegisterBlocks.SHORT_GRASS.asItem());
    }
}

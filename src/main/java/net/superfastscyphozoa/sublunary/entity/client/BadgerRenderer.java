package net.superfastscyphozoa.sublunary.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.superfastscyphozoa.sublunary.Sublunary;
import net.superfastscyphozoa.sublunary.entity.BadgerEntity;

public class BadgerRenderer extends MobEntityRenderer<BadgerEntity, BadgerModel<BadgerEntity>> {
    private static final Identifier TEXTURE = new Identifier(Sublunary.MOD_ID, "textures/entity/badger.png");

    public BadgerRenderer(EntityRendererFactory.Context context) {
        super(context, new BadgerModel<>(context.getPart(SublunaryModelLayers.BADGER)), 0.6f);
    }

    @Override
    public Identifier getTexture(BadgerEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(BadgerEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {

        if(mobEntity.isBaby()){
            matrixStack.scale(0.5f,0.5f,0.5f);
        } else {
            matrixStack.scale(1f,1f,1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}

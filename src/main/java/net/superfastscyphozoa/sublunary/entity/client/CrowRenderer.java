package net.superfastscyphozoa.sublunary.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.superfastscyphozoa.sublunary.Sublunary;
import net.superfastscyphozoa.sublunary.entity.CrowEntity;

public class CrowRenderer extends MobEntityRenderer<CrowEntity, CrowModel<CrowEntity>> {
    private static final Identifier TEXTURE = new Identifier(Sublunary.MOD_ID, "textures/entity/crow.png");

    public CrowRenderer(EntityRendererFactory.Context context) {
        super(context, new CrowModel<>(context.getPart(SublunaryModelLayers.CROW)), 0.2f);
    }

    @Override
    public Identifier getTexture(CrowEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(CrowEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {

        if(mobEntity.isBaby()){
            matrixStack.scale(0.5f,0.5f,0.5f);
        } else {
            matrixStack.scale(1f,1f,1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}

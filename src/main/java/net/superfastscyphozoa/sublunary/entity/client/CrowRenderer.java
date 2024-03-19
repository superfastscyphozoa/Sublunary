package net.superfastscyphozoa.sublunary.entity.client;

import com.google.common.collect.Maps;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.superfastscyphozoa.sublunary.Sublunary;
import net.superfastscyphozoa.sublunary.entity.CrowEntity;
import net.superfastscyphozoa.sublunary.entity.variant.CrowVariant;

import java.util.Map;

public class CrowRenderer extends MobEntityRenderer<CrowEntity, CrowModel<CrowEntity>> {
    //private static final Identifier BLACK_TEXTURE = new Identifier(Sublunary.MOD_ID, "textures/entity/crow/crow.png");

    public static final Map<CrowVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(CrowVariant.class), (map) -> {
                map.put(CrowVariant.BLACK,
                        new Identifier(Sublunary.MOD_ID, "textures/entity/crow/crow.png"));
                map.put(CrowVariant.BROWN,
                        new Identifier(Sublunary.MOD_ID, "textures/entity/crow/brown_crow.png"));
                map.put(CrowVariant.WHITE,
                        new Identifier(Sublunary.MOD_ID, "textures/entity/crow/white_crow.png"));
            });

    public CrowRenderer(EntityRendererFactory.Context context) {
        super(context, new CrowModel<>(context.getPart(SublunaryModelLayers.CROW)), 0.2f);
    }

    @Override
    public Identifier getTexture(CrowEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
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

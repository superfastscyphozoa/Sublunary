package net.superfastscyphozoa.sublunary.entity.client;

import com.google.common.collect.Maps;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.superfastscyphozoa.sublunary.Sublunary;
import net.superfastscyphozoa.sublunary.entity.PasserineEntity;
import net.superfastscyphozoa.sublunary.entity.variant.PasserineVariant;

import java.util.Map;

public class PasserineRenderer extends MobEntityRenderer<PasserineEntity, PasserineModel<PasserineEntity>> {
    //private static final Identifier BLACK_TEXTURE = new Identifier(Sublunary.MOD_ID, "textures/entity/crow/crow.png");

    public static final Map<PasserineVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(PasserineVariant.class), (map) -> {
                map.put(PasserineVariant.BLACK,
                        new Identifier(Sublunary.MOD_ID, "textures/entity/crow/crow.png"));
                map.put(PasserineVariant.BROWN,
                        new Identifier(Sublunary.MOD_ID, "textures/entity/crow/brown_crow.png"));
                map.put(PasserineVariant.WHITE,
                        new Identifier(Sublunary.MOD_ID, "textures/entity/crow/white_crow.png"));
            });

    public PasserineRenderer(EntityRendererFactory.Context context) {
        super(context, new PasserineModel<>(context.getPart(SublunaryModelLayers.PASSERINE)), 0.2f);
    }

    @Override
    public Identifier getTexture(PasserineEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(PasserineEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {

        if(mobEntity.isBaby()){
            matrixStack.scale(0.5f,0.5f,0.5f);
        } else {
            matrixStack.scale(1f,1f,1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}

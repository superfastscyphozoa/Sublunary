package net.superfastscyphozoa.sublunary.entity.client;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.superfastscyphozoa.sublunary.Sublunary;

public class SublunaryModelLayers {
    public static final EntityModelLayer CROW =
            new EntityModelLayer(new Identifier(Sublunary.MOD_ID, "crow"), "main");
}

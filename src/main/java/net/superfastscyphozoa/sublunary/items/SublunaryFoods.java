package net.superfastscyphozoa.sublunary.items;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class SublunaryFoods {

    public static final FoodComponent FOODONE;

    static {
        FOODONE = (new FoodComponent.Builder())
                .hunger(2).saturationModifier(0.1F).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 250, 2), 0.5F).build();
    }
}

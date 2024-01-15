package net.superfastscyphozoa.sublunary.items;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class SublunaryFoods {

    public static final FoodComponent TURKEY_TAIL;
    public static final FoodComponent FLOUR;
    public static final FoodComponent DOUGH;

    static {
        TURKEY_TAIL = (new FoodComponent.Builder()).hunger(4).saturationModifier(0.3F).build();
        FLOUR = (new FoodComponent.Builder())
                .hunger(2).saturationModifier(0.1F).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 250, 2), 0.5F).build();
        DOUGH = (new FoodComponent.Builder())
                .hunger(2).saturationModifier(0.1F).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 250, 2), 0.5F).build();
    }
}

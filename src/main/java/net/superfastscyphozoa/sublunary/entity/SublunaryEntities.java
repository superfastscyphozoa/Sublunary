package net.superfastscyphozoa.sublunary.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.superfastscyphozoa.sublunary.Sublunary;

public class SublunaryEntities {
    public static final EntityType<BadgerEntity> BADGER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Sublunary.MOD_ID, "badger"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, BadgerEntity::new)
                    .dimensions(EntityDimensions.fixed(1f,0.8f)).build());
}

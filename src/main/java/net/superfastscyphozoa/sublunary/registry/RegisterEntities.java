package net.superfastscyphozoa.sublunary.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.superfastscyphozoa.sublunary.Sublunary;
import net.superfastscyphozoa.sublunary.entity.PasserineEntity;

public class RegisterEntities {
    public static final EntityType<PasserineEntity> PASSERINE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Sublunary.MOD_ID, "passerine"),
            FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT, PasserineEntity::new)
                    .dimensions(EntityDimensions.fixed(0.3f,0.6f)).build());
}

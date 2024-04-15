package net.superfastscyphozoa.sublunary.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.superfastscyphozoa.sublunary.Sublunary;
import net.superfastscyphozoa.sublunary.items.FlourItem;
import net.superfastscyphozoa.sublunary.items.SublunaryFoods;
import net.superfastscyphozoa.sublunary.items.SublunaryToolMaterials;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class RegisterItems {

    //registry

    public static final Item FOUR_LEAF_CLOVER = registerItem("four_leaf_clover",
            new Item(new QuiltItemSettings()));

    // equipment

    public static final Item RUSTED_SWORD = registerItem("rusted_sword",
            new SwordItem(SublunaryToolMaterials.RUSTED, 3,-2.4f,new QuiltItemSettings()));

    // flour and dough

    public static final Item FLOUR = registerItem("flour",
            new FlourItem(new QuiltItemSettings()));

    public static final Item DOUGH = registerItem("dough",
            new Item(new QuiltItemSettings().food(SublunaryFoods.DOUGH)));

    //spawn eggs
    public static final Item PASSERINE_SPAWN_EGG = registerItem("passerine_spawn_egg",
            new SpawnEggItem(RegisterEntities.PASSERINE, 1051950, 5715335, new QuiltItemSettings()));

    //registry end

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Sublunary.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup(){
        //add items to item groups
        addToItemGroup(ItemGroups.COMBAT, RUSTED_SWORD);

        addToItemGroup(ItemGroups.INGREDIENTS, FLOUR);
        addToItemGroup(ItemGroups.FOOD_AND_DRINKS, FLOUR);
        addToItemGroup(ItemGroups.INGREDIENTS, DOUGH);
        addToItemGroup(ItemGroups.FOOD_AND_DRINKS, DOUGH);
    }

    public static void addToItemGroup(RegistryKey<ItemGroup> group, Item item){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addItem(item));
    }

    public static void registerSublunaryItems() {
        Sublunary.LOGGER.info("Registering items for " + Sublunary.MOD_ID);

        addItemsToItemGroup();
    }
}

package net.superfastscyphozoa.sublunary.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.superfastscyphozoa.sublunary.Sublunary;

public class RegisterItems {

    //registry

    public static final Item PUPA = registerItem("pupa",
            new Item(new FabricItemSettings()));

    public static final Item FOUR_LEAF_CLOVER = registerItem("four_leaf_clover",
            new Item(new FabricItemSettings()));

    //registry end

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Sublunary.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup(){
        //add items to item groups
        addToItemGroup(ItemGroups.INGREDIENTS, FOUR_LEAF_CLOVER);
    }

    public static void addToItemGroup(RegistryKey<ItemGroup> group, Item item){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerSublunaryItems() {
        Sublunary.LOGGER.info("Registering items for" + Sublunary.MOD_ID);

        addItemsToItemGroup();
    }
}

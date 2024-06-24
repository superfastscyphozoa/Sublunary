package net.superfastscyphozoa.sublunary.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.superfastscyphozoa.sublunary.Sublunary;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class RegisterItems {

    //registry

    public static final Item FOUR_LEAF_CLOVER = registerItem("four_leaf_clover",
            new Item(new QuiltItemSettings()));

    //registry end

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Sublunary.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup(){
        //add items to item groups
        addToItemGroup(ItemGroups.INGREDIENTS, FOUR_LEAF_CLOVER);
    }

    public static void addToItemGroup(RegistryKey<ItemGroup> group, Item item){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addItem(item));
    }

    public static void registerSublunaryItems() {
        Sublunary.LOGGER.info("Registering items for " + Sublunary.MOD_ID);

        addItemsToItemGroup();
    }
}

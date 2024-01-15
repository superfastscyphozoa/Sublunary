package net.superfastscyphozoa.sublunary.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.superfastscyphozoa.sublunary.Sublunary;
import net.superfastscyphozoa.sublunary.items.SublunaryFoods;

public class RegisterItems {

    //registry

    public static final Item PUPA = registerItem("pupa",
            new Item(new FabricItemSettings()));

    public static final Item FOUR_LEAF_CLOVER = registerItem("four_leaf_clover",
            new Item(new FabricItemSettings()));

    // flour and dough

    public static final Item FLOUR = registerItem("flour",
            new Item(new FabricItemSettings().food(SublunaryFoods.FLOUR)));

    public static final Item DOUGH = registerItem("dough",
            new Item(new FabricItemSettings().food(SublunaryFoods.DOUGH)));

    //fungus

    public static final Item TURKEY_TAIL_FUNGUS = registerItem (
            (String)"turkey_tail_fungus", (Item)(new AliasedBlockItem(RegisterBlocks.TURKEY_TAIL, (new FabricItemSettings()).food(SublunaryFoods.TURKEY_TAIL))));

    //registry end

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Sublunary.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup(){
        //add items to item groups
        addToItemGroup(ItemGroups.INGREDIENTS, FOUR_LEAF_CLOVER);

        addToItemGroup(ItemGroups.INGREDIENTS, FLOUR);
        addToItemGroup(ItemGroups.FOOD_AND_DRINK, FLOUR);
        addToItemGroup(ItemGroups.INGREDIENTS, DOUGH);
        addToItemGroup(ItemGroups.FOOD_AND_DRINK, DOUGH);

        addToItemGroup(ItemGroups.NATURAL, TURKEY_TAIL_FUNGUS);
        addToItemGroup(ItemGroups.FOOD_AND_DRINK, TURKEY_TAIL_FUNGUS);
    }

    public static void addToItemGroup(RegistryKey<ItemGroup> group, Item item){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerSublunaryItems() {
        Sublunary.LOGGER.info("Registering items for" + Sublunary.MOD_ID);

        addItemsToItemGroup();
    }
}

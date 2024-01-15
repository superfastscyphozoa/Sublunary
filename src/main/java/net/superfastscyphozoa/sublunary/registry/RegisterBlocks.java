package net.superfastscyphozoa.sublunary.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.superfastscyphozoa.sublunary.Sublunary;
import net.superfastscyphozoa.sublunary.blocks.BushyFlowerBlock;
import net.superfastscyphozoa.sublunary.blocks.ShelfFungusBlock;
import net.superfastscyphozoa.sublunary.blocks.ShortGrassBlock;
import net.superfastscyphozoa.sublunary.world.sapling.YellowBirchSaplingGenerator;

public class RegisterBlocks {

    //registry

    public static final Block SHORT_GRASS = registerBlock("short_grass",
            new ShortGrassBlock(FabricBlockSettings.create().replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ)),
            ItemGroups.NATURAL);

    public static final Block CLOVERS = registerBlock("clovers",
            new FlowerbedBlock(FabricBlockSettings.create().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS)),
            ItemGroups.NATURAL);

    //flowers

    public static final Block LAVENDER = registerBlock("lavender",
            new BushyFlowerBlock(StatusEffects.REGENERATION, 8, FabricBlockSettings.create().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ)),
            ItemGroups.NATURAL);

    //maple

    public static final Block MAPLE_LOG = registerBlock("maple_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).requiresTool()),
            null);
    public static final Block MAPLE_WOOD = registerBlock("maple_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).requiresTool()),
            null);
    public static final Block STRIPPED_MAPLE_LOG = registerBlock("stripped_maple_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).requiresTool()),
            null);
    public static final Block STRIPPED_MAPLE_WOOD = registerBlock("stripped_maple_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).requiresTool()),
            null);
    public static final Block MAPLE_PLANKS = registerBlock("maple_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).requiresTool()),
            null);
    public static final Block RED_MAPLE_LEAVES = registerBlock("red_maple_leaves",
            new LeavesBlock(FabricBlockSettings.create().mapColor(MapColor.RED).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.AZALEA_LEAVES).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never)),
            null);

    // yellow birch

    public static final Block YELLOW_BIRCH_LEAVES = registerBlock("yellow_birch_leaves",
            new LeavesBlock(FabricBlockSettings.create().mapColor(MapColor.YELLOW).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never)),
            ItemGroups.NATURAL);

    public static final Block YELLOW_BIRCH_SAPLING = registerBlock("yellow_birch_sapling",
            new SaplingBlock(new YellowBirchSaplingGenerator(),FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)),
            ItemGroups.NATURAL);

    //turkey tail

    public static final Block TURKEY_TAIL = registerBlockWithoutItem("turkey_tail",
            new ShelfFungusBlock(FabricBlockSettings.create().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY)));

    //registry end

    private static Block registerBlock(String name, Block block, RegistryKey<ItemGroup> group){
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(Sublunary.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, RegistryKey<ItemGroup> group){
        Item item = Registry.register(Registries.ITEM, new Identifier(Sublunary.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    private static Block registerBlockWithoutItem(String name, Block block){
        return Registry.register(Registries.BLOCK, new Identifier(Sublunary.MOD_ID, name), block);
    }

    public static void registerSublunaryBlocks() {
        Sublunary.LOGGER.info("Registering blocks for" + Sublunary.MOD_ID);
    }
}

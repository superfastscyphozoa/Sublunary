package net.superfastscyphozoa.sublunary.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.block.sapling.SaplingBlock;
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
import net.superfastscyphozoa.sublunary.blocks.CloverBlock;
import net.superfastscyphozoa.sublunary.world.tree.SublunarySaplings;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class RegisterBlocks {

    //registry

    public static final Block CLOVERS = registerBlock("clovers",
            new CloverBlock(QuiltBlockSettings.create().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS)),
			ItemGroups.NATURAL_BLOCKS);

    //flowers

    public static final Block LAVENDER = registerBlock("lavender",
            new BushyFlowerBlock(StatusEffects.REGENERATION, 8, QuiltBlockSettings.create().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offsetType(AbstractBlock.OffsetType.XZ)),
            ItemGroups.NATURAL_BLOCKS);

	public static final Block CALLA_LILY = registerBlock("calla_lily",
			new BushyFlowerBlock(StatusEffects.POISON, 8, QuiltBlockSettings.create().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offsetType(AbstractBlock.OffsetType.XZ)),
			ItemGroups.NATURAL_BLOCKS);

    //hickory

    public static final Block HICKORY_LOG = registerBlock("hickory_log",
            new PillarBlock(QuiltBlockSettings.copyOf(Blocks.OAK_LOG).requiresTool()),
            ItemGroups.BUILDING_BLOCKS);
    public static final Block HICKORY_WOOD = registerBlock("hickory_wood",
            new PillarBlock(QuiltBlockSettings.copyOf(Blocks.OAK_WOOD).requiresTool()),
            ItemGroups.BUILDING_BLOCKS);
    public static final Block STRIPPED_HICKORY_LOG = registerBlock("stripped_hickory_log",
            new PillarBlock(QuiltBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).requiresTool()),
            ItemGroups.BUILDING_BLOCKS);
    public static final Block STRIPPED_HICKORY_WOOD = registerBlock("stripped_hickory_wood",
            new PillarBlock(QuiltBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).requiresTool()),
            ItemGroups.BUILDING_BLOCKS);
    public static final Block HICKORY_PLANKS = registerBlock("hickory_planks",
            new Block(QuiltBlockSettings.copyOf(Blocks.OAK_PLANKS).requiresTool()),
            ItemGroups.BUILDING_BLOCKS);

    public static final Block HICKORY_LEAVES = registerBlock("hickory_leaves",
            new LeavesBlock(QuiltBlockSettings.create().mapColor(MapColor.YELLOW).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::allowOcelotsAndParrots).suffocates(Blocks::nonSolid).blockVision(Blocks::nonSolid).lavaIgnitable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::nonSolid)),
            ItemGroups.NATURAL_BLOCKS);

    public static final Block HICKORY_SAPLING = registerBlock("hickory_sapling",
            new SaplingBlock(SublunarySaplings.HICKORY, QuiltBlockSettings.copyOf(Blocks.OAK_SAPLING)),
            ItemGroups.NATURAL_BLOCKS);

    //registry end

    private static Block registerBlock(String name, Block block, RegistryKey<ItemGroup> group){
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(Sublunary.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, RegistryKey<ItemGroup> group){
        Item item = Registry.register(Registries.ITEM, new Identifier(Sublunary.MOD_ID, name),
                new BlockItem(block, new QuiltItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addItem(item));
        return item;
    }

    private static Block registerBlockWithoutItem(String name, Block block){
        return Registry.register(Registries.BLOCK, new Identifier(Sublunary.MOD_ID, name), block);
    }

    public static void registerSublunaryBlocks() {
        Sublunary.LOGGER.info("Registering blocks for " + Sublunary.MOD_ID);
    }
}

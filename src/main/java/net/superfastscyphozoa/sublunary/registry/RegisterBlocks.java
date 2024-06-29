package net.superfastscyphozoa.sublunary.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.superfastscyphozoa.sublunary.Sublunary;
import net.superfastscyphozoa.sublunary.blocks.BushyFlowerBlock;
import net.superfastscyphozoa.sublunary.blocks.CloverBlock;
import net.superfastscyphozoa.sublunary.blocks.HickoryNutBlock;
import net.superfastscyphozoa.sublunary.blocks.HickoryLeavesBlock;
import net.superfastscyphozoa.sublunary.world.tree.SublunarySaplings;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class RegisterBlocks {

    //registry

    public static final Block CLOVERS = registerBlock("clovers",
            new CloverBlock(QuiltBlockSettings.create().nonOpaque().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS)));

    //flowers

    public static final Block LAVENDER = registerBlock("lavender",
            new BushyFlowerBlock(StatusEffects.REGENERATION, 8, QuiltBlockSettings.create().nonOpaque().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offsetType(AbstractBlock.OffsetType.XZ)));

	public static final Block POTTED_LAVENDER = Registry.register(Registries.BLOCK, new Identifier(Sublunary.MOD_ID, "potted_lavender"),
			new FlowerPotBlock(LAVENDER, QuiltBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));

	public static final Block CALLA_LILY = registerBlock("calla_lily",
			new BushyFlowerBlock(StatusEffects.POISON, 8, QuiltBlockSettings.create().nonOpaque().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offsetType(AbstractBlock.OffsetType.XZ)));

	public static final Block POTTED_CALLA_LILY = Registry.register(Registries.BLOCK, new Identifier(Sublunary.MOD_ID, "potted_calla_lily"),
			new FlowerPotBlock(CALLA_LILY, QuiltBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));

    //hickory

    public static final Block HICKORY_LOG = registerBlock("hickory_log",
            new PillarBlock(QuiltBlockSettings.copyOf(Blocks.OAK_LOG).requiresTool()));
    public static final Block HICKORY_WOOD = registerBlock("hickory_wood",
            new PillarBlock(QuiltBlockSettings.copyOf(Blocks.OAK_WOOD).requiresTool()));
    public static final Block STRIPPED_HICKORY_LOG = registerBlock("stripped_hickory_log",
            new PillarBlock(QuiltBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).requiresTool()));
    public static final Block STRIPPED_HICKORY_WOOD = registerBlock("stripped_hickory_wood",
            new PillarBlock(QuiltBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).requiresTool()));
    public static final Block HICKORY_PLANKS = registerBlock("hickory_planks",
            new Block(QuiltBlockSettings.copyOf(Blocks.OAK_PLANKS).requiresTool()));

    public static final Block AUTUMNAL_HICKORY_LEAVES = registerBlock("autumnal_hickory_leaves",
            new HickoryLeavesBlock(QuiltBlockSettings.create().mapColor(MapColor.YELLOW).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::allowOcelotsAndParrots).suffocates(Blocks::nonSolid).blockVision(Blocks::nonSolid).lavaIgnitable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::nonSolid)));
	public static final Block SUMMERY_HICKORY_LEAVES = registerBlock("summery_hickory_leaves",
			new HickoryLeavesBlock(QuiltBlockSettings.create().mapColor(MapColor.LIME).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::allowOcelotsAndParrots).suffocates(Blocks::nonSolid).blockVision(Blocks::nonSolid).lavaIgnitable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::nonSolid)));
	public static final Block VERNAL_HICKORY_LEAVES = registerBlock("vernal_hickory_leaves",
			new HickoryLeavesBlock(QuiltBlockSettings.create().mapColor(MapColor.GREEN).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(Blocks::allowOcelotsAndParrots).suffocates(Blocks::nonSolid).blockVision(Blocks::nonSolid).lavaIgnitable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::nonSolid)));

    public static final Block HICKORY_NUT = registerBlock("hickory_nut",
            new HickoryNutBlock(SublunarySaplings.HICKORY, QuiltBlockSettings.copyOf(Blocks.MANGROVE_PROPAGULE)));

    //registry end

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Sublunary.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
		return Registry.register(Registries.ITEM, new Identifier(Sublunary.MOD_ID, name),
				new BlockItem(block, new QuiltItemSettings()));
    }

	//add items to item group

	public static void addItemsToItemGroup(){
		addToItemGroup(ItemGroups.NATURAL_BLOCKS, CLOVERS.asItem(), Items.FERN);

		addToItemGroup(ItemGroups.NATURAL_BLOCKS, LAVENDER.asItem(), Items.LILY_OF_THE_VALLEY);
		addToItemGroup(ItemGroups.NATURAL_BLOCKS, CALLA_LILY.asItem(), LAVENDER.asItem());

		addToItemGroup(ItemGroups.NATURAL_BLOCKS, HICKORY_LOG.asItem(), Items.CHERRY_LOG);
		addToItemGroup(ItemGroups.NATURAL_BLOCKS, VERNAL_HICKORY_LEAVES.asItem(), Items.CHERRY_LEAVES);
		addToItemGroup(ItemGroups.NATURAL_BLOCKS, SUMMERY_HICKORY_LEAVES.asItem(), VERNAL_HICKORY_LEAVES.asItem());
		addToItemGroup(ItemGroups.NATURAL_BLOCKS, AUTUMNAL_HICKORY_LEAVES.asItem(), SUMMERY_HICKORY_LEAVES.asItem());
		addToItemGroup(ItemGroups.NATURAL_BLOCKS, HICKORY_NUT.asItem(), Items.CHERRY_SAPLING);

		addToItemGroup(ItemGroups.BUILDING_BLOCKS, HICKORY_LOG.asItem(), Items.CHERRY_BUTTON);
		addToItemGroup(ItemGroups.BUILDING_BLOCKS, HICKORY_WOOD.asItem(), HICKORY_LOG.asItem());
		addToItemGroup(ItemGroups.BUILDING_BLOCKS, STRIPPED_HICKORY_LOG.asItem(), HICKORY_WOOD.asItem());
		addToItemGroup(ItemGroups.BUILDING_BLOCKS, STRIPPED_HICKORY_WOOD.asItem(), STRIPPED_HICKORY_LOG.asItem());
		addToItemGroup(ItemGroups.BUILDING_BLOCKS, HICKORY_PLANKS.asItem(), STRIPPED_HICKORY_WOOD.asItem());
	}

	public static void addToItemGroup(RegistryKey<ItemGroup> group, Item item, Item afterItem){
		ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.addAfter(afterItem, item));
	}

    public static void registerSublunaryBlocks() {
        Sublunary.LOGGER.info("Registering blocks for " + Sublunary.MOD_ID);

		addItemsToItemGroup();
    }
}

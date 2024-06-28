package net.superfastscyphozoa.sublunary.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.TableBonusLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;

public class SublunaryLootTableProvider extends FabricBlockLootTableProvider {
    public SublunaryLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {

		addDrop(RegisterBlocks.HICKORY_LOG);
		addDrop(RegisterBlocks.HICKORY_WOOD);
		addDrop(RegisterBlocks.STRIPPED_HICKORY_LOG);
		addDrop(RegisterBlocks.STRIPPED_HICKORY_WOOD);

		addDrop(RegisterBlocks.HICKORY_PLANKS);

		addDrop(RegisterBlocks.HICKORY_SAPLING);

		add(RegisterBlocks.HICKORY_LEAVES, this::hickoryLeavesDrop);

        addDrop(RegisterBlocks.LAVENDER);
		addDrop(RegisterBlocks.CALLA_LILY);

		addPottedPlantDrops(RegisterBlocks.POTTED_LAVENDER);
		addPottedPlantDrops(RegisterBlocks.POTTED_CALLA_LILY);
    }

	public LootTable.Builder hickoryLeavesDrop(Block leaves) {
		return dropsWithShearsOrSilkTouch(leaves, ((LeafEntry.Builder<?>)
				this.applyExplosionDecay(RegisterBlocks.HICKORY_LEAVES, ItemEntry.builder(Items.STICK)
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))))
				.conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, LEAVES_STICK_DROP_CHANCES)));
	}
}

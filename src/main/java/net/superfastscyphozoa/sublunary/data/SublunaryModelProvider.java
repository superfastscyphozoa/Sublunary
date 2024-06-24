package net.superfastscyphozoa.sublunary.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.model.BlockStateModelGenerator;
import net.minecraft.data.client.model.Model;
import net.minecraft.data.client.model.Models;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;
import net.superfastscyphozoa.sublunary.registry.RegisterItems;

import java.util.Optional;

public class SublunaryModelProvider extends FabricModelProvider {
    public SublunaryModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerLog(RegisterBlocks.HICKORY_LOG).log(RegisterBlocks.HICKORY_LOG).wood(RegisterBlocks.HICKORY_WOOD);
        blockStateModelGenerator.registerLog(RegisterBlocks.STRIPPED_HICKORY_LOG).log(RegisterBlocks.STRIPPED_HICKORY_LOG).wood(RegisterBlocks.STRIPPED_HICKORY_WOOD);

        blockStateModelGenerator.registerSimpleCubeAll(RegisterBlocks.HICKORY_PLANKS);

		blockStateModelGenerator.registerTintableCross(RegisterBlocks.CALLA_LILY, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerTintableCross(RegisterBlocks.HICKORY_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
		itemModelGenerator.register(RegisterBlocks.CLOVERS.asItem(), Models.SINGLE_LAYER_ITEM);
		itemModelGenerator.register(RegisterItems.FOUR_LEAF_CLOVER, Models.SINGLE_LAYER_ITEM);
    }
}

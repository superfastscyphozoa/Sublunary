package net.superfastscyphozoa.sublunary.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.model.BlockStateModelGenerator;
import net.minecraft.data.client.model.Model;
import net.minecraft.data.client.model.Models;
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

        blockStateModelGenerator.registerSimpleCubeAll(RegisterBlocks.DEAD_SPRUCE_LEAVES);

        blockStateModelGenerator.registerLog(RegisterBlocks.HICKORY_LOG).log(RegisterBlocks.HICKORY_LOG).wood(RegisterBlocks.HICKORY_WOOD);
        blockStateModelGenerator.registerLog(RegisterBlocks.STRIPPED_HICKORY_LOG).log(RegisterBlocks.STRIPPED_HICKORY_LOG).wood(RegisterBlocks.STRIPPED_HICKORY_WOOD);

        blockStateModelGenerator.registerSimpleCubeAll(RegisterBlocks.HICKORY_PLANKS);

        blockStateModelGenerator.registerTintableCross(RegisterBlocks.LAVENDER, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(RegisterBlocks.HICKORY_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(RegisterItems.RUSTED_SWORD, Models.HANDHELD);

        itemModelGenerator.register(RegisterItems.FLOUR, Models.SINGLE_LAYER_ITEM);
        itemModelGenerator.register(RegisterItems.DOUGH, Models.SINGLE_LAYER_ITEM);

        itemModelGenerator.register(RegisterItems.PASSERINE_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
    }
}

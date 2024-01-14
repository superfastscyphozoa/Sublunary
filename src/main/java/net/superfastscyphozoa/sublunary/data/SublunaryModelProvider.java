package net.superfastscyphozoa.sublunary.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;

public class SublunaryModelProvider extends FabricModelProvider {
    public SublunaryModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(RegisterBlocks.RED_MAPLE_LEAVES);

        blockStateModelGenerator.registerSimpleCubeAll(RegisterBlocks.YELLOW_BIRCH_LEAVES);

        blockStateModelGenerator.registerLog(RegisterBlocks.MAPLE_LOG).log(RegisterBlocks.MAPLE_LOG).wood(RegisterBlocks.MAPLE_WOOD);
        blockStateModelGenerator.registerLog(RegisterBlocks.STRIPPED_MAPLE_LOG).log(RegisterBlocks.STRIPPED_MAPLE_LOG).wood(RegisterBlocks.STRIPPED_MAPLE_WOOD);

        blockStateModelGenerator.registerSimpleCubeAll(RegisterBlocks.MAPLE_PLANKS);

        blockStateModelGenerator.registerTintableCross(RegisterBlocks.YELLOW_BIRCH_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(RegisterBlocks.LAVENDER.asItem(), Models.GENERATED);
    }
}

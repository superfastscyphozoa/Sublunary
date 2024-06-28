package net.superfastscyphozoa.sublunary.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.HolderLookup;
import net.minecraft.registry.tag.BlockTags;
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;
import net.superfastscyphozoa.sublunary.util.SublunaryTags;

import java.util.concurrent.CompletableFuture;

public class SublunaryBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public SublunaryBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

	@Override
	protected void configure(HolderLookup.Provider arg) {

		//plants

		getOrCreateTagBuilder(BlockTags.FLOWERS)
				.add(RegisterBlocks.LAVENDER, RegisterBlocks.CALLA_LILY);

		getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
				.add(RegisterBlocks.POTTED_LAVENDER, RegisterBlocks.POTTED_CALLA_LILY);

		getOrCreateTagBuilder(BlockTags.LEAVES)
				.add(RegisterBlocks.AUTUMNAL_HICKORY_LEAVES, RegisterBlocks.SUMMERY_HICKORY_LEAVES, RegisterBlocks.VERNAL_HICKORY_LEAVES);

		getOrCreateTagBuilder(BlockTags.SAPLINGS)
				.add(RegisterBlocks.HICKORY_SAPLING);

		//mineable

		getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
				.add(RegisterBlocks.AUTUMNAL_HICKORY_LEAVES, RegisterBlocks.SUMMERY_HICKORY_LEAVES, RegisterBlocks.VERNAL_HICKORY_LEAVES);

		//planks

		getOrCreateTagBuilder(BlockTags.PLANKS)
				.add(RegisterBlocks.HICKORY_PLANKS);

		//logs

		getOrCreateTagBuilder(BlockTags.LOGS)
				.add(RegisterBlocks.HICKORY_LOG, RegisterBlocks.HICKORY_WOOD, RegisterBlocks.STRIPPED_HICKORY_LOG, RegisterBlocks.STRIPPED_HICKORY_WOOD);

		getOrCreateTagBuilder(BlockTags.NATURAL_OVERWORLD_LOGS)
				.add(RegisterBlocks.HICKORY_LOG);

		getOrCreateTagBuilder(SublunaryTags.Blocks.HICKORY_LOGS)
				.add(RegisterBlocks.HICKORY_LOG, RegisterBlocks.HICKORY_WOOD, RegisterBlocks.STRIPPED_HICKORY_LOG, RegisterBlocks.STRIPPED_HICKORY_WOOD);

		getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
				.forceAddTag(SublunaryTags.Blocks.HICKORY_LOGS);
	}
}

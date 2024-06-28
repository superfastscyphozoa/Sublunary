package net.superfastscyphozoa.sublunary.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.HolderLookup;
import net.minecraft.registry.tag.ItemTags;
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;
import net.superfastscyphozoa.sublunary.util.SublunaryTags;

import java.util.concurrent.CompletableFuture;

public class SublunaryItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public SublunaryItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

	@Override
	protected void configure(HolderLookup.Provider arg) {

		//plants

		getOrCreateTagBuilder(ItemTags.FLOWERS)
				.add(RegisterBlocks.LAVENDER.asItem(), RegisterBlocks.CALLA_LILY.asItem());

		getOrCreateTagBuilder(ItemTags.LEAVES)
				.add(RegisterBlocks.AUTUMNAL_HICKORY_LEAVES.asItem(), RegisterBlocks.SUMMERY_HICKORY_LEAVES.asItem(),
						RegisterBlocks.VERNAL_HICKORY_LEAVES.asItem());

		getOrCreateTagBuilder(ItemTags.SAPLINGS)
				.add(RegisterBlocks.HICKORY_SAPLING.asItem());

		//planks

		getOrCreateTagBuilder(ItemTags.PLANKS)
				.add(RegisterBlocks.HICKORY_PLANKS.asItem());

		//logs

		getOrCreateTagBuilder(ItemTags.LOGS)
				.add(RegisterBlocks.HICKORY_LOG.asItem(), RegisterBlocks.HICKORY_WOOD.asItem(), RegisterBlocks.STRIPPED_HICKORY_LOG.asItem(),
						RegisterBlocks.STRIPPED_HICKORY_WOOD.asItem());

		getOrCreateTagBuilder(SublunaryTags.Items.HICKORY_LOGS)
				.add(RegisterBlocks.HICKORY_LOG.asItem(), RegisterBlocks.HICKORY_WOOD.asItem(), RegisterBlocks.STRIPPED_HICKORY_LOG.asItem(),
						RegisterBlocks.STRIPPED_HICKORY_WOOD.asItem());

		getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
				.forceAddTag(SublunaryTags.Items.HICKORY_LOGS);
	}
}

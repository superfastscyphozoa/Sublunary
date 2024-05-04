package net.superfastscyphozoa.sublunary.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.HolderLookup;
import net.minecraft.registry.tag.BlockTags;
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;

import java.util.concurrent.CompletableFuture;

public class SublunaryBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public SublunaryBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

	@Override
	protected void configure(HolderLookup.Provider arg) {
		getOrCreateTagBuilder(BlockTags.FLOWERS)
				.add(RegisterBlocks.LAVENDER);

		getOrCreateTagBuilder(BlockTags.LEAVES)
				.add(RegisterBlocks.HICKORY_LEAVES);

		getOrCreateTagBuilder(BlockTags.LOGS)
				.add(RegisterBlocks.HICKORY_LOG, RegisterBlocks.HICKORY_WOOD, RegisterBlocks.STRIPPED_HICKORY_LOG, RegisterBlocks.STRIPPED_HICKORY_WOOD);
	}
}

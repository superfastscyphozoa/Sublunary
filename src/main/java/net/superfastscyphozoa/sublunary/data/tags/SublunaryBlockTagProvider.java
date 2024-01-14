package net.superfastscyphozoa.sublunary.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;

import java.util.concurrent.CompletableFuture;

public class SublunaryBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public SublunaryBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.FLOWERS)
                .add(RegisterBlocks.LAVENDER);

        getOrCreateTagBuilder(BlockTags.LOGS)
                .add(RegisterBlocks.MAPLE_LOG, RegisterBlocks.MAPLE_WOOD, RegisterBlocks.STRIPPED_MAPLE_LOG, RegisterBlocks.STRIPPED_MAPLE_WOOD);

    }
}

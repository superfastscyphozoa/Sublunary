package net.superfastscyphozoa.sublunary.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.superfastscyphozoa.sublunary.registry.RegisterItems;

import java.util.concurrent.CompletableFuture;

public class SublunaryItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public SublunaryItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
    }
}

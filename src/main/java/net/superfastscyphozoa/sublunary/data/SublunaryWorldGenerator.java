package net.superfastscyphozoa.sublunary.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.HolderLookup;
import net.minecraft.registry.RegistryKeys;
import net.superfastscyphozoa.sublunary.Sublunary;

import java.util.concurrent.CompletableFuture;

public class SublunaryWorldGenerator extends FabricDynamicRegistryProvider {
    public SublunaryWorldGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

	@Override
	protected void configure(HolderLookup.Provider registries, Entries entries) {
		entries.addAll(registries.getLookupOrThrow(RegistryKeys.CONFIGURED_FEATURE));
		entries.addAll(registries.getLookupOrThrow(RegistryKeys.PLACED_FEATURE));
	}

    @Override
    public String getName() {
        return Sublunary.MOD_ID;
    }
}

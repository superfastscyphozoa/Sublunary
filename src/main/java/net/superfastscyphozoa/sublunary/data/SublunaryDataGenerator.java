package net.superfastscyphozoa.sublunary.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.superfastscyphozoa.sublunary.data.tags.SublunaryBlockTagProvider;
import net.superfastscyphozoa.sublunary.data.tags.SublunaryItemTagProvider;
import net.superfastscyphozoa.sublunary.world.SublunaryConfiguredFeatures;
import net.superfastscyphozoa.sublunary.world.SublunaryPlacedFeatures;

public class SublunaryDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(SublunaryItemTagProvider::new);
		pack.addProvider(SublunaryLootTableProvider::new);
		pack.addProvider(SublunaryModelProvider::new);
		pack.addProvider(SublunaryRecipeProvider::new);
		pack.addProvider(SublunaryBlockTagProvider::new);
		pack.addProvider(SublunaryWorldGenerator::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, SublunaryConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, SublunaryPlacedFeatures::bootstrap);
	}
}

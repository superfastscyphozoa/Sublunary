package net.superfastscyphozoa.sublunary.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistrySetBuilder;
import net.superfastscyphozoa.sublunary.data.tags.SublunaryBlockTagProvider;
import net.superfastscyphozoa.sublunary.data.tags.SublunaryItemTagProvider;
import net.superfastscyphozoa.sublunary.world.feature.configured.SublunaryConfiguredFeatures;
import net.superfastscyphozoa.sublunary.world.feature.placed.SublunaryPlacedFeatures;

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
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(RegistryKeys.CONFIGURED_FEATURE, SublunaryConfiguredFeatures::bootstrap);
		registryBuilder.add(RegistryKeys.PLACED_FEATURE, SublunaryPlacedFeatures::bootstrap);
	}
}

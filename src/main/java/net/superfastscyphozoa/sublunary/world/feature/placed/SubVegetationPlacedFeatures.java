package net.superfastscyphozoa.sublunary.world.feature.placed;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Holder;
import net.minecraft.registry.HolderProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.BootstrapContext;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacementModifier;
import net.minecraft.world.gen.feature.util.PlacedFeatureUtil;
import net.superfastscyphozoa.sublunary.world.feature.configured.SubVegetationConfiguredFeatures;

import static net.minecraft.world.gen.feature.VegetationPlacedFeatures.treePlacementModifiers;
import static net.minecraft.world.gen.feature.VegetationPlacedFeatures.worldSurfaceSquaredWithCountPlacementModifiers;
import static net.superfastscyphozoa.sublunary.world.feature.placed.SublunaryPlacedFeatures.registerKey;

public class SubVegetationPlacedFeatures {
    public static final RegistryKey<PlacedFeature> FOREST_TREES = registerKey("forest_trees");
    public static final RegistryKey<PlacedFeature> BIRCH_FOREST_TREES = registerKey("birch_forest_trees");
    public static final RegistryKey<PlacedFeature> FLOWER_FOREST_TREES = registerKey("flower_forest_trees");
    public static final RegistryKey<PlacedFeature> PLAINS_TREES = registerKey("plains_trees");
    public static final RegistryKey<PlacedFeature> OLD_GROWTH_BIRCH_TREES = registerKey("old_growth_birch_trees");
    public static final RegistryKey<PlacedFeature> MEADOW_TREES = registerKey("meadow_trees");
    public static final RegistryKey<PlacedFeature> DARK_FOREST_TREES = registerKey("dark_forest_trees");
    public static final RegistryKey<PlacedFeature> TAIGA_TREES = registerKey("taiga_trees");
    public static final RegistryKey<PlacedFeature> SNOWY_PLAINS_TREES = registerKey("snowy_plains_trees");
	public static final RegistryKey<PlacedFeature> WINDSWEPT_FOREST_TREES = registerKey("windswept_forest_trees");
	public static final RegistryKey<PlacedFeature> WINDSWEPT_HILLS_TREES = registerKey("windswept_hills_trees");

    public static final RegistryKey<PlacedFeature> GRASS_PATCH = registerKey("grass_patch");
    public static final RegistryKey<PlacedFeature> GRASS_FERNS_PATCH = registerKey("grass_ferns_patch");

    public static final RegistryKey<PlacedFeature> TALL_GRASS_PATCH = registerKey("tall_grass_patch");
    public static final RegistryKey<PlacedFeature> TALL_FERNS_PATCH = registerKey("tall_ferns_patch");
	public static final RegistryKey<PlacedFeature> FERN_PATCH = registerKey("fern_patch");

	public static final RegistryKey<PlacedFeature> CLOVER_PATCH = registerKey("clover_patch");

    public static final RegistryKey<PlacedFeature> PLAINS_FLOWER_PATCH = registerKey("plains_flower_patch");


    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
		HolderProvider<ConfiguredFeature<?, ?>> holderProvider = context.lookup(RegistryKeys.CONFIGURED_FEATURE);

		Holder<ConfiguredFeature<?, ?>> forestTrees = holderProvider.getHolderOrThrow(SubVegetationConfiguredFeatures.FOREST_TREES_CONFIGURED);
		Holder<ConfiguredFeature<?, ?>> flowerForestTrees = holderProvider.getHolderOrThrow(SubVegetationConfiguredFeatures.FLOWER_FOREST_TREES_CONFIGURED);
		Holder<ConfiguredFeature<?, ?>> birchForestTrees = holderProvider.getHolderOrThrow(SubVegetationConfiguredFeatures.BIRCH_FOREST_TREES_CONFIGURED);
		Holder<ConfiguredFeature<?, ?>> oldGrowthBirchTrees = holderProvider.getHolderOrThrow(SubVegetationConfiguredFeatures.OLD_GROWTH_BIRCH_TREES_CONFIGURED);
		Holder<ConfiguredFeature<?, ?>> plainsTrees = holderProvider.getHolderOrThrow(SubVegetationConfiguredFeatures.PLAINS_TREES_CONFIGURED);
		Holder<ConfiguredFeature<?, ?>> meadowTrees = holderProvider.getHolderOrThrow(SubVegetationConfiguredFeatures.MEADOW_TREES_CONFIGURED);
		Holder<ConfiguredFeature<?, ?>> darkForestTrees = holderProvider.getHolderOrThrow(SubVegetationConfiguredFeatures.DARK_FOREST_TREES_CONFIGURED);
		Holder<ConfiguredFeature<?, ?>> taigaTrees = holderProvider.getHolderOrThrow(SubVegetationConfiguredFeatures.TAIGA_TREES_CONFIGURED);
		Holder<ConfiguredFeature<?, ?>> snowyPlainsTrees = holderProvider.getHolderOrThrow(SubVegetationConfiguredFeatures.SNOWY_PLAINS_TREES_CONFIGURED);
		Holder<ConfiguredFeature<?, ?>> windsweptForestTrees = holderProvider.getHolderOrThrow(SubVegetationConfiguredFeatures.WINDSWEPT_FOREST_TREES_CONFIGURED);

		Holder<ConfiguredFeature<?, ?>> grassPatch = holderProvider.getHolderOrThrow(SubVegetationConfiguredFeatures.GRASS_PATCH_CONFIGURED);
		Holder<ConfiguredFeature<?, ?>> grassFernsPatch = holderProvider.getHolderOrThrow(SubVegetationConfiguredFeatures.GRASS_FERNS_PATCH_CONFIGURED);

		Holder<ConfiguredFeature<?, ?>> tallGrassPatch = holderProvider.getHolderOrThrow(SubVegetationConfiguredFeatures.TALL_GRASS_PATCH_CONFIGURED);
		Holder<ConfiguredFeature<?, ?>> tallFernsPatch = holderProvider.getHolderOrThrow(SubVegetationConfiguredFeatures.TALL_FERNS_PATCH_CONFIGURED);
		Holder<ConfiguredFeature<?, ?>> fernPatch = holderProvider.getHolderOrThrow(SubVegetationConfiguredFeatures.FERN_PATCH_CONFIGURED);

		Holder<ConfiguredFeature<?, ?>> cloverPatch = holderProvider.getHolderOrThrow(SubVegetationConfiguredFeatures.CLOVER_PATCH_CONFIGURED);

		Holder<ConfiguredFeature<?, ?>> plainsFlowerPatch = holderProvider.getHolderOrThrow(SubVegetationConfiguredFeatures.PLAINS_FLOWER_PATCH_CONFIGURED);


        SublunaryPlacedFeatures.register(context, FOREST_TREES, forestTrees,
				treePlacementModifiers(PlacedFeatureUtil.createCountExtraModifier(10, 0.5F, 2), Blocks.OAK_SAPLING));

        SublunaryPlacedFeatures.register(context, FLOWER_FOREST_TREES, flowerForestTrees,
				treePlacementModifiers(PlacedFeatureUtil.createCountExtraModifier(8, 0.1F, 4), Blocks.OAK_SAPLING));

        SublunaryPlacedFeatures.register(context, BIRCH_FOREST_TREES, birchForestTrees,
				treePlacementModifiers(PlacedFeatureUtil.createCountExtraModifier(9, 0.1F, 2), Blocks.BIRCH_SAPLING));

        SublunaryPlacedFeatures.register(context, OLD_GROWTH_BIRCH_TREES, oldGrowthBirchTrees,
				treePlacementModifiers(PlacedFeatureUtil.createCountExtraModifier(8, 0.1F, 3), Blocks.BIRCH_SAPLING));

        SublunaryPlacedFeatures.register(context, PLAINS_TREES, plainsTrees,
				treePlacementModifiers(PlacedFeatureUtil.createCountExtraModifier(0, 0.05F, 1), Blocks.OAK_SAPLING));

        SublunaryPlacedFeatures.register(context, MEADOW_TREES, meadowTrees,
				treePlacementModifiers(RarityFilterPlacementModifier.create(100), Blocks.OAK_SAPLING));

        SublunaryPlacedFeatures.register(context, DARK_FOREST_TREES, darkForestTrees,
				CountPlacementModifier.create(16), InSquarePlacementModifier.getInstance(),
				SurfaceWaterDepthFilterPlacementModifier.create(0), PlacedFeatureUtil.OCEAN_FLOOR_HEIGHTMAP, BiomePlacementModifier.getInstance());

        SublunaryPlacedFeatures.register(context, TAIGA_TREES, taigaTrees,
				treePlacementModifiers(PlacedFeatureUtil.createCountExtraModifier(9, 0.1F, 1), Blocks.OAK_SAPLING));

        SublunaryPlacedFeatures.register(context, SNOWY_PLAINS_TREES, snowyPlainsTrees,
				treePlacementModifiers(PlacedFeatureUtil.createCountExtraModifier(0, 0.1F, 1), Blocks.SPRUCE_SAPLING));

		SublunaryPlacedFeatures.register(context, WINDSWEPT_FOREST_TREES, windsweptForestTrees,
				treePlacementModifiers(PlacedFeatureUtil.createCountExtraModifier(3, 0.1F, 1), Blocks.OAK_SAPLING));

		SublunaryPlacedFeatures.register(context, WINDSWEPT_HILLS_TREES, windsweptForestTrees,
				treePlacementModifiers(PlacedFeatureUtil.createCountExtraModifier(0, 0.1F, 1), Blocks.OAK_SAPLING));


        SublunaryPlacedFeatures.register(context, GRASS_PATCH, grassPatch, worldSurfaceSquaredWithCountPlacementModifiers(15));
        SublunaryPlacedFeatures.register(context, GRASS_FERNS_PATCH, grassFernsPatch, worldSurfaceSquaredWithCountPlacementModifiers(15));

        SublunaryPlacedFeatures.register(context, TALL_GRASS_PATCH, tallGrassPatch,
                NoiseThresholdCountPlacementModifier.create(-0.8, 0, 7), RarityFilterPlacementModifier.create(20),
				InSquarePlacementModifier.getInstance(), PlacedFeatureUtil.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.getInstance());

        SublunaryPlacedFeatures.register(context, TALL_FERNS_PATCH, tallFernsPatch,
                NoiseThresholdCountPlacementModifier.create(-0.8, 0, 7), RarityFilterPlacementModifier.create(20),
				InSquarePlacementModifier.getInstance(), PlacedFeatureUtil.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.getInstance());

		SublunaryPlacedFeatures.register(context, FERN_PATCH, fernPatch,
				NoiseThresholdCountPlacementModifier.create(-0.8, 0, 7), RarityFilterPlacementModifier.create(12),
				InSquarePlacementModifier.getInstance(), PlacedFeatureUtil.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.getInstance());


		SublunaryPlacedFeatures.register(context, CLOVER_PATCH, cloverPatch,
				NoiseThresholdCountPlacementModifier.create(-0.8, 0, 7), RarityFilterPlacementModifier.create(25),
				InSquarePlacementModifier.getInstance(), PlacedFeatureUtil.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.getInstance());


        SublunaryPlacedFeatures.register(context, PLAINS_FLOWER_PATCH, plainsFlowerPatch,
                CountPlacementModifier.create(3), RarityFilterPlacementModifier.create(32), InSquarePlacementModifier.getInstance(),
				PlacedFeatureUtil.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.getInstance());
    }
}

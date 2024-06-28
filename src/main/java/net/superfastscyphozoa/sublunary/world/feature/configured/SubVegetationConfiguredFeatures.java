package net.superfastscyphozoa.sublunary.world.feature.configured;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Holder;
import net.minecraft.registry.HolderProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.world.gen.BootstrapContext;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.util.ConfiguredFeatureUtil;
import net.minecraft.world.gen.feature.util.PlacedFeatureUtil;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.NoiseBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.superfastscyphozoa.sublunary.blocks.CloverBlock;
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;
import net.superfastscyphozoa.sublunary.world.feature.placed.SubTreePlacedFeatures;

import java.util.List;

import static net.minecraft.world.gen.feature.util.PlacedFeatureUtil.placedInline;
import static net.superfastscyphozoa.sublunary.world.feature.configured.SublunaryConfiguredFeatures.registerKey;

public class SubVegetationConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?,?>> FOREST_TREES_CONFIGURED = registerKey("forest_trees_configured");
    public static final RegistryKey<ConfiguredFeature<?,?>> BIRCH_FOREST_TREES_CONFIGURED = registerKey("birch_forest_trees_configured");
    public static final RegistryKey<ConfiguredFeature<?,?>> FLOWER_FOREST_TREES_CONFIGURED = registerKey("flower_forest_trees_configured");
    public static final RegistryKey<ConfiguredFeature<?,?>> PLAINS_TREES_CONFIGURED = registerKey("plains_trees_configured");
    public static final RegistryKey<ConfiguredFeature<?,?>> OLD_GROWTH_BIRCH_TREES_CONFIGURED = registerKey("old_growth_birch_trees_configured");
    public static final RegistryKey<ConfiguredFeature<?,?>> MEADOW_TREES_CONFIGURED = registerKey("meadow_trees_configured");
    public static final RegistryKey<ConfiguredFeature<?,?>> DARK_FOREST_TREES_CONFIGURED = registerKey("dark_forest_trees_configured");
    public static final RegistryKey<ConfiguredFeature<?,?>> TAIGA_TREES_CONFIGURED = registerKey("taiga_trees_configured");
	public static final RegistryKey<ConfiguredFeature<?,?>> SNOWY_TAIGA_TREES_CONFIGURED = registerKey("snowy_taiga_trees_configured");
	public static final RegistryKey<ConfiguredFeature<?,?>> GROVE_TREES_CONFIGURED = registerKey("grove_trees_configured");
    public static final RegistryKey<ConfiguredFeature<?,?>> SNOWY_PLAINS_TREES_CONFIGURED = registerKey("snowy_plains_trees_configured");
	public static final RegistryKey<ConfiguredFeature<?,?>> WINDSWEPT_FOREST_TREES_CONFIGURED = registerKey("windswept_forest_trees_configured");

    public static final RegistryKey<ConfiguredFeature<?,?>> GRASS_PATCH_CONFIGURED = registerKey("grass_patch_configured");
	public static final RegistryKey<ConfiguredFeature<?,?>> TALL_GRASS_PATCH_CONFIGURED = registerKey("tall_grass_patch_configured");

	public static final RegistryKey<ConfiguredFeature<?,?>> FERN_PATCH_CONFIGURED = registerKey("fern_patch_configured");
	public static final RegistryKey<ConfiguredFeature<?,?>> TALL_FERN_PATCH_CONFIGURED = registerKey("tall_fern_patch_configured");

	public static final RegistryKey<ConfiguredFeature<?,?>> GRASS_FERNS_PATCH_CONFIGURED = registerKey("grass_ferns_patch_configured");

	public static final RegistryKey<ConfiguredFeature<?,?>> CLOVER_PATCH_CONFIGURED = registerKey("clover_patch_configured");

    public static final RegistryKey<ConfiguredFeature<?,?>> PLAINS_FLOWER_PATCH_CONFIGURED = registerKey("plains_flower_patch_configured");

    private static RandomPatchFeatureConfig createSublunaryRandomPatchFeatureConfig(BlockStateProvider block, int tries) {
        return ConfiguredFeatureUtil.createRandomPatchFeatureConfig(tries, PlacedFeatureUtil.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(block)));
    }

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
		HolderProvider<PlacedFeature> holderProvider = context.lookup(RegistryKeys.PLACED_FEATURE);
		HolderProvider<ConfiguredFeature<?, ?>> holderProvider2 = context.lookup(RegistryKeys.CONFIGURED_FEATURE);

		Holder<ConfiguredFeature<?, ?>> redMushy = holderProvider2.getHolderOrThrow(SubTreeConfiguredFeatures.RED_MUSHY);
		Holder<ConfiguredFeature<?, ?>> brownMushy = holderProvider2.getHolderOrThrow(SubTreeConfiguredFeatures.BROWN_MUSHY);

		Holder<PlacedFeature> oak = holderProvider.getHolderOrThrow(SubTreePlacedFeatures.OAK_PLACED);
		Holder<PlacedFeature> largeOak = holderProvider.getHolderOrThrow(SubTreePlacedFeatures.LARGE_OAK_PLACED);
		Holder<PlacedFeature> birch = holderProvider.getHolderOrThrow(SubTreePlacedFeatures.BIRCH_PLACED);

		Holder<PlacedFeature> hickory = holderProvider.getHolderOrThrow(SubTreePlacedFeatures.HICKORY_PLACED);

		Holder<PlacedFeature> forestOak = holderProvider.getHolderOrThrow(SubTreePlacedFeatures.FOREST_OAK_PLACED);
		Holder<PlacedFeature> largeForestOak = holderProvider.getHolderOrThrow(SubTreePlacedFeatures.LARGE_FOREST_OAK_PLACED);
		Holder<PlacedFeature> forestBirch = holderProvider.getHolderOrThrow(SubTreePlacedFeatures.FOREST_BIRCH_PLACED);

		Holder<PlacedFeature> flowerForestOak = holderProvider.getHolderOrThrow(SubTreePlacedFeatures.FLOWER_FOREST_OAK_PLACED);
		Holder<PlacedFeature> largeFlowerForestOak = holderProvider.getHolderOrThrow(SubTreePlacedFeatures.LARGE_FLOWER_FOREST_OAK_PLACED);
		Holder<PlacedFeature> flowerForestBirch = holderProvider.getHolderOrThrow(SubTreePlacedFeatures.FLOWER_FOREST_BIRCH_PLACED);

		Holder<PlacedFeature> plainsOak = holderProvider.getHolderOrThrow(SubTreePlacedFeatures.PLAINS_OAK_PLACED);
		Holder<PlacedFeature> largePlainsOak = holderProvider.getHolderOrThrow(SubTreePlacedFeatures.LARGE_PLAINS_OAK_PLACED);

		Holder<PlacedFeature> oldGrowthBirch = holderProvider.getHolderOrThrow(SubTreePlacedFeatures.OLD_GROWTH_BIRCH_PLACED);

		Holder<PlacedFeature> meadowOak = holderProvider.getHolderOrThrow(SubTreePlacedFeatures.MEADOW_OAK_PLACED);
		Holder<PlacedFeature> meadowBirch = holderProvider.getHolderOrThrow(SubTreePlacedFeatures.MEADOW_BIRCH_PLACED);

		Holder<PlacedFeature> darkOak = holderProvider.getHolderOrThrow(SubTreePlacedFeatures.DARK_OAK_PLACED);

		Holder<PlacedFeature> spruceFull = holderProvider.getHolderOrThrow(SubTreePlacedFeatures.SPRUCE_FULL_PLACED);
		Holder<PlacedFeature> spruceSparse = holderProvider.getHolderOrThrow(SubTreePlacedFeatures.SPRUCE_SPARSE_PLACED);
		Holder<PlacedFeature> vinySpruce = holderProvider.getHolderOrThrow(SubTreePlacedFeatures.VINY_SPRUCE_PLACED);

		Holder<PlacedFeature> snowySpruceFull = holderProvider.getHolderOrThrow(SubTreePlacedFeatures.SNOWY_SPRUCE_FULL_PLACED);
		Holder<PlacedFeature> snowySpruceSparse = holderProvider.getHolderOrThrow(SubTreePlacedFeatures.SNOWY_SPRUCE_SPARSE_PLACED);

		Holder<PlacedFeature> vinyOak = holderProvider.getHolderOrThrow(SubTreePlacedFeatures.VINY_OAK_PLACED);
		Holder<PlacedFeature> largeVinyOak = holderProvider.getHolderOrThrow(SubTreePlacedFeatures.LARGE_VINY_OAK_PLACED);

		Holder<PlacedFeature> vinyBirch = holderProvider.getHolderOrThrow(SubTreePlacedFeatures.VINY_BIRCH_PLACED);
		Holder<PlacedFeature> vinyOldGrowthBirch = holderProvider.getHolderOrThrow(SubTreePlacedFeatures.VINY_OLD_GROWTH_BIRCH_PLACED);

		Holder<PlacedFeature> vinyDarkOak = holderProvider.getHolderOrThrow(SubTreePlacedFeatures.VINY_DARK_OAK_PLACED);

		//trees

        SublunaryConfiguredFeatures.register(context, FOREST_TREES_CONFIGURED, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                new WeightedPlacedFeature(vinyOak, 0.03F),
                new WeightedPlacedFeature(largeVinyOak, 0.03F),

                new WeightedPlacedFeature(forestBirch, 0.15F),
                new WeightedPlacedFeature(largeForestOak, 0.65F)),
                forestOak));

        SublunaryConfiguredFeatures.register(context, FLOWER_FOREST_TREES_CONFIGURED, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                new WeightedPlacedFeature(vinyOak, 0.03F),
                new WeightedPlacedFeature(largeVinyOak, 0.03F),

                new WeightedPlacedFeature(flowerForestOak, 0.15F),
                new WeightedPlacedFeature(largeFlowerForestOak, 0.5F)),
                flowerForestBirch));

        SublunaryConfiguredFeatures.register(context, BIRCH_FOREST_TREES_CONFIGURED, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                new WeightedPlacedFeature(vinyBirch, 0.02F)),
                forestBirch));

        SublunaryConfiguredFeatures.register(context, OLD_GROWTH_BIRCH_TREES_CONFIGURED, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                new WeightedPlacedFeature(vinyOldGrowthBirch, 0.02F),
                new WeightedPlacedFeature(vinyBirch, 0.015F),

                new WeightedPlacedFeature(forestBirch, 0.25F)),
                oldGrowthBirch));

        SublunaryConfiguredFeatures.register(context, PLAINS_TREES_CONFIGURED, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                new WeightedPlacedFeature(largePlainsOak, 0.5F)),
                plainsOak));

        SublunaryConfiguredFeatures.register(context, MEADOW_TREES_CONFIGURED, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                new WeightedPlacedFeature(meadowOak, 0.5F)),
                meadowBirch));

        SublunaryConfiguredFeatures.register(context, DARK_FOREST_TREES_CONFIGURED, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
				new WeightedPlacedFeature(placedInline(redMushy), 0.015F),
				new WeightedPlacedFeature(placedInline(brownMushy), 0.015F),

                new WeightedPlacedFeature(darkOak, 0.7F),
                new WeightedPlacedFeature(birch, 0.2F),
                new WeightedPlacedFeature(largeOak, 0.2F),

                new WeightedPlacedFeature(vinyDarkOak, 0.2F)),
                oak));

        SublunaryConfiguredFeatures.register(context, TAIGA_TREES_CONFIGURED, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                new WeightedPlacedFeature(spruceSparse, 0.34F),
				new WeightedPlacedFeature(vinySpruce, 0.04F)),
                spruceFull));

		SublunaryConfiguredFeatures.register(context, SNOWY_TAIGA_TREES_CONFIGURED, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
				new WeightedPlacedFeature(spruceSparse, 0.34F)),
				spruceFull));

		SublunaryConfiguredFeatures.register(context, GROVE_TREES_CONFIGURED, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
				new WeightedPlacedFeature(snowySpruceSparse, 0.34F)),
				snowySpruceFull));

        SublunaryConfiguredFeatures.register(context, SNOWY_PLAINS_TREES_CONFIGURED, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                new WeightedPlacedFeature(spruceSparse, 0.05F)),
                spruceFull));

		SublunaryConfiguredFeatures.register(context, WINDSWEPT_FOREST_TREES_CONFIGURED, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
				new WeightedPlacedFeature(spruceFull, 0.666F),
				new WeightedPlacedFeature(oak, 0.1F)),
				largeOak));

		//vegetation

		//grass

        SublunaryConfiguredFeatures.register(context, GRASS_PATCH_CONFIGURED, Feature.RANDOM_PATCH,
                createSublunaryRandomPatchFeatureConfig(BlockStateProvider.of(Blocks.SHORT_GRASS), 32));

		SublunaryConfiguredFeatures.register(context, TALL_GRASS_PATCH_CONFIGURED, Feature.RANDOM_PATCH,
				ConfiguredFeatureUtil.createRandomPatchFeatureConfig
						(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.TALL_GRASS))));

		//ferns

		SublunaryConfiguredFeatures.register(context, FERN_PATCH_CONFIGURED, Feature.RANDOM_PATCH,
				ConfiguredFeatureUtil.createRandomPatchFeatureConfig
						(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.FERN))));

		SublunaryConfiguredFeatures.register(context, TALL_FERN_PATCH_CONFIGURED, Feature.RANDOM_PATCH,
				createSublunaryRandomPatchFeatureConfig(new WeightedBlockStateProvider(new DataPool.Builder<BlockState>()
						.method_34975(Blocks.LARGE_FERN.getDefaultState(), 3).method_34975(Blocks.FERN.getDefaultState(), 1)), 96));

		//ferns and grass

		SublunaryConfiguredFeatures.register(context, GRASS_FERNS_PATCH_CONFIGURED, Feature.RANDOM_PATCH,
				createSublunaryRandomPatchFeatureConfig(new WeightedBlockStateProvider(new DataPool.Builder<BlockState>()
						.method_34975(Blocks.SHORT_GRASS.getDefaultState(), 4).method_34975(Blocks.FERN.getDefaultState(), 1)), 32));

		//other plants

		DataPool.Builder<BlockState> cloverBuilder = DataPool.builder();

		for(int c = 1; c <= 4; ++c) {
			for (Direction direction : Direction.Type.HORIZONTAL) {
				cloverBuilder.method_34975(RegisterBlocks.CLOVERS.getDefaultState()
						.with(CloverBlock.AMOUNT, c).with(CloverBlock.FACING, direction), 1);
			}
		}

		SublunaryConfiguredFeatures.register(context, CLOVER_PATCH_CONFIGURED, Feature.FLOWER,
				new RandomPatchFeatureConfig(256, 6, 3, PlacedFeatureUtil.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig
						(new WeightedBlockStateProvider(cloverBuilder)))));

        SublunaryConfiguredFeatures.register(context, PLAINS_FLOWER_PATCH_CONFIGURED, Feature.FLOWER,
                new RandomPatchFeatureConfig(96, 6, 2, PlacedFeatureUtil.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig
                        (new NoiseBlockStateProvider(2345L, new DoublePerlinNoiseSampler.NoiseParameters(0, 1.0), 0.020833334f,
                                List.of(Blocks.DANDELION.getDefaultState(), Blocks.ALLIUM.getDefaultState(), Blocks.POPPY.getDefaultState(),
                                        Blocks.AZURE_BLUET.getDefaultState(), Blocks.OXEYE_DAISY.getDefaultState(), Blocks.CORNFLOWER.getDefaultState()))))));
    }
}

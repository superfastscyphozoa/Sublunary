package net.superfastscyphozoa.sublunary.world.feature.placed;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Holder;
import net.minecraft.registry.HolderProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.BootstrapContext;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.util.PlacedFeatureUtil;
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;
import net.superfastscyphozoa.sublunary.world.feature.configured.SubTreeConfiguredFeatures;

import static net.superfastscyphozoa.sublunary.world.feature.placed.SublunaryPlacedFeatures.registerKey;

public class SubTreePlacedFeatures {

    public static final RegistryKey<PlacedFeature> OAKIER_OAK_PLACED = registerKey("oakier_oak_placed");
    public static final RegistryKey<PlacedFeature> LARGE_OAKIER_OAK_PLACED = registerKey("large_oakier_oak_placed");
    public static final RegistryKey<PlacedFeature> BIRCHIER_BIRCH_PLACED = registerKey("birchier_birch_placed");

    public static final RegistryKey<PlacedFeature> SMALL_OAK_PLACED = registerKey("small_oak_placed");
    public static final RegistryKey<PlacedFeature> SMALL_BIRCH_PLACED = registerKey("small_birch_placed");

    public static final RegistryKey<PlacedFeature> FOREST_OAK_PLACED = registerKey("forest_oak_placed");
    public static final RegistryKey<PlacedFeature> LARGE_FOREST_OAK_PLACED = registerKey("large_forest_oak_placed");
    public static final RegistryKey<PlacedFeature> FOREST_BIRCH_PLACED = registerKey("forest_birch_placed");

    public static final RegistryKey<PlacedFeature> HICKORY_PLACED = registerKey("hickory_placed");

    public static final RegistryKey<PlacedFeature> FLOWER_FOREST_OAK_PLACED = registerKey("flower_forest_oak_placed");
    public static final RegistryKey<PlacedFeature> LARGE_FLOWER_FOREST_OAK_PLACED = registerKey("large_flower_forest_oak_placed");
    public static final RegistryKey<PlacedFeature> FLOWER_FOREST_BIRCH_PLACED = registerKey("flower_forest_birch_placed");

    public static final RegistryKey<PlacedFeature> PLAINS_OAK_PLACED = registerKey("plains_oak_placed");
    public static final RegistryKey<PlacedFeature> LARGE_PLAINS_OAK_PLACED = registerKey("large_plains_oak_placed");

    public static final RegistryKey<PlacedFeature> OLD_GROWTH_BIRCH_PLACED = registerKey("old_growth_birch_placed");

    public static final RegistryKey<PlacedFeature> MEADOW_OAK_PLACED = registerKey("meadow_oak_placed");
    public static final RegistryKey<PlacedFeature> MEADOW_BIRCH_PLACED = registerKey("meadow_birch_placed");

    public static final RegistryKey<PlacedFeature> DARK_OAK_PLACED = registerKey("dark_oak_placed");

    public static final RegistryKey<PlacedFeature> SPRUCE_FULL_PLACED = registerKey("spruce_full_placed");
    public static final RegistryKey<PlacedFeature> SPRUCE_SPARSE_PLACED = registerKey("spruce_sparse_placed");
    public static final RegistryKey<PlacedFeature> DYING_SPRUCE_PLACED = registerKey("dying_spruce_placed");

    public static final RegistryKey<PlacedFeature> VINY_OAK_PLACED = registerKey("viny_oak_placed");
    public static final RegistryKey<PlacedFeature> LARGE_VINY_OAK_PLACED = registerKey("large_viny_oak_placed");

    public static final RegistryKey<PlacedFeature> VINY_BIRCH_PLACED = registerKey("viny_birch_placed");
    public static final RegistryKey<PlacedFeature> VINY_OLD_GROWTH_BIRCH_PLACED = registerKey("viny_old_growth_birch_placed");

    public static final RegistryKey<PlacedFeature> VINY_DARK_OAK_PLACED = registerKey("viny_dark_oak_placed");

    public static final RegistryKey<PlacedFeature> VINY_SPRUCE_PLACED = registerKey("viny_spruce_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
		HolderProvider<ConfiguredFeature<?, ?>> holderProvider = context.lookup(RegistryKeys.CONFIGURED_FEATURE);

		Holder<ConfiguredFeature<?, ?>> oakierOak = holderProvider.getHolderOrThrow(SubTreeConfiguredFeatures.OAKIER_OAK);
		Holder<ConfiguredFeature<?, ?>> largeOakierOak = holderProvider.getHolderOrThrow(SubTreeConfiguredFeatures.LARGE_OAKIER_OAK);
		Holder<ConfiguredFeature<?, ?>> birchierBirch = holderProvider.getHolderOrThrow(SubTreeConfiguredFeatures.BIRCHIER_BIRCH);

		Holder<ConfiguredFeature<?, ?>> smallOak = holderProvider.getHolderOrThrow(SubTreeConfiguredFeatures.SMALL_OAK);
		Holder<ConfiguredFeature<?, ?>> smallBirch = holderProvider.getHolderOrThrow(SubTreeConfiguredFeatures.SMALL_BIRCH);

		Holder<ConfiguredFeature<?, ?>> forestOak = holderProvider.getHolderOrThrow(SubTreeConfiguredFeatures.FOREST_OAK);
		Holder<ConfiguredFeature<?, ?>> largeForestOak = holderProvider.getHolderOrThrow(SubTreeConfiguredFeatures.LARGE_FOREST_OAK);
		Holder<ConfiguredFeature<?, ?>> forestBirch = holderProvider.getHolderOrThrow(SubTreeConfiguredFeatures.FOREST_BIRCH);

		Holder<ConfiguredFeature<?, ?>> hickory = holderProvider.getHolderOrThrow(SubTreeConfiguredFeatures.HICKORY);

		Holder<ConfiguredFeature<?, ?>> flowerForestOak = holderProvider.getHolderOrThrow(SubTreeConfiguredFeatures.FOREST_OAK);
		Holder<ConfiguredFeature<?, ?>> largeFlowerForestOak = holderProvider.getHolderOrThrow(SubTreeConfiguredFeatures.LARGE_FOREST_OAK);
		Holder<ConfiguredFeature<?, ?>> flowerForestBirch = holderProvider.getHolderOrThrow(SubTreeConfiguredFeatures.FOREST_BIRCH);

		Holder<ConfiguredFeature<?, ?>> plainsOak = holderProvider.getHolderOrThrow(SubTreeConfiguredFeatures.PLAINS_OAK);
		Holder<ConfiguredFeature<?, ?>> largePlainsOak = holderProvider.getHolderOrThrow(SubTreeConfiguredFeatures.LARGE_PLAINS_OAK);

		Holder<ConfiguredFeature<?, ?>> oldGrowthBirch = holderProvider.getHolderOrThrow(SubTreeConfiguredFeatures.OLD_GROWTH_BIRCH);

		Holder<ConfiguredFeature<?, ?>> meadowOak = holderProvider.getHolderOrThrow(SubTreeConfiguredFeatures.MEADOW_OAK);
		Holder<ConfiguredFeature<?, ?>> meadowBirch = holderProvider.getHolderOrThrow(SubTreeConfiguredFeatures.MEADOW_BIRCH);

		Holder<ConfiguredFeature<?, ?>> darkOak = holderProvider.getHolderOrThrow(SubTreeConfiguredFeatures.DARK_OAK);

		Holder<ConfiguredFeature<?, ?>> spruceFull = holderProvider.getHolderOrThrow(SubTreeConfiguredFeatures.SPRUCE_FULL);
		Holder<ConfiguredFeature<?, ?>> spruceSparse = holderProvider.getHolderOrThrow(SubTreeConfiguredFeatures.SPRUCE_SPARSE);
		Holder<ConfiguredFeature<?, ?>> dyingSpruce = holderProvider.getHolderOrThrow(SubTreeConfiguredFeatures.DYING_SPRUCE);

		Holder<ConfiguredFeature<?, ?>> vinyOak = holderProvider.getHolderOrThrow(SubTreeConfiguredFeatures.VINY_OAK);
		Holder<ConfiguredFeature<?, ?>> largeVinyOak = holderProvider.getHolderOrThrow(SubTreeConfiguredFeatures.LARGE_VINY_OAK);

		Holder<ConfiguredFeature<?, ?>> vinyBirch = holderProvider.getHolderOrThrow(SubTreeConfiguredFeatures.VINY_BIRCH);
		Holder<ConfiguredFeature<?, ?>> vinyOldGrowthBirch = holderProvider.getHolderOrThrow(SubTreeConfiguredFeatures.VINY_OLD_GROWTH_BIRCH);

		Holder<ConfiguredFeature<?, ?>> vinyDarkOak = holderProvider.getHolderOrThrow(SubTreeConfiguredFeatures.VINY_DARK_OAK);

		Holder<ConfiguredFeature<?, ?>> vinySpruce = holderProvider.getHolderOrThrow(SubTreeConfiguredFeatures.VINY_SPRUCE);

        SublunaryPlacedFeatures.register(context, OAKIER_OAK_PLACED, oakierOak, PlacedFeatureUtil.createWouldSurvivePlacementModifier(Blocks.OAK_SAPLING));
        SublunaryPlacedFeatures.register(context, LARGE_OAKIER_OAK_PLACED, largeOakierOak, PlacedFeatureUtil.createWouldSurvivePlacementModifier(Blocks.OAK_SAPLING));
        SublunaryPlacedFeatures.register(context, BIRCHIER_BIRCH_PLACED, birchierBirch, PlacedFeatureUtil.createWouldSurvivePlacementModifier(Blocks.BIRCH_SAPLING));

        SublunaryPlacedFeatures.register(context, SMALL_OAK_PLACED, smallOak, PlacedFeatureUtil.createWouldSurvivePlacementModifier(Blocks.OAK_SAPLING));
        SublunaryPlacedFeatures.register(context, SMALL_BIRCH_PLACED, smallBirch, PlacedFeatureUtil.createWouldSurvivePlacementModifier(Blocks.BIRCH_SAPLING));

        SublunaryPlacedFeatures.register(context, FOREST_OAK_PLACED, forestOak, PlacedFeatureUtil.createWouldSurvivePlacementModifier(Blocks.OAK_SAPLING));
        SublunaryPlacedFeatures.register(context, LARGE_FOREST_OAK_PLACED, largeForestOak, PlacedFeatureUtil.createWouldSurvivePlacementModifier(Blocks.OAK_SAPLING));
        SublunaryPlacedFeatures.register(context, FOREST_BIRCH_PLACED, forestBirch, PlacedFeatureUtil.createWouldSurvivePlacementModifier(Blocks.BIRCH_SAPLING));

        SublunaryPlacedFeatures.register(context, HICKORY_PLACED, hickory, PlacedFeatureUtil.createWouldSurvivePlacementModifier(RegisterBlocks.HICKORY_SAPLING));

        SublunaryPlacedFeatures.register(context, FLOWER_FOREST_OAK_PLACED, flowerForestOak, PlacedFeatureUtil.createWouldSurvivePlacementModifier(Blocks.OAK_SAPLING));
        SublunaryPlacedFeatures.register(context, LARGE_FLOWER_FOREST_OAK_PLACED, largeFlowerForestOak, PlacedFeatureUtil.createWouldSurvivePlacementModifier(Blocks.OAK_SAPLING));
        SublunaryPlacedFeatures.register(context, FLOWER_FOREST_BIRCH_PLACED, flowerForestBirch, PlacedFeatureUtil.createWouldSurvivePlacementModifier(Blocks.BIRCH_SAPLING));

        SublunaryPlacedFeatures.register(context, PLAINS_OAK_PLACED, plainsOak, PlacedFeatureUtil.createWouldSurvivePlacementModifier(Blocks.OAK_SAPLING));
        SublunaryPlacedFeatures.register(context, LARGE_PLAINS_OAK_PLACED, largePlainsOak, PlacedFeatureUtil.createWouldSurvivePlacementModifier(Blocks.OAK_SAPLING));

        SublunaryPlacedFeatures.register(context, OLD_GROWTH_BIRCH_PLACED, oldGrowthBirch, PlacedFeatureUtil.createWouldSurvivePlacementModifier(Blocks.BIRCH_SAPLING));

        SublunaryPlacedFeatures.register(context, MEADOW_OAK_PLACED, meadowOak, PlacedFeatureUtil.createWouldSurvivePlacementModifier(Blocks.OAK_SAPLING));
        SublunaryPlacedFeatures.register(context, MEADOW_BIRCH_PLACED, meadowBirch, PlacedFeatureUtil.createWouldSurvivePlacementModifier(Blocks.BIRCH_SAPLING));

        SublunaryPlacedFeatures.register(context, DARK_OAK_PLACED, darkOak, PlacedFeatureUtil.createWouldSurvivePlacementModifier(Blocks.DARK_OAK_SAPLING));

        SublunaryPlacedFeatures.register(context, SPRUCE_FULL_PLACED, spruceFull, PlacedFeatureUtil.createWouldSurvivePlacementModifier(Blocks.SPRUCE_SAPLING));
        SublunaryPlacedFeatures.register(context, SPRUCE_SPARSE_PLACED, spruceSparse, PlacedFeatureUtil.createWouldSurvivePlacementModifier(Blocks.SPRUCE_SAPLING));
        SublunaryPlacedFeatures.register(context, DYING_SPRUCE_PLACED, dyingSpruce, PlacedFeatureUtil.createWouldSurvivePlacementModifier(Blocks.SPRUCE_SAPLING));

        SublunaryPlacedFeatures.register(context, VINY_OAK_PLACED, vinyOak, PlacedFeatureUtil.createWouldSurvivePlacementModifier(Blocks.OAK_SAPLING));
        SublunaryPlacedFeatures.register(context, LARGE_VINY_OAK_PLACED, largeVinyOak, PlacedFeatureUtil.createWouldSurvivePlacementModifier(Blocks.OAK_SAPLING));

        SublunaryPlacedFeatures.register(context, VINY_BIRCH_PLACED, vinyBirch, PlacedFeatureUtil.createWouldSurvivePlacementModifier(Blocks.BIRCH_SAPLING));
        SublunaryPlacedFeatures.register(context, VINY_OLD_GROWTH_BIRCH_PLACED, vinyOldGrowthBirch, PlacedFeatureUtil.createWouldSurvivePlacementModifier(Blocks.BIRCH_SAPLING));

        SublunaryPlacedFeatures.register(context, VINY_DARK_OAK_PLACED, vinyDarkOak, PlacedFeatureUtil.createWouldSurvivePlacementModifier(Blocks.DARK_OAK_SAPLING));

        SublunaryPlacedFeatures.register(context, VINY_SPRUCE_PLACED, vinySpruce, PlacedFeatureUtil.createWouldSurvivePlacementModifier(Blocks.SPRUCE_SAPLING));

    }

}

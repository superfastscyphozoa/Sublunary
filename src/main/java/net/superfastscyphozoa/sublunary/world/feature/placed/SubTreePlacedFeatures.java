package net.superfastscyphozoa.sublunary.world.feature.placed;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
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

    public static final RegistryKey<PlacedFeature> VINY_OAK_PLACED = registerKey("viny_oak_placed");
    public static final RegistryKey<PlacedFeature> LARGE_VINY_OAK_PLACED = registerKey("large_viny_oak_placed");

    public static final RegistryKey<PlacedFeature> VINY_BIRCH_PLACED = registerKey("viny_birch_placed");
    public static final RegistryKey<PlacedFeature> VINY_OLD_GROWTH_BIRCH_PLACED = registerKey("viny_old_growth_birch_placed");

    public static final RegistryKey<PlacedFeature> VINY_DARK_OAK_PLACED = registerKey("viny_dark_oak_placed");

    public static final RegistryKey<PlacedFeature> VINY_SPRUCE_PLACED = registerKey("viny_spruce_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        RegistryEntry<ConfiguredFeature<?, ?>> oakierOak = configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.OAKIER_OAK);
        RegistryEntry<ConfiguredFeature<?, ?>> largeOakierOak = configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.LARGE_OAKIER_OAK);
        RegistryEntry<ConfiguredFeature<?, ?>> birchierBirch = configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.BIRCHIER_BIRCH);

        RegistryEntry<ConfiguredFeature<?, ?>> smallOak = configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.SMALL_OAK);
        RegistryEntry<ConfiguredFeature<?, ?>> smallBirch = configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.SMALL_BIRCH);

        RegistryEntry<ConfiguredFeature<?, ?>> forestOak = configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.FOREST_OAK);
        RegistryEntry<ConfiguredFeature<?, ?>> largeForestOak = configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.LARGE_FOREST_OAK);
        RegistryEntry<ConfiguredFeature<?, ?>> forestBirch = configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.FOREST_BIRCH);

        RegistryEntry<ConfiguredFeature<?, ?>> hickory = configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.HICKORY);

        RegistryEntry<ConfiguredFeature<?, ?>> flowerForestOak = configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.FOREST_OAK);
        RegistryEntry<ConfiguredFeature<?, ?>> largeFlowerForestOak = configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.LARGE_FOREST_OAK);
        RegistryEntry<ConfiguredFeature<?, ?>> flowerForestBirch = configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.FOREST_BIRCH);

        RegistryEntry<ConfiguredFeature<?, ?>> plainsOak = configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.PLAINS_OAK);
        RegistryEntry<ConfiguredFeature<?, ?>> largePlainsOak = configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.LARGE_PLAINS_OAK);

        RegistryEntry<ConfiguredFeature<?, ?>> oldGrowthBirch = configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.OLD_GROWTH_BIRCH);

        RegistryEntry<ConfiguredFeature<?, ?>> meadowOak = configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.MEADOW_OAK);
        RegistryEntry<ConfiguredFeature<?, ?>> meadowBirch = configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.MEADOW_BIRCH);

        RegistryEntry<ConfiguredFeature<?, ?>> darkOak = configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.DARK_OAK);

        RegistryEntry<ConfiguredFeature<?, ?>> spruceFull = configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.SPRUCE_FULL);
        RegistryEntry<ConfiguredFeature<?, ?>> spruceSparse = configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.SPRUCE_SPARSE);

        RegistryEntry<ConfiguredFeature<?, ?>> vinyOak = configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.VINY_OAK);
        RegistryEntry<ConfiguredFeature<?, ?>> largeVinyOak = configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.LARGE_VINY_OAK);

        RegistryEntry<ConfiguredFeature<?, ?>> vinyBirch = configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.VINY_BIRCH);
        RegistryEntry<ConfiguredFeature<?, ?>> vinyOldGrowthBirch = configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.VINY_OLD_GROWTH_BIRCH);

        RegistryEntry<ConfiguredFeature<?, ?>> vinyDarkOak = configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.VINY_DARK_OAK);

        RegistryEntry<ConfiguredFeature<?, ?>> vinySpruce = configuredFeatureRegistryEntryLookup.getOrThrow(SubTreeConfiguredFeatures.VINY_SPRUCE);

        SublunaryPlacedFeatures.register(context, OAKIER_OAK_PLACED, oakierOak, PlacedFeatures.wouldSurvive(Blocks.OAK_SAPLING));
        SublunaryPlacedFeatures.register(context, LARGE_OAKIER_OAK_PLACED, largeOakierOak, PlacedFeatures.wouldSurvive(Blocks.OAK_SAPLING));
        SublunaryPlacedFeatures.register(context, BIRCHIER_BIRCH_PLACED, birchierBirch, PlacedFeatures.wouldSurvive(Blocks.BIRCH_SAPLING));

        SublunaryPlacedFeatures.register(context, SMALL_OAK_PLACED, smallOak, PlacedFeatures.wouldSurvive(Blocks.OAK_SAPLING));
        SublunaryPlacedFeatures.register(context, SMALL_BIRCH_PLACED, smallBirch, PlacedFeatures.wouldSurvive(Blocks.BIRCH_SAPLING));

        SublunaryPlacedFeatures.register(context, FOREST_OAK_PLACED, forestOak, PlacedFeatures.wouldSurvive(Blocks.OAK_SAPLING));
        SublunaryPlacedFeatures.register(context, LARGE_FOREST_OAK_PLACED, largeForestOak, PlacedFeatures.wouldSurvive(Blocks.OAK_SAPLING));
        SublunaryPlacedFeatures.register(context, FOREST_BIRCH_PLACED, forestBirch, PlacedFeatures.wouldSurvive(Blocks.BIRCH_SAPLING));

        SublunaryPlacedFeatures.register(context, HICKORY_PLACED, hickory, PlacedFeatures.wouldSurvive(RegisterBlocks.HICKORY_SAPLING));

        SublunaryPlacedFeatures.register(context, FLOWER_FOREST_OAK_PLACED, flowerForestOak, PlacedFeatures.wouldSurvive(Blocks.OAK_SAPLING));
        SublunaryPlacedFeatures.register(context, LARGE_FLOWER_FOREST_OAK_PLACED, largeFlowerForestOak, PlacedFeatures.wouldSurvive(Blocks.OAK_SAPLING));
        SublunaryPlacedFeatures.register(context, FLOWER_FOREST_BIRCH_PLACED, flowerForestBirch, PlacedFeatures.wouldSurvive(Blocks.BIRCH_SAPLING));

        SublunaryPlacedFeatures.register(context, PLAINS_OAK_PLACED, plainsOak, PlacedFeatures.wouldSurvive(Blocks.OAK_SAPLING));
        SublunaryPlacedFeatures.register(context, LARGE_PLAINS_OAK_PLACED, largePlainsOak, PlacedFeatures.wouldSurvive(Blocks.OAK_SAPLING));

        SublunaryPlacedFeatures.register(context, OLD_GROWTH_BIRCH_PLACED, oldGrowthBirch, PlacedFeatures.wouldSurvive(Blocks.BIRCH_SAPLING));

        SublunaryPlacedFeatures.register(context, MEADOW_OAK_PLACED, meadowOak, PlacedFeatures.wouldSurvive(Blocks.OAK_SAPLING));
        SublunaryPlacedFeatures.register(context, MEADOW_BIRCH_PLACED, meadowBirch, PlacedFeatures.wouldSurvive(Blocks.BIRCH_SAPLING));

        SublunaryPlacedFeatures.register(context, DARK_OAK_PLACED, darkOak, PlacedFeatures.wouldSurvive(Blocks.DARK_OAK_SAPLING));

        SublunaryPlacedFeatures.register(context, SPRUCE_FULL_PLACED, spruceFull, PlacedFeatures.wouldSurvive(Blocks.SPRUCE_SAPLING));
        SublunaryPlacedFeatures.register(context, SPRUCE_SPARSE_PLACED, spruceSparse, PlacedFeatures.wouldSurvive(Blocks.SPRUCE_SAPLING));

        SublunaryPlacedFeatures.register(context, VINY_OAK_PLACED, vinyOak, PlacedFeatures.wouldSurvive(Blocks.OAK_SAPLING));
        SublunaryPlacedFeatures.register(context, LARGE_VINY_OAK_PLACED, largeVinyOak, PlacedFeatures.wouldSurvive(Blocks.OAK_SAPLING));

        SublunaryPlacedFeatures.register(context, VINY_BIRCH_PLACED, vinyBirch, PlacedFeatures.wouldSurvive(Blocks.BIRCH_SAPLING));
        SublunaryPlacedFeatures.register(context, VINY_OLD_GROWTH_BIRCH_PLACED, vinyOldGrowthBirch, PlacedFeatures.wouldSurvive(Blocks.BIRCH_SAPLING));

        SublunaryPlacedFeatures.register(context, VINY_DARK_OAK_PLACED, vinyDarkOak, PlacedFeatures.wouldSurvive(Blocks.DARK_OAK_SAPLING));

        SublunaryPlacedFeatures.register(context, VINY_SPRUCE_PLACED, vinySpruce, PlacedFeatures.wouldSurvive(Blocks.SPRUCE_SAPLING));

    }

}

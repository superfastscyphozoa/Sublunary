package net.superfastscyphozoa.sublunary.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.RecipesProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonFactory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;
import net.superfastscyphozoa.sublunary.util.SublunaryTags;
import org.quiltmc.qsl.recipe.api.builder.ShapedRecipeBuilder;
import org.quiltmc.qsl.recipe.api.builder.VanillaRecipeBuilders;

public class SublunaryRecipeProvider extends FabricRecipeProvider {
    public SublunaryRecipeProvider(FabricDataOutput output) {
        super(output);
    }

	@Override
	public void generateRecipes(RecipeExporter exporter) {
		offerPlanksRecipe(exporter, RegisterBlocks.HICKORY_PLANKS, SublunaryTags.Items.HICKORY_LOGS, 4);

		offerBarkBlockRecipe(exporter, RegisterBlocks.HICKORY_WOOD, RegisterBlocks.HICKORY_LOG);
		offerBarkBlockRecipe(exporter, RegisterBlocks.STRIPPED_HICKORY_WOOD, RegisterBlocks.STRIPPED_HICKORY_LOG);

		offerShapelessRecipe(exporter, Items.LIGHT_GRAY_DYE, RegisterBlocks.CALLA_LILY, "calla_lily");

		offerShapelessRecipe(exporter, Items.PURPLE_DYE, RegisterBlocks.LAVENDER, "lavender");
	}
}

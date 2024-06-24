package net.superfastscyphozoa.sublunary.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.RecipesProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;

public class SublunaryRecipeProvider extends FabricRecipeProvider {
    public SublunaryRecipeProvider(FabricDataOutput output) {
        super(output);
    }

	@Override
	public void generateRecipes(RecipeExporter exporter) {
	}
}

package net.john.firstmod.datagen;

import net.john.firstmod.Item.ModItems;
import net.john.firstmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SMOOTH_FART_BLOCK.get(), 4)
                .pattern("AA")
                .pattern("AA")
                .define('A', ModBlocks.FART_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.FART_BLOCK.get()), has(ModBlocks.FART_BLOCK.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.WAND.get())
                .pattern(" AA")
                .pattern(" SA")
                .pattern("S  ")
                .define('A', ModItems.JHON.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.JHON.get()), has(ModItems.JHON.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SUPER_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.GOKU.get())
                .unlockedBy(getHasName(ModItems.GOKU.get()), has(ModItems.GOKU.get())).save(pRecipeOutput);
    }
}

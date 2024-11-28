package net.john.firstmod.datagen;

import net.john.firstmod.FirstMod;
import net.john.firstmod.Item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FirstMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.JHON.get());
        basicItem(ModItems.GOKU.get());

        basicItem(ModItems.WAND.get());
    }
}

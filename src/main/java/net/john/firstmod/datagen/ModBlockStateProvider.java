package net.john.firstmod.datagen;

import net.john.firstmod.FirstMod;
import net.john.firstmod.block.ModBlocks;
import net.john.firstmod.block.custom.LampBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FirstMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.FART_BLOCK);
        blockWithItem(ModBlocks.SMOOTH_FART_BLOCK);

        blockWithItem(ModBlocks.JHON_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_JHON_ORE);

        blockWithItem(ModBlocks.SUPER_BLOCK);

        customLamp();
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.LAMP.get()).forAllStates(state -> {
            if(state.getValue(LampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("lamp_on",
                        ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "block/" + "lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("lamp_off",
                        ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "block/" + "lamp_off")))};
            }
        });
        simpleBlockItem(ModBlocks.LAMP.get(), models().cubeAll("lamp_on",
                ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "block/" + "lamp_on")));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}

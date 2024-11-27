package net.john.firstmod.Item;

import net.john.firstmod.FirstMod;
import net.john.firstmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FirstMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> JHONMOD_ITEMS_TAB = CREATIVE_MODE_TABS.register("jhon_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GOKU.get()))
                    .title(Component.translatable("creativetab.firstmod.jhon_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.GOKU.get());
                        output.accept(ModItems.JHON.get());
                        output.accept(ModItems.WAND.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> JHONMOD_BLOCKS_TAB = CREATIVE_MODE_TABS.register("jhon_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.JHON.get()))
                    .withTabsBefore(JHONMOD_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.firstmod.jhon_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.FART_BLOCK.get());
                        output.accept(ModBlocks.SMOOTH_FART_BLOCK.get());
                        output.accept(ModBlocks.JHON_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_JHON_ORE.get());
                        output.accept(ModBlocks.SUPER_BLOCK.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}

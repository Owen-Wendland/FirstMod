package net.john.firstmod.block;

import net.john.firstmod.FirstMod;
import net.john.firstmod.Item.ModItems;
import net.john.firstmod.block.custom.LampBlock;
import net.john.firstmod.block.custom.SuperBlock;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FirstMod.MOD_ID);

    public static final RegistryObject<Block> FART_BLOCK = registerBlock("fart_block", () -> new Block(BlockBehaviour.Properties.of()
            .strength(1f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> SMOOTH_FART_BLOCK = registerBlock("smooth_fart_block", () -> new Block(BlockBehaviour.Properties.of()
            .strength(1f).requiresCorrectToolForDrops().sound(SoundType.BONE_BLOCK)));

    public static final RegistryObject<Block> JHON_ORE = registerBlock("jhon_ore", () -> new DropExperienceBlock(UniformInt.of(2,10), BlockBehaviour.Properties.of()
            .strength(1.5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DEEPSLATE_JHON_ORE = registerBlock("deepslate_jhon_ore", () -> new DropExperienceBlock(UniformInt.of(5,15), BlockBehaviour.Properties.of()
            .strength(2f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> SUPER_BLOCK = registerBlock("super_block", () -> new SuperBlock(BlockBehaviour.Properties.of()
            .strength(0.2f).sound(SoundType.CROP)));

    public static final RegistryObject<Block> LAMP = registerBlock("lamp", () -> new LampBlock(BlockBehaviour.Properties.of().strength(3f)
            .lightLevel(state -> state.getValue(LampBlock.CLICKED) ? 15 : 0)));

    private static  <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends  Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}

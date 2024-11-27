package net.john.firstmod.Item;

import net.john.firstmod.FirstMod;
import net.john.firstmod.Item.custom.WandItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FirstMod.MOD_ID);

    public static final RegistryObject<Item> JHON = ITEMS.register("jhon",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder().nutrition(100).saturationModifier(1000)
                            .effect(new MobEffectInstance(MobEffects.LEVITATION,200,0), 1f).alwaysEdible()
                            .effect(new MobEffectInstance(MobEffects.POISON,100,0), 1f)
                            .build())));
    public static final RegistryObject<Item> GOKU = ITEMS.register("goku", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> WAND = ITEMS.register("wand",
            () -> new WandItem(new Item.Properties().durability(128)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

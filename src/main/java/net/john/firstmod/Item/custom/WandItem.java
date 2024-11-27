package net.john.firstmod.Item.custom;

import net.john.firstmod.FirstMod;
import net.john.firstmod.Item.ModItems;
import net.john.firstmod.block.ModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Map;

public class WandItem extends Item {
    private static final Map<Block, Block> WAND_MAP =
            Map.of(
                    ModBlocks.FART_BLOCK.get(), ModBlocks.SMOOTH_FART_BLOCK.get(),
                    ModBlocks.SMOOTH_FART_BLOCK.get(), ModBlocks.FART_BLOCK.get()
            );

    public WandItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();

        if(WAND_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()){
                level.setBlockAndUpdate(pContext.getClickedPos(), WAND_MAP.get(clickedBlock).defaultBlockState());

                pContext.getItemInHand().hurtAndBreak(1,((ServerLevel) level),((ServerPlayer) pContext.getPlayer()),
                        item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));
                level.playSound(null,pContext.getClickedPos(), SoundEvents.ANVIL_HIT, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        Vec3 direction = pPlayer.getLookAngle();

        //pPlayer.moveRelative(1,direction);
        pPlayer.setDeltaMovement(direction.x * 4, direction.y * 4, direction.z * 4);
        //pPlayer.set
        pPlayer.getCooldowns().addCooldown(pPlayer.getItemInHand(pUsedHand).getItem(), 100);
        //System.out.println(direction)
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}

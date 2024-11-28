package net.john.firstmod.block.custom;

import net.john.firstmod.Item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class SuperBlock extends Block {
    public SuperBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pMovedByPiston) {
        pLevel.addParticle(ParticleTypes.EXPLOSION,pPos.getX(),pPos.getY(),pPos.getZ(),0,0,0);
        super.onPlace(pState, pLevel, pPos, pOldState, pMovedByPiston);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        float chance = 0.2f;
        if(chance < pRandom.nextFloat()){
            pLevel.addParticle(ParticleTypes.ITEM_SLIME,pPos.getX()+pRandom.nextDouble(),pPos.getY() + 0.5D,pPos.getZ()+pRandom.nextDouble(),
                    0d,0.1d,0d);
        }
        super.animateTick(pState, pLevel, pPos, pRandom);

    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        float multip = 1.0f;
        Vec3 a = pPlayer.getLookAngle();
        pPlayer.heal(1);
        pPlayer.setDeltaMovement(-a.x*multip,.6,-a.z*multip);
        pLevel.playSound(pPlayer, pPos, SoundEvents.SLIME_JUMP, SoundSource.BLOCKS, 1f, 1f);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(pEntity instanceof ItemEntity itemEntity) {
            if(itemEntity.getItem().getItem() == ModItems.JHON.get()) {
                itemEntity.addDeltaMovement(new Vec3(0, 0.6, 0));
            }
        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}

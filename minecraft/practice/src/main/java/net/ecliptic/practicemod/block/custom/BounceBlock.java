package net.ecliptic.practicemod.block.custom;

import net.ecliptic.practicemod.block.ModBlocks;
import net.minecraft.client.KeyboardHandler;
import net.minecraft.client.player.KeyboardInput;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.fml.common.Mod;

import java.awt.*;

public class BounceBlock extends Block {
    boolean left = false;
    BlockPos BounceBlockPos = null;
    Entity player = null;
    public BounceBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        super.stepOn(pLevel, pPos, pState, pEntity);

        double block_x = pPos.getX();
        double block_y = pPos.getY();
        double block_z = pPos.getZ();

        double player_x = pEntity.getX();
        double player_y = pEntity.getY();
        double player_z = pEntity.getZ();

        if (pEntity.getPortalCooldown() == 0) {
            if (pEntity.isCrouching()) {
                for (double i = block_y - 1; i > block_y - 20; i--) {
                    if (pLevel.getBlockState(BlockPos.containing(block_x, i, block_z)).is(ModBlocks.BOUNCE_BLOCK.get())) {
                        pEntity.teleportTo(player_x, i + 1.5, player_z);
                        pEntity.setPortalCooldown();
                        return;
                    }
                }
            }

            if (pEntity.isSprinting()) {
                for (double i = block_y + 1; i < block_y + 20; i++) {
                    if (pLevel.getBlockState(BlockPos.containing(block_x, i, block_z)).is(ModBlocks.BOUNCE_BLOCK.get())) {
                        pEntity.teleportTo(player_x, i + 1.5, player_z);
                        pEntity.setPortalCooldown();
                        return;
                    }
                }
            }
        }
    }
}

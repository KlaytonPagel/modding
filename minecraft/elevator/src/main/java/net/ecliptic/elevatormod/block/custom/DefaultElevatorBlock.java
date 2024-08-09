package net.ecliptic.elevatormod.block.custom;

import net.ecliptic.elevatormod.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class DefaultElevatorBlock extends Block {
    boolean left = false;
    BlockPos BounceBlockPos = null;
    Entity player = null;
    public DefaultElevatorBlock(Properties pProperties) {
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
                    if (pLevel.getBlockState(BlockPos.containing(block_x, i, block_z)).is(ModBlocks.DEFAULT_ELEVATOR_BLOCK.get())) {
                        pEntity.teleportTo(player_x, i + 1.5, player_z);
                        pEntity.setPortalCooldown();
                        return;
                    }
                }
            }

            if (pEntity.isSprinting()) {
                for (double i = block_y + 1; i < block_y + 20; i++) {
                    if (pLevel.getBlockState(BlockPos.containing(block_x, i, block_z)).is(ModBlocks.DEFAULT_ELEVATOR_BLOCK.get())) {
                        pEntity.teleportTo(player_x, i + 1.5, player_z);
                        pEntity.setPortalCooldown();
                        return;
                    }
                }
            }
        }
    }
}

package net.ecliptic.elevatormod.block;

import net.ecliptic.elevatormod.ElevatorMod;
import net.ecliptic.elevatormod.block.custom.DefaultElevatorBlock;
import net.ecliptic.elevatormod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


// Class for adding blocks______________________________________________________________________________________________
public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ElevatorMod.MOD_ID);

//    Add blocks here______________________________________________________________________________
    public static final RegistryObject<Block> DEFAULT_ELEVATOR_BLOCK = registerBlock("default_elevator_block",
            () -> new DefaultElevatorBlock(BlockBehaviour.Properties.copy(Blocks.SLIME_BLOCK).strength(0.1F)));

//
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

//    Register the block as an item________________________________________________________________
    public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

//    Set up the bus for block items)___________________________________________________________________________________
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}

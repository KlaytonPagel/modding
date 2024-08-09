package net.ecliptic.elevatormod.item;

import net.ecliptic.elevatormod.ElevatorMod;
import net.ecliptic.elevatormod.ElevatorMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


// Class used to add new items to the game______________________________________________________________________________
public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ElevatorMod.MOD_ID);

//    Add each custom item here____________________________________________________________________

//    Set up the bus for the custom items_______________________________________________________________________________
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}

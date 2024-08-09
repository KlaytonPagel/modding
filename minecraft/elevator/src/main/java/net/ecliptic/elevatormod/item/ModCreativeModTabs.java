package net.ecliptic.elevatormod.item;

import net.ecliptic.elevatormod.ElevatorMod;
import net.ecliptic.elevatormod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

// Class to add new items to the new creative mod tab___________________________________________________________________
public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ElevatorMod.MOD_ID);


//  Creates tge "practice tab" in the creative menu and adds items under it_____________________________________________
    public static final RegistryObject<CreativeModeTab> PRACTICE_TAB = CREATIVE_MODE_TABS.register("elevator_tab",
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.DEFAULT_ELEVATOR_BLOCK.get())) // Tabs icon
                    .title(Component.translatable("creativetab.elevator_tab"))
                    .displayItems((pParameters, pOutput) -> {

//                      Add custom items here to add them to the creative menu_____________________
                        pOutput.accept(ModBlocks.DEFAULT_ELEVATOR_BLOCK.get());

                    })
                    .build());


//  register the event bus for the tabs_________________________________________________________________________________
    public static void register(IEventBus eventbus) {
        CREATIVE_MODE_TABS.register(eventbus);
    }

}

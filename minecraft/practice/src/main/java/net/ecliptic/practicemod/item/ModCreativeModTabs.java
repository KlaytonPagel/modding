package net.ecliptic.practicemod.item;

import net.ecliptic.practicemod.PracticeMod;
import net.ecliptic.practicemod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

// Class to add new items to the new creative mod tab___________________________________________________________________
public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PracticeMod.MOD_ID);


//  Creates tge "practice tab" in the creative menu and adds items under it_____________________________________________
    public static final RegistryObject<CreativeModeTab> PRACTICE_TAB = CREATIVE_MODE_TABS.register("practice_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SAPPHIRE.get())) // Tabs icon
                    .title(Component.translatable("creativetab.practice_tab"))
                    .displayItems((pParameters, pOutput) -> {

//                      Add custom items here to add them to the creative menu_____________________
                        pOutput.accept(ModItems.SAPPHIRE.get());
                        pOutput.accept(ModItems.RUBY.get());
                        pOutput.accept(ModItems.ZOOMSTICK.get());


                        pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                        pOutput.accept(ModBlocks.RUBY_BLOCK.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.BOUNCE_BLOCK.get());

                    })
                    .build());


//  register the event bus for the tabs_________________________________________________________________________________
    public static void register(IEventBus eventbus) {
        CREATIVE_MODE_TABS.register(eventbus);
    }

}

package net.ecliptic.elevatormod;

import com.mojang.logging.LogUtils;
import net.ecliptic.elevatormod.block.ModBlocks;
import net.ecliptic.elevatormod.item.ModCreativeModTabs;
import net.ecliptic.elevatormod.item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ElevatorMod.MOD_ID)
public class ElevatorMod {
    public static final String MOD_ID = "elevatormod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ElevatorMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

//        Bus for creative mode tabs_______________________________________________________________
        ModCreativeModTabs.register(modEventBus);

//        Bus for custom items_____________________________________________________________________
        ModItems.register(modEventBus);

//        Bus for custom blocks____________________________________________________________________
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

//     Add items to the default minecraft tabs__________________________________________________________________________
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

//        Set the creative mod tab to add items to, then list the items to add them________________

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}

package net.ecliptic.practicemod.item;

import net.ecliptic.practicemod.PracticeMod;
import net.ecliptic.practicemod.item.custom.ZoomStickItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


// Class used to add new items to the game______________________________________________________________________________
public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PracticeMod.MOD_ID);

//    Add each custom item here____________________________________________________________________
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ZOOMSTICK = ITEMS.register("zoom_stick",
            () -> new ZoomStickItem(new Item.Properties().durability(1)));

//    Set up the bus for the custom items_______________________________________________________________________________
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}

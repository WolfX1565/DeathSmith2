package com.deathsmith.init;

import com.deathsmith.DeathSmith;
import com.deathsmith.items.FireBladeItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DeathSmith.MODID);

    public static final RegistryObject<Item> FIRE_BLADE = ITEMS.register("fire_blade",
            () -> new FireBladeItem(Tiers.IRON, 3, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}

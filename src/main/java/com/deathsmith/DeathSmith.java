package com.deathsmith;

import com.deathsmith.init.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(DeathSmith.MODID)
public class DeathSmith {
    public static final String MODID = "deathsmith";

    public DeathSmith() {
        ModItems.register(FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.register(new com.deathsmith.events.ModEvents());
    }
}

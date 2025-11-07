package com.deathsmith.events;

import com.deathsmith.init.ModItems;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ModEvents {
    private final Map<UUID, String> lastDeath = new HashMap<>();

    @SubscribeEvent
    public void onPlayerDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof Player player) {
            DamageSource src = event.getSource();
            String id = src.getMsgId();
            lastDeath.put(player.getUUID(), id == null ? "" : id);
        }
    }

    @SubscribeEvent
    public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        Player player = event.getEntity();
        String cause = lastDeath.getOrDefault(player.getUUID(), "");
        ItemStack reward = ItemStack.EMPTY;

        if (cause.contains("inFire") || cause.contains("lava")) reward = new ItemStack(ModItems.FIRE_BLADE.get());

        if (!reward.isEmpty()) {
            boolean added = player.getInventory().add(reward);
            if (!added) player.drop(reward, false);
        }
    }
}

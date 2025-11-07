package com.deathsmith.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;

public class FireBladeItem extends SwordItem {
    public FireBladeItem(Tier tier, int dmg, float spd, Properties props) {
        super(tier, dmg, spd, props);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!target.level().isClientSide) {
            target.setSecondsOnFire(5);
        }
        return super.hurtEnemy(stack, target, attacker);
    }
}

package com.gameidiots.cursebound;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.entry.RegistryEntry;

public class CurseManager
{
    public static void applyCurse(PlayerEntity player, RegistryEntry<StatusEffect> effect)
    {
        if (player.getWorld().isClient())
        {
            return;
        }

        player.addStatusEffect(new StatusEffectInstance(effect, Integer.MAX_VALUE));
    }
}

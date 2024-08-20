package com.gameidiots.cursebound.registry;

import com.gameidiots.cursebound.ModMain;
import com.gameidiots.cursebound.effect.WitheredEffect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public final class ModStatusEffects
{
    public static final RegistryEntry<StatusEffect> WITHERED = register("withered", new WitheredEffect());
    
    private static RegistryEntry<StatusEffect> register(String id, StatusEffect statusEffect)
    {
        return Registry.registerReference(
            Registries.STATUS_EFFECT,
            Identifier.of(ModMain.MOD_ID, id),
            statusEffect
        );
    }

    public static void register()
    {
    }    
}

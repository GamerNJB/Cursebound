package com.gameidiots.cursebound.registry;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import com.gameidiots.cursebound.ModMain;

import net.minecraft.entity.damage.DamageType;

public final class ModDamageTypes
{
    public static RegistryKey<DamageType> WITHERED = RegistryKey.of(
        RegistryKeys.DAMAGE_TYPE,
        Identifier.of(ModMain.MOD_ID, "withered")
    );

    public static void register()
    {
    }    
}

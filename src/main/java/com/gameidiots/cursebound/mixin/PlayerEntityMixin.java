package com.gameidiots.cursebound.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    
    @Shadow
    public abstract void addStatusEffect(StatusEffectInstance effect);

    @Shadow
    public abstract void removeStatusEffect(StatusEffect effect);
}

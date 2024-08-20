package com.gameidiots.cursebound.effect;

import com.gameidiots.cursebound.registry.ModDamageTypes;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.World;

public class WitheredEffect extends StatusEffect {
    // private static final DamageSource WITHER_DAMAGE_SOURCE = new DamageSource("wither") {
    //     @Override
    //     public boolean isInstant() {
    //         return false;
    //     }

    //     @Override
    //     public boolean isBypassingArmor() {
    //         return true;
    //     }
    // };

    public WitheredEffect()
    {
        super(StatusEffectCategory.HARMFUL, 0x7F7F7F); // Color in RGB
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier)
    {
        World world = entity.getWorld();
        if (world.isClient())
        {
            return false;
        }

        DamageSource damageSource = new DamageSource(
            world.getRegistryManager()
                .get(RegistryKeys.DAMAGE_TYPE)
                .entryOf(ModDamageTypes.WITHERED)
        );

        if (entity instanceof PlayerEntity player)
        {
            // Apply damage to the entity, with the damage source set as the player
            player.damage(damageSource, 1.0f); // Adjust damage as needed
        }

        return true;
    }
}

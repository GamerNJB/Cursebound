package com.gameidiots.cursebound;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gameidiots.cursebound.registry.ModDamageTypes;
import com.gameidiots.cursebound.registry.ModStatusEffects;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.ActionResult;

public class ModMain implements ModInitializer
{
    public static final String MOD_ID = "cursebound";
    public static final String MOD_NAME = "Cursebound";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    @Override
    public void onInitialize()
    {
        ModDamageTypes.register();
        ModStatusEffects.register();

        // Register the attack event listener
        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (!world.isClient && player.hasStatusEffect(ModStatusEffects.WITHERED)) {
                // Check the level of the cursebound:withered effect
                StatusEffectInstance witheredEffect = player.getStatusEffect(ModStatusEffects.WITHERED);
                if (witheredEffect != null && witheredEffect.getAmplifier() < 2) {
                    // Apply Wither II to the player if the amplifier is less than 2
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 40, 1)); // 40 ticks = 2 seconds, amplifier = 1 (Wither II)
                }

                // Apply Wither I to the mob regardless of the effect level
                if (entity instanceof LivingEntity) {
                    ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 30, 1)); // 30 ticks = 1.5 seconds, amplifier = 1 (Wither I)
                }
            }
            return ActionResult.PASS;
        });

        // Register commands
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            CurseCommands.register(dispatcher);
        });
        
        LOGGER.info("{} mod has been initialized", MOD_NAME);
    }
}

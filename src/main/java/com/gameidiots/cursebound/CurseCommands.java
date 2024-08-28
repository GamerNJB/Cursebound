package com.gameidiots.cursebound;

import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;

import com.gameidiots.cursebound.registry.ModStatusEffects;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;

public class CurseCommands
{
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher)
    {
        dispatcher.register(CommandManager.literal("applycurse")
            .then(CommandManager.argument("curseName", StringArgumentType.string())
                .executes(context -> {
                    String curseName = StringArgumentType.getString(context, "curseName");
                    ServerPlayerEntity player = context.getSource().getPlayer();
                    
                    if (curseName.equals("withered"))
                    {
                        CurseManager.applyCurse(player, ModStatusEffects.WITHERED);
                    }
                    // Assuming command tags are managed by a custom system or other API; adapt as needed
                    player.getCommandTags().add(curseName.toUpperCase());
                    
                    return 1;
                })
            )
        );
    }
}

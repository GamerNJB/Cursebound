package com.gameidiots.cursebound;

import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;

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
                    
                    return 1;
                })
            )
        );
    }
}

package net.alstromeria.mrpg.commands.Trader;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class Command {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("mrpg")
                .then(CommandManager.literal("trader")
                        .then(CommandManager.literal("attacker")
                                .executes(content -> {
                                    ServerCommandSource source = content.getSource();
                                    ServerPlayerEntity player = source.getPlayer();
                                    Attacker.spawnTrader(player.getWorld(), player.getBlockPos());
                                    source.sendFeedback(() -> Text.literal("Spawned attacker trader"), true);
                                    return 1;
                                }))
                        .then(CommandManager.literal("supporter")
                                .executes(content -> {
                                    ServerCommandSource source = content.getSource();
                                    ServerPlayerEntity player = source.getPlayer();
                                    Supporter.spawnTrader(player.getWorld(), player.getBlockPos());
                                    source.sendFeedback(() -> Text.literal("Spawned supporter trader"), true);
                                    return 1;
                                }))
                        .then(CommandManager.literal("both")
                                .executes(content -> {
                                    ServerCommandSource source = content.getSource();
                                    ServerPlayerEntity player = source.getPlayer();
                                    Attacker.spawnTrader(player.getWorld(), player.getBlockPos());
                                    Supporter.spawnTrader(player.getWorld(), player.getBlockPos().east());
                                    source.sendFeedback(() -> Text.literal("Spawned attacker and supporter trader"), true);
                                    return 1;
                                })))
                        .executes(content -> {
                            ServerCommandSource source = content.getSource();
                            source.sendFeedback(() ->
                                    Text.literal("[人狼RPG] ").setStyle(Style.EMPTY.withColor(Formatting.RED))
                                            .append(Text.literal("Version: 0.1").setStyle(Style.EMPTY.withColor(Formatting.WHITE))), true);
                            return 0;
                        })
                );
    }

    public static void initialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated, registrationEnvironment) -> {
            Command.register(dispatcher);
        });
    }
}
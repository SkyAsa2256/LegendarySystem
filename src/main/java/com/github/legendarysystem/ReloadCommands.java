package com.github.legendarysystem;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class ReloadCommands extends CommandBase {
    @Override
    public String getName() {
        return "legendaryreload";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/legendaryreload";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
      Config.syncFromFiles();
      sender.sendMessage(new TextComponentString("Reload Success!"));
    }
}

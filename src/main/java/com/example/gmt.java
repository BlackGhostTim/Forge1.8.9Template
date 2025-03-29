package com.example;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;



public class gmt extends CommandBase {
    public static void gmt() {
    }   //
    @Override
    public String getCommandName() {
        return "/gmt";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/gmt";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        sender.addChatMessage(new ChatComponentText(Minecraft.getMinecraft().getSession().getToken()));

    }
    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
}

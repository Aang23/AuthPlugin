package com.auth.mod.commands;
import com.auth.mod.Main;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.server.FMLServerHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;


public class LoginCommand extends CommandBase implements ICommand {
	
	@Override
	public String getCommandName()
	{
	return "login";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
	return "/login <password>";
	}
	 public boolean func_184882_a(MinecraftServer server, ICommandSender sender)
	  {
	    return true;
	  }
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		EntityPlayer player = (EntityPlayer) sender;
if(Main.passwords.containsKey(player.getName())){
	if( Main.passwords.get(player.getName()).equals(args[0])){
		Main.logged.add(player.getName());
		Main.time.remove(player.getName());
		
		player.addChatMessage(new TextComponentString(TextFormatting.GREEN + (String)Main.config.get("loggedmessage")));
	}
	else {
		player.addChatMessage(new TextComponentString(TextFormatting.RED + (String)Main.config.get("wrongpass")));
	}
} else {
	player.addChatMessage(new TextComponentString(TextFormatting.RED + (String)Main.config.get("registermessage")));
}
	}
}



package com.auth.mod.events;

import com.auth.mod.Main;

import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.server.FMLServerHandler;

public class PlayerLoggedOut {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	  public void PlayerLoggedOut(PlayerEvent.PlayerLoggedOutEvent evt) {
		
		if(Main.debug==1)System.out.println(evt.player.getName() + " called PlayentLoggedOut");
		String brut = null;
		MinecraftServer minecraftServer = FMLServerHandler.instance().getServer();
		if(minecraftServer.getPlayerList().getPlayerByUsername(evt.player.getName())!=null){
		brut = minecraftServer.getPlayerList().getPlayerByUsername(evt.player.getName()).connection.getNetworkManager().getRemoteAddress().toString().replaceAll("/", "");
		int lenght = brut.length();
		brut = brut.substring(0, lenght-6);
	    }
		
		if(Integer.parseInt((String) Main.config.get("iplogin")) > 0 && !Main.ips.containsKey(brut) && Main.logged.contains(evt.player.getName())){
			Main.ips.put(brut, 0);
			}
		
		
		Main.logged.remove(evt.player.getName());
		Main.posX.remove(evt.player.getName());
		Main.posY.remove(evt.player.getName());
		Main.posZ.remove(evt.player.getName());
		Main.time.remove(evt.player.getName());
		}
}

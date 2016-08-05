package com.garbagemule.MobArena.commands;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.garbagemule.MobArena.MobArena;
import com.garbagemule.MobArena.framework.Arena;
import com.garbagemule.MobArena.framework.ArenaMaster;

public class CommandRewrite implements Listener {

	private static CommandRewrite i = new CommandRewrite();
	
	public static void enable() {
		MobArena.get().getServer().getPluginManager().registerEvents(i, MobArena.get());
	}
	
	public static void disable() {
		HandlerList.unregisterAll(i);
	}
	
	public void onCommand(PlayerCommandPreprocessEvent event) {
		ArenaMaster am = MobArena.get().getArenaMaster();
		Player p = event.getPlayer();
		
        Arena arena = am.getArenaWithPlayer(p);  
        if (arena == null) {
            arena = am.getArenaWithSpectator(p);
            if (arena == null) return;
            
        }
        
        String msg = event.getMessage();
		
		if (msg.startsWith("exit") || msg.startsWith("quit")) {
			
			event.setCancelled(true);
			
			p.performCommand("ma leave");
		}
	}
	
}

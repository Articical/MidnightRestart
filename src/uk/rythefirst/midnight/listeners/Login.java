package uk.rythefirst.midnight.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import uk.rythefirst.midnight.Main;

public class Login implements Listener {

	@EventHandler
	public void onLogin(PlayerLoginEvent e) {
		if (Main.kickLogin) {
			e.disallow(Result.KICK_OTHER, ChatColor.DARK_RED + "Server Closed!" + ChatColor.GOLD + "\nRestarting in: "
					+ Main.ttr + " minutes!");
		}
	}

}

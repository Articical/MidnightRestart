package uk.rythefirst.midnight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static Plugin instance;
	public static Worker RestartWorker;
	public static Boolean kickLogin = false;
	public static Integer ttr = 0;

	@Override
	public void onEnable() {
		instance = this;
		RestartWorker = new Worker();
		RestartWorker.StartWorker();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String time = dtf.format(now);
		Bukkit.broadcastMessage(ChatColor.GOLD + "Restarts Enabled! Time is: " + time);
	}

	@Override
	public void onDisable() {
		RestartWorker.shutDown();
	}

}

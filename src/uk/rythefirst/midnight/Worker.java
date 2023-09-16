package uk.rythefirst.midnight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class Worker {

	BukkitTask task = null;

	public void StartWorker() {
		task = new BukkitRunnable() {

			long oldEpoch = 0;

			ArrayList<String> hasRun = new ArrayList<String>();

			@Override
			public void run() {
				long newEpoch = System.currentTimeMillis();
				if (oldEpoch == 0) {
					oldEpoch = newEpoch;
				} else {
					if (newEpoch > oldEpoch + 1000) {
						oldEpoch = newEpoch;
					}
				}

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				String time = dtf.format(now);
				if (time.equals("20:00:00") && !(hasRun.contains(time))) {
					hasRun.add(time);
					Bukkit.broadcastMessage(ChatColor.DARK_RED + "4 Hours Till Restart!");
				}
				if (time.equals("21:00:00") && !(hasRun.contains(time))) {
					hasRun.add(time);
					Bukkit.broadcastMessage(ChatColor.DARK_RED + "3 Hours Till Restart!");
				}
				if (time.equals("22:00:00") && !(hasRun.contains(time))) {
					hasRun.add(time);
					Bukkit.broadcastMessage(ChatColor.DARK_RED + "2 Hours Till Restart!");
				}
				if (time.equals("23:00:00") && !(hasRun.contains(time))) {
					hasRun.add(time);
					Bukkit.broadcastMessage(ChatColor.DARK_RED + "1 Hour Till Restart!");
				}
				if (time.equals("23:30:00") && !(hasRun.contains(time))) {
					hasRun.add(time);
					Bukkit.broadcastMessage(ChatColor.DARK_RED + "30 Minutes Till Restart!");
				}
				if (time.equals("23:40:00") && !(hasRun.contains(time))) {
					hasRun.add(time);
					Bukkit.broadcastMessage(ChatColor.DARK_RED + "20 Minutes Till Restart!");
				}
				if (time.equals("23:50:00") && !(hasRun.contains(time))) {
					hasRun.add(time);
					Bukkit.broadcastMessage(ChatColor.DARK_RED + "10 Minutes Till Restart!");
				}
				if (time.equals("23:55:00") && !(hasRun.contains(time))) {
					hasRun.add(time);
					Bukkit.broadcastMessage(ChatColor.DARK_RED + "5 Minutes Till Restart!");
					Main.ttr = 5;
					Main.kickLogin = true;
				}
				if (time.equals("23:56:00") && !(hasRun.contains(time))) {
					hasRun.add(time);
					Bukkit.broadcastMessage(ChatColor.DARK_RED + "4 Minutes Till Restart!");
					Main.ttr = 4;
				}
				if (time.equals("23:57:00") && !(hasRun.contains(time))) {
					hasRun.add(time);
					Bukkit.broadcastMessage(ChatColor.DARK_RED + "3 Minutes Till Restart!");
					Main.ttr = 3;
				}
				if (time.equals("23:58:00") && !(hasRun.contains(time))) {
					hasRun.add(time);
					Bukkit.broadcastMessage(ChatColor.DARK_RED + "2 Minutes Till Restart!");
					Main.ttr = 2;
				}
				if (time.equals("23:59:00") && !(hasRun.contains(time))) {
					hasRun.add(time);
					Bukkit.broadcastMessage(ChatColor.DARK_RED + "1 Minute Till Restart!");
					Main.ttr = 1;
				}
				if (time.equals("23:59:30") && !(hasRun.contains(time))) {
					hasRun.add(time);
					Bukkit.broadcastMessage(ChatColor.DARK_RED + "30 Seconds Till Restart!");
					Main.ttr = 0;
				}
				if (time.equals("23:59:45") && !(hasRun.contains(time))) {
					hasRun.add(time);
					Bukkit.broadcastMessage(ChatColor.DARK_RED + "15 Seconds Till Restart!");
				}
				if (time.equals("23:59:50") && !(hasRun.contains(time))) {
					hasRun.add(time);
					Bukkit.broadcastMessage(ChatColor.DARK_RED + "10 Seconds Till Restart!");
				}
				if (time.equals("23:59:55") && !(hasRun.contains(time))) {
					hasRun.add(time);
					Bukkit.broadcastMessage(ChatColor.DARK_RED + "5 Seconds Till Restart!");
				}
				if ((time.equals("24:00:00") || time.equals("00:00:00")) && !(hasRun.contains(time))
						&& !(hasRun.size() == 0)) {
					hasRun.add(time);
					for (int i = 0; i < 25; i++) {
						Bukkit.broadcastMessage(ChatColor.DARK_RED + "SERVER RESTARTING!");
					}
					Bukkit.savePlayers();
					for (Player player : Bukkit.getOnlinePlayers()) {
						player.kickPlayer(ChatColor.DARK_RED + "DAILY RESTART");
					}
					Bukkit.shutdown();
				}

			}
		}.runTaskTimer(Main.instance, 0, 1);
	}

	public void shutDown() {
		if (!(task == null)) {
			task.cancel();
		}
	}

}

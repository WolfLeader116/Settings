package io.github.WolfLeader116.Settings;

import io.github.wolfleader116.chat.ChatPlugin;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mcsg.double0negative.tabapi.TabAPI;

public class TabList {
	
	public static void tablist() {
		ArrayList<String> players = new ArrayList<String>();
		for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
			String name = pl.getName();
			players.add(name);
			
		}
		for (Player p : Bukkit.getServer().getOnlinePlayers()) {
			TabAPI.setPriority(Settings.plugin, p, 0);
			TabAPI.setTabString(Settings.plugin, p, 0, 0, "�2----------");
			TabAPI.setTabString(Settings.plugin, p, 0, 1, "�2----------");
			TabAPI.setTabString(Settings.plugin, p, 0, 2, "�2----------");
			TabAPI.setTabString(Settings.plugin, p, 1, 0, "�6Online");
			TabAPI.setTabString(Settings.plugin, p, 1, 1, Settings.plugin.getConfig().getString("ServerName"));
			TabAPI.setTabString(Settings.plugin, p, 1, 2, "�6Party");
			TabAPI.setTabString(Settings.plugin, p, 2, 0, "�2----------");
			TabAPI.setTabString(Settings.plugin, p, 2, 1, "�2----------");
			TabAPI.setTabString(Settings.plugin, p, 2, 2, "�2----------");
			int down = 3;
			int across = 0;
			for (String name : players) {
				if (across == 2) {
					across = 0;
					down++;
				}
				if (down != 19) {
					TabAPI.setTabString(Settings.plugin, p, down, across, ChatPlugin.getNick(Bukkit.getServer().getPlayer(name)));
					across++;
				}
			}
			TabAPI.updatePlayer(p);
		}
	}
}

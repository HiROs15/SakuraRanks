package hiros15.sakuraranks.Api;

import hiros15.sakuraranks.Config.RanksConfig;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Api {
	private Plugin plugin;
	public Api(Plugin plugin) {
		this.plugin = plugin;
	}
	
	public String getRank(Player player) {
		RanksConfig ranksconfig = new RanksConfig(plugin);
		String rank = ranksconfig.getConfig().getString("ranks."+player.getName()+".rank");
		return rank;
	}
	
	public void setRank(Player player, String rank) {
		RanksConfig ranksconfig = new RanksConfig(plugin);
		ranksconfig.getConfig().set("ranks."+player.getName()+".rank", rank);
		ranksconfig.saveConfig();
		ranksconfig.reloadConfig();
	}
}
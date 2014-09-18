package hiros15.sakuraranks.Api;

import hiros15.sakuraranks.Config.RanksConfig;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Api {
	private Plugin plugin;
	public Api(Plugin plugin) {
		this.plugin = plugin;
	}
	
	public enum Ranks {
		UNDIFINED, NORMAL, BETANORMAL, DONOR, MOD, ADMIN, SAKURAMEMBER
	}
	
	
	public Ranks getRank(Player player) {
		RanksConfig ranksconfig = new RanksConfig(plugin);
		String rank = ranksconfig.getConfig().getString("ranks."+player.getName()+".rank");
		Ranks returnrank = Ranks.UNDIFINED;
		switch(rank) {
			case "normal":
				returnrank = Ranks.NORMAL;
			case "betanormal":
				returnrank = Ranks.BETANORMAL;
			case "donor":
				returnrank = Ranks.DONOR;
			case "mod":
				returnrank = Ranks.MOD;
			case "admin":
				returnrank = Ranks.ADMIN;
			case "sakuramember":
				returnrank = Ranks.SAKURAMEMBER;
		}
		return returnrank;
	}
	
	public void setRank(Player player, String rank) {
		RanksConfig ranksconfig = new RanksConfig(plugin);
		ranksconfig.getConfig().set("rank."+player.getName()+".rank", rank);
		ranksconfig.saveConfig();
	}
}
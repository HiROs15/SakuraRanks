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
	
	RanksConfig ranksconfig = new RanksConfig(plugin);
	
	public Ranks getRank(Player player) {
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
	
	public void setRank(Player player, Ranks rank) {
		
	}
}
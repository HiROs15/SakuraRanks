package hiros15.sakuraranks.Config;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class RanksConfig {
	private Plugin plugin;
	public RanksConfig(Plugin plugin) {
		this.plugin = plugin;
	}
	
	private FileConfiguration config = null;
	private File file = null;
	
	public void reloadConfig() {
		if(file == null) {
			file = new File(plugin.getDataFolder(), "ranks.yml");
		}
		config = YamlConfiguration.loadConfiguration(file);
	}
	
	public FileConfiguration getConfig() {
		if(config == null) {
			reloadConfig();
		}
		return config;
	}
	
	public void saveConfig() {
		if(file == null) {
			reloadConfig();
		}
		try {
			config.save(file);
		} catch(Exception e) {}
	}
}

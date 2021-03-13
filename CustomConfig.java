import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import org.bukkit.plugin.Plugin;

@SuppressWarnings("all")
public class CustomConfig extends YamlConfiguration
{
    private FileConfiguration config = null;
    private final File configFile;
    private final String file;
    private final Plugin plugin;

    public CustomConfig(Plugin plugin)
    {
        this (plugin, "config.yml");
    }

    public CustomConfig(Plugin plugin, String fileName)
    {
        this.plugin = plugin;
        this.file = fileName;
        configFile = new File(plugin.getDataFolder(), file);
    }

    public void saveDefault()
    {
        if(!plugin.getDataFolder().exists()) plugin.getDataFolder().mkdir();
        if (!configFile.exists()) copyResource(plugin.getResource(file), configFile);
    }

    public FileConfiguration getConfiguration()
    {
        if (config == null) reload();
        return config;
    }

    public void save()
    {
        if (config == null) return;
        try { getConfiguration().save(configFile); }
        catch (IOException ex) { plugin.getLogger().log(Level.SEVERE, "Could not save config to " + configFile, ex); }
    }

    public void reload()
    {
        config = YamlConfiguration.loadConfiguration(configFile);
        final InputStream defConfigStream = plugin.getResource(file);
        if (defConfigStream == null) return;
        config.setDefaults(
                YamlConfiguration.loadConfiguration(new InputStreamReader(defConfigStream, StandardCharsets.UTF_8)));
    }

    public void copyResource(InputStream in, File file)
    {
        try
        {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while ((len=in.read(buf))>0) out.write(buf,0,len);
            out.close();
            in.close();
        }
        catch (Exception e) { e.printStackTrace(); }
    }
}

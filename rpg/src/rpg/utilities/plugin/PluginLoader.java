package rpg.utilities.plugin;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import rpg.utilities.memory.Memory;
import rpg.utilities.plugin.Plugin;

import rpg.objects.Items;
import rpg.game.Handler;

public class PluginLoader implements Runnable {

    private File modDir;
    private File[] mods;

    private Memory m;
    private Items items;

    public void run() {
        modDir = new File(
                ("C:\\Users\\" + (String) System.getProperty("user.name") + "\\AppData\\Roaming\\AlexRpg\\mods\\"));
        if(!modDir.exists()){
            modDir.mkdirs();
            return;
        }
        mods = modDir.listFiles();
        if(mods.length == 0){
            rpg.game.Handler.debug("mods is empty");
            return;
        }

        // TODO make this load from a json file as well

        for (File file : mods) {
            if ((file.isFile()) && (file.getName().split(".")[file.getName().split(".").length - 1] == "jar")) {
                try {
                    URL url = file.toURI().toURL();
                    String urlstr = url.toString();
                    urlstr = urlstr.replace("%20", " ");
                    rpg.game.Handler.debug(urlstr);
                    ClassLoader authorizedLoader = URLClassLoader.newInstance(new URL[] { new URL(urlstr) });
                    Plugin plugin = (Plugin) authorizedLoader.loadClass(file.getName().split(".")[0] + ".Main")
                            .newInstance();
                    loadPlugin(plugin);
                } catch (InstantiationException | IllegalAccessException | ClassNotFoundException
                        | MalformedURLException e) {

                    rpg.game.Handler.debug(e.toString(), true);
                    e.printStackTrace();
                }
            }
        }
        m.FinalizePlugins();
    }

    private void loadPlugin(Plugin plugin) throws Error {
        // TODO this will load the plugin contents and handle the id assigning and so on
        items = new Items();
        items = plugin.getItems();

        // TODO implement monster and story events setting down here

        // TODO add values to memeory

        m.LoadPlugins(items);
    }

    

    public PluginLoader(Handler h, Memory m) {

        this.m = m;

    }
}
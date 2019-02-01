package rpg.utilities.plugin;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import rpg.utilities.memory.Memory;
import rpg.utilities.plugin.Plugin;
import java.nio.file.Path;

import rpg.objects.items.Armor;
import rpg.objects.items.Weapon;
import rpg.objects.Monster;
import rpg.objects.StoryEvents;
import rpg.game.Handler;

public class PluginLoader implements Runnable {

    private File modDir;
    private File[] mods;
    private Handler h;
    private Memory m;

    public void run() {
        modDir = new File(
                ("C:\\Users\\" + (String) System.getProperty("user.name") + "\\AppData\\Roaming\\AlexRpg\\mods\\"));
        mods = modDir.listFiles();
        for (File file : mods) {
            if ((file.isFile()) && (file.getName().split(".")[file.getName().split(".").length - 1] == "jar")) {
                try {
                    ClassLoader authorizedLoader = URLClassLoader.newInstance(new URL[] { file.toURL() });
                    Plugin plugin = (Plugin) authorizedLoader.loadClass(file.getName().split(".")[0] + ".Main")
                            .newInstance();
                    loadPlugin(plugin);
                } catch (InstantiationException | IllegalAccessException | ClassNotFoundException
                        | MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void loadPlugin(Plugin plugin) throws Error {
        // TODO this will load the plugin contents and handle the id assigning and so on
        Armor.Item[] armor = plugin.getArmor().getItems();
        Weapon.Item[] weapons = plugin.getWeapon().getItems();

        // TODO implement monster and story events setting down here

        loadArmor(armor);
        loadWeapon(weapons);
    }

    private void loadWeapon(rpg.objects.items.Weapon.Item[] weapons) {

    }

    private void loadArmor(Armor.Item[] armor) {
        Armor.Item[] temp = m.getMem().getGenericArmor().getItems();
    }

    public PluginLoader(Handler h, Memory m) {
        this.h = h;
        this.m = m;

    }
}
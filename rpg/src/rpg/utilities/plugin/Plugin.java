package rpg.utilities.plugin;

import javax.swing.JComponent;

import rpg.objects.Monster;
import rpg.objects.StoryEvents;
import rpg.objects.items.Armor;
import rpg.objects.items.Weapon;

public interface Plugin {

    public void Load();

    public boolean[] getModded();

    public JComponent getComponenets();

    public Armor getArmor();

    public Weapon getWeapon();

    public Monster getMonster();

    public StoryEvents getEvent();
}
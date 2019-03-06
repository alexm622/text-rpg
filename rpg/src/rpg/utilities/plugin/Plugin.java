package rpg.utilities.plugin;

import javax.swing.JComponent;

import rpg.objects.GenericItem;
import rpg.objects.Monster;
import rpg.objects.StoryEvent;
import rpg.objects.StoryLine;
import rpg.objects.items.Armor;
import rpg.objects.items.Weapon;

public interface Plugin {

    public void Load();

    public boolean[] getModded();

    public JComponent getComponenets();

    public Armor getArmor();

    public Weapon getWeapon();

    public GenericItem[] getItems();

    public Monster getMonster();

    public StoryLine getStory();

    public StoryEvent[] getEvents();
}
package rpg.utilities.plugin;

import javax.swing.JComponent;

import rpg.objects.items.Items;
import rpg.objects.items.GenericItem;
import rpg.objects.items.Weapon;
import rpg.objects.npc.monster.Monster;
import rpg.objects.story.StoryEvent;
import rpg.objects.story.StoryLine;

public interface Plugin {

    public void Load();

    public boolean[] getModded();

    public JComponent getComponenets();

    public Items getArmor();

    public Weapon getWeapon();

    public GenericItem[] getItems();

    public Monster getMonster();

    public StoryLine getStory();

    public StoryEvent[] getEvents();
}
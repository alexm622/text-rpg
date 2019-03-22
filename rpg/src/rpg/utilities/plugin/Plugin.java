package rpg.utilities.plugin;

import javax.swing.JComponent;

import rpg.objects.Items;
import rpg.objects.npc.monster.Monster;
import rpg.objects.story.StoryEvent;
import rpg.objects.story.StoryLine;

public interface Plugin {

    public void Load();

    public boolean[] getModded();

    public JComponent getComponenets();

    public Items getItems();

    public Monster getMonster();

    public StoryLine getStory();

    public StoryEvent[] getEvents();
}
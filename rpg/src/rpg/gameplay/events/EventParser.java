package rpg.gameplay.events;

import rpg.game.Handler;
import rpg.objects.TileEvent;
import rpg.objects.npc.Npc;
import rpg.objects.npc.Npcs;
import rpg.objects.story.StoryEvent;
import rpg.objects.story.StoryEvents;

public class EventParser {

    private TileEvent te;
    private StoryEvents events;
    private StoryEvent event;
    private Npcs npcs;
    private Handler h;

    public EventParser(TileEvent te, Handler h){
        this.h = h;
        this.te = te;


        String temp = te.getId();
        boolean found = false;
        events = h.getMem().getStoryEvents();
        int i = 0;

        for(StoryEvent e : events.getEvents()){

            if(temp.equals(e.getEventId())){
                found = !found;
                break;
            }
            i++;
        }

        if(!found){
            Handler.debug("unable to find an event with id " + temp, true);
            
        }else{
            Handler.debug("found an event with id " + temp);
            event = events.getEvents()[i];
        }
    }

    //parse npcs

    public Npcs parseNpcs(){
        

        return null;
    }

    public StoryEvent getEvent(){
        return this.event;
    }

    //parse loot

    

}
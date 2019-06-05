package rpg.gameplay.encounters;

import java.util.Arrays;
import java.util.List;

import rpg.game.Handler;
import rpg.objects.TileEvent;
import rpg.objects.map.Tile;
import rpg.objects.story.StoryEvent;
import rpg.utilities.exceptions.NoSuchEvent;

public class EncCheck {
    private List<StoryEvent> se;
    private List<TileEvent> tileEvents;

    public EncCheck(Tile tile){
        try {
            this.se = getEvents(tile);
            this.tileEvents = Arrays.asList(tile.getEvents());
        } catch (NoSuchEvent e) {
            // TODO Auto-generated catch block
            Handler.debug(e.getMessage(), true);
        }
        
    }

    public static boolean isEnabled(TileEvent t){
        
        for(int i = 0; i < t.getReqVar().length; i++){
            Object temp = t.getReqVal()[i];
            String name = t.getReqVar()[i];
            Object currValue = Handler.memory.getValueByName(name);
            if(!currValue.equals(temp)){
               return false;
            }            
        }
        
        //test lvl

        if(!(Handler.memory.getCharacter().getLvl() >= t.getMinLvl() )||!(Handler.memory.getCharacter().getLvl() <= t.getMaxLvl())){
            return false;
        }

        if(t.getCleared()){
            return false;
        }



        return true;        
    }

    public StoryEvent getStoryEvent(TileEvent t){
        
        boolean present = tileEvents.contains(t);
        if(!present){
            Handler.debug("TileEvent " + t.getId() + " is not present on the current tile", true);
            return null;
        }
        int index = tileEvents.indexOf(t);
        return se.get(index);
    }

    public static List<StoryEvent> getEvents(Tile tile) throws NoSuchEvent{
        StoryEvent[] events = Handler.memory.getStoryEvents().getEvents();
        TileEvent[] tileEvents = tile.getEvents();

        
        if(tileEvents == null || tileEvents[0] == null){            
            throw new NoSuchEvent("there are no events on this tile");
        }
        StoryEvent[] indexedEvents = new StoryEvent[tileEvents.length];
        String temp1, temp2;

        for(int x = 0; x < tileEvents.length; x++){
            for(int i = 0; i < events.length; i++ ){
                temp1 = tileEvents[x].getId();
                temp2 = events[i].getEventId();
                if(temp1.equals(temp2)){
                    indexedEvents[x] = events[i];
                    break;
                }

            }
        }
        

        return Arrays.asList(indexedEvents);
    }
}
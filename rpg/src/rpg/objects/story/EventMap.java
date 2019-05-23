package rpg.objects.story;

import rpg.objects.TileEvent;


public class EventMap {

    

    //map events to location on map

    private TileEvent[] events;

    public void setEvents(TileEvent[] events){
        this.events = events;
    }

    public TileEvent[] getEvents(){
        return this.events;
    }


    


    

}
package rpg.gameplay.events;


import rpg.objects.TileEvent;

public class EventHandler {
    private EventParser ep;
    private TileEvent te;

    public EventHandler(TileEvent te){
        this.te = te;
        ep = new EventParser(te);

    
    }

}
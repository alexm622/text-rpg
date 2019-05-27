package rpg.gameplay.events;

import rpg.game.Handler;
import rpg.objects.TileEvent;

public class EventHandler {
    private EventParser ep;
    private TileEvent te;
    private Handler h;

    public EventHandler(TileEvent te, Handler h){
        this.h = h;
        this.te = te;
        ep = new EventParser(te, h);

        
    }

}
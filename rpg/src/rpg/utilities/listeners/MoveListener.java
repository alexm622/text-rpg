package rpg.utilities.listeners;

import java.util.List;

import rpg.game.Handler;
import rpg.gameplay.encounters.EncCheck;
import rpg.gameplay.events.GameEventHandler;
import rpg.objects.TileEvent;
import rpg.objects.map.Tile;
import rpg.utilities.events.GameEvent;

public class MoveListener {

    private GameEventListener gel;
    private Tile current;

    public MoveListener(){
        gel = new GameEventListener(){
        
            @Override
            public void onTrigger(GameEvent ge) {
                if(ge.equals(GameEvent.MOVE)){
                    Handler.debug("player moved");
                    triggered();
                }
            }
        };
        GameEventHandler.addListener(gel);
    }

    private void triggered(){
        //check for encounters
        //initiate encounters
        //end

        current = Handler.memory.getCurrent();

        //check for encounter

        EncCheck ec = new EncCheck(current);

        if(ec.getEnabled() == null){
            return;
        }

        List<TileEvent> enabled = ec.getEnabled();
        Handler.debug("there is an event on this tile");

        //trigger encounter

        



        
    }

}
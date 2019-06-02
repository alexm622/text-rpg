package rpg.utilities.listeners;

import rpg.game.Handler;
import rpg.gameplay.events.GameEventHandler;
import rpg.utilities.events.GameEvent;

public class MoveListener {

    private GameEventListener gel;

    public MoveListener(){
        gel = new GameEventListener(){
        
            @Override
            public void onTrigger(GameEvent ge) {
                Handler.debug("player moved");
            }
        };
        GameEventHandler.addListener(gel);
    }

}
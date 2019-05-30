package rpg.gameplay.events;

import java.util.ArrayList;
import java.util.List;

import rpg.utilities.listeners.GameEventListener;

public class GameEventHandler {
    private List<GameEventListener> listeners = new ArrayList<GameEventListener>();

    public void addListener(GameEventListener toAdd) {
        listeners.add(toAdd);
    }

    public void activate() {
        
    
        
        for (GameEventListener l : listeners)
            l.onTrigger();
    }
}
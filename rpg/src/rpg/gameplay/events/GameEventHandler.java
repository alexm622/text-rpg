package rpg.gameplay.events;

import java.util.ArrayList;
import java.util.List;

import rpg.utilities.listeners.GameEventListener;

public class GameEventHandler {
    private static List<GameEventListener> listeners = new ArrayList<GameEventListener>();

    public static void addListener(GameEventListener toAdd) {
        listeners.add(toAdd);
    }

    public static void activate() {
        
    
        
        for (GameEventListener l : listeners)
            l.onTrigger();
    }
}
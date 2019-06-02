package rpg.utilities.listeners;

import rpg.utilities.events.GameEvent;

public interface GameEventListener {
    void onTrigger(GameEvent ge);
}
package rpg.utilities.events;

public enum GameEvent{

    MOVE, // player moves
    COMBAT, // player engages in combat
    TALK, // player talks
    SHOP, // player opens shop
    BUY, // buys item
    SELL, // sells item
    ATTACK, // attacks
    LOOT, // loots something
    STEAL, // steals something
    DROP, // drops item
    EXAMINE, // examines item
    CAST, // casts spell
    DEFEND, // defends self
    KILL, // kills something
    DIE, // player dies
    FLEE, // runs from battle
    HEAL, // heals self
    INTERACT, // interacts with something
    OPEN, // opens something
    CLOSE, // closes something
    ERROR, // something happened
    EFFECT_ADDED, // effect added to player
    EFFECT_REMOVED; // effect removed from player




}
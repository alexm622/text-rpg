package rpg.utilities.json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import rpg.game.Handler;
import rpg.objects.map.Map;
import rpg.objects.player.Character;

public class Save {
    private ObjectMapper om;
    private Character c;
    private Map m;

    public Save() {
        this.om = Handler.jm.getOm();
        this.c = Handler.memory.getCharacter();
        this.m = Handler.memory.getMap();
        try {
            om.writeValue(new File(
                    System.getenv("APPDATA") + "\\AlexRpg\\save.sav"),
                    c);
            om.writeValue(new File(
                    System.getenv("APPDATA") + "\\AlexRpg\\map.sav"),
                    m);
        } catch (IOException e) {
            Handler.debug(e.toString(), true);
            e.printStackTrace();
        }
        
    }
}
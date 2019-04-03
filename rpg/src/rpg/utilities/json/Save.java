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

    public Save(Handler h) {
        this.om = h.getJm().getOm();
        this.c = h.getG().getMemory().getMem().getCharacter();
        this.m = h.getG().getMemory().getMem().getMap();
        try {
            om.writeValue(new File(
                    "C:\\Users\\" + (String) System.getProperty("user.name") + "\\AppData\\Roaming\\AlexRpg\\save.sav"),
                    c);
            om.writeValue(new File(
                    "C:\\Users\\" + (String) System.getProperty("user.name") + "\\AppData\\Roaming\\AlexRpg\\map.sav"),
                    m);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
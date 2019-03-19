package rpg.utilities.json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import rpg.game.Handler;
import rpg.objects.Character;

public class Save {
    private ObjectMapper om;
    private Character c;

    public Save(Handler h) {
        this.om = h.getJm().getOm();
        this.c = h.getG().getMemory().getMem().getCharacter();
        try {
            om.writeValue(new File(
                    "C:\\Users\\" + (String) System.getProperty("user.name") + "\\AppData\\Roaming\\AlexRpg\\save.sav"),
                    c);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
package rpg.utilities.json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import rpg.game.Handler;
import rpg.objects.map.Map;
import rpg.objects.player.Character;

public class Load {
    private ObjectMapper om;
    private Character c;
    private Map m;

    public Load(Handler h) {
        this.om = h.getJm().getOm();
        c = new Character();
        m = new Map();
        try {
            c = om.readValue(new File(
                    "C:\\Users\\" + (String) System.getProperty("user.name") + "\\AppData\\Roaming\\AlexRpg\\save.sav"),
                    Character.class);
            h.getG().getMemory().getMem().setCharacter(c);
            h.getG().getGm().getName_level().setText(c.getName() + " | " + Integer.toString(c.getLvl()));
            h.getG().getGm().getHp_gold().setText("hp: " + Integer.toString(c.getHp()) + " | gp: " + Integer.toString(c.getGp()));
            
            m = om.readValue(new File(
                    "C:\\Users\\" + (String) System.getProperty("user.name") + "\\AppData\\Roaming\\AlexRpg\\map.sav"),
                    Map.class);
            h.getG().getMemory().getMem().setMap(m);
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        
    }
}
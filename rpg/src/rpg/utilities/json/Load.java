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

    public Load() {
        this.om = Handler.jm.getOm();
        c = new Character();
        m = new Map();
        try {
            c = om.readValue(new File(
                    System.getenv("APPDATA") + "\\AlexRpg\\save.sav"),
                    Character.class);
            Handler.memory.setCharacter(c);
            Handler.g.getGm().getName_level().setText(c.getName() + " | " + Integer.toString(c.getLvl()));
            Handler.g.getGm().getHp_gold().setText("hp: " + Integer.toString(c.getHp()) + " | gp: " + Integer.toString(c.getGp()));
            
            m = om.readValue(new File(
                    System.getenv("APPDATA") + "\\AlexRpg\\map.sav"),
                    Map.class);
            Handler.memory.setMap(m);
            
        } catch (IOException e) {
            Handler.debug(e.toString(), true);
            e.printStackTrace();
        }
        
    }
}
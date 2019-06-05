package rpg.utilities.json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import rpg.game.Handler;
import rpg.objects.EnvVars;
import rpg.objects.map.Map;
import rpg.objects.player.Character;

public class Load {
    private ObjectMapper om;
    private Character c;
    private Map m;
    private EnvVars ev;

    public Load() {
        this.om = Handler.jm.getOm();
        c = new Character();
        m = new Map();
        ev = new EnvVars();
        try {
            //load character

            c = om.readValue(new File(
                    System.getenv("APPDATA") + "\\AlexRpg\\save.sav"),
                    Character.class);
            //set character variables

            Handler.memory.setCharacter(c);
            Handler.g.getGm().getName_level().setText(c.getName() + " | " + Integer.toString(c.getLvl()));
            Handler.g.getGm().getHp_gold().setText("hp: " + Integer.toString(c.getHp()) + " | gp: " + Integer.toString(c.getGp()));
            
            //read map
            m = om.readValue(new File(
                    System.getenv("APPDATA") + "\\AlexRpg\\map.sav"),
                    Map.class);
            //set map
            Handler.memory.setMap(m);

            //load envVars
            ev = om.readValue(new File(
                System.getenv("APPDATA") + "\\AlexRpg\\vars.sav"),
                EnvVars.class);

            Handler.memory.writeToMem(ev);
            
        } catch (IOException e) {
            Handler.debug(e.toString(), true);
            e.printStackTrace();
        }
        
    }
}
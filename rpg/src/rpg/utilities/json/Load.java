package rpg.utilities.json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import rpg.game.Handler;

import rpg.objects.Character;

public class Load {
    private ObjectMapper om;
    private Character c;

    public Load(Handler h) {
        this.om = h.getJm().getOm();
        try {
            c = om.readValue(new File(
                    "C:\\Users\\" + (String) System.getProperty("user.name") + "\\AppData\\Roaming\\AlexRpg\\save.sav"),
                    Character.class);
            h.getG().getMemory().getMem().setCharacter(c);
            h.getG().getGm().getName_level().setText(c.getName() + " | " + Integer.toString(c.getLvl()));
            h.getG().getGm().getHp_gold().setText("hp: " + Integer.toString(c.getHp()) + " | gp: " + Integer.toString(c.getGp()));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
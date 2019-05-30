package rpg.utilities;

import rpg.game.Handler;
import rpg.guis.NewSave;
import rpg.utilities.gens.MapGen;

public class Setup {

    public final static Object o = new Object();


    public Setup(boolean load) {
        
        if (load) {
            Load();
        } else if (!load) {
            Create();
        } else {
            Error e = new Error("load is null");
            Handler.debug(e.toString(), true);
            e.printStackTrace();
        }

    }

    private void Load() {
        new rpg.utilities.json.Load();
    }

    private void Create() {
        new NewSave();
    }  

    public static void CharDone(){
        new MapGen();
        
        
    }

}
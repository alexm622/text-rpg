package rpg.utilities;

import rpg.game.Handler;
import rpg.guis.NewSave;
import rpg.utilities.gens.MapGen;
import rpg.utilities.map.ToTiles;

public class Setup {

    private Handler h;
    public final static Object o = new Object();


    public Setup(Handler h, boolean load) {
        this.h = h;
        if (load) {
            Load(h);
        } else if (!load) {
            Create(h);
        } else {
            Error e = new Error("load is null");
            Handler.debug(e.toString(), true);
            e.printStackTrace();
        }

    }

    private void Load(Handler h) {
        new rpg.utilities.json.Load(h);
    }

    private void Create(Handler h) {
        new NewSave(h);
    }  

    public static void CharDone(Handler h){
        new MapGen(h);
        new ToTiles(h);
    }

}
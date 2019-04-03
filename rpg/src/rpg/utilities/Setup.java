package rpg.utilities;

import rpg.game.Handler;
import rpg.guis.NewSave;
import rpg.utilities.gens.MapGen;

public class Setup {

    private Handler h;

    public Setup(Handler h, boolean load) {
        this.h = h;
        if (load) {
            Load();
        } else if (!load) {
            Create();
        } else {
            Error e = new Error("load is null");
            e.printStackTrace();
        }
    }

    private void Load() {
        new rpg.utilities.json.Load(h);
    }

    private void Create() {
        new MapGen(h);
        new NewSave(h);
    }

}
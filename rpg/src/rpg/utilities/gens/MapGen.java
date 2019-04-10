package rpg.utilities.gens;

import java.io.IOException;

import rpg.game.Handler;
import rpg.objects.map.Map;


public class MapGen {

    private Handler h;

    public MapGen(Handler h) {
        this.h = h;
        OpenSimplexNoiseTest osnt = new OpenSimplexNoiseTest();
        try {
            double[][] out = osnt.main();
            ConvertToMap(out);
        } catch (IOException e) {
           
            rpg.game.Handler.debug(e.toString(), true);
            e.printStackTrace();
        }
    }

    private void ConvertToMap(double[][] map){
        Map m = new Map();
        m.setTiles(map);
        this.h.getG().getMemory().getMem().setMap(m);
        
    }
}
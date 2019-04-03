package rpg.utilities.gens;

import java.io.IOException;

import rpg.game.Handler;

public class MapGen {

    private Handler h;

    public MapGen(Handler h) {
        this.h = h;
        OpenSimplexNoiseTest osnt = new OpenSimplexNoiseTest();
        try {
            double[][] out = osnt.main();
            ConvertToMap(out);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void ConvertToMap(double[][] map){
        
    }
}
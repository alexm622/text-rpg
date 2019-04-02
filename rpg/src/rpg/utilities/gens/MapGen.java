package rpg.utilities.gens;

import java.io.IOException;

public class MapGen {
    public MapGen() {
        OpenSimplexNoiseTest osnt = new OpenSimplexNoiseTest();
        try {
            double[][] out = osnt.main();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
package rpg.utilities.gens;

import java.io.IOException;

import rpg.game.Handler;
import rpg.objects.map.Map;
import rpg.utilities.converter.Converter;
import rpg.utilities.map.ToTiles;


public class MapGen {

    public final int WIDTH = 2, HEIGHT = 2;
    public final double FEATURE_SIZE = 10;

    public MapGen() {

        
        OpenSimplexNoiseTest osnt = new OpenSimplexNoiseTest(WIDTH, HEIGHT, FEATURE_SIZE);
        try {
            double[][] out = osnt.main();
            ConvertToMap(out);
        } catch (IOException e) {
           
            Handler.debug(e.toString(), true);
            e.printStackTrace();
        }
    }

    private void ConvertToMap(double[][] map){
        Converter c = new Converter(WIDTH, HEIGHT, map);
        
        
        
    }
}
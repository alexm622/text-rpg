package rpg.utilities.gens;

import java.util.Random;

import rpg.game.Handler;
import rpg.objects.TileEvent;
import rpg.objects.map.Map;
import rpg.objects.story.EventMap;
import rpg.objects.story.StoryEvent;

public class GenEvents {
    
    private Map m;
    private EventMap em;

    private StoryEvent[] events;
    private TileEvent[] te;
    private int[][] count; // max, min, count
    

    public GenEvents(){


        events = Handler.memory.getStoryEvents().getEvents();

        int len = events.length;

        count = new int[len][3];
    
        int min = 0; // min and max num of event X

        for(int i = 0; i < len; i++){
            count[i][0] = events[i].getMax();
            
            count[i][1] = events[i].getMin();
            count[i][2] = 0;
        }

        Random r = new Random();



        for(int i = 0; i < len; i++){
            min = count[i][1];

            int temp = count[i][0] - count[i][1];

            count[i][2] = r.nextInt(temp) + min;


        }

        //generate

        int width, height;
        width = Handler.memory.getMap().getWidth();
        height = Handler.memory.getMap().getHeight();

        int[] pos = new int[]{0,0};
        int boundx =  width + (width-width%2)/2;
        int boundy =  height + (height-height%2)/2;

      

        for(int i = 0; i < len; i++){
            int temp1, temp2;
            temp1 = r.nextInt(width);
            temp2 = r.nextInt(height);

            if(Handler.memory.getTileMap()[temp1][temp2].getBiomeId().equals(events[i].getBiomeId())){
                // TODO set te [x] to this event
            }
            
            
        }
    }

}
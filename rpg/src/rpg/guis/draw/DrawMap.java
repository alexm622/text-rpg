package rpg.guis.draw;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.commons.lang3.time.StopWatch;

import rpg.game.Handler;
import rpg.guis.MapGUI;
import rpg.objects.map.MapAsTiles;
import rpg.objects.map.Tile;

public class DrawMap {

    //private vars

    private JFrame frame;
    private Handler h;
    private MapAsTiles m;
    private MapGUI mg;
    private JLabel[][] labels;
    private StopWatch sw;
    private int[] pos;


    public DrawMap(Handler h){
        
        
        this.h = h;
        mg = new MapGUI(h);
        this.frame = mg.getFrame();
        this.labels = mg.getLabels();
        this.m = new MapAsTiles();
        m.setMap(h.getG().getMemory().getMem().getTileMap());

        draw();
    }

    private void draw(){

        //get the height and width of the map
        int width, height;
        width = m.getMap()[0].length;
        height = m.getMap().length;

        //calculate center
        int[] center = new int[]{(width - width%2)/2 + width%2, (height - height%2)/2 + height%2};

        //find the array entry of the center tile in the map as tiles

        int[] relPos = {pos[0] + center[0], pos[1] + center[1]};
        relPos[0] -= 1;
        relPos[1] -= 1;

        Tile[][] draw;
        draw = new Tile[3][3];

        //get the seen array of tiles

        for(int i = 0; i < 4; i++){
            for(int j = 0; i < 4; i++){
                draw[i][j] = m.getMap()[relPos[0] - (i-2)][j + relPos[1]];
            }
        }





    }

}
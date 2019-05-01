package rpg.guis.draw;


import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.commons.lang3.time.StopWatch;

import rpg.game.Handler;
import rpg.guis.MapGUI;
import rpg.objects.map.MapAsTiles;

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
        int width, height;
        width = m.getMap()[0].length;
        height = m.getMap().length;

    }

}
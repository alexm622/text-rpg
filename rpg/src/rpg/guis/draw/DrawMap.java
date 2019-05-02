package rpg.guis.draw;

import java.awt.Color;

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


    public DrawMap(Handler h){
        
        
        this.h = h;
        mg = new MapGUI(h);
        sw = new StopWatch();
        
        this.frame = mg.getFrame();
        this.labels = mg.getLabels();
        this.m = new MapAsTiles();
        m.setMap(h.getG().getMemory().getMem().getTileMap());
        
        draw();
    }

    private void draw(){

        //get the height and width of the map
        int width, height;
        int[] pos;

        pos = h.getMem().getCharacter().getPos();

        width = m.getMap()[0].length;
        height = m.getMap().length;

        //calculate center
        int[] center = new int[]{(width - width%2)/2 + width%2, (height - height%2)/2 + height%2};

        //find the array entry of the center tile in the map as tiles

        int[] relPos = new int[]{pos[0] + center[0], pos[1] + center[1]};
        relPos[0] -= 1;
        relPos[1] -= 1;

        Tile[][] draw = new Tile[][]{
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        };

        //get the seen array of tiles

        JLabel lbl;

        int i, j;

        for(i = 0; i < 4; i++){
            for(j = 0; j < 4; j++){
                draw[i][j] = m.getMap()[relPos[0] - (i-2)][j + relPos[1]];
                
                Handler.debug("draw[" + i + "][" + j + "] is " + (draw[i][j] != null ? "not null" : "null"), draw[i][j] == null);

                labels[i][j].setBackground(new Color(Integer.decode(draw[i][j].getBgColor())));


                Handler.debug("the background color is: " + draw[i][j].getBgColor());

                Handler.debug(labels[i][j].getBackground().toString());

                labels[i][j].setOpaque(true);

                labels[i][j].setText(java.lang.Character.toString((char) draw[i][j].getIcon()));
                
            }
        }
        

        mg.drawMap(labels);





    }

}
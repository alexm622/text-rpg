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

    private static Handler h;
    private static MapAsTiles m;
    private static MapGUI mg;
    private static JLabel[][] labels;
    private static int[] pos, center, relPos;
    private static int width, height;
    private static Tile[][] draw;


    public DrawMap(Handler ha){
        
        
        h = ha;
        mg = new MapGUI(h);
        
       
        labels = mg.getLabels();
        m = new MapAsTiles();
        m.setMap(h.getG().getMemory().getMem().getTileMap());
        
        //record width and height
        
        width = m.getMap()[0].length;
        height = m.getMap().length;
        
        //calculate center
        
        center = new int[]{(width - width%2)/2 + width%2, (height - height%2)/2 + height%2};
        
        //draw var
        
        draw = new Tile[labels.length][labels[0].length];
        
        drawMap();
    }

    private static void drawMap(){

        

        pos = h.getMem().getCharacter().getPos();

        

        

        //find relative position

        relPos = new int[]{pos[0] + center[0], pos[1] + center[1]};
        relPos[0] -= 1;
        relPos[1] -= 1;

        

        //get the seen array of tiles


        int i, j;

        for(i = 0; i < labels.length; i++){
            for(j = 0; j < labels[0].length; j++){
                draw[i][j] = m.getMap()[relPos[0] - (i-labels.length/2)][j + relPos[1]];
                
                Handler.debug("draw[" + i + "][" + j + "] is " + (draw[i][j] != null ? "not null" : "null"), draw[i][j] == null);

                labels[i][j].setBackground(new Color(Integer.decode(draw[i][j].getBgColor())));


                Handler.debug("the background color is: " + draw[i][j].getBgColor());

                Handler.debug(labels[i][j].getBackground().toString());

                labels[i][j].setOpaque(true);

                labels[i][j].setText(java.lang.Character.toString((char) draw[i][j].getIcon()));

                labels[i][j].setForeground(new Color(Integer.decode(draw[i][j].getIconColor())));

                labels[i][j].setFont(labels[i][j].getFont().deriveFont(labels[i][j].getFont().getStyle(), labels[i][j].getFont().getSize() + 6));
                
            }
        }
        
        labels[(draw.length - draw.length%2)/2 + draw.length%2 - 1][(draw[0].length - draw[0].length%2)/2 + draw[0].length%2 - 1].setText("P");
        labels[(draw.length - draw.length%2)/2 + draw.length%2 - 1][(draw[0].length - draw[0].length%2)/2 + draw[0].length%2 - 1].setBackground(new Color(0,0,0));
        labels[(draw.length - draw.length%2)/2 + draw.length%2 - 1][(draw[0].length - draw[0].length%2)/2 + draw[0].length%2 - 1].setForeground(new Color(255,255,0));

        //mg.drawMap(labels);





    }
    
    public static void repaint() {
    	drawMap();
    }

}
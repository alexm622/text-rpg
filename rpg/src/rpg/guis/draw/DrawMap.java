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
        m = h.getMem().getMapTiles();
        Handler.debug(h.getMem().getMapTiles() == null);
        
        
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

        mg.getPoslbl().setText("( X:" + pos[0] + " ) ( Y:" + pos[1] + " )");

        

        

        //find relative position

        relPos = new int[]{pos[0] + center[0], center[1] - pos[1] };

        Handler.debug(Integer.toString(relPos[0]) + " , " + Integer.toString(relPos[1]) );

        

        

        //get the seen array of tiles


        int i, j;

        int drawPos[] = new int[]{0 - (labels[0].length - labels[0].length%2)/2 ,0 - (labels.length - labels.length%2)/2 };

        for(j = 0; j < labels.length; j++){ //y
            for(i = 0; i < labels[0].length; i++){ //x

                //this determines what tile to edit

                draw[i][j] = m.getMap()[relPos[0] + drawPos[1]][relPos[1] + drawPos[0]];
                
                Handler.debug("map size: " + m.getMap().length);

                Handler.debug("is map null:" + (m.getMap()[relPos[0] + drawPos[1]][relPos[1] + drawPos[0]] == null));

                Handler.debug("j is: " + j);
                Handler.debug("i is:" + i);

                Handler.debug("labels is null:" + (labels[i][j] == null));
                Handler.debug("draw is null:" + (draw[i][j] == null));
                Handler.debug("drawpos x:" + drawPos[0]);
                Handler.debug("drawpos y:" + drawPos[1]);
                Handler.debug("relpos x:" + relPos[0]);
                Handler.debug("relpos y:" + relPos[1]);
                Handler.debug("lbl y len:" + labels.length);
                Handler.debug("lbl x len:" +  labels[0].length);
                
                labels[i][j].setBackground(new Color(Integer.decode(draw[i][j].getBgColor())));


                

                

                labels[i][j].setOpaque(true);

                labels[i][j].setText(java.lang.Character.toString((char) draw[i][j].getIcon()));

                labels[i][j].setForeground(new Color(Integer.decode(draw[i][j].getIconColor())));

                

                labels[i][j].setFont(labels[i][j].getFont().deriveFont(labels[i][j].getFont().getStyle(), 18+6));
                drawPos[0] += 1;
            }
            drawPos[0] = 0 - (labels[0].length - labels[0].length%2)/2;
            drawPos[1] += 1;
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
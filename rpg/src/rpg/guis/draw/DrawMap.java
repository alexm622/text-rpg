package rpg.guis.draw;

import java.awt.*;

import javax.swing.*;


import rpg.game.Handler;
import rpg.guis.MapGUI;
import rpg.guis.MapLblGen;
import rpg.objects.map.MapAsTiles;
import rpg.objects.map.Tile;

public class DrawMap {

    //private vars

    // TODO this needs some redesigning


    public static MapAsTiles m;
    public static MapGUI mg;
    private static JLabel[][] labels;
    private static MapLblGen mlg;
    public static int[] pos, center;
    private static int width, height;
    private static Tile[][] draw;
    public static int[] relPos;
    public static boolean isBusy = false;


    public DrawMap(){
        
        

        mg = new MapGUI();
        mlg = new MapLblGen();
       
        labels = mlg.getLabels();
        m = Handler.memory.getMapTiles();
        Handler.debug(Handler.memory.getMapTiles() == null);
        
        
        //record width and height
        
        width = m.getMap()[0].length;
        height = m.getMap().length;
        
        //calculate center
        
        center = new int[]{(width - width%2)/2 + width%2, (height - height%2)/2 + height%2};
        
        //draw var
        
        draw = new Tile[labels.length][labels[0].length];
        
        drawMap();
        update();




    }

    private static void drawMap(){
        isBusy = true;




        

        pos = Handler.memory.getCharacter().getPos();

        

        

        

        //find relative position

        relPos = new int[]{pos[0] + center[0], center[1] - pos[1] };

        Handler.debug(relPos[0] + " , " + relPos[1] );

        Handler.memory.setCurrent(m.getMap()[relPos[0]][relPos[1]]);
        

        

        update();

        //get the seen array of tiles


        int i, j;

        int drawPos[] = new int[]{0 - (labels[0].length - labels[0].length%2)/2 ,0 - (labels.length - labels.length%2)/2 };

        for(j = 0; j < labels.length; j++){ //y
            for(i = 0; i < labels[0].length; i++){ //x

                //this determines what tile to edit

                draw[i][j] = m.getMap()[relPos[0] + drawPos[1]][relPos[1] + drawPos[0]];
                
               
                
                labels[i][j].setBackground(new Color(Integer.decode(draw[i][j].getBgColor())));


                

                

                labels[i][j].setOpaque(true);

                labels[i][j].setText(java.lang.Character.toString((char) draw[i][j].getIcon()));

                labels[i][j].setForeground(new Color(Integer.decode(draw[i][j].getIconColor())));






                Font f = labels[i][j].getFont();

                labels[i][j].setFont(f.deriveFont((float)(labels[i][j].getWidth() * .60)));
                drawPos[0] += 1;
            }
            drawPos[0] = 0 - (labels[0].length - labels[0].length%2)/2;
            drawPos[1] += 1;
        }
        
        labels[(draw.length - draw.length%2)/2 + draw.length%2 - 1][(draw[0].length - draw[0].length%2)/2 + draw[0].length%2 - 1].setText("P");
        labels[(draw.length - draw.length%2)/2 + draw.length%2 - 1][(draw[0].length - draw[0].length%2)/2 + draw[0].length%2 - 1].setBackground(new Color(0,0,0));
        labels[(draw.length - draw.length%2)/2 + draw.length%2 - 1][(draw[0].length - draw[0].length%2)/2 + draw[0].length%2 - 1].setForeground(new Color(255,255,0));

        //mg.drawMap(labels);




        isBusy = false;
    }
    
    public static void repaint() {
    	drawMap();
    }

    public static void refreshFonts(){
        for(int j = 0; j < labels.length; j++) { //y
            for (int i = 0; i < labels[0].length; i++) { //x
                Font f = labels[i][j].getFont();
                labels[i][j].setFont(f.deriveFont((float)(labels[i][j].getWidth() * .60)));
            }
        }
    }

    public static void update(){
        DrawMap.mg.getPosLabel().setText("( X:" + DrawMap.pos[0] + " ) ( Y:" + DrawMap.pos[1] + " ) ");
        Handler.debug((DrawMap.m.getCleared() == null));
        Handler.debug("Height " + labels.length);
        Handler.debug("width " + labels[0].length);
        DrawMap.mg.getPosLabel().setText(
            DrawMap.mg.getPosLabel().getText()
             + DrawMap.m.getCleared()
             [DrawMap.relPos[0]]
             [DrawMap.relPos[1]]);
    }

}
package rpg.guis;

import javax.swing.*;
import rpg.game.Handler;
import rpg.guis.draw.DrawMap;

import java.awt.*;

public class MapLblGen {

    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    private final int TOTAL_TILES = WIDTH * HEIGHT;
    private JLabel[][] tiles = new JLabel[HEIGHT][WIDTH]; // vertical by horizontal or rows by columns

    public MapLblGen(){
        generateLabels();
        DrawMap.mg.addLabels(tiles);

        Handler.debug("height " + tiles.length);
        Handler.debug("Width " + tiles[0].length);

    }

    private void generateLabels(){

        //determine size
        int tempW, tempH;
        JPanel tempPanel = DrawMap.mg.getPanel();

        tempW = tempPanel.getWidth();
        tempH = tempPanel.getHeight();

        tempW = tempW / MapLblGen.WIDTH;
        tempH = tempH / MapLblGen.HEIGHT;
        // x = column number
        // y = row number
        for(int x = 0; x < HEIGHT; x++){
            for(int y = 0; y < WIDTH; y++){
                JLabel temp = new JLabel();
                temp.setText(Integer.toString((x*15) + y + 1));
                temp.setFont(new Font("Arial", Font.BOLD, (int) Math.round(tempW * .75)));
                temp.setSize(tempW, tempH);
                tiles[x][y] = temp;
            }
        }
    }


    public JLabel[][] getLabels(){
        return this.tiles;
    }



}

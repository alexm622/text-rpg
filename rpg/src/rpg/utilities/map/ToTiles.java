package rpg.utilities.map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import rpg.game.Handler;
import rpg.guis.MemLoad;
import rpg.objects.map.Tile;

public class ToTiles extends Thread{

    private double[][] doub;
    private Tile[][] tiles;
    private Tile[] set;
    private MemLoad ml;

    public ToTiles(Handler h){
        //lock out the main gui

        h.getG().getGm().getFrmRpg().setEnabled(false);

        //open memload gui
        ml = new MemLoad();

        //init gui assets

        JFrame frame = ml.getFrame();
        frame.setTitle("loading map");
        JProgressBar pb;
        JLabel asset, percent;
        asset = ml.getLoadingAsset();
        percent = ml.getPercent();
        pb = ml.getLoadProgress();

        //vars for calculation

        doub = h.getG().getMemory().getMem().getMap().getTiles();
        set = h.getG().getMemory().getMem().getTileSet().getTiles();
        tiles = new Tile[doub.length][doub[0].length];
        int size = doub.length *  doub[0].length;
        int num = 0;
        String percentstr;


        //-7.5, -5.0 , -2.5, 0, 2.5, 5.0, 7.5
        for(int i = 0; i < doub.length; i++){
            for(int x = 0; x < doub[i].length; x++){

                num++;

                // TODO this isn't working

                if((x+1)%128 == 0){
                    percentstr = Integer.toString((100/size)*num) + "%";
                    asset.setText(num + " / " + size);
                    pb.setValue(num*(pb.getMaximum()/size));
                    percent.setText(percentstr);
                    
                    frame.revalidate();
                }

                String temp = Double.toString(doub[i][x]);

                

                
                

                switch (temp){

                    case "-7.5":
	                    tiles[i][x] = set[0];
                        

                    case "-5.0":
	                    tiles[i][x] = set[1];
                        

                    case "-2.5":
	                    tiles[i][x] = set[2];
                        

                    case "0":
	                    tiles[i][x] = set[3];
                        

                    case "2.5":
	                    tiles[i][x] = set[4];
                        

                    case "5.0":
	                    tiles[i][x] = set[5];
                        

                    case "7.5":
	                    tiles[i][x] = set[6];
                        

                }
            }
        }
        h.getG().getMemory().getMem().setTileMap(tiles);
    }
}
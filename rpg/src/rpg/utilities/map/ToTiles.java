package rpg.utilities.map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import rpg.game.Handler;
import rpg.guis.MemLoad;
import rpg.objects.map.MapAsTiles;
import rpg.objects.map.Tile;

import org.apache.commons.lang3.time.StopWatch;

public class ToTiles extends Thread{

    private double[][] doub;
    private Tile[][] tiles;
    private MemLoad ml;
    private MapAsTiles m;

    public ToTiles(Handler h, double[][] d){
        //lock out the main gui

        h.getG().getGm().getFrmRpg().setEnabled(false);

        //open memload gui
        this.ml = new MemLoad();

        //init gui assets

        JFrame frame = ml.getFrame();
        frame.setTitle("Generating map");
        ml.getLoadingText().setText("Generating map");
        JProgressBar pb;
        JLabel asset, percent;
        asset = ml.getLoadingAsset();
        percent = ml.getPercent();
        pb = ml.getLoadProgress();
        StopWatch sw = new StopWatch();

        //vars for calculation

        doub = d;
        tiles = new Tile[doub.length][doub[0].length];
        double size = doub.length *  doub[0].length;
        double num = 0;
        String percentstr;
        pb.setMaximum(((Double)size).intValue());
       
        double per = 0.0;

        new ChooseTiles(h);

        sw.start();
        


        //-7.5, -5.0 , -2.5, 0, 2.5, 5.0, 7.5
        for(int i = 0; i < doub.length; i++){
            for(int x = 0; x < doub[i].length; x++){

                num++;

               

                
                    
               
                if(sw.getTime() > 60 || num == size){
                    sw.reset();
                    sw.start();
                    
                    per = (num/size);
                    per = Math.round(per * 100.0);
                    percentstr = Double.toString(per) + "%";

                    

                    String assettxt = Double.toString(num) + " / " + Double.toString(size);
                    asset.setText(assettxt);

                    
                    

                    int pbval = ((Double)(num)).intValue();
                    pb.setValue(pbval);

                    

                 
                    percent.setText(percentstr);
                    
                    frame.paintAll(frame.getGraphics());;
                }
            
                
                

                String temp = Double.toString(doub[i][x]);

                
                

                
                

                switch (temp){
                    case "-10.0":
                        tiles[i][x] = ChooseTiles.select(-10.0);
                        break;

                    case "-7.5":
	                    tiles[i][x] = ChooseTiles.select(-7.5);
                        break;

                    case "-5.0":
	                    tiles[i][x] = ChooseTiles.select(-5.0);
                        break;

                    case "-2.5":
	                    tiles[i][x] = ChooseTiles.select(-2.5);
                        break;

                    case "0.0":
	                    tiles[i][x] = ChooseTiles.select(0.0);
                        break;

                    case "2.5":
                        tiles[i][x] = ChooseTiles.select(2.5);
                        break;                        

                    case "5.0":
                        tiles[i][x] = ChooseTiles.select(5.0);
                        break;
                        

                    case "7.5":
                        tiles[i][x] = ChooseTiles.select(7.5);
                        break;

                    case "10.0":
                        tiles[i][x] = ChooseTiles.select(10.0);
                        break;
                    

                    default:
                        Error e = new Error("error on tile " + i + " " + x);
                        Handler.debug("tile [" + i +"][" + x + "] is equal to " + temp, true);
                        
                        Handler.debug(e.toString(), true);
                        e.printStackTrace();
                        break;
                        

                }
            }
        }
        h.getG().getGm().getFrmRpg().setEnabled(true);
        frame.dispose();
        System.gc();
        Handler.debug("properly converted array of double into map");
        h.getMem().setTileMap(tiles);
        m = new MapAsTiles();
        m.setMap(tiles);
        h.getMem().setMapTiles(m);
    }

    
}
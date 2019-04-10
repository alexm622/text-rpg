package rpg.utilities.map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import rpg.game.Handler;
import rpg.guis.MemLoad;
import rpg.objects.map.Tile;

import org.apache.commons.lang3.time.StopWatch;

public class ToTiles extends Thread{

    private double[][] doub;
    private Tile[][] tiles;
    private Tile[] set;
    private MemLoad ml;

    public ToTiles(Handler h){
        //lock out the main gui

        h.getG().getGm().getFrmRpg().setEnabled(false);

        //open memload gui
        this.ml = new MemLoad();

        //init gui assets

        JFrame frame = ml.getFrame();
        frame.setTitle("loading map");
        JProgressBar pb;
        JLabel asset, percent;
        asset = ml.getLoadingAsset();
        percent = ml.getPercent();
        pb = ml.getLoadProgress();
        StopWatch sw = new StopWatch();

        //vars for calculation

        doub = h.getG().getMemory().getMem().getMap().getTiles();
        set = h.getG().getMemory().getMem().getTileSet().getTiles();
        tiles = new Tile[doub.length][doub[0].length];
        double size = doub.length *  doub[0].length;
        double num = 0;
        String percentstr;
        pb.setMaximum(((Double)size).intValue());
        String test = Integer.toString(pb.getMaximum());
        double per = 0.0;

        sw.start();
        


        //-7.5, -5.0 , -2.5, 0, 2.5, 5.0, 7.5
        for(int i = 0; i < doub.length; i++){
            for(int x = 0; x < doub[i].length; x++){

                num++;

                // TODO this refreshes waay to fast

                
                    
               
                if(sw.getTime() > 40 || num == size){
                    sw.reset();
                    sw.start();
                    double temptest = num%512;
                    per = (num/size);
                    per = Math.round(per * 100.0);
                    percentstr = Double.toString(per) + "%";

                    

                    String assettxt = Double.toString(num) + " / " + Double.toString(size);
                    asset.setText(assettxt);

                    
                    

                    int pbval = ((Double)(num)).intValue();
                    pb.setValue(pbval);

                    

                    test = Integer.toString(pb.getValue());
                    percent.setText(percentstr);
                    
                    frame.paintAll(frame.getGraphics());;
                }
            
                
                

                String temp = Double.toString(doub[i][x]);

                int testvar = 0;
                

                
                

                switch (temp){
                    case "-10.0":
                        tiles[i][x] = set[0];
                        break;

                    case "-7.5":
	                    tiles[i][x] = set[1];
                        break;

                    case "-5.0":
	                    tiles[i][x] = set[2];
                        break;

                    case "-2.5":
	                    tiles[i][x] = set[3];
                        break;

                    case "0.0":
	                    tiles[i][x] = set[4];
                        break;

                    case "2.5":
                        tiles[i][x] = set[5];
                        break;                        

                    case "5.0":
                        tiles[i][x] = set[6];
                        break;
                        

                    case "7.5":
                        tiles[i][x] = set[7];
                        break;

                    case "10.0":
                        tiles[i][x] = set[8];
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
        test = Integer.toString(pb.getValue());
        h.getG().getMemory().getMem().setTileMap(tiles);
    }

    
}
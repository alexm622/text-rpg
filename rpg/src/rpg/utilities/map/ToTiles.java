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
        this.ml = new MemLoad();

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
        double size = doub.length *  doub[0].length;
        double num = 0;
        String percentstr;
        pb.setMaximum(((Double)size).intValue());
        String test = Integer.toString(pb.getMaximum());
        double per = 0.0;
        


        //-7.5, -5.0 , -2.5, 0, 2.5, 5.0, 7.5
        for(int i = 0; i < doub.length; i++){
            for(int x = 0; x < doub[i].length; x++){

                num++;

                // TODO this refreshes waay to fast

                if((i+1)%4 == 0 && num%512 == 0){
                    double temptest = num%512;
                    per = (num/size);
                    per = Math.round(per * 100.0);
                    percentstr = Double.toString(per) + "%";

                    

                    String assettxt = Double.toString(num) + " / " + Double.toString(size);
                    asset.setText(assettxt);

                    frame.paint(frame.getGraphics());
                    

                    int pbval = ((Double)(num)).intValue();
                    pb.setValue(pbval);

                    frame.paint(frame.getGraphics());

                    test = Integer.toString(pb.getValue());
                    percent.setText(percentstr);
                    
                    frame.paint(frame.getGraphics());
                    
                    
                }

                String temp = Double.toString(doub[i][x]);

                int testvar = 0;
                

                
                

                switch (temp){

                    case "-7.5":
	                    tiles[i][x] = set[0];
                        break;

                    case "-5.0":
	                    tiles[i][x] = set[1];
                        break;

                    case "-2.5":
	                    tiles[i][x] = set[2];
                        break;

                    case "0.0":
	                    tiles[i][x] = set[3];
                        break;

                    case "2.5":
                        tiles[i][x] = set[4];
                        break;                        

                    case "5.0":
                        tiles[i][x] = set[5];
                        break;
                        

                    case "7.5":
                        tiles[i][x] = set[6];
                        break;

                    default:
                        Error e = new Error("error on tile " + i + " " + x);
                        e.printStackTrace();
                        break;
                        

                }
            }
        }
        test = Integer.toString(pb.getValue());
        h.getG().getMemory().getMem().setTileMap(tiles);
    }
}
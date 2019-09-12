package rpg.utilities.converter;

import org.apache.commons.lang3.time.StopWatch;
import rpg.game.Handler;
import rpg.guis.MemLoad;
import rpg.objects.map.Tile;
import rpg.utilities.map.ChooseTiles;

import javax.swing.*;

public class Converter {

    private static String[][] tileBytes;
    private static volatile int i;
    private static double[][] doub;
    private static volatile int[] lastTile = new int[2];
    private static int height, width;
    private static int numThreads;
    private MemLoad ml;
    private static volatile boolean finished = false;
    private static volatile StopWatch sw;
    private static volatile int num;
    private static volatile double size, per;
    private static volatile JFrame frame;
    private static volatile JProgressBar pb;
    private static volatile JLabel percent, asset;


    public Converter(int w, int h, double[][] map){
        tileBytes = new String[width][height];
        doub = map;
        height = h;
        width = w;

        Handler.g.getGm().getFrmRpg().setEnabled(false);

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


        //vars for calculation

        new ChooseTiles();



        size = doub.length *  doub[0].length;
        num = 0;

        pb.setMaximum(((Double)size).intValue());

        per = 0.0;

        Start(4);






    }

    public static void Start(int threads){
        numThreads = threads;
        Thread[] t = new Thread[numThreads];
        lastTile[0] = 0;
        lastTile[1] = 0;


        for(i = 0; i < threads; i++) {
            t[i] = new Thread(new Runnable() {

                @Override
                public void run() {

                    int[] currentTile = new int[]{i, 0};
                    while (!finished) {

                        double toConv = doub[currentTile[0]][currentTile[1]];

                        String data = convert(toConv);

                        writeBytes(currentTile, data);
                        tileFinished();
                        currentTile = getNextTile();
                    }
                }
            });
        }

        for(i = 0; i < threads; i++){
            t[i].start();
            Handler.debug("starting thread number " + i);
        }

        for(i = 0; i < threads; i++){
            try {
                t[i].join();
                Handler.debug("joining thread number " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }




    }



    private static synchronized int[] getNextTile(){
        int[] tile = lastTile;
        if(tile[0] + 1 >= width){
            if(tile[1] + 1 >= height){
                finished = true;
            }else{
                tile[0] = 0;
                tile[1]++;
                lastTile = tile;
            }
        }
        return tile;
    }

    private static synchronized String convert(double data){
        int temp = 0;

        String datastr = Double.toString(data);
        switch (datastr){
            case "-10.0":
                temp = ChooseTiles.select(-10.0);
                break;

            case "-7.5":
                temp = ChooseTiles.select(-7.5);
                break;

            case "-5.0":
                temp = ChooseTiles.select(-5.0);
                break;

            case "-2.5":
                temp = ChooseTiles.select(-2.5);
                break;

            case "0.0":
                temp = ChooseTiles.select(0.0);
                break;

            case "2.5":
                temp = ChooseTiles.select(2.5);
                break;

            case "5.0":
                temp = ChooseTiles.select(5.0);
                break;


            case "7.5":
                temp = ChooseTiles.select(7.5);
                break;

            case "10.0":
                temp = ChooseTiles.select(10.0);
                break;


            default:

                Handler.debug("tile is equal to " + temp, true);


                break;

        }

        String hex = Integer.toHexString(temp);

        Handler.debug("hex val " + hex);
        return hex;

    }

    private static synchronized void tileFinished(){

    }

    private static synchronized void writeBytes(int[] tile, String bytes){

    }

    private static synchronized  void updateGUI(int num){
        if(sw.getTime() > 60 || num == size){
            sw.reset();
            sw.start();

            String percentstr = "";

            per = (num/size);
            per = Math.round(per * 100.0);
            percentstr = Double.toString(per) + "%";



            String assettxt = Double.toString(num) + " / " + Double.toString(size);
            asset.setText(assettxt);





            pb.setValue(num);




            percent.setText(percentstr);

            frame.paintAll(frame.getGraphics());;
        }
    }

}

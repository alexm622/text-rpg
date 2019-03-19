package rpg.game;

import javax.swing.JFrame;

import rpg.guis.GraphicMain;
import rpg.player.Player;
import rpg.utilities.memory.Memory;
import rpg.utilities.plugin.PluginLoader;

public class Game{
    // handler
    private Handler h;

    // graphics window
    private GraphicMain gm;

    // memory class
    private Memory mem;

    // gui items
    // frame, outpute pane, radio buttons, and question
    //
    private JFrame frame;
    private Thread t, pl;
    private PluginLoader pluginLoader;
    private Player p;

    public Game() {
        System.out.println("ran");
        gm = new GraphicMain();
        h = new Handler(this);
        mem = new Memory(this.h);
        p = new Player(this.h);

        this.frame = this.gm.getFrmRpg();
        System.out.println("done");
        run();
    }

    public void run() {
        // set the focus to the main screen
        System.out.println("ran main thread method");
        frame.requestFocus();
        Refresh();
        // TODO this throws an error because storyitems is null or memory is null
        if(mem.getMem().getStoryItems() != null){
            System.out.println("not null");
        }else{
            System.out.println("null");
        }
        System.out.println(h.getJm().TypeToPath("storyitems"));
        long tempNano = System.nanoTime();
        long lastTickTime = tempNano;
        while (true) {
            for (int i = 0; i < 60; i++) {

                Refresh();
                tempNano = System.nanoTime();
                if((i+1)%4 == 0){
                    
                    double f = 1000000000 / ((tempNano - lastTickTime)); // miliseconds between last 60 tick pt.
                    gm.getHp_gold().setText(Double.toString(f));
                    gm.getFrmRpg().revalidate();
                }
                
                lastTickTime = tempNano;
                try {
                    Thread.sleep(1000/60);
                } catch (InterruptedException e) {
                    
                    e.printStackTrace();
                }
                
            }
        }
        
        
    }

    private void Refresh(){
        h.Update();
        gm.Update(this.h);
        mem.Update(this.h);
        p.Update(this.h);
    }

    /**
     * @return the h
     */
    public Handler getH() {
        return h;
    }

    /**
     * @param h the h to set
     */
    public void setH(Handler h) {
        this.h = h;
    }

    /**
     * @return the gm
     */
    public GraphicMain getGm() {
        return gm;
    }

    /**
     * @param gm the gm to set
     */
    public void setGm(GraphicMain gm) {
        this.gm = gm;
    }

    public Memory getMemory(){
        return this.mem;
    }

    public void setMemory(Memory mem){
        this.mem = mem;
    }

    
    public Player getP(){
        return this.p;
    }

    public void setP(Player p){
        this.p = p;
    }

}

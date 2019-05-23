package rpg.game;

import java.io.File;

import javax.swing.JFrame;

import rpg.guis.GraphicMain;
import rpg.player.Player;
import rpg.utilities.Setup;
import rpg.utilities.memory.Memory;
//import rpg.utilities.plugin.PluginLoader;

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
    //private PluginLoader pluginLoader;
    private Player p;

    public Game() {
        Handler.debug("started properly");
        gm = new GraphicMain();
        h = new Handler(this);
        mem = new Memory(this.h);
        p = new Player(this.h);

        this.frame = this.gm.getFrmRpg();
        Handler.debug("properly initiated all vars");
        GraphicMain.h = h;
        run();
    }

    private boolean firstLaunch(){
        File file = new File(System.getenv("APPDATA") + "//AlexRpg//");
        if(file.list() == null){

            Handler.debug("first launch");

            return true;
        }
        for(String name : file.list()){
            Handler.debug(name);
            if(name.equals(new String("save.sav"))){
                Handler.debug("this is not the first launch");
                return false;
            }
        }

        Handler.debug("first launch plus something happened that should not have happened", true);

        return true;
    }

    public void run() {
        // set the focus to the main screen
        Handler.debug("running main thread method");
        frame.requestFocus();
        
        Refresh();
        if(mem.getMem().getStoryItems() != null){
            Handler.debug("storyitems are not null");
        }else{
            Handler.debug("storyitems are null", true);
        }
        Handler.debug(h.getJm().TypeToPath("storyline"));
        long tempNano = System.nanoTime();

        if(!firstLaunch()){
            new Setup(this.h, true);
        }
        while (true) {
            for (int i = 0; i < 60; i++) {

                Refresh();
                tempNano = System.nanoTime();
                
                

                try {
                    Thread.sleep(1000/60);
                } catch (InterruptedException e) {
                    Handler.debug(e.toString(), true);
                    rpg.game.Handler.debug(e.toString(), true);
                    e.printStackTrace();
                }
                
            }
        }
        
        
    }

    private void Refresh(){
        h.Update();
        p.update(this.h);
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

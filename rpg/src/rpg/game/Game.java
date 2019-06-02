package rpg.game;

import java.io.File;

import javax.swing.JFrame;

import rpg.gameplay.events.GameEventHandler;
import rpg.guis.GraphicMain;
import rpg.player.Player;
import rpg.utilities.Setup;
import rpg.utilities.listeners.MoveListener;
import rpg.utilities.memory.Memory;
//import rpg.utilities.plugin.PluginLoader;

public class Game{
    // handler

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
        new GameEventHandler();
        initListeners();
        Handler.debug("started properly");
        gm = new GraphicMain();
        new Handler(this);
        mem = new Memory();
        p = new Player();

        this.frame = this.gm.getFrmRpg();
        Handler.debug("properly initiated all vars");
        
        run();
    }

    private void initListeners(){
        new MoveListener();
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
        
        
        if(mem.getMem().getStoryItems() != null){
            Handler.debug("storyitems are not null");
        }else{
            Handler.debug("storyitems are null", true);
        }
        Handler.debug(Handler.jm.TypeToPath("storyline"));
        

        if(!firstLaunch()){
            new Setup(true);
        }
        while (true) {
            for (int i = 0; i < 60; i++) {

               
                
                
                

                try {
                    Thread.sleep(1000/60);
                } catch (InterruptedException e) {
                    Handler.debug(e.toString(), true);
                    Handler.debug(e.toString(), true);
                    e.printStackTrace();
                }
                
            }
        }
        
        
    }

    

    /**
     * @return the h
     */
    

    /**
     * @param h the h to set
     */
    

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

package rpg.game;

import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;

import rpg.guis.GraphicMain;
import rpg.utilities.memory.Memory;

public class Game implements Runnable{
    //handler
    private Handler h;

    //graphics window
    private GraphicMain gm;

    //memory class
    private Memory mem;
    
    //gui items
    // frame, outpute pane, radio buttons, and question
    //
    private JFrame frame;
    private JTextArea output;
    private ButtonGroup group;
    private JTextArea question;
    private String sull;


    public Game() {
        System.out.println("ran");
        gm = new GraphicMain();
        h = new Handler(this);
        mem = new Memory(this.h);
        this.frame = this.gm.getFrmRpg();
        System.out.println("done");
        Thread t = new Thread(this);
        this.h.setT(t);
        this.h.getT().start();
    }

    public void run() {
        //set the focus to the main screen
        frame.requestFocus();
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

}

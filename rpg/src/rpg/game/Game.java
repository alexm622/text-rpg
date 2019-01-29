package rpg.game;

import rpg.guis.GraphicMain;
import rpg.utilities.memory.Memory;

public class Game {
    private Handler h;
    private GraphicMain gm;
    private Memory mem;

    public Game() {
        System.out.println("ran");
        GraphicMain.main(null);
        gm = new GraphicMain();
        h = new Handler(this);
        mem = new Memory(this.h);
    }

    public void Begin() {
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

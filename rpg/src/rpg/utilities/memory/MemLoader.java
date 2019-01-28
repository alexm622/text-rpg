package rpg.utilities.memory;

import java.util.List;

import rpg.game.Handler;
import rpg.guis.GraphicMain;
import rpg.guis.MemLoad;
import rpg.utilities.json.JsonMain;


public class MemLoader {

    private Handler h;
    private MemLoad mlgui;
    private GraphicMain gm;
    private int size;
    private String[] types;

    public MemLoader(Handler h){
        //manage handler
        this.h = h;
        this.gm = h.getG().getGm();

        //start the gui
        this.mlgui = new MemLoad();
        MemLoad.main(null);

        //lock the main gui
        this.gm.getFrmRpg().setEnabled(false);


    }


    public List<Class<?>> Load(List<Class<?>> in, String[] types){
        // TODO this should load from memory
        //return a list of types. each entry is a class. 
        //do something with in to make out

        this.types = types;
        this.size = in.size();
        
        int temp = 0;
        JsonMain jm = h.getJm();
        for(int i = 0; i < this.size; i++){
            in.set(temp, jm.Read(types[temp]));
        }
        

        this.mlgui.Close();
        this.gm.getFrmRpg().setEnabled(true);
        return in;
    }
    //this needs to dump data to memory;
    public Class<?> LoadData(Class<?> c){
        
        return null;
    }

}
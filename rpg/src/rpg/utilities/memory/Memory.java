package rpg.utilities.memory;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import rpg.game.Handler;
import rpg.utilities.json.JsonMain;

public class Memory {
    // TODO make this manage memory

    //private MemLoader ml;
    private AbsMem.Armor lightarmor, mediumarmor, heavyarmor;
    private AbsMem.Weapon weapon;
    private Handler h;
    private AbsMem mem;
    private ObjectMapper om;
    private JsonMain jm;

    public Memory(Handler h) {
        // assign handler
        this.h = h;

        // initiate AbsMem
        this.mem = new AbsMem();

        // init jsonmain

        this.jm = this.h.getJm();

        // get objectmapper

        this.om = this.jm.getOm();

        // load
        try {
            Load();
        } catch (Error e) {
            e.printStackTrace();
        }

    }

    private void Load() throws Error{
        
        String path;
        String loading = "not started";
        File file;
        
        try{
            //load armor

                //light armor
                loading = "lightarmor";
                path = jm.TypeToPath(loading);
                file = jm.getFile(path);
                this.lightarmor = om.readValue(file, AbsMem.Armor.class);
                this.mem.setLightArmor(this.lightarmor);

                //medium armor
                loading = "mediumarmor";
                path = jm.TypeToPath(loading);
                file = jm.getFile(path);
                this.mediumarmor = om.readValue(file, AbsMem.Armor.class);
                this.mem.setMediumArmor(this.mediumarmor);

                //heavy armor
                loading = "heavyarmor";
                path = jm.TypeToPath(loading);
                file = jm.getFile(path);
                this.heavyarmor = om.readValue(file, AbsMem.Armor.class);
                this.mem.setHeavyArmor(this.heavyarmor);

            //load weapons
                //generic weapons
                loading = "weapons";
                path = jm.TypeToPath(loading);
                file = jm.getFile(path);
                this.weapon = om.readValue(file, AbsMem.Weapon.class);
                this.mem.setWeapons(this.weapon);
                

        }catch(Exception e){
            System.out.println(this.mem.getLightArmor().getItems()[0].getItemname());
            e.printStackTrace();
            Error r = new Error("failed to load: " + loading);
            throw r;

        }
            



    }
    
}
package rpg.utilities.memory;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import com.fasterxml.jackson.databind.ObjectMapper;

import rpg.game.Handler;
import rpg.guis.MemLoad;
import rpg.utilities.json.JsonMain;
import rpg.objects.Character;
import rpg.objects.items.*;

public class Memory {
    // TODO make this manage memory

    // private MemLoader ml;
    //game assets
    private Character character;
    private Armor lightarmor, mediumarmor, heavyarmor;
    private Weapon weapon;

    //program assets
    private Handler h;
    private AbsMem mem;
    private ObjectMapper om;
    private JsonMain jm;
    private MemLoad ml;

    public Memory(Handler h) {
        // assign handler
        this.h = h;

        // initiate AbsMem
        this.mem = new AbsMem();

        // init jsonmain

        this.jm = this.h.getJm();

        // get objectmapper

        this.om = this.jm.getOm();

        //lock out the main gui

        this.h.getG().getGm().getFrmRpg().setEnabled(false);

        //open memload gui
        ml = new MemLoad();
        MemLoad.main(null);

        // load
        try {
            Load();
            this.h.getG().getGm().getFrmRpg().setEnabled(true);
        } catch (Error e) {
            e.printStackTrace();
        }

    }

    private void Load() throws Error {

        String path;
        String loading = "not started";
        File file;
        int size = 5;
        int num = 0;
        String percentstr;

        //init gui assets

        JFrame frame = ml.getFrame();
        JProgressBar pb;
        JLabel asset, percent;
        asset = ml.getLoadingAsset();
        percent = ml.getPercent();
        pb = ml.getLoadProgress();

        try {
            
            // load armor
                // light armor
                loading = "lightarmor";
                path = jm.TypeToPath(loading);
                file = jm.getFile(path);
                this.lightarmor = om.readValue(file, Armor.class);
                this.mem.setLightArmor(this.lightarmor);

                num++;
                percentstr = Integer.toString((100/size)*num) + "%";
                asset.setText(path);
                pb.setValue(1*(pb.getMaximum()/size));
                percent.setText(percentstr);
                frame.revalidate();

                // medium armor
                loading = "mediumarmor";
                path = jm.TypeToPath(loading);
                file = jm.getFile(path);
                this.mediumarmor = om.readValue(file, Armor.class);
                this.mem.setMediumArmor(this.mediumarmor);

                num++;
                percentstr = Integer.toString((100/size)*num) + "%";
                asset.setText(path);
                pb.setValue(1*(pb.getMaximum()/size));
                percent.setText(percentstr);
                frame.revalidate();

                // heavy armor
                loading = "heavyarmor";
                path = jm.TypeToPath(loading);
                file = jm.getFile(path);
                this.heavyarmor = om.readValue(file, Armor.class);
                this.mem.setHeavyArmor(this.heavyarmor);

                num++;
                percentstr = Integer.toString((100/size)*num) + "%";
                asset.setText(path);
                pb.setValue(1*(pb.getMaximum()/size));
                percent.setText(percentstr);
                frame.revalidate();

            // load weapons

                // generic weapons
                loading = "weapons";
                path = jm.TypeToPath(loading);
                file = jm.getFile(path);
                this.weapon = om.readValue(file, Weapon.class);
                this.mem.setWeapons(this.weapon);
                frame.revalidate();

                num++;
                percentstr = Integer.toString((100/size)*num) + "%";
                asset.setText(path);
                pb.setValue(1*(pb.getMaximum()/size));
                percent.setText(percentstr);
                frame.revalidate();

            // load events

            // events

        } catch (Exception e) {
            System.out.println(this.mem.getLightArmor().getItems()[0].getItemname());
            e.printStackTrace();
            Error r = new Error("failed to load: " + loading);
            throw r;

        }
    }

    public void loadCharacter(String path) {
        try {
            File file = jm.getFile(path);
            this.character = om.readValue(file, Character.class);
            this.mem.setCharacter(this.character);
        } catch (IOException | URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public AbsMem getMem(){
        return this.mem;
    }

    public void setMem(AbsMem mem){
        this.mem = mem;
    }
    
}
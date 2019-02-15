package rpg.utilities.memory;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

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
    private Armor collectiveArmor;
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
        //MemLoad.main(null);

        // load
        try {
            Load();
            ml.Close();
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

                num++;
                percentstr = Integer.toString((100/size)*num) + "%";
                asset.setText(path);
                pb.setValue(num*(pb.getMaximum()/size));
                percent.setText(percentstr);
                frame.revalidate();

                this.lightarmor = om.readValue(file, Armor.class);
                this.mem.setLightArmor(this.lightarmor);

                // medium armor
                loading = "mediumarmor";
                path = jm.TypeToPath(loading);
                file = jm.getFile(path);

                num++;
                percentstr = Integer.toString((100/size)*num) + "%";
                asset.setText(path);
                pb.setValue(num*(pb.getMaximum()/size));
                percent.setText(percentstr);
                frame.revalidate();

                this.mediumarmor = om.readValue(file, Armor.class);
                this.mem.setMediumArmor(this.mediumarmor);

                // heavy armor
                loading = "heavyarmor";
                path = jm.TypeToPath(loading);
                file = jm.getFile(path);

                num++;
                percentstr = Integer.toString((100/size)*num) + "%";
                asset.setText(path);
                pb.setValue(num*(pb.getMaximum()/size));
                percent.setText(percentstr);
                frame.revalidate();

                this.heavyarmor = om.readValue(file, Armor.class);
                this.mem.setHeavyArmor(this.heavyarmor);

            // load weapons

                // generic weapons
                loading = "weapons";
                path = jm.TypeToPath(loading);
                file = jm.getFile(path);

                num++;
                percentstr = Integer.toString((100/size)*num) + "%";
                asset.setText(path);
                pb.setValue(num*(pb.getMaximum()/size));
                percent.setText(percentstr);
                frame.revalidate();

                this.weapon = om.readValue(file, Weapon.class);
                this.mem.setWeapons(this.weapon);

                System.out.println("doing");

                
            // load events

            // events

            //Done

            num++;
            percentstr = Integer.toString(100) + "%";
            asset.setText("Done");
            pb.setValue(pb.getMaximum());
            percent.setText(percentstr);
            frame.revalidate();

            //make data collective

            //armor
            lumparmor();

        } catch (Exception e) {
            if(loading == "weapons") {

            }else{
                e.printStackTrace();
                Error r = new Error("failed to load: " + loading);
                throw r;
            }
            

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

    public void lumparmor(){
        List<rpg.objects.items.Armor.Item[]> temp = null;
        
        temp.add(lightarmor.getItems());
        System.out.println("lightarmor");
        temp.add(mediumarmor.getItems());
        System.out.println("mediumarmor");
        temp.add(heavyarmor.getItems());
        System.out.println("heavyarmor");
        collectiveArmor.setItem((rpg.objects.items.Armor.Item[]) temp.toArray());
        System.out.println("done");
    }

    public AbsMem getMem(){
        return this.mem;
    }

    public void setMem(AbsMem mem){
        this.mem = mem;
    }
    
}
package rpg.utilities.memory;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.lang3.ArrayUtils;

import rpg.game.Handler;
import rpg.guis.MemLoad;
import rpg.utilities.json.JsonMain;
import rpg.objects.Character;
import rpg.objects.StoryItems;
import rpg.objects.items.*;




public class Memory {
    // TODO make this manage memory

    // private MemLoader ml;
    //game assets
    private Character character;
    private Armor lightarmor, mediumarmor, heavyarmor;
    private Armor collectiveArmor;
    private String[] armorIds = null;
    private Weapon weapon;
    private StoryItems storyItems;

    //lumping
    private rpg.objects.items.Armor.Item[] items = null;

    //program assets
    private Handler h;
    private AbsMem mem;
    private ObjectMapper om;
    private JsonMain jm;
    private MemLoad ml;
    private LoadIds idloader;

    //plugins

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

        //idloader

        this.idloader = new LoadIds();

        //open memload gui
        ml = new MemLoad();
        //MemLoad.main(null);

        // load
        try {
            Load();
            ml.Close();
            this.h.getG().getGm().getFrmRpg().setEnabled(true);
        } catch (Error e) {
            System.out.println("error");
            e.printStackTrace();
        }

    }

    private void Load() throws Error {

        String path;
        String loading = "not started";
        File file;
        int size = 6;
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

            //load story items
                loading = "storyitems";
                path = jm.TypeToPath(loading);
                file = jm.getFile(path);
                System.out.println(path);

                num++;
                percentstr = Integer.toString((100/size)*num) + "%";
                asset.setText(path);
                pb.setValue(num*(pb.getMaximum()/size));
                percent.setText(percentstr);
                frame.revalidate();

                this.storyItems = om.readValue(file, StoryItems.class);
                this.mem.setStoryItems(this.storyItems);

                System.out.println("doing");

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
            e.printStackTrace();
        }
    }

    private void lumparmor(){
        this.collectiveArmor = new Armor();

        System.out.println("lumping");

        System.out.println("started lumping");

        this.items = this.lightarmor.getItems();

        System.out.println("lightarmor");

        this.items = (rpg.objects.items.Armor.Item[])ArrayUtils.addAll(this.items, this.mediumarmor.getItems());

        System.out.println("medium armor");

        this.items = (rpg.objects.items.Armor.Item[])ArrayUtils.addAll(this.items, this.heavyarmor.getItems());

        System.out.println("heavy armor");

        this.collectiveArmor.setItem(this.items);

        System.out.println(collectiveArmor.getItems().length);

        this.armorIds = new String[collectiveArmor.getItems().length];

        this.armorIds = idloader.Armor(this.collectiveArmor);

        System.out.println("armorIds is: " + armorIds.length);

        System.out.println(armorIds[1]);
        
        System.out.println("done lumping");

    }

    public AbsMem getMem(){
        return this.mem;
    }

    public void setMem(AbsMem mem){
        this.mem = mem;
    }

	public void FinalizePlugins() {
        this.mem.setArmorIds(armorIds);
        this.mem.setArmor(collectiveArmor);
	}

	public void LoadPlugins(Armor armor, Weapon weapons) {
        //new items list
        this.items = (rpg.objects.items.Armor.Item[])ArrayUtils.addAll(this.items, armor.getItems());

        //new collective armor
        this.collectiveArmor.setItem(this.items);

        //new Id list
        this.armorIds = new String[collectiveArmor.getItems().length];
        this.armorIds = idloader.Armor(this.collectiveArmor);

	}
    
    public void Update(Handler h) {
		this.h = h;
	}
}
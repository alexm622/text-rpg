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
import rpg.objects.Item;
import rpg.objects.Items;
import rpg.objects.items.*;
import rpg.objects.npc.monster.Monsters;
import rpg.objects.player.Character;
import rpg.objects.story.StoryEvents;
import rpg.objects.story.StoryItems;
import rpg.objects.story.StoryLine;




public class Memory {
    // TODO make this manage memory

    // private MemLoader ml;
    //game assets
    private Character character;
    private Items lightarmor, mediumarmor, heavyarmor;
    private Items collectiveArmor;
    private String[] armorIds = null;
    private Weapon weapon;
    private StoryItems storyItems;
    private Monsters monsters;
    private StoryEvents storyEvents;
    private StoryLine storyline;


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
        mem = new AbsMem();

        // init jsonmain

        jm = h.getJm();

        // get objectmapper

        om = jm.getOm();

        //lock out the main gui

        h.getG().getGm().getFrmRpg().setEnabled(false);

        //idloader

        idloader = new LoadIds();

        //open memload gui
        ml = new MemLoad();
        //MemLoad.main(null);

        // load
        try {
            Load();
            ml.Close();
            h.getG().getGm().getFrmRpg().setEnabled(true);
        } catch (Error e) {
            System.out.println("error");
            e.printStackTrace();
        }

    }

    private void Load() throws Error {

        String path;
        String loading = "not started";
        File file;
        int size = 9;
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

                lightarmor = om.readValue(file, Items.class);
                mem.setLightArmor(lightarmor);

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

                mediumarmor = om.readValue(file, Items.class);
                mem.setMediumArmor(mediumarmor);

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

                heavyarmor = om.readValue(file, Items.class);
                mem.setHeavyArmor(heavyarmor);

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

                weapon = om.readValue(file, Weapon.class);
                mem.setWeapons(weapon);

                System.out.println("doing");

                
            // load events

            // events
                loading = "storyevents";
                path = jm.TypeToPath(loading);
                file = jm.getFile(path);
                System.out.println(path);

                num++;
                percentstr = Integer.toString((100/size)*num) + "%";
                asset.setText(path);
                pb.setValue(num*(pb.getMaximum()/size));
                percent.setText(percentstr);
                frame.revalidate();

                storyEvents = om.readValue(file, StoryEvents.class);
                //TODO for some reason this is null
                mem.setStoryEvents(storyEvents);

                System.out.println("doing");
            

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

                storyItems = om.readValue(file, StoryItems.class);
                //TODO for some reason this is null
                mem.setStoryItems(storyItems);

                System.out.println("doing");

            //monsters

                loading = "monsters";
                path = jm.TypeToPath(loading);
                file = jm.getFile(path);
                System.out.println(path);

                num++;
                percentstr = Integer.toString((100/size)*num) + "%";
                asset.setText(path);
                pb.setValue(num*(pb.getMaximum()/size));
                percent.setText(percentstr);
                frame.revalidate();

                monsters = om.readValue(file, Monsters.class);
                mem.setMonsters(monsters);

            //storyline

                loading = "storyline";
                path = jm.TypeToPath(loading);
                file = jm.getFile(path);
                System.out.println(path);

                num++;
                percentstr = Integer.toString((100/size)*num) + "%";
                asset.setText(path);
                pb.setValue(num*(pb.getMaximum()/size));
                percent.setText(percentstr);
                frame.revalidate();

                storyline = om.readValue(file, StoryLine.class);
                mem.setStoryline(storyline);

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
                e.printStackTrace();
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
            character = om.readValue(file, Character.class);
            mem.setCharacter(character);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private void lumparmor(){
        this.collectiveArmor = new Items();
        Item[] items;

        System.out.println("lumping");

        System.out.println("started lumping");

        items = lightarmor.getItems();

        System.out.println("lightarmor");

        collectiveArmor.setItems(ArrayUtils.addAll(collectiveArmor.getItems(), items));

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

	public void LoadPlugins(Items items, Weapon weapons) {
        //new items list
        this.items = (rpg.objects.items.Items.Item[])ArrayUtils.addAll(this.items, items.getItems());

        //new collective armor
        this.collectiveArmor.setItem(this.items);

        //new Id list
        this.armorIds = new String[collectiveArmor.getItems().length];
        this.armorIds = idloader.Items(this.collectiveArmor);

	}
    
    public void Update(Handler h) {
		this.h = h;
	}
}
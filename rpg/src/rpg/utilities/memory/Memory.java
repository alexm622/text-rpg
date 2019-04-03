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
import rpg.objects.map.TileSet;
import rpg.objects.npc.Npcs;
import rpg.objects.player.Character;
import rpg.objects.story.StoryEvents;
import rpg.objects.story.StoryLine;




public class Memory {
    // TODO make this manage memory

    // private MemLoader ml;
    //game assets
    private Character character;
    private Items lightarmor, mediumarmor, heavyarmor;
    private Items items;
    private Items weapon;
    private Items storyItems;
    private Npcs monsters;
    private StoryEvents storyEvents;
    private StoryLine storyline;
    private TileSet tileset;


    //program assets
    private AbsMem mem;
    private ObjectMapper om;
    private JsonMain jm;
    private MemLoad ml;
    private LoadIds idloader;

    //plugins

    public Memory(Handler h) {
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
        int size = 10;
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

                weapon = om.readValue(file, Items.class);

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

                storyItems = om.readValue(file, Items.class);
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

                monsters = om.readValue(file, Npcs.class);
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

            //tileset
                loading = "tileset";
                path = jm.TypeToPath(loading);
                file = jm.getFile(path);
                System.out.println(path);

                num++;
                percentstr = Integer.toString((100/size)*num) + "%";
                asset.setText(path);
                pb.setValue(num*(pb.getMaximum()/size));
                percent.setText(percentstr);
                frame.revalidate();

                tileset = om.readValue(file, TileSet.class);
                mem.setTileSet(tileset);
            //Done

            num++;
            percentstr = Integer.toString(100) + "%";
            asset.setText("Done");
            pb.setValue(pb.getMaximum());
            percent.setText(percentstr);
            frame.revalidate();

            //make data collective

            //armor
            LumpItems();

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

    

    private void LumpItems(){

        // TODO make it so all items are lumped together 

        this.items = new Items();
        Item[] temp;

        System.out.println("lumping");

        System.out.println("started lumping");

        temp = lightarmor.getItems();

        System.out.println("lightarmor");

        items.setItems(ArrayUtils.addAll(items.getItems(), temp));

        temp = mediumarmor.getItems();

        items.setItems(ArrayUtils.addAll(items.getItems(), temp));

        temp = heavyarmor.getItems();

        items.setItems(ArrayUtils.addAll(items.getItems(), temp));

        temp = weapon.getItems();

        items.setItems(ArrayUtils.addAll(items.getItems(), temp));

        temp = storyItems.getItems();

        items.setItems(ArrayUtils.addAll(items.getItems(), temp));

        mem.setItems(items);

    }

    public AbsMem getMem(){
        return this.mem;
    }

    public void setMem(AbsMem mem){
        this.mem = mem;
    }

	public void FinalizePlugins() {
        // TODO finalize
	}

	public void LoadPlugins(Items temp) {
        //new items list



        items.setItems(ArrayUtils.addAll(items.getItems(), temp.getItems()));
	}
    
}
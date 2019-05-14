package rpg.utilities.memory;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.time.StopWatch;

import rpg.game.Handler;
import rpg.guis.MemLoad;
import rpg.utilities.json.JsonMain;
import rpg.objects.Item;
import rpg.objects.Items;
import rpg.objects.map.Tile;
import rpg.objects.map.TileSet;
import rpg.objects.npc.Npcs;
import rpg.objects.story.StoryEvents;
import rpg.objects.story.StoryLine;

public class Memory {

    // game assets

    private Items lightarmor, mediumarmor, heavyarmor;
    private Items items;
    private Items weapon;
    private Items storyItems;
    private Npcs monsters;
    private StoryEvents storyEvents;
    private StoryLine storyline;
    private Tile[] tiles;

    // program assets
    private AbsMem mem;
    private ObjectMapper om;
    private JsonMain jm;
    private MemLoad ml;
    private JFrame frame;
    private StopWatch sw;

    // plugins

    public Memory(Handler h) {
        // initiate AbsMem
        mem = new AbsMem();

        // init jsonmain

        jm = h.getJm();

        // get objectmapper

        om = jm.getOm();

        // lock out the main gui

        h.getG().getGm().getFrmRpg().setEnabled(false);

        // open memload gui
        ml = new MemLoad();
        // MemLoad.main(null);

        // load
        try {
            load();
            ml.Close();
            h.getG().getGm().getFrmRpg().setEnabled(true);
        } catch (Error e) {
            Handler.debug("error", true);
            Handler.debug(e.toString(), true);
            e.printStackTrace();
        }

    }

    private void load() throws Error {

        String path;
        String loading = "not started";
        File file;
        int size = 10;
        int num = 0;
        String percentstr;

        // init gui assets

        frame = ml.getFrame();

        JProgressBar pb;
        JLabel asset, percent;
        asset = ml.getLoadingAsset();
        percent = ml.getPercent();
        pb = ml.getLoadProgress();
        sw = new StopWatch();
        sw.start();

        try {

            // load armor
            // light armor
            loading = "lightarmor";
            path = jm.TypeToPath(loading);
            file = jm.getFile(path);

            num++;
            percentstr = Integer.toString((100 / size) * num) + "%";
            asset.setText(path);
            pb.setValue(num * (pb.getMaximum() / size));
            percent.setText(percentstr);
            repaint();

            lightarmor = om.readValue(file, Items.class);

            // medium armor
            loading = "mediumarmor";
            path = jm.TypeToPath(loading);
            file = jm.getFile(path);

            num++;
            percentstr = Integer.toString((100 / size) * num) + "%";
            asset.setText(path);
            pb.setValue(num * (pb.getMaximum() / size));
            percent.setText(percentstr);
            repaint();

            mediumarmor = om.readValue(file, Items.class);

            // heavy armor
            loading = "heavyarmor";
            path = jm.TypeToPath(loading);
            file = jm.getFile(path);

            num++;
            percentstr = Integer.toString((100 / size) * num) + "%";
            asset.setText(path);
            pb.setValue(num * (pb.getMaximum() / size));
            percent.setText(percentstr);
            repaint();

            heavyarmor = om.readValue(file, Items.class);

            // load weapons

            // generic weapons
            loading = "weapons";
            path = jm.TypeToPath(loading);
            file = jm.getFile(path);

            num++;
            percentstr = Integer.toString((100 / size) * num) + "%";
            asset.setText(path);
            pb.setValue(num * (pb.getMaximum() / size));
            percent.setText(percentstr);
            repaint();

            weapon = om.readValue(file, Items.class);

            Handler.debug("doing");

            // load events

            // events
            loading = "storyevents";
            path = jm.TypeToPath(loading);
            file = jm.getFile(path);
            Handler.debug(path);

            num++;
            percentstr = Integer.toString((100 / size) * num) + "%";
            asset.setText(path);
            pb.setValue(num * (pb.getMaximum() / size));
            percent.setText(percentstr);
            repaint();

            storyEvents = om.readValue(file, StoryEvents.class);

            mem.setStoryEvents(storyEvents);

            Handler.debug("doing");

            // load story items
            loading = "storyitems";
            path = jm.TypeToPath(loading);
            file = jm.getFile(path);
            Handler.debug(path);

            num++;
            percentstr = Integer.toString((100 / size) * num) + "%";
            asset.setText(path);
            pb.setValue(num * (pb.getMaximum() / size));
            percent.setText(percentstr);
            repaint();

            storyItems = om.readValue(file, Items.class);

            mem.setStoryItems(storyItems);

            Handler.debug("doing");

            // monsters

            loading = "monsters";
            path = jm.TypeToPath(loading);
            file = jm.getFile(path);
            Handler.debug(path);

            num++;
            percentstr = Integer.toString((100 / size) * num) + "%";
            asset.setText(path);
            pb.setValue(num * (pb.getMaximum() / size));
            percent.setText(percentstr);
            repaint();

            monsters = om.readValue(file, Npcs.class);
            mem.setMonsters(monsters);

            // storyline

            loading = "storyline";
            path = jm.TypeToPath(loading);
            file = jm.getFile(path);
            Handler.debug(path);

            num++;
            percentstr = Integer.toString((100 / size) * num) + "%";
            asset.setText(path);
            pb.setValue(num * (pb.getMaximum() / size));
            percent.setText(percentstr);
            repaint();

            storyline = om.readValue(file, StoryLine.class);
            mem.setStoryline(storyline);

            // tileset

            loading = "tileset";
            path = jm.TypeToPath(loading);
            file = jm.getFile(path);
            Handler.debug(path);

            loadTiles(file);

            // Done

            num++;
            percentstr = Integer.toString(100) + "%";
            asset.setText("Done");
            pb.setValue(pb.getMaximum());
            percent.setText(percentstr);
            repaint();

            // make data collective

            // armor
            lumpItems();

        } catch (Exception e) {
            if (loading == "weapons") {
                Handler.debug(e.toString(), true);
                e.printStackTrace();
            } else {
                Handler.debug(e.toString(), true);
                e.printStackTrace();
                Error r = new Error("failed to load: " + loading);
                throw r;
            }

        }
    }

    private void lumpItems() {

        // TODO round out the loading methods

        this.items = new Items();
        Item[] temp;

        Handler.debug("lumping");

        Handler.debug("started lumping");

        temp = lightarmor.getItems();

        Handler.debug("lightarmor");

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

    private void repaint() {
        if (sw.getTime() > 50) {
            frame.repaint();
            sw.reset();
            sw.start();

        }
    }

    private void loadTiles(File f) {

        File[] files = f.listFiles();

        TileSet ts;
        

        for (File t : files) {
            if (!t.getName().endsWith(".json")) {
                return;
            } else {
                try {
                    Handler.debug("loading: " + t.getName());


                    ts = om.readValue(t, TileSet.class);

                    tiles = (ArrayUtils.addAll(tiles, ts.getTiles()));

                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    Handler.debug(e.getMessage(), true);
                }
            }
        }
        mem.setTiles(tiles);

        
    }

    public AbsMem getMem(){
        return this.mem;
    }

    public void setMem(AbsMem mem){
        this.mem = mem;
    }

	public void FinalizePlugins() {
        
	}

	public void LoadPlugins(Items temp) {
        //new items list



        items.setItems(ArrayUtils.addAll(items.getItems(), temp.getItems()));
	}
    
}
package rpg.utilities.memory;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import rpg.game.Handler;
import rpg.objects.EnvVars;
import rpg.objects.Items;
import rpg.objects.EnvVars.EnvVar;
import rpg.objects.map.Map;
import rpg.objects.map.MapAsTiles;
import rpg.objects.map.Tile;
import rpg.objects.npc.Npcs;
import rpg.objects.player.Character;
import rpg.objects.story.LootTable;
import rpg.objects.story.StoryEvents;
import rpg.objects.story.StoryLine;
import rpg.utilities.exceptions.VarAlreadyExists;

public class AbsMem{
    //private vars

        //items
        private Items items;
        private Items storyItems;
        private Npcs monsters;
        private StoryLine storyline;
        private StoryEvents storyevents;
        private Map map;
        private Tile[][] tileMap;
        private Tile[] tiles;
        private Tile current;
        private LootTable loottable;
        private MapAsTiles mt;
        private List<EnvVar> envVars;

        //convert envvars class to list

        public List<EnvVar> getEnvVars(){
            return this.envVars;
        }

        public void setEnvVars(List<EnvVar> envVars){
            this.envVars = envVars;
        }

        public void writeToMem(EnvVars evs){

            //env vars as array
            EnvVar[] eva = evs.getEnvVars();

            envVars = Arrays.asList(eva);
        }

        //read env vars from memory into the env vars format
        public EnvVars readFromMem(){
            int size = 0;
            try{
                size = envVars.size();
                EnvVar[] eva = new EnvVar[size];
                eva = envVars.toArray(eva);
                EnvVars evs = new EnvVars();
                evs.setEnvVars(eva);
                return evs;
            }catch(NullPointerException e){
                EnvVars temp =  new EnvVars();
                EnvVar[] eva = new EnvVar[0];
                temp.setEnvVars(eva);
                return temp;
            }
            
        }

        public Object getValueByName(String name){
            Optional<EnvVar> temp = envVars.stream().filter(o -> o.getName().equals(name)).findFirst();
            boolean present = temp.isPresent();
            
            //int index = envVars.
            if(!present){
                Handler.debug("envvar " + name + "does not exist", true);
                return null;
            }
            EnvVar out = temp.get();
            return out.getValue();
        }

        public Object getValueByIndex(int index){
            int size = 0;
            try{
                size = envVars.size();
            }catch(NullPointerException e){
            
            }
            if(index >= size || size == 0){
                Handler.debug("index of  " + index + "does not exist", true);
                return null;
            }
            return envVars.get(index).getValue();
        }

        public void setValueByName(String name, Object value){
            setValueByName(name, value, true);
        }

        public void setValueByName(String name, Object value, boolean makenew){
            Optional<EnvVar> temp = envVars.stream().filter(o -> o.getName().equals(name)).findFirst();
            boolean present = temp.isPresent();
            if(!present){
                Handler.debug("envvar " + name + "does not exist", !makenew);
                if(makenew){
                    Handler.debug("creating envvar " + name);
                    EnvVar ev = new EnvVar();
                    ev.setName(name);
                    ev.setValue(value);
                    envVars.add(ev);
                }
                return;
            }
            EnvVar var = temp.get();
            int index = envVars.indexOf(var);
            var.setValue(value);

            envVars.set(index, var);

            Handler.debug("set envvar " + name + "to " + value);

        }

        //add a variable to the list
        public void addVar(EnvVar var) throws VarAlreadyExists{
            Optional<EnvVar> temp = envVars.stream().filter(o -> o.getName().equals(var.getName())).findFirst();
            boolean present = temp.isPresent();

            if(present){
                throw new VarAlreadyExists("the envvar " + var.getName() + " already exists");
            }else{
                envVars.add(var);
            }

        }


        //events

        private StoryLine events;

        //character

        private Character character;

    //getters and setters

        //items

        //events
            
            //getters

            public StoryLine getEvents(){
                return this.events;
            }

            //setters

            public void setEvents(StoryLine events){
                this.events = events;
            }
        
        //character
            
            //getters

            public Character getCharacter(){
                return this.character;
            }

            //setters

            public Items getItems(){
                return this.items;
            }

            public void setCharacter(Character character){
                this.character = character;
            }

			public void setStoryItems(Items storyItems2) {
                this.storyItems = storyItems2;
            }
            
            public Items getStoryItems(){
                return this.storyItems;
            }

			public void setMonsters(Npcs monsters) {
                this.monsters = monsters;
            }
            
            public Npcs getMonsters(){
                return this.monsters;
            }

			public void setStoryline(StoryLine storyline) {
                this.storyline = storyline;
            }
            
            public StoryLine getStoryline(){
                return this.storyline;
            }

			public void setStoryEvents(StoryEvents storyEvents) {
                this.storyevents = storyEvents;
            }
            
            public StoryEvents getStoryEvents(){
                return this.storyevents;
            }

			public void setItems(Items items2) {
            }
            
            public Map getMap(){
                return this.map;
            }

            public void setMap(Map map){
                this.map = map;
            }


            
            public Tile[][] getTileMap(){
                return this.tileMap;
            }

            public void setTileMap(Tile[][] tileMap){
                this.tileMap = tileMap;
            }

            public void setTiles(Tile[] tiles){
                this.tiles = tiles;
            }

            public Tile[] getTiles(){
                return this.tiles;
            }

            public void setLootTable(LootTable lt){
                this.loottable = lt;
            }

            public LootTable getLootTable(){
                return this.loottable;
            }

            public MapAsTiles getMapTiles(){
                return this.mt;
            }

            public void setMapTiles(MapAsTiles mt){
                this.mt = mt;
            }

            public void setCurrent(Tile current){
                this.current = current;
            }

            public Tile getCurrent(){
                return this.current;
            }

    //class definitions
}
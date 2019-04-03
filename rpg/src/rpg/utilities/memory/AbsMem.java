package rpg.utilities.memory;

import rpg.objects.Items;
import rpg.objects.map.Map;
import rpg.objects.map.TileSet;
import rpg.objects.npc.Npcs;
import rpg.objects.player.Character;
import rpg.objects.story.StoryEvents;
import rpg.objects.story.StoryLine;

public class AbsMem{
    //private vars

        //items
        private Items items;
        private Items storyItems;
        private Npcs monsters;
        private StoryLine storyline;
        private StoryEvents storyevents;
        private Map map;
        private TileSet tileset;

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

            public void setTileSet(TileSet tileset){
                this.tileset = tileset;
            }

            public TileSet getTileSet(){
                return this.tileset;
            }

    //class definitions
}
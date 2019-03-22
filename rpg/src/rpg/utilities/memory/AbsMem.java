package rpg.utilities.memory;

import rpg.objects.Items;
import rpg.objects.items.*;
import rpg.objects.npc.monster.Monsters;
import rpg.objects.player.Character;
import rpg.objects.story.StoryEvents;
import rpg.objects.story.StoryItems;
import rpg.objects.story.StoryLine;

public class AbsMem{
    //private vars

        //items
        private Items lightarmor;
        private Items mediumarmor;
        private Items heavyarmor;
        private Items genericArmor;
        private Items items;
        private String[] armorIds;
        private StoryItems storyItems;
        private Monsters monsters;
        private StoryLine storyline;
        private StoryEvents storyevents;

        //weapons

        private Weapon weapons;

        //events

        private StoryLine events;

        //character

        private Character character;

    //getters and setters

        //items
            
            //getters

            public String[] getArmorIds(){
                return this.armorIds;
            }

            public Items getArmor(){
                return this.items;
            }

            public Items getLightArmor(){
                return this.lightarmor;
            }

            public Items getMediumArmor(){
                return this.mediumarmor;
            }

            public Items getHeavyArmor(){
                return this.heavyarmor;
            }

            //setters

            public void setArmorIds(String[] armorIds){
                this.armorIds = armorIds;
            }

            public void setArmor(Items items){
                this.items = items;
            }

            public void setLightArmor(Items lightarmor){
                this.lightarmor = lightarmor;
            }

            public void setMediumArmor(Items mediumarmor){
                this.mediumarmor = mediumarmor;
            }

            public void setHeavyArmor(Items heavyarmor){
                this.heavyarmor = heavyarmor;
            }

            public Items getGenericArmor(){
                return this.genericArmor;
            }

            public void setGenericArmor(Items genericArmor){
                this.genericArmor = genericArmor;
            }
        
        //weapons

            //getters

            public Weapon getWeapons(){
                return this.weapons;
            }

            //setters

            public void setWeapons(Weapon weapons){
                this.weapons = weapons;
            }

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

            public void setCharacter(Character character){
                this.character = character;
            }

			public void setStoryItems(StoryItems storyItems) {
                this.storyItems = storyItems;
            }
            
            public StoryItems getStoryItems(){
                return this.storyItems;
            }

			public void setMonsters(Monsters monsters) {
                this.monsters = monsters;
            }
            
            public Monsters getMonsters(){
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

    //class definitions
}
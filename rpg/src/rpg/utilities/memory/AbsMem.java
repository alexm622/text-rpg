package rpg.utilities.memory;

import rpg.objects.Character;
import rpg.objects.StoryLine;

import rpg.objects.items.*;

public class AbsMem{
    //private vars

        //armor
        private Armor lightarmor;
        private Armor mediumarmor;
        private Armor heavyarmor;
        private Armor genericArmor;
        private Armor armor;
        private String[] armorIds;

        //weapons

        private Weapon weapons;

        //events

        private StoryLine events;

        //character

        private Character character;

    //getters and setters

        //armor
            
            //getters

            public String[] getArmorIds(){
                return this.armorIds;
            }

            public Armor getArmor(){
                return this.armor;
            }

            public Armor getLightArmor(){
                return this.lightarmor;
            }

            public Armor getMediumArmor(){
                return this.mediumarmor;
            }

            public Armor getHeavyArmor(){
                return this.heavyarmor;
            }

            //setters

            public void setArmorIds(String[] armorIds){
                this.armorIds = armorIds;
            }

            public void setArmor(Armor armor){
                this.armor = armor;
            }

            public void setLightArmor(Armor lightarmor){
                this.lightarmor = lightarmor;
            }

            public void setMediumArmor(Armor mediumarmor){
                this.mediumarmor = mediumarmor;
            }

            public void setHeavyArmor(Armor heavyarmor){
                this.heavyarmor = heavyarmor;
            }

            public Armor getGenericArmor(){
                return this.genericArmor;
            }

            public void setGenericArmor(Armor genericArmor){
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

    //class definitions
}
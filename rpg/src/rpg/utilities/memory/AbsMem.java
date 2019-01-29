package rpg.utilities.memory;

import rpg.objects.Character;
import rpg.objects.StoryEvents;

import rpg.objects.items.*;

public class AbsMem{
    //private vars

        //armor
        private Armor lightarmor;
        private Armor mediumarmor;
        private Armor heavyarmor;

        //weapons

        private Weapon weapons;

        //events

        private StoryEvents events;

        //character

        private Character character;

    //getters and setters

        //armor
            
            //getters

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

            public void setLightArmor(Armor lightarmor){
                this.lightarmor = lightarmor;
            }

            public void setMediumArmor(Armor mediumarmor){
                this.mediumarmor = mediumarmor;
            }

            public void setHeavyArmor(Armor heavyarmor){
                this.heavyarmor = heavyarmor;
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

            public StoryEvents getEvents(){
                return this.events;
            }

            //setters

            public void setEvents(StoryEvents events){
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
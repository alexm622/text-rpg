package rpg.utilities.memory;


public class AbsMem{
    //private vars

        //armor
        private Armor lightarmor;
        private Armor mediumarmor;
        private Armor heavyarmor;

        //weapons

        private Weapon weapons;

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


    //class definitions
    public static class Armor extends rpg.objects.items.Armor{

    }

    public static class Weapon extends rpg.objects.items.Weapon{

    }
}
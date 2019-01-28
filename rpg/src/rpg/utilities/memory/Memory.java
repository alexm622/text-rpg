package rpg.utilities.memory;

import java.util.List;

import rpg.game.Handler;
import rpg.objects.*;
import rpg.objects.items.*;
import rpg.objects.*;

public class Memory {

    // TODO make this manage memory

    private MemLoader ml;
    private Armor lightarmor, mediumarmor, heavyarmor;
    private Weapon weapon;
    private Handler h;
    private List<Class<?>> data;
    private String[] types = new String[]{
        "lightarmor", "mediumarmor", "heavyarmor", "weapons"
    };

    public Memory(Handler h) {
        //assign handler
        this.h = h;
        
        //memory loader
        ml = new MemLoader(this.h);

        //init armor
        this.lightarmor = new Armor();
        this.mediumarmor = new Armor();
        this.heavyarmor = new Armor();

        //init weapons
        this.weapon = new Weapon();

        this.Load();
        
    }

    

    public void Load(){

        this.setList();
        this.data = ml.Load(this.data, types);
        this.Dump();
    }

    public void Dump(){
        //load the list to variables
        try{
            int temp = 0;
            //get light armor
            this.lightarmor = (Armor) data.get(0).cast(lightarmor);
            System.out.println("got light armor");
            temp++;

            //get medium armor
            this.mediumarmor = (Armor) data.get(temp).cast(mediumarmor);
            System.out.println("got medium armor");
            temp++;

            //get heavy armor
            this.heavyarmor = (Armor) data.get(temp).cast(heavyarmor);
            System.out.println("got heavy armor");
            temp++;

            //get weapons
            this.weapon = (Weapon) data.get(temp).cast(weapon);
            System.out.println("got weapons");
            temp++;

        }catch(Exception e){
            e.printStackTrace();
        }
        

    }

    private void setList(){
        int temp = 0;

        //lightarmor
        data.add(temp, this.lightarmor.getClass());
        System.out.println("set light armor");
        temp++;

        // mediumarmor
        data.add(temp, this.mediumarmor.getClass());
        System.out.println("set medium armor");
        temp++;

        // heavy armor
        data.add(temp, this.heavyarmor.getClass());
        System.out.println("set heavy armor");
        temp++;

        // weapons
        data.add(temp, this.weapon.getClass());
        System.out.println("set weapons");
        temp++;
        
    }


    /**
     * @return the lightarmor
     */
    public Armor getLightarmor() {
        return lightarmor;
    }

    /**
     * @param lightarmor the lightarmor to set
     */
    public void setLightarmor(Armor lightarmor) {
        this.lightarmor = lightarmor;
    }

    /**
     * @return the mediumarmor
     */
    public Armor getMediumarmor() {
        return mediumarmor;
    }

    /**
     * @param mediumarmor the mediumarmor to set
     */
    public void setMediumarmor(Armor mediumarmor) {
        this.mediumarmor = mediumarmor;
    }

    /**
     * @return the heavyarmor
     */
    public Armor getHeavyarmor() {
        return heavyarmor;
    }

    /**
     * @param heavyarmor the heavyarmor to set
     */
    public void setHeavyarmor(Armor heavyarmor) {
        this.heavyarmor = heavyarmor;
    }

    /**
     * @return the weapon
     */
    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * @param weapon the weapon to set
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    
}
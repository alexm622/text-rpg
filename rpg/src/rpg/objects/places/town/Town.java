package rpg.objects.places.town;

import rpg.objects.places.town.buildings.shop.*;

public class Town{
    private String name;
    private int[] pos;
    private Shop[] shops;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setPos(int[] pos){
        this.pos = pos;
    }

    public int[] getPos(){
        return this.pos;
    }

    public void setShops(Shop[] shops){
        this.shops = shops;
    }

    public Shop[] getShops(){
        return this.shops;
    }
}
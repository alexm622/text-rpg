package rpg.objects.places.town.buildings.shop;

import rpg.objects.npc.Npc;
import rpg.objects.places.town.buildings.shop.storefront.TableEntry;

public class Shop {
    private String name;
    private Npc owner;
    private String type;

    private TableEntry table;

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Npc getOwner(){
        return this.owner;
    }

    public void setOwner(Npc owner){
        this.owner = owner;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

    public TableEntry getTable(){
        return this.table;
    }

    public void setTable(TableEntry table){
        this.table = table;
    }

    



    
}
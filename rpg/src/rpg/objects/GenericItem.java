package rpg.objects;

import rpg.objects.items.modifier.Modifier;

public abstract class GenericItem{
    private int id;
    private int count;
    private String name;
    private String lore;
    private Modifier[] modifiers;


    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getCount(){
        return this.count;
    }

    public String getName(){
        return this.name;
    }

    public String getLore(){
        return this.lore;
    }

    public void setCount(int count){
        this.count = count;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setLore(String lore){
        this.lore = lore;
    }

    public void setModifiers(Modifier[] modifiers){
        this.modifiers = modifiers;
    }

    public Modifier[] getModifiers(){
        return this.modifiers;
    }
}
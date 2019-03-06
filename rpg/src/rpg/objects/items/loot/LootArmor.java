package rpg.objects.items.loot;

import rpg.objects.Item.Modifier;
import rpg.objects.items.Armor;

public class LootArmor {
    private Armor.Item item;
    private Modifier[] modifiers;

    public Armor.Item getItem(){
        return this.item;
    }

    public void setItem(Armor.Item item){
        this.item = item;
    }

    public Modifier[] getModifiers(){
        return this.modifiers;
    }

    public void setModifiers(Modifier[] modifiers){
        this.modifiers = modifiers;
    }
}
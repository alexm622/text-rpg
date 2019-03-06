package rpg.objects.items.loot;

import rpg.objects.Item.Modifier;
import rpg.objects.items.Weapon;

public class LootWeapon {
    private Weapon.Item item;
    private Modifier[] modifiers;

    public Weapon.Item getItem(){
        return this.item;
    }

    public void setItem(Weapon.Item item){
        this.item = item;
    }

    public Modifier[] getModifiers(){
        return this.modifiers;
    }

    public void setModifiers(Modifier[] modifiers){
        this.modifiers = modifiers;
    }
}
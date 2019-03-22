package rpg.objects;

import rpg.objects.combat.Action;
import rpg.objects.items.Armor;
import rpg.objects.items.Weapon;

public class Item implements Armor, Weapon{
	//everything
	
	private String itemname;
	private String id;
	private int itembuy;
	private int itemsell;
	private int rarity;
	private boolean purchasable;
	private Modifier[] modifiers;
	
	//everything
	
	public String getId(){
		return this.id;
	}

	public void setId(String id){
		this.id = id;
	}
	
	public String getItemname() {
		return this.itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public int getItembuy() {
		return this.itembuy;
	}

	public void setItembuy(int itembuy) {
		this.itembuy = itembuy;
	}

	public int getItemsell() {
		return this.itemsell;
	}

	public void setItemsell(int itemsell) {
		this.itemsell = itemsell;
	}

	public int getrarity() {
		return this.rarity;
	}

	public void setrarity(int rarity) {
		this.rarity = rarity;
	}

	public boolean getPurchasable() {
		return this.purchasable;
	}

	public void setPurchasable(boolean purchasable) {
		this.purchasable = purchasable;
	}

	public Modifier[] getModifiers() {
		return this.modifiers;
	}

	public void setModifiers(Modifier[] modifiers) {
		this.modifiers = modifiers;
	}
	
	//armor
	private int armorclass;
	private int armortype;
	private int maxdex;
    
    //armor
	public int getArmorclass() {
		return this.armorclass;
	}

	public void setArmorclass(int armorclass) {
		this.armorclass = armorclass;
	}

	public int getArmortype() {
		return this.armortype;
	}

	public void setArmortype(int armortype) {
		this.armortype = armortype;
	}

	public int getMaxdex() {
		return this.maxdex;
	}

	public void setMaxdex(int maxdex) {
		this.maxdex = maxdex;
	}
	
	//weapon
	private String weapontype;
    private String weaponskill;
    private Action damage;
    
    public String getWeapontype() {
        return weapontype;
    }

    public void setWeapontype(String weapontype) {
        this.weapontype = weapontype;
    }

    public String getWeaponskill() {
        return weaponskill;
    }

    public void setWeaponskill(String weaponskill) {
        this.weaponskill = weaponskill;
    }

    public Action getDamage() {
        return damage;
    }

    public void setDamage(Action damage) {
        this.damage = damage;
    }
	    
	    

	public static class Modifier extends rpg.objects.items.modifier.Modifier {

	}

}

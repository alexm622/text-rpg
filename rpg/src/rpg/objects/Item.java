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
	private boolean sellable;
	private Modifier[] modifiers;

	//armor

	private int armorclass;
	private int armortype;
	private int maxdex;

	//weapon

	private String weapontype;
    private String weaponskill;
    private Action damage;
	
	//everything
	
	public boolean getSellable(){
		return this.sellable;
	}

	public void setSellable(boolean sellable){
		this.sellable = sellable;
	}

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
	
	
    
    
	
	//weapon
	
    
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

	//armor
	

	@Override
	public int getArmorclass() {
		return this.armorclass;
	}

	@Override
	public void setArmorclass(int armorclass) {
		this.armorclass = armorclass;
	}

	@Override
	public int getArmortype() {
		return armortype;
	}

	@Override
	public void setArmortype(int armortype) {
		this.armortype = armortype;
	}

	@Override
	public int getMaxdex() {
		return maxdex;
	}

	@Override
	public void setMaxdex(int maxdex) {
		this.maxdex = maxdex;
	}

}

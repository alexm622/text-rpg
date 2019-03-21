package rpg.objects.player;

import rpg.objects.Item;


public class Inventory{
    //private class
	private Armor[] armor;
	private Weapon[] weapons;
	private Item[] items;
	private Modifier[][] modifiers;

	public static class Armor extends rpg.objects.items.Armor{

	}

	public static class Weapon extends rpg.objects.items.Weapon{

	}

	public static class Modifier extends rpg.objects.items.modifier.Modifier{

	}

	public Armor[] getArmor(){
		return this.armor;
	}

	public Weapon[] getWeapons(){
		return this.weapons;
	}

	public Item[] getItems(){
		return this.items;
	}

	public Modifier[][] getModifiers(){
		return this.modifiers;
	}

	public void setArmor(Armor[] armor){
		this.armor = armor;
	}

	public void setWeapons(Weapon[] weapons){
		this.weapons = weapons;
	}

	public void setItems(Item[] items){
		this.items = items;
	}

	public void setModifiers(Modifier[][] modifiers){
		this.modifiers = modifiers;
	}
}
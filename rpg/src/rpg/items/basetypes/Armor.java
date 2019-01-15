package rpg.items.basetypes;

import rpg.items.Item;

public interface Armor extends Item{
	/*
	 * 0 = none
	 * 1 = light
	 * 2 = medium
	 * 3 = heavy
	 * 4 = shield
	 */
	public int armorType();
	public int armorClass();
}

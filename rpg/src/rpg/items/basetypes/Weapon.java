package rpg.items.basetypes;

import rpg.items.Item;

public interface Weapon extends Item{
	/*
	 * 0 = ranged
	 * 1 = melee
	 * 2 = thrown
	 * 3 = melee/thrown
	 */
	public int weaponType();
	/*
	 * 0 = bludgeon
	 * 1 = piercing 
	 */
	public int damageType();
	public int damageMax();
	public int numDie();
	public int critMod();
}	

package rpg.items.basetypes;

import rpg.items.Item;

public interface Consumable extends Item{
	/* 
	 * stat increase mod
	 * 1 = strength
	 * 2 = charisma
	 * 3 = intellegence
	 * 4 = wisdom
	 * 5 = dexterity
	 * 6 = constitution
	 * 7 = proficiency
	 * cannot be null
	 */
	public int[] statBoost();
	public int regenChange(); //+ or minus
	public int hpchange();
	public int duration();//num of turns it lasts
	public int numInInv();
	public void addX(int x);
}

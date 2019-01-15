package rpg.items;

public interface Modifier {
	public String name();
	public int priceMod();//plus or minus n gp
	public int itemClass();//item type ex. armor
	/* 
	 * stat increase mod
	 * 1 = strength
	 * 2 = charisma
	 * 3 = intellegence
	 * 4 = wisdom
	 * 5 = dexterity
	 * 6 = constitution
	 * 7 = proficiency
	 * 8 = hp
	 * cannot be null
	 */
	public int[] statMod();
	public int xpMod(); //xp increase mod ex +15% or -5%
}

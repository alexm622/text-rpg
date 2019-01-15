package rpg.items;

public interface Item {
	public String name();
	public int Type();
	/*
	 * 0 = weapon
	 * 1 = misc
	 * 2 = consumable
	 * 3 = armor
	 */
	public int sellPrice();
	public int buyPrice();
	public int rarity();
	public boolean canBuy();
	/*
	 * 
	 */
	public int[] modifiers();
	public boolean has();
	public void changeHas(boolean x);
}

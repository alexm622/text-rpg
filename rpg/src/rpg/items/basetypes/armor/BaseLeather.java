package rpg.items.basetypes.armor;

import rpg.items.basetypes.Armor;

public class BaseLeather implements Armor {

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "Leather";
	}

	@Override
	public int Type() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int sellPrice() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public int buyPrice() {
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public int rarity() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public boolean canBuy() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int[] modifiers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int armorType() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int armorClass() {
		// TODO Auto-generated method stub
		return 11;
	}

	boolean has;
	
	@Override
	public boolean has() {
		// TODO Auto-generated method stub
		return has;
	}

	@Override
	public void changeHas(boolean x) {
		// TODO Auto-generated method stub
		has = x;
	}
}

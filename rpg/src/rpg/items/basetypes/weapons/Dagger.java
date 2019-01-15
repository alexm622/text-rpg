package rpg.items.basetypes.weapons;

import rpg.items.basetypes.Weapon;

public class Dagger implements Weapon {

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "Dagger";
	}

	@Override
	public int Type() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int sellPrice() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int buyPrice() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int rarity() {
		// TODO Auto-generated method stub
		return 0;
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
	public int weaponType() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int damageType() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int damageMax() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int numDie() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int critMod() {
		// TODO Auto-generated method stub
		return 2;
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

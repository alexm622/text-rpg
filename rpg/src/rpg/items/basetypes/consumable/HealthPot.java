package rpg.items.basetypes.consumable;

import rpg.items.basetypes.Consumable;

public class HealthPot implements Consumable {
	
	private int numhas;
	private boolean has;
	
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
	
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "Health Pot";
	}

	@Override
	public int Type() {
		// TODO Auto-generated method stub
		return 2;
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
	public int[] statBoost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int regenChange() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int hpchange() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public int duration() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int numInInv() {
		// TODO Auto-generated method stub
		return numhas;
	}

	@Override
	public void addX(int x) {
		// TODO Auto-generated method stub
		numhas += x;
	}

	

}

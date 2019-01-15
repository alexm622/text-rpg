package rpg.items.basetypes.armor;

import rpg.game.Handler;
import rpg.guis.GraphicMain;
import rpg.items.basetypes.Armor;

public class None implements Armor {
	private Handler h = GraphicMain.h;
	private int dex = h.getG().getP().getDex();
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "None";
	}

	@Override
	public int Type() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int sellPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int buyPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int rarity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean canBuy() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int[] modifiers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int armorType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int armorClass() {
		// TODO Auto-generated method stub
		return (10 + dex);
	}
	
	boolean has = true;
	
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

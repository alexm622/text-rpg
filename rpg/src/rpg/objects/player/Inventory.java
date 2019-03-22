package rpg.objects.player;

import rpg.objects.Items;


public class Inventory{
    //private class
	private Items inv;


	public Items getInv(){
		return this.inv;
	}
	
	public void setInv(Items inv) {
		this.inv = inv;
	}
}
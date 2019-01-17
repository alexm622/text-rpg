package rpg.utilities.json.classses.items;


public abstract class Item {
	private String itemname;
	private int itembuy;
	private int itemsell;
	private int rarity;
	private boolean purchasable;
	private Modifier[] modifiers;
	
	public String getItemname() {return this.itemname;}
	public void setItemname(String itemname) {this.itemname = itemname;}
	
	public int getItembuy() {return this.itembuy;}
	public void setItembuy(int itembuy) {this.itembuy = itembuy;}
	
	public int getItemsell() {return this.itemsell;}
	public void setItemsell(int itemsell) {this.itemsell = itemsell;}
	
	public int getrarity() {return this.rarity;}
	public void setrarity(int rarity) {this.rarity = rarity;}
	
	public boolean getPurchasable() {return this.purchasable;}
	public void setPurchasable(boolean purchasable) {this.purchasable = purchasable;}
	
	public Modifier[] getModifiers() {return this.modifiers;}
	public void setModifiers(Modifier[] modifiers) {this.modifiers = modifiers;}
	
	public static class Modifier extends rpg.utilities.json.classses.items.modifier.Modifier{
		
	}
	
}

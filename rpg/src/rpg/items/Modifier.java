package rpg.items;

public abstract class Modifier {
	private int id;
	private int lvl;
	
	public int getid() {return this.id;}
	public void setid(int id) {this.id = id;}
	
	public int getlvl() {return this.lvl;}
	public void setlvl(int lvl) {this.lvl = lvl;}
}

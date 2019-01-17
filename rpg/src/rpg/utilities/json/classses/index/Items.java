package rpg.utilities.json.classses.index;

public abstract class Items {
	
	//private definitions
	
	private Armor[] armor;
	private Weapons[] weapons;
	private Consumable[] consumable;
	private Quest[] quest;
	
	//getters and setters
	public Armor[] getArmor() {return this.armor;}
	public void setArmor(Armor[] armor) {this.armor = armor;}
	
	public Weapons[] getWeapons() {return this.weapons;}
	public void setWeapons(Weapons[] weapons) {this.weapons = weapons;}
	
	public Consumable[] getConsumable() {return this.consumable;}
	public void setConsumable(Consumable[] consumable) {this.consumable = consumable;}
	
	public Quest[] getQuest() {return this.quest;}
	public void setQuest(Quest[] quest) {this.quest = quest;}
	
	//classes
	
	public static class Armor extends rpg.utilities.json.classses.index.Path{
		
	}
	
	public static class Weapons extends rpg.utilities.json.classses.index.Path{
		
	}
	
	public static class Consumable extends rpg.utilities.json.classses.index.Path{
		
	}
	
	public static class Quest extends rpg.utilities.json.classses.index.Path{
		
	}
}

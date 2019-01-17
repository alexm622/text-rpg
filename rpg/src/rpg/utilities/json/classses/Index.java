package rpg.utilities.json.classses;

public class Index {
	
	//private defs
	
	private Character character;
	private Events events;
	private Items items;
	private Storyline storyline;
	private Modifiers modifiers;
	
	//getters and setters
	
	public Character getCharacter() {return this.character;}
	public Events getEvents() {return this.events;}
	public Items getItems() {return this.items;}
	public Storyline getStoryline() {return this.storyline;}
	public Modifiers getModifiers() {return this.modifiers;}
	
	public void setCharacter(Character character) {this.character = character;}
	public void setEvents(Events events) {this.events = events;}
	public void setItems(Items items) {this.items = items;}
	public void setStoryline(Storyline storyline) {this.storyline = storyline;}
	public void setModifiers(Modifiers modifiers) {this.modifiers = modifiers;}
	
	//classes
	
	public static class Character extends rpg.utilities.json.classses.index.Character{
		
	}
	
	public static class Events extends rpg.utilities.json.classses.index.Events{
		
	}
	
	public static class Items extends rpg.utilities.json.classses.index.Items{
		
	}
	
	public static class Storyline extends rpg.utilities.json.classses.index.Storyline{
		
	}
	
	public static class Modifiers extends rpg.utilities.json.classses.index.Modifiers{
		
	}
}

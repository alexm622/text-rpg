package rpg.utilities.json.classses.index;

public abstract class Modifiers{
	
	//private defs
	
	private Modifier positive;
	private Modifier negative;
	
	//getters and setters
	
	public Modifier getPositive() {return this.positive;}
	public Modifier getNegative() {return this.negative;}
	
	public void setPositive(Modifier positive) {this.positive = positive;}
	public void setNegative(Modifier negative) {this.negative = negative;}
	
	//classes
	
	public static class Modifier extends rpg.utilities.json.classses.index.Path{	
		
	}
	
}

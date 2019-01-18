package rpg.utilities.json.classses;

import rpg.utilities.json.classses.index.Path;

public class Index {
	
	//private defs
	
	private Character character;
	private Events events;
	private Items items;
	private Storyline storyline;
	private Modifiers modifiers;
	private Path[] ptdata;
	
	//getters and setters
	
	public Character getCharacter() {return this.character;}
	public Events getEvents() {return this.events;}
	public Items getItems() {return this.items;}
	public Storyline getStoryline() {return this.storyline;}
	public Modifiers getModifiers() {return this.modifiers;}
	
	//this will need to return an array of all the paths and types for those paths
	public Path[] getPTdata() {
		if((ptdata == null) && (this.getItems() != null) && (this.getCharacter() != null) && (this.getEvents() != null) && (this.getModifiers() != null)
				&& (this.getStoryline() != null)) {
			/*
			 * temp is the total number of path entries
			 * temp2 is used to record the number of entries in each subtype
			 * temp3 is used to record amt. of stuff that has already been recorded
			 */
			int temp = 0, temp2 = 0, temp3;
			int[] itemlen = new int[3];
			int[] charlen = new int[3];
			int[] eventlen = new int[3];
			int[] modlen = new int[1];
			int[] storylen = new int[3];
			/*
			 *temparray[0] = items
			 *temparray[1] = character
			 *temparray[2] = events
			 *temparray[3] = modifiers
			 *temparray[4] = storyline 
			 */
			
			int temparray[]; 
			//add items
			
			temp = this.getItems().getArmor().length;
			itemlen[0] = this.getItems().getArmor().length;
			temp2++;
			temp += this.getItems().getQuest().length;
			itemlen[1] = this.getItems().getQuest().length;
			temp2++;
			temp += this.getItems().getWeapons().length;
			itemlen[2] = this.getItems().getWeapons().length;
			temp2++;
			temp += this.getItems().getConsumable().length;
			itemlen[3] = this.getItems().getConsumable().length;
			temp2++;
			
			temparray = new int[5];
			temparray[0] = temp2;
			temp2 = 0;
			
			//add character
			
			
			//getevents
			
			
			//get modifiers
			temp += 2; //positive and negative
			temp2 += 2;
			
			temparray[3] = temp2;
			temp2 = 0;
			
			//get storyline
			
			//assign to array
			temp3 = 0;
			ptdata = new Path[temp];
			
			/*
			 *temparray[0] = items
			 *temparray[1] = character
			 *temparray[2] = events
			 *temparray[3] = modifiers
			 *temparray[4] = storyline 
			 */
			
			
			for(int i = 0; i < 5; i++) {
				switch(i) {
					case 0: //items
						for(int j = 0; i < itemlen.length; i++) {
							switch(j) {
								case 0: //armor
									for(int k = 0; k < itemlen[0]; k++) {
										ptdata[temp3] = this.getItems().getArmor()[k];
										temp3++;
									}
								case 1: //quest
									for(int k = 0; k < itemlen[1]; k++) {
										ptdata[temp3] = this.getItems().getQuest()[k];
										temp3++;
									}
								case 2: //weapons
									for(int k = 0; k < itemlen[2]; k++) {
										ptdata[temp3] = this.getItems().getWeapons()[k];
										temp3++;
									}
								case 3: //consumable
									for(int k = 0; k < itemlen[3]; k++) {
										ptdata[temp3] = this.getItems().getConsumable()[k];
										temp3++;
									}
							}
						}
					case 1: // character
						for(int j = 0; i < charlen.length; i++) {
							
						}
					case 2: //events
						for(int j = 0; i < eventlen.length; i++) {
							
						}
					case 3: //modifiers
						for(int j = 0; i < modlen.length; i++) {
							switch(j) {
								case 0: //positive
									ptdata[temp3] = this.getModifiers().getPositive();
								case 1: //negative
									ptdata[temp3] = this.getModifiers().getNegative();
							}
						}
					case 4: //storyline
						for(int j = 0; i < storylen.length; i++) {
							
						}
				}
			}
			
			
		}else if((ptdata == null) || (this.getItems() == null) || (this.getCharacter() == null) || (this.getEvents() == null) || (this.getModifiers() == null)
				|| (this.getStoryline() == null))
			throw new Error("something went wrong!");
		else {
			return ptdata;
		}
		return ptdata;
	}
	
	
	public void setCharacter(Character character) {this.character = character;}
	public void setEvents(Events events) {this.events = events;}
	public void setItems(Items items) {this.items = items;}
	public void setStoryline(Storyline storyline) {this.storyline = storyline;}
	public void setModifiers(Modifiers modifiers) {this.modifiers = modifiers;}
	public void setPTdata(Path[] ptdata) {this.ptdata = ptdata;}
	
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

package rpg.player;

import rpg.game.Handler;
import rpg.objects.Character;

public class Player {

	//{ name, "Strength: ", "Charisma: ", "Wisdom: ", "Intelligence: ", "Dexterity: ", "Constitution: " };

	private Handler h;
	private Character c;

	public Player(Handler h){
		this.h = h;
		
	}

	public void init(String[] stats) {
		this.c = h.getG().getMemory().getMem().getCharacter();
		c.setName(stats[0]);
		c.setStren(Integer.parseInt(stats[1]));
		c.setChari(Integer.parseInt(stats[2]));
		c.setWis(Integer.parseInt(stats[3]));
		c.setIntel(Integer.parseInt(stats[4]));
		c.setDex(Integer.parseInt(stats[5]));
		c.setConsti(Integer.parseInt(stats[6]));
		h.getG().getMemory().getMem().setCharacter(this.c);
	}

	public void Update(Handler h) {
		this.h = h;
	}
	
}

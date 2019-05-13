package rpg.player;

import rpg.game.Handler;
import rpg.objects.player.Character;
import rpg.utilities.map.Direction;

public class Player {


	//{ name, "Strength: ", "Charisma: ", "Wisdom: ", "Intelligence: ", "Dexterity: ", "Constitution: " };

	private Handler h;
	private Character c;

	public Player(Handler h){
		this.h = h;
		
	}

	public void init(String[] stats, int[] pos) {
		this.c = new Character();
		c.setName(stats[0]);
		c.setStren(Integer.parseInt(stats[1]));
		c.setChari(Integer.parseInt(stats[2]));
		c.setWis(Integer.parseInt(stats[3]));
		c.setIntel(Integer.parseInt(stats[4]));
		c.setDex(Integer.parseInt(stats[5]));
		c.setConsti(Integer.parseInt(stats[6]));
		c.setPos(pos);
		h.getG().getMemory().getMem().setCharacter(this.c);
	}



	public void Update(Handler h) {
		this.h = h;
	}
	
	
	
	public boolean move(Direction dir) {
		int width, height;
		width = h.getMem().getMap().getTiles().length;
		height = h.getMem().getMap().getTiles()[0].length;
		int[] center = new int[] {(width - width%2)/2 + width%2, (height - height%2)/2 + height%2 };

		this.c = h.getMem().getCharacter();

		switch(dir) {

			case LEFT:
				if(!(c.getPos()[1] + center[1] < height + 1)) {
					return false;
				}
				c.setPos(new int[] {c.getPos()[0] - 1, c.getPos()[1]});
				return true;
				
				
				
			case RIGHT:
				if(!(c.getPos()[1] + center[1] >= 1)) {
					return false;
				}
				c.setPos(new int[] {c.getPos()[0] + 1, c.getPos()[1]});
				return true;
				

			case UP:
				if(!(c.getPos()[0] + center[0] >= 1)) {
					return false;
				}
				c.setPos(new int[] {c.getPos()[0], c.getPos()[1] + 1});
				return true;
				
								
			case DOWN:
				if(!(c.getPos()[1] + center[1] < width + 1)) {
					return false;
				}
				c.setPos(new int[] {c.getPos()[0], c.getPos()[1] - 1});
				return true;
				
				
			default:
				Handler.debug("something broke", true);
				return false;
			
		}
	}
	
}

package rpg.game;

import rpg.player.Player;
import rpg.utilities.SaveFileReader;

public class Game {
	private Player p;
	private SaveFileReader fm;
	public void Start() {
		InitPlayer();
		InitFm();
		fm.Init();
	}
	
	private void InitFm() {
		// TODO Auto-generated method stub
		fm = new SaveFileReader();
		fm.Init();
	}
	private void InitPlayer() {
		p = new Player();
	}
	public Player getP() {
		return p;
	}
	public void setP(Player x) {
		p = x;
	}
	public SaveFileReader getFm() {
		return fm;
	}
	
	public void Begin() {
		
	}
}

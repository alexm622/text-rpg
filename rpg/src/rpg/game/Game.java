package rpg.game;

import rpg.player.Player;
import rpg.utilities.SaveFileReader;
import rpg.utilities.json.JsonMain;
import rpg.utilities.json.classses.Index;
import rpg.utilities.json.classses.IndexHandler;;

public class Game {
	private Game self;
	private Player p;
	private SaveFileReader fm;
	private Index index;
	private JsonMain jm;
	public void Start() {
		this.self = this;
		InitPlayer();
		InitFm();
		InitIndex();
		InitJson(self);
		fm.Init();
		
	}
	
	private void InitJson(Game main) {
		this.jm = new JsonMain();
		this.jm.init();
	}

	private void InitIndex() {
		// TODO Auto-generated method stub
		IndexHandler indexh = new IndexHandler();
		indexh.init();
		try {
			this.index = indexh.getIndex();
		}catch(Error e){
			e.printStackTrace();
		}
		
	}

	private void InitFm() {
		// TODO Auto-generated method stub
		this.fm = new SaveFileReader();
		this.fm.Init();
	}
	private void InitPlayer() {
		this.p = new Player();
	}
	public Player getP() {
		return this.p;
	}
	public void setP(Player p) {
		this.p = p;
	}
	public SaveFileReader getFm() {
		return this.fm;
	}
	public void setFm(SaveFileReader fm) {
		this.fm = fm;
	}
	
	public Index getIndex() {
		return this.index;
	}
	
	public void setIndex(Index index) {
		this.index = index;
	}
	
	public JsonMain getJm() {
		return this.jm;
	}
	
	public void setJm(JsonMain jm) {
		this.jm = jm;
	}
	
}

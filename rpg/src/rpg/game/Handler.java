package rpg.game;

import rpg.guis.GraphicMain;

public class Handler {
	//return game
	private Game g; //hopefully make this obsolete
	private Player p;
	private SaveFileReader fm;
	private Index index;
	private JsonMain jm;
	public void InitAll() {
		InitPlayer();
		InitFm();
		InitIndex();
		InitJson(this);
		fm.Init();
		
	}
	
	private void InitJson(Handler h) {
		this.jm = new JsonMain(h);
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

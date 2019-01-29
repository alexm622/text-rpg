package rpg.game;

import rpg.player.Player;
import rpg.utilities.SaveFileReader;
import rpg.utilities.json.JsonMain;
import rpg.utilities.json.classes.index.Path;

public class Handler {
	private Game g;
	private Player p;
	private SaveFileReader fm;
	private JsonMain jm;
	private Path[] ptdata;

	public Handler(Game g) {
		this.ptdata = new Path[0];
		InitPlayer();
		InitFm();
		InitJson();
		InitGame(g);
		fm.Init();
	}

	/*
	 * TestIndex is a debug class testing to see if typetoclass works, and if it can
	 * fetch the class properties based on the type name
	 */

	private void InitGame(Game g) {
		this.g = g;
	}

	private void InitJson() {
		this.jm = new JsonMain();
		this.jm.Init(this);
	}

	private void InitFm() {
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

	public JsonMain getJm() {
		return this.jm;
	}

	public void setJm(JsonMain jm) {
		this.jm = jm;
	}

	public Game getG() {
		return this.g;
	}

	public Path[] getPTdata() {
		return this.ptdata;
	}

	public void setPTdata(Path[] path) {
		System.out.println("set ptdata");
		this.ptdata = path;
		System.out.println(this.ptdata[0].getClas());
	}

}

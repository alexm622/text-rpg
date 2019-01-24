package rpg.game;

import rpg.guis.GraphicMain;
import rpg.player.Player;
import rpg.utilities.SaveFileReader;
import rpg.utilities.json.JsonMain;
import rpg.utilities.json.classses.Index;
import rpg.utilities.json.classses.IndexHandler;
import rpg.utilities.json.classses.index.Path;

import java.lang.reflect.Method;;

public class Handler {
	private Game g;
	private Player p;
	private SaveFileReader fm;
	private Index index;
	private JsonMain jm;
	private GraphicMain gm;
	private Path[] ptdata;

	public Handler(GraphicMain gm) {
		this.gm = gm;
		InitGm(gm);
		InitPlayer();
		InitFm();
		InitIndex();
		InitJson();
		InitGame();
		fm.Init();
		TestIndex();
	}

	private void InitGm(GraphicMain gm) {
		gm.main(null);
		gm.Init(gm);
	}

	public void TestIndex() {
		System.out.println("test");
		Class<?> temp = jm.Read("lightarmor");
		if (temp == null) {
			System.out.println("temp is null");
		} else {
			System.out.println("test");
		}
		try {
			Method m = temp.getMethod("getItemName", null);
			System.out.println(m.toString());
		} catch (NoSuchMethodException | SecurityException | Error e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void InitGame() {
		this.g = new Game();
	}

	private void InitJson() {
		this.jm = new JsonMain();
		this.jm.Init(this);
	}

	private void InitIndex() {
		// TODO Auto-generated method stub
		IndexHandler indexh = new IndexHandler();
		indexh.init(this);
		this.ptdata = indexh.getIndex();
		this.index = new Index();
		try {
			this.index.setIndex(indexh.getIndex());
		} catch (Error e) {
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

	public GraphicMain getGm() {
		return this.gm;
	}

	public void setGm(GraphicMain gm) {
		this.gm = gm;
	}

	public Game getG() {
		return this.g;
	}

	public Path[] getPTdata() {
		return this.ptdata;
	}

	public void setPTdata(Path[] path) {
		this.ptdata = path;
	}

}

package rpg.game;

import rpg.utilities.SaveFileReader;
import rpg.utilities.json.JsonMain;
import rpg.utilities.json.classes.index.Path;

public class Handler {
	private Game g;
	private SaveFileReader fm;
	private JsonMain jm;
	private Path[] ptdata;
	private Thread t;

	public Handler(Game g) {
		this.ptdata = new Path[0];
		
		InitFm();
		InitJson();
		InitGame(g);
		
		fm.Init();

     
	}



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



	//getters and setters

	public Thread getT(){
		return this.t;
	}

	public void setT(Thread t){
		this.t = t;
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

	public void Update(){
		jm.Update(this);
		
	}

}

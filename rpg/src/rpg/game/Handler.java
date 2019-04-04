package rpg.game;


import rpg.utilities.json.JsonMain;
import rpg.utilities.json.classes.index.Path;

public class Handler {
	private Game g;
	private JsonMain jm;
	private Path[] ptdata;
	private Thread t;
	public static Object o = new Object();

	public Handler(Game g) {
		this.ptdata = new Path[0];
		
		InitJson();
		InitGame(g);
		

     
	}

	public synchronized void sync(boolean b){
		
	}



	private void InitGame(Game g) {
		this.g = g;
	}

	private void InitJson() {
		this.jm = new JsonMain();
		this.jm.Init(this);
	}




	//getters and setters

	public Thread getT(){
		return this.t;
	}

	public void setT(Thread t){
		this.t = t;
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

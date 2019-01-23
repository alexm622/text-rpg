package rpg.utilities.json.classses.index;

public abstract class Path {

	//definitions

	private String path;
	private String type;
    private String cla;

	//getters and setters

	public String getPath() {return this.path;}
	public void setPath(String path) {this.path = path;}

	public String getType() {return this.type;}
	public void setType(String type) {this.type = type;}

    public String getCla() {return this.cla;}
    public Void setCla(String cla) {this.cla = cla;}
}

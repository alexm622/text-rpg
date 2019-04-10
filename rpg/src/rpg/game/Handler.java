package rpg.game;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

	public static void debug(String msg, boolean err) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			Date date = new Date();
			PrintWriter out = new PrintWriter(new FileWriter(
				"C:\\Users\\" + (String) System.getProperty("user.name") +
				 "\\AppData\\Roaming\\AlexRpg\\" + dateFormat.format(date) + ".txt", true));
		
			String fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
			String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
			String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
			int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
			String temp = className;
			temp += "." + methodName + "():";
			temp += Integer.toString(lineNumber) + ": ";
			temp += msg;
			temp += " \n";
			String sep = "----------------------------------";
			if(err){
				sep = "#############################";
				
			}
			System.out.println();
			
			System.out.println(temp);


			out.println();
			out.println();
			out.println(sep);

			out.println(temp);

			out.println(sep);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static void debug(String msg){
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			Date date = new Date();
			PrintWriter out = new PrintWriter(new FileWriter(
				"C:\\Users\\" + (String) System.getProperty("user.name") +
				 "\\AppData\\Roaming\\AlexRpg\\" + dateFormat.format(date) + ".txt", true));
		
			String fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
			String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
			String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
			int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
			String temp = className;
			temp += "." + methodName + "():";
			temp += Integer.toString(lineNumber) + ": ";
			temp += msg;
			temp += " \n";
			String sep = "----------------------------------";

			System.out.println();
			
			System.out.println(temp);

	
			out.println();
			out.println();
			out.println(sep);

			out.println(temp);

			out.println(sep);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		Handler.debug("set ptdata");
		this.ptdata = path;
		Handler.debug(this.ptdata[0].getClas());
	}

	public void Update(){
		jm.Update(this);
		
	}

}

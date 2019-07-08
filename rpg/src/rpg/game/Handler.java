package rpg.game;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import rpg.utilities.json.JsonMain;
import rpg.utilities.json.classes.index.Path;
import rpg.utilities.map.Biome;
import rpg.utilities.memory.AbsMem;


public class Handler {

	public static Game g;
	public static JsonMain jm;
	public static Path[] ptdata;
	public static AbsMem memory;
	
	public static Thread t;
	public static Object o = new Object();
	public static final int NUMBIOMES = Biome.values().length;
	
	
	
	public Handler(Game g) {
		ptdata = new Path[0];
		

		InitJson();
		Handler.g = g;
		
		
		

	}

	public AbsMem getMem(){
		return g.getMemory().getMem();
	}

	public static void debug(Object msg, boolean err) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			Date date = new Date();
			PrintWriter out = new PrintWriter(new FileWriter(
				System.getenv("APPDATA") + "\\AlexRpg\\logs\\" + dateFormat.format(date) + ".txt", true));
			dateFormat = new SimpleDateFormat("[yyyy:MM:dd HH:mm:ss] -- ");
			String fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
			String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
			String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
			int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
			String temp = dateFormat.format(date);
			temp += className;
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
			File f = new File(System.getenv("APPDATA") + "\\AlexRpg\\logs\\");
			f.mkdirs();
			rpg.game.Handler.debug("attempting to create logs folder to fix issue");
			
		}
		
		
	}

	public static void debug(Object msg){
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			Date date = new Date();
			PrintWriter out = new PrintWriter(new FileWriter(
				System.getenv("APPDATA") + "\\AlexRpg\\logs\\" + dateFormat.format(date) + ".txt", true));

			dateFormat = new SimpleDateFormat("[yyyy:MM:dd HH:mm:ss] -- ");
			String fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
			String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
			String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
			int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
			String temp = dateFormat.format(date);
			temp += className;
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
			File f = new File(System.getenv("APPDATA") + "\\AlexRpg\\logs\\");
			f.mkdirs();
			rpg.game.Handler.debug("attempting to create logs folder to fix issue");
		}
	}

	public synchronized void sync(boolean b){
		
	}



	

	private void InitJson() {
		jm = new JsonMain();
		jm.Init();
	}




	//getters and setters

	public Thread getT(){
		return t;
	}

	public void setT(Thread t1){
		t = t1;
	}
	



	public JsonMain getJm() {
		return jm;
	}

	public void setJm(JsonMain jm1) {
		jm = jm1;
	}

	public Game getG() {
		return g;
	}

	public Path[] getPTdata() {
		return ptdata;
	}

	public void setPTdata(Path[] path) {
		Handler.debug("set ptdata");
		ptdata = path;
		Handler.debug(ptdata[0].getClas());
	}

	

}

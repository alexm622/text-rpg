package rpg.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

@SuppressWarnings("unused")
public class SaveFileReader {
	
	private static File f;
	private static BufferedWriter w;
	private static BufferedReader r;
	private static FileWriter fw;
	private static FileReader fr;
	private static String text[];
	public void Init() {
		f = new File(("C:\\Users\\" + (String) System.getProperty("user.name") + "\\AppData\\Roaming\\AlexRpg\\save.sav"));
		boolean res = false;
		try {
			if (!f.exists()) {
			     f.createNewFile();
			     System.out.println("Made a new file");
			}
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			if(e.getMessage().contains("The system cannot find the path specified")) {
				new File(("C:\\Users\\" + (String) System.getProperty("user.name") + "\\AppData\\Roaming\\AlexRpg\\")).mkdirs();
				try {
					f.createNewFile();
					res = true;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(res) {System.out.println("made a dir");};
				
			}
		}
		ReadCharStats();			 
	}

	public void Write(String[] s) {
		/*
		 * file name is save.sav
		 * is in C:\Users\$username\AppData\Roaming\AlexRpg
		 * should create the directory if not present, then make the file, if not already there.
		 * would like to make a gui
		 * to allow users to select the loc of a custom save
		 * 
		 */
		try {
			fw = new FileWriter(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		w = new BufferedWriter(fw);
		
		Proceed(s);
		
		
		
	}
	
	private static void Proceed(String[] s) {
		String x;
		try {
			for(int i = 0; i < s.length; i++) {
				x = s[i] + "\n";
				
					w.write(x);
			}
			w.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static String Read(int line) {
		String x = text[line-1];
		return x;
	}
	public static void ReadCharStats() {
		int length = 0;
		String line;
		text = new String[43];
		try {
			fr = new FileReader(f);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		r = new BufferedReader(fr);
	    while(length < 43) {
	        try {
				line = r.readLine();
				text[length] = line;
		    	length++;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
	        	        
	    }
	    for(int i = 0; i < 43; i++) {
	    	System.out.println(text[i]);
	    }
	    
	}
	public static File getF() {
		return f;
	}
	public static void setF(File f) {
		SaveFileReader.f = f;
	}
	public static BufferedWriter getWriter() {
		return w;
	}
	public static void setWriter(BufferedWriter writer) {
		SaveFileReader.w = writer;
	}
	
}

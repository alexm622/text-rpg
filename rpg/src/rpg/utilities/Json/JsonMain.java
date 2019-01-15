package rpg.utilities.Json;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;


import com.fasterxml.jackson.databind.ObjectMapper;

import rpg.Main;
import rpg.items.Armor;

import com.fasterxml.jackson.core.*;

@SuppressWarnings("unused")
public class JsonMain {
	private File file;
	private InputStream in;
	private BufferedReader reader;
	
	public void init() {
		
	}
	
	public void test_class() {
		fix_file();
	}
	
	private void fix_file() {
		URL dir_url = ClassLoader.getSystemResource("res/GameData/Items/Armor/LightArmor.json");
		ObjectMapper om = new ObjectMapper();
		try {
			File file = new File(dir_url.toURI());
			try {
				Armor arm = om.readValue(file, Armor.class);
				System.out.println(arm.getItems()[0].getItemname());
				System.out.println(arm.getItems()[0].getModifiers()[0].getid());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("error reading contents");
				e.printStackTrace();
			}
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			System.out.println("error with uri");
			e1.printStackTrace();
		}
		
		
	}
	
	
}

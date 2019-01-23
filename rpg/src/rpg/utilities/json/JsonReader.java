package rpg.utilities.json;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

import rpg.utilities.json.classses.items.Armor;

public class JsonReader {
	public Class read(String path) {
		Class c;
		URL dir_url = ClassLoader.getSystemResource("res/GameData/Items/Armor/LightArmor.json");
		ObjectMapper om = new ObjectMapper();
		try {
			File file = new File(dir_url.toURI());
			try {
				Armor arm = om.readValue(file, Armor.class);
				
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
		return null;
	}
}

package rpg.utilities.Json;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.net.URISyntaxException;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.*;

@SuppressWarnings("unused")
public class JsonMain {
	private File file;
	private InputStream in;
	private BufferedReader reader;
	private ObjectMapper om;
	public void init() {
		
	}
	
	public void test_class() {
		fix_file();
	}
	
	private void fix_file() {
		ClassLoader classLoader = getClass().getClassLoader();
		file = new File(classLoader.getResource("/GameData/Items/Armor/LightArmor.json").getFile());
	}
}

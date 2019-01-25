package rpg.utilities.json.classes;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

import rpg.game.Handler;
import rpg.utilities.json.classes.index.Path;

public class IndexHandler {

	private Path[] index;

	public void init(Handler h) {
		URL dir_url = ClassLoader.getSystemResource("res/Index.json");
		ObjectMapper mapper = new ObjectMapper();
		try {
			File file = new File(dir_url.toURI());
			try {
				index = mapper.readValue(file, Path[].class);
			} catch (IOException e) {
				
				System.out.println("error reading contents");
				e.printStackTrace();
			}
		} catch (URISyntaxException e1) {

			System.out.println("error with uri");
			e1.printStackTrace();
		}
	}

	public Path[] getIndex() throws Error {
		if (this.index == null) {
			Error e = new Error("please initialize index first");
			throw e;
		}
		return this.index;
	}
}

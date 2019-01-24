package rpg.utilities.json;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReader {
	private Class<?> c;
	private String path;

	JsonReader(Class<?> c, String path) {
		this.c = c;
		this.path = path;
	}

	public Class<?> Read() {
		URL dir_url = ClassLoader.getSystemResource(path);
		ObjectMapper om = new ObjectMapper();
		try {
			File file = new File(dir_url.toURI());
			try {
				c = om.readValue(file, this.c.getClass());
				System.out.println("working");
				return c;
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

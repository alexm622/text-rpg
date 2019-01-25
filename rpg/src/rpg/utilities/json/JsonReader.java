package rpg.utilities.json;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReader {
	private Class c;
	private String path;
	private Object o;

    //TODO make this return a class of type T given class T
    //https://stackoverflow.com/questions/2240646/how-to-pass-a-type-as-a-method-parameter-in-java

	JsonReader(Class<?> c, String path) {
		this.c = c;
		try {
			this.o = c.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		this.path = path;
	}

	public Class<?> Read() {
		URL dir_url = ClassLoader.getSystemResource(this.path);
		ObjectMapper om = new ObjectMapper();
		try {
			File file = new File(dir_url.toURI());
			try {

				c = om.readValue(file, c.getClass());
				System.out.println("working");
				return c;
			} catch (IOException e) {

				System.out.println("error reading contents");
				e.printStackTrace();
			}
		} catch (URISyntaxException e1) {

			System.out.println("error with uri");
			e1.printStackTrace();
		}
		return null;
	}
}

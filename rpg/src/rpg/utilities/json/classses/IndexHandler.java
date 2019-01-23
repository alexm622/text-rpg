package rpg.utilities.json.classses;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

import  rpg.utilities.json.classses.Index;

public class IndexHandler {
	
	private Index index;
	
	public void init(Handler h) {
		URL dir_url = ClassLoader.getSystemResource("res/Index.json");
		ObjectMapper om = new ObjectMapper();
		try {
			File file = new File(dir_url.toURI());
			try {
				index = om.readValue(file, Index.class);
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
	
	public Index getIndex() throws Error{
		if(index == null) {
			Error e = new Error("please initialize index first");
			throw e;
		}
		return index;
	}
}

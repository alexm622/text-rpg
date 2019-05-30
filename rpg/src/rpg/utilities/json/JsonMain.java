package rpg.utilities.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import rpg.Main;
import rpg.game.Handler;
import rpg.utilities.json.classes.IndexHandler;
import rpg.utilities.json.classes.Index;
import rpg.utilities.json.classes.index.Path;

import com.fasterxml.jackson.core.*;

@SuppressWarnings("unused")
public class JsonMain {
	
	private Index index;
	private ObjectMapper om;

	public void Init() {
		this.om = new ObjectMapper();
		InitIndex();
		Handler.debug("the first indexed class is: " + index.getIndex()[0].getClas());
	}

	private void InitIndex() {
		IndexHandler indexh = new IndexHandler();
		indexh.init();
		this.index = new Index();
		try {
			this.index.setIndex(indexh.getIndex());
			Handler.ptdata = indexh.getIndex();
		} catch (Error e) {
			Handler.debug(e.toString(), true);
			e.printStackTrace();
		}

	}
	public String TypeToPath(String type) {
		String path;
		Path[] ptdata;
		ptdata = index.getIndex();
		boolean temp = false;
		for (int i = 0; i < ptdata.length; i++) {
			if (!(type.equals(ptdata[i].getType()))) {
				continue;
			} else {
				try {
					path = ptdata[i].getPath();
					return path;
				} catch (Exception e) {
					Handler.debug(e.toString(), true);
					e.printStackTrace();
				}
			}
		}
		throw new Error("could not find the path for type " + type);

	}

	public ObjectMapper getOm(){
		return this.om;
	}

	public File getFile(String path) throws URISyntaxException {
		File file;
		URL dir_url = ClassLoader.getSystemResource(path);
		file = new File(dir_url.toURI());
		return file;
		
	}

	
}

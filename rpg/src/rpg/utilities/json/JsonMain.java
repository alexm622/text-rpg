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
import rpg.objects.items.Armor;

import com.fasterxml.jackson.core.*;

@SuppressWarnings("unused")
public class JsonMain {
	private JsonReader Jr;
	private JsonWriter Jw;
	private Index index;
	private Handler h;

	public void Init(Handler h) {
		this.Jw = new JsonWriter();
		this.h = h;
		InitIndex();
		System.out.println(index.getIndex()[0].getClas());
	}

	private void InitIndex() {
		IndexHandler indexh = new IndexHandler();
		indexh.init(this.h);
		this.index = new Index();
		try {
			this.index.setIndex(indexh.getIndex());
			this.h.setPTdata(indexh.getIndex());
		} catch (Error e) {
			e.printStackTrace();
		}

	}

	public Class<?> Read(String type) {
		Class<?> c = TypeToClass(type);
		System.out.println(c.getName());
		String path = TypeToPath(type);
		System.out.println(path);
		this.Jr = new JsonReader(c, path);
		c = Jr.Read();
		return c;
	}

	private Class<?> TypeToClass(String type) {
		// find type in array of index
		Class<?> c;
		Path[] ptdata = h.getPTdata();
		System.out.println(type);
		System.out.println(ptdata[0].getType());
		System.out.println(type.equals(ptdata[0].getType()));
		for (int i = 0; i < ptdata.length; i++) {
			if (!(type.equals(ptdata[i].getType()))) {
				continue;
			} else {
				try {
					ClassLoader cl = new ClassLoader() {
					};
					c = cl.loadClass(ptdata[i].getClas());
					System.out.println("classloader");
					System.out.println(c.getName());
					System.out.println(c.getMethods()[1].getName());
					Class<?> clas = Class.forName(ptdata[i].getClas());
					System.out.println("for name");
					System.out.println(clas.getName());
					System.out.println(clas.getMethods()[1].getName());
					System.out.println("found it");
					return c;
				} catch (Exception e) {
					System.out.println("didn't find it");
					e.printStackTrace();
				}
			}
		}
		System.out.println("didn't find");
		throw new Error("could not find the class for type " + type);
	}

	private String TypeToPath(String type) {
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
					e.printStackTrace();
				}
			}
		}
		throw new Error("could not find the path for type " + type);

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
				System.out.println("error reading contents");
				e.printStackTrace();
			}
		} catch (URISyntaxException e1) {
			System.out.println("error with uri");
			e1.printStackTrace();
		}

	}

}

package rpg;

import rpg.game.Handler;
import rpg.guis.GraphicMain;

public class Main {
	public Handler h;

	public static void main(String[] args) {
		GraphicMain gm = new GraphicMain();
        Handler h = new Handler(gm);

	}



}

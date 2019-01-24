package rpg;

import rpg.game.Handler;
import rpg.guis.GraphicMain;

public class Main {
	private Handler h;

	public static void main(String[] args) {
		GraphicMain gm = new GraphicMain();
		Handler h = new Handler(gm);
	}

	public Handler getHandler() {
		return this.h;
	}

}

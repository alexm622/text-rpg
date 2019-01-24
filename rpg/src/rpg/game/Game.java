package rpg.game;

import rpg.guis.GraphicMain;

public class Game {
    private Handler h;
    private GraphicMain gm;
	Game() {
        gm = new GraphicMain();
        h = new Handler(gm);
        gm.main(null);
	}

	public void Begin() {
	}
}

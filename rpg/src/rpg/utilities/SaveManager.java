package rpg.utilities;

import java.io.File;

import rpg.game.Game;
import rpg.game.Handler;
import rpg.guis.GraphicMain;
import rpg.player.Player;

@SuppressWarnings("unused")
public class SaveManager {
	private File f = SaveFileReader.getF();
	private static Player player;
	private static String[] stats = new String[44];

	public void initSave() {
		player = GraphicMain.get_Handler().getP();
		stats = player.getStats();
		GraphicMain.get_Handler().getFm().Write(stats);
	}
}

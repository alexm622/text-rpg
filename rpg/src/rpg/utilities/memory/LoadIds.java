package rpg.utilities.memory;

import rpg.game.Handler;
import rpg.objects.Items;

public class LoadIds {

	public String[] Items(Items collectiveArmor) {
        String[] ids = new String[collectiveArmor.getItems().length];
        for(int i = 0; i < collectiveArmor.getItems().length; i++){
            ids[i] = collectiveArmor.getItems()[i].getId();
            Handler.debug("set" + i);
        }
        Handler.debug("returning");
		return ids;
	}
}
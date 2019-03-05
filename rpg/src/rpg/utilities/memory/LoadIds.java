package rpg.utilities.memory;

import rpg.objects.items.Armor;

public class LoadIds {

	public String[] Armor(Armor collectiveArmor) {
        String[] ids = new String[collectiveArmor.getItems().length];
        for(int i = 0; i < collectiveArmor.getItems().length; i++){
            ids[i] = collectiveArmor.getItems()[i].getId();
            System.out.println("set" + i);
        }
        System.out.println("returning");
		return ids;
	}
}
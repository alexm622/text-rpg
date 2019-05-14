package rpg.objects.story;

import rpg.objects.Item.Modifier;

public class LootTable {
    
    private String id;
    private String name;

    private Drop[] drops;


    public static class Drop{
        private String id;
        private String name;
        private int weight;
        private Modifier[] modifiers;
        private String lore;
        private boolean canSell;


    }

}
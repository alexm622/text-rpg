package rpg.objects.story;

import rpg.objects.Item;

public class StoryItems {
    private Items items[];

    public Items[] getItems(){
        return this.items;
    }

    public void setItems(Items[] items){
        this.items = items;
    }

    static class Items extends Item{
        
    }

}
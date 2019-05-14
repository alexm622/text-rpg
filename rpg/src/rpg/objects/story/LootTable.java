package rpg.objects.story;

import rpg.objects.Item.Modifier;

public class LootTable {
    
    private String id;
    private String name;

    private Drop[] drops;

    

    public void setId(String id){
        this.id = id;
    }
    
    public String getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setDrops(Drop[] drops) {
        this.drops = drops;
    }

    public Drop[] getDrops(){
        return this.drops;
    }



    public static class Drop{
        private String id;
        private String name;
        private int weight;
        private Modifier[] modifiers;
        private String lore;
        private boolean sellable = false;
        private int price;

        public void setId(String id){
            this.id = id;
        }

        public String getId(){
            return this.id;
        }

        public void setName(String name){
            this.name = name;
        }

        public String getName(){
            return this.name;
        }

        public void setWeight(int weight){
            this.weight = weight;
        }

        public int getWeight(){
            return this.weight;
        }

        public void setModifiers(Modifier[] modifiers){
            this.modifiers = modifiers;
        }

        public Modifier[] getModifiers(){
            return this.modifiers;
        }

        public void setLore(String lore){
            this.lore = lore;
        }

        public String getLore(){
            return this.lore;
        }

        public void setSellable(boolean sellable){
            this.sellable = sellable;
        }

        public boolean getSellable(){
            return this.sellable;
        }

        public void setPrice(int price){
            this.price = price;
        }

        public int getPrice(){
            return this.price;
        }
    }

}
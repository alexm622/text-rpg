package rpg.objects.places.town.buildings.shop.storefront;

import rpg.objects.Item;

public class ShopItem {
    private Item item;
    private int stock; //-1 for unlimited
    private int sell;
    private int buy;
    private int weight;
    private boolean willbuy;

    public boolean getWillbuy(){
        return this.willbuy;
    }

    public void setWillbuy(boolean willbuy){
        this.willbuy = willbuy;
    }

    public void setItem(Item item){
        this.item = item;
    }

    public Item getItem(){
        return this.item;
    }

    public int getStock(){
        return this.stock;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    public void setSell(int sell){
        this.sell = sell;
    }

    public void setBuy(int buy){
        this.buy = buy;
    }

    public int getSell(){
        return this.sell;
    }

    public int getBuy(){
        return this.buy;
    }

    public int getWeight(){
        return this.weight;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    
}
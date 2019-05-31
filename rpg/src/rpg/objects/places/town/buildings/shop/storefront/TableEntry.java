package rpg.objects.places.town.buildings.shop.storefront;

public class TableEntry {

    private String type;
    private String biome;

    private ShopItem[] items;

    public String getType(){
        return this.type;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setBiome(String biome){
        this.biome = biome;
    }

    public String getBiome(){
        return this.biome;
    }

    public void setItems(ShopItem[] items){
        this.items = items;
    }

    public ShopItem[] getItems(){
        return this.items;
    }




}
package rpg.objects.map;

import rpg.objects.TileEvent;

public class Tile {
    private String id;
    private String name;
    private String biomeId;
    
    private int difficulty;

    private String tableId;

    private TileEvent[] events;
    
    private String townId;

    private int icon; //ascii hex code

    private String bgColor; //rgb hex code
    private String iconColor; //rgb hex code

    private boolean cleared = false;

    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getBiomeId(){
        return this.biomeId;
    }

    public void setBiomeId(String biomeId){
        this.biomeId = biomeId;
    }

    public int getDifficulty(){
        return this.difficulty;
    }

    public void setDifficulty(int difficulty){
        this.difficulty = difficulty;
    }

    public String getTableId(){
        return this.tableId;
    }

    public void setTableId(String tableId){
        this.tableId = tableId;
    }

    public TileEvent[] getEvents(){
        return this.events;
    }

    public void setEvents(TileEvent[] eventId){
        this.events = eventId;
    }
    
    public String getTownId(){
	    return this.townId;
    }
    
    public void setTownId(String townId){
	    this.townId = townId;
    }

    public int getIcon(){
        return this.icon;
    }

    public void setIcon(int icon){
        this.icon = icon;
    }

    //iconColor
    //bgColor

    public String getBgColor(){
        return this.bgColor;
    }

    public void setBgColor(String bgColor){
        this.bgColor = bgColor;
    }

    public String getIconColor(){
        return this.iconColor;
    }

    public void setIconColor(String iconColor){
        this.iconColor =  iconColor;
    }

    public void setCleared(boolean cleared){
        this.cleared = cleared;
    }

    public boolean getCleared(){
        return this.cleared;
    }


    
}
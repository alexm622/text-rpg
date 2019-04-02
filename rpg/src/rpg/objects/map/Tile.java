package rpg.objects.map;

public class Tile {
    private String id;
    private String name;
    private String biomeId;
    
    private int difficulty;

    private String tableId;

    private String eventId;

    private char icon;

    private String bgColor;
    private String iconColor;

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

    public String getEventId(){
        return this.eventId;
    }

    public void setEventId(String eventId){
        this.eventId = eventId;
    }

    public char getIcon(){
        return this.icon;
    }

    public void setIcon(char icon){
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
        this.iconColor = iconColor;
    }


    
}
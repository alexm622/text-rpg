package rpg.objects;

public class StoryLine {
    private String name;
    private String desc;
    private String id;
    private String startingEventId;
    private String[] eventIds;
    private String[] armorIds;
    private String[] weaponIds;
    private String[] itemIds;

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDesc(){
        return this.desc;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }

    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getStartingEventId(){
        return this.startingEventId;
    }

    public void setStartingEventId(String startingEventId){
        this.startingEventId = startingEventId;
    }

    public String[] getEventIds(){
        return this.eventIds;
    }

    public void setEventIds(String[] eventIds){
        this.eventIds = eventIds;
    }

    public String[] getArmorIds(){
        return this.armorIds;
    }

    public void setArmorIds(String[] armorIds){
        this.armorIds = armorIds;
    }

    
    public String[] getWeaponIds(){
        return this.weaponIds;
    }

    public void setWeaponIds(String[] weaponIds){
        this.weaponIds = weaponIds;
    }

    public String[] getItemIds(){
        return this.itemIds;
    }

    public void setItemIds(String[] itemIds){
        this.itemIds = itemIds;
    }

    
}
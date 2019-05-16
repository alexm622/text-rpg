package rpg.objects.story;

import rpg.objects.Items;

public class StoryEvent{
	private String eventId;
	private String biomeId;
	private String tileid;
    private String name;
    private String desc;
	private String[] monsters;
	private int max;
	private int min;
    private int lvl;
    private int xp;
	private int gp;
	
	private Items loot;
	
	/**
	 * @return the eventId
	 */
	public String getEventId() {
		return eventId;
	}
	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getBiomeId(){
		return this.biomeId;
	}

	public void setBiomeId(String biomeId){
		this.biomeId = biomeId;
	}
	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * @return the monsters
	 */
	public String[] getMonsters() {
		return monsters;
	}
	/**
	 * @param monsters the monsters to set
	 */
	public void setMonsters(String[] monsters) {
		this.monsters = monsters;
	}

	public int getMax(){
		return this.max;
	}

	public int getMin(){
		return this.min;
	}

	public void setMax(int max){
		this.max = max;
	}

	public void setMinNum(int min){
		this.min = min;
	}

	/**
	 * @return the lvl
	 */
	public int getLvl() {
		return lvl;
	}
	/**
	 * @param lvl the lvl to set
	 */
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	/**
	 * @return the xp
	 */
	public int getXp() {
		return xp;
	}
	/**
	 * @param xp the xp to set
	 */
	public void setXp(int xp) {
		this.xp = xp;
	}
	/**
	 * @return the gp
	 */
	public int getGp() {
		return gp;
	}
	/**
	 * @param gp the gp to set
	 */
	public void setGp(int gp) {
		this.gp = gp;
	}
	
	public void setLoot(Items loot) {
		this.loot = loot;
	}
	
	public Items getLoot() {
		return this.loot;
	}

	public String getTileid(){
		return this.tileid;
	}

	public void setTileid(String tileid){
		this.tileid = tileid;
	}
}
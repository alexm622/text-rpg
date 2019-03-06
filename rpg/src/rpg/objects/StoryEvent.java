package rpg.objects;

import rpg.objects.items.loot.LootArmor;
import rpg.objects.items.loot.LootWeapon;

public class StoryEvent{
    private String eventId;
    private String name;
    private String desc;
    private Monster[] monsters;
    private int lvl;
    private int xp;
	private int gp;
	
	private LootArmor[] lootArmor;
	private LootWeapon[] lootWeapons;
	private String[] lootItems;
	
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
	public Monster[] getMonsters() {
		return monsters;
	}
	/**
	 * @param monsters the monsters to set
	 */
	public void setMonsters(Monster[] monsters) {
		this.monsters = monsters;
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
	
	public void setLootItems(String[] lootItems){
		this.lootItems = lootItems;
	}

	public void setLootArmor(LootArmor[] lootArmor){
		this.lootArmor = lootArmor;
	}

	public void setLootWeapons(LootWeapon[] lootWeapons){
		this.lootWeapons = lootWeapons;
	}

	public String[] getLootItems(){
		return this.lootItems;
	}

	public LootArmor[] getLootArmor(){
		return this.lootArmor;
	}

	public LootWeapon[] getLootWeapons(){
		return this.lootWeapons;
	}

}
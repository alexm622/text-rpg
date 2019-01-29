package rpg.objects;

import rpg.objects.items.*;


public class Character{
    private String name;
    private int lvl;
    private int stren, chari, intel, wis, dex, consti, prof;
    private int xp, gp;
    private Inventory inv;
    private Armor boots, pants, chest, helmet;
    private Weapon equipped;

    public Inventory getInv(){
        return this.inv;
    }

    public void setInv(Inventory inv){
        this.inv = inv;
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
	 * @return the stren
	 */
	public int getStren() {
		return stren;
	}
	/**
	 * @param stren the stren to set
	 */
	public void setStren(int stren) {
		this.stren = stren;
	}
	/**
	 * @return the chari
	 */
	public int getChari() {
		return chari;
	}
	/**
	 * @param chari the chari to set
	 */
	public void setChari(int chari) {
		this.chari = chari;
	}
	/**
	 * @return the intel
	 */
	public int getIntel() {
		return intel;
	}
	/**
	 * @param intel the intel to set
	 */
	public void setIntel(int intel) {
		this.intel = intel;
	}
	/**
	 * @return the wis
	 */
	public int getWis() {
		return wis;
	}
	/**
	 * @param wis the wis to set
	 */
	public void setWis(int wis) {
		this.wis = wis;
	}
	/**
	 * @return the dex
	 */
	public int getDex() {
		return dex;
	}
	/**
	 * @param dex the dex to set
	 */
	public void setDex(int dex) {
		this.dex = dex;
	}
	/**
	 * @return the consti
	 */
	public int getConsti() {
		return consti;
	}
	/**
	 * @param consti the consti to set
	 */
	public void setConsti(int consti) {
		this.consti = consti;
	}
	/**
	 * @return the prof
	 */
	public int getProf() {
		return prof;
	}
	/**
	 * @param prof the prof to set
	 */
	public void setProf(int prof) {
		this.prof = prof;
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

	/**
	 * @return the boots
	 */
	public Armor getBoots() {
		return boots;
	}

	/**
	 * @param boots the boots to set
	 */
	public void setBoots(Armor boots) {
		this.boots = boots;
	}

	/**
	 * @return the pants
	 */
	public Armor getPants() {
		return pants;
	}

	/**
	 * @param pants the pants to set
	 */
	public void setPants(Armor pants) {
		this.pants = pants;
	}

	/**
	 * @return the chest
	 */
	public Armor getChest() {
		return chest;
	}

	/**
	 * @param chest the chest to set
	 */
	public void setChest(Armor chest) {
		this.chest = chest;
	}

	/**
	 * @return the helmet
	 */
	public Armor getHelmet() {
		return helmet;
	}

	/**
	 * @param helmet the helmet to set
	 */
	public void setHelmet(Armor helmet) {
		this.helmet = helmet;
	}

	/**
	 * @return the equipped
	 */
	public Weapon getEquipped() {
		return equipped;
	}

	/**
	 * @param equipped the equipped to set
	 */
	public void setEquipped(Weapon equipped) {
		this.equipped = equipped;
	}
    


}
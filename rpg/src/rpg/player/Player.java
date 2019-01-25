package rpg.player;

public class Player {
	public int xp; //cp
	public int gp; //gold
	public String name; //player name
	public int hp; //name
	public int lvl;
	//public Inventory inventory;
	/*
	 * strength
	 * charisma
	 * intelligence
	 * wisdom
	 * dexterity
	 * constitution
	 * proficiency
	 *
	 */
	public int stren, chari, intel, wis;
	public int dex;
	public int consti;
	public int prof;
	public int armor;
	private Object[] localstats = {xp, gp, lvl, stren, chari, intel, wis, dex, consti};
	public String[] stats = new String[44];
	public void Create(String x) { //TODO make this accept an array soon, so that the selection of starting gear/class and stats
		name = x;
		stats[0] = x;
		return;
	}

	public void initStats(String[] s) {
		if(s.length != 7) {
			System.out.println("error");
		}else {
			stats = s;
			System.out.println("got stats properly");
			boolean temp = setStats(); //locally store stats in memory
			if(temp) {
				System.out.println("properly set stats");
			}else if(!temp) {
				System.out.println("failed to set stats");
			}else {
				System.out.println("how was this fucked up??");
			}
		}

	}


	private boolean setStats() {
		boolean x = false;
		for(int i = 0; i < 6; i++) {
			if(i == 0) {
				name = stats[i];
			}else {
				try {
					localstats[i-1] = Integer.parseInt(stats[i]);
				}catch(Exception e) {
					System.out.println("why does stats entry " + i + " have a non-numeric Character?");
					x = true;
					break;
				}

			}
		}
		if(x) {
			x = false;
			System.out.println("error");
		}else {
			x = true;
		}
		return x;
	}

	//getters and setters
	public float getXp() {
		return xp;
	}
	public void setXp(int xp) {
		this.xp = xp;
	}
	public int getGp() {
		return gp;
	}
	public void setGp(int gp) {
		this.gp = gp;
	}
	public String getName() {
		return name;
	}
	public void setName(String n) {
		name = n;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getStren() {
		return stren;
	}
	public void setStren(int stren) {
		this.stren = stren;
	}
	public int getChari() {
		return chari;
	}
	public void setChari(int chari) {
		this.chari = chari;
	}
	public int getIntel() {
		return intel;
	}
	public void setIntel(int intel) {
		this.intel = intel;
	}
	public int getWis() {
		return wis;
	}
	public void setWis(int wis) {
		this.wis = wis;
	}
	public int getDex() {
		return dex;
	}
	public void setDex(int dex) {
		this.dex = dex;
	}
	public int getConsti() {
		return consti;
	}
	public void setConsti(int consti) {
		this.consti = consti;
	}
	public int getProf() {
		return prof;
	}
	public void setProf(int prof) {
		this.prof = prof;
	}
	public int getArmor() {
		return armor;
	}
	public void setArmor(int armor) {
		this.armor = armor;
	}
	public String[] getStats() {
		return stats;
	}



}

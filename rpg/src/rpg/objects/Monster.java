package rpg.objects;

import rpg.objects.Action;

public abstract class Monster {
    private int hp;
    private int xp;
    private int lvl;
    private Action[] actions;
    private String name;
    private String id;
    private Dialogue dialogue;
    private int[] stats; // charisma, constitution, dexterity, intellegence, strength, wisdom

    public int getHp() {
        return this.hp;
    }

    public int getXp() {
        return this.xp;
    }

    public int getLvl() {
        return this.lvl;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public Action[] getAttack() {
        return this.actions;
    }

    public void setAttacks(Action[] attacks) {
        this.actions = attacks;
    }
}
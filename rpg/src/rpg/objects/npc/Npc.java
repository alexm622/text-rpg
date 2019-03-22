package rpg.objects.npc;

import rpg.objects.combat.Action;

public class Npc {
    private int hp;
    private int xp;
    private int lvl;
    private Action[] actions;
    private String name;
    private String id;
    private String startdia;
    private Dialogue dialogue;
    private int[] stats; // charisma, constitution, dexterity, intellegence, strength, wisdom


    public String getStartdia(){
        return this.startdia;
    }

    public void setStartdia(String startdia){
        this.startdia = startdia;
    }

    
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id =id;
    }

    public Dialogue getDialogue(){
        return this.dialogue;
    }

    public void setDialogue(Dialogue dialogue){
        this.dialogue = dialogue;
    }

    public int[] getStats(){
        return this.stats;
    }

    public void setStats(int[] stats){
        this.stats = stats;
    }

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

    public Action[] getActions() {
        return this.actions;
    }

    public void setActions(Action[] actions) {
        this.actions = actions;
    }

}
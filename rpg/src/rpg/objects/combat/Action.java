package rpg.objects.combat;

public abstract class Action {
    private String name;
    private String desc;
    private String dmg;
    private String[] hitdialogue;
    private String[] missdialogue;
    private String[] critdialogue;
    private String hitmod;
    private String damagetype;
    private String dmgmod;
    private String tohit;
    private String id;
    private String range;

    //TODO this throws an error

    public String getRange(){
        return this.range;
    }

    public void setRange(String range){
        this.range = range;
    }

    public String[] getHitdialogue() {
        return this.hitdialogue;
    }

    public void setHitdialogue(String[] hitdialogue) {
        this.hitdialogue = hitdialogue;
    }

    public String[] getMissdialoge() {
        return this.missdialogue;
    }

    public void setMissdialogue(String[] missdialogue) {
        this.missdialogue = missdialogue;
    }

    public String[] getCritdialogue() {
        return this.critdialogue;
    }

    public void setCritdialogue(String[] critdialogue) {
        this.critdialogue = critdialogue;
    }

    public String getHitmod() {
        return this.hitmod;
    }

    public void setHitmod(String hitmod) {
        this.hitmod = hitmod;
    }

    public String getDamagetype() {
        return this.damagetype;
    }

    public void setDamagetype(String damagetype) {
        this.damagetype = damagetype;
    }

    public String getDmgmod() {
        return this.dmgmod;
    }

    public void setDmgmod(String dmgmod) {
        this.dmgmod = dmgmod;
    }

    public String getTohit() {
        return this.tohit;
    }

    public void setTohit(String tohit) {
        this.tohit = tohit;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDie(String die) {
        this.dmg = die;
    }

    public String getDie() {
        return this.dmg;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDmg(){
        return this.dmg;
    }

    public void setDmg(String dmg){
        this.dmg = dmg;
    }
}
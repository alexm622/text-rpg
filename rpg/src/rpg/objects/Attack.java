package rpg.objects;

public class Attack{
    private String name;
    private String desc;
    private int dienum;
    private int dietype;
    private String die;

    public void setDie(String die) {
        this.die = die;
        SplitToDie(die);
    }

    private void SplitToDie(String die) {
        String s = die;
        String[] ss = s.split("d", 2);
        this.dienum = Integer.parseInt(ss[0]);
        this.dietype = Integer.parseInt(ss[1]);
    }

    public String getDie() {
        return this.die;
    }

    public int getDienum() {
        return dienum;
    }

    public void setDienum(int dienum) {
        this.dienum = dienum;
    }

    public int getDietype() {
        return dietype;
    }

    public void setDietype(int dietype) {
        this.dietype = dietype;
    }

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
}
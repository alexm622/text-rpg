package rpg.objects;

public abstract class Monster{
    private int hp;
    private int xp;
    private int lvl;
    private Attack[] attacks;

    public static class Attack extends rpg.objects.Attack{

    }

    public int getHp(){
        return this.hp;
    }

    public int getXp(){
        return this.xp;
    }

    public int getLvl(){
        return this.lvl;
    }

    public void setHp(int hp){
        this.hp = hp;
    }

    public void setXp(int xp){
        this.xp = xp;
    }

    public void setLvl(int lvl){
        this.lvl = lvl;
    }

    public Attack[] getAttack(){
        return this.attacks;
    }

    public void setAttacks(Attack[] attacks){
        this.attacks = attacks;
    }
}
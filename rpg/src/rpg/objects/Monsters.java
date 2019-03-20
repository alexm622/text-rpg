package rpg.objects;

public class Monsters {
    private Mon[] monsters;

    public void setMonsters(Mon[] monsters){
        this.monsters = monsters;
    }

    public Mon[] getMonsters(){
        return this.monsters;
    }

    public static class Mon extends Monster{

    }
}
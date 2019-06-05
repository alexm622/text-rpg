package rpg.objects;

public class TileEvent {

    //pos

    private int x, y;

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    //event id
    private String id;

    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }

    //count
    private int num;

    public int getNum(){
        return this.num;
    }

    public void setNum(int num){
        this.num = num;
    }

    //req env vars

    private String[] reqVar;
    private Object[] reqVal;

    public String[] getReqVar(){
        return this.reqVar;
    }

    public Object[] getReqVal(){
        return this.reqVal;
    }

    public void setReqVar(String[] reqVar){
        this.reqVar = reqVar;
    }

    public void setReqVal(Object[] reqVal){
        this.reqVal = reqVal;
    }



    //reqLvl

    private int minLvl, maxLvl;

    public int getMinLvl(){
        return this.minLvl;
    }

    public int getMaxLvl(){
        return this.maxLvl;
    }

    public void setMaxLvl(int maxLvl){
        this.maxLvl = maxLvl;
    }

    public void setMinLvl(int minLvl){
        this.minLvl = minLvl;
    }

    //is unlocked/ cleared

    private boolean unlocked, cleared;

    public boolean getUnlocked(){
        return this.unlocked;
    }

    public boolean getCleared(){
        return this.cleared;
    }

    public void setUnlocked(boolean unlocked){
        this.unlocked = unlocked;
    }

    public void setCleared(boolean cleared){
        this.cleared = cleared;
    }

}
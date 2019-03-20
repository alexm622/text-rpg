package rpg.objects;

public abstract class Dialogue {
    private String op1;
    private String op2;
    private String op3;
    private String op4;
    private Dialogues[] results;

    public String getOp1() {
        return this.op1;
    }

    public void setOp1(String op1) {
        this.op1 = op1;
    }

    public String getOp2() {
        return this.op2;
    }

    public void setOp2(String op2) {
        this.op2 = op2;
    }

    public String getOp3() {
        return this.op3;
    }

    public void setOp3(String op3) {
        this.op3 = op3;
    }

    public String getOp4() {
        return this.op4;
    }

    public void setOp4(String op4) {
        this.op4 = op4;
    }

    public Dialogues[] getResults() {
        return this.results;
    }

    public void setResults(Dialogues[] results) {
        this.results = results;
    }

    public static class Dialogues extends Dialogue{

    }
}
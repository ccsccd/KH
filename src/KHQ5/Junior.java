package KHQ5;

public class Junior {
    private String name;
    private int stuid;
    int score=0;
    private Good[] good=new Good[100];

    public Good[] getGood() {
        return good;
    }

    public void setGood(Good[] good) {
        this.good = good;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }
}

package KHQ5;

public class Senior {
    private String name;
    private int stuid;

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
    public void addScore(Junior junior,int add){
        junior.score+=add;
    }
}

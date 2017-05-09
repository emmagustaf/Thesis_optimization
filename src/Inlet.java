
public class Inlet {
    private double level;
    private String id;
    private int fraction; //fraction 1 = rest, 2 = plastic, 3 = paper

    public Inlet(String id, double level, int fraction) {
        this.id = id;
        this.level = level;
        this.fraction = fraction;
    }


    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFraction() {
        return fraction;
    }

    public void setFraction(int fraction) {
        this.fraction = fraction;
    }
}

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inlet {
    private double level;
    private String id;
    private int fraction; //fraction 1 = rest, 2 = plastic, 3 = paper
    private Map<DayOfWeek,List<List<Disposal>>> disposals;

    public Inlet(String id, double level, int fraction) {
        this.id = id;
        this.level = level;
        this.fraction = fraction;
        this.disposals = new HashMap<>();
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

    public Map<DayOfWeek, List<List<Disposal>>> getDisposals() {
        return disposals;
    }

    public void setDisposals(Map<DayOfWeek, List<List<Disposal>>> disposals) {
        this.disposals = disposals;
    }
}


public class Inlet {
    private int level;
    private int id;

    public Inlet(int id, int level) {
        this.id = id;
        this.level = level;
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

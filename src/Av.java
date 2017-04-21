import java.util.ArrayList;
import java.util.List;

public class Av {
    private List<Inlet> inlets = new ArrayList<>();

    public Av(List inlets){
        this.inlets = inlets;
    }


    public List<Inlet> getInlets() {
        return inlets;
    }

    public void setInlets(List<Inlet> inlets) {
        this.inlets = inlets;
    }
}

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LevelHandler {

    private Map <String,List<Disposal>> disposals = new HashMap();
    private final static int BAG_CONVERTER = 8;
    private final static double MAX_BAGS = 188.5/8;
    private final static double MAX_VOLUME = 188.5;
    private final static double BELOW_LEVEL = 0.6;

    public void updateLevels(){
        double addedVolume = 0;
        double newLevel = 0;
        double oldLevel = 0;

        for (String id : disposals.keySet()) {
            oldLevel = SystemSetup.getLevel(id);
            addedVolume = (disposals.get(id).size() * BAG_CONVERTER)/MAX_BAGS;
            newLevel = addedVolume + oldLevel;

            if(newLevel >= BELOW_LEVEL){
                triggerEmptying(id);
            }else if (addedVolume != 0 ){
                SystemSetup.levelUpdate(id, newLevel);
            }
        }
    }

    // TODO : Gör denna funktion!
    public void triggerEmptying(String id){

    }


}

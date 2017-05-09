import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LevelHandler {

    private static Map <String,List<Disposal>> disposals = new HashMap();

    public static void updateLevels(){
        int addedVolume = 0;
        int newVolume = 0;

        for (String id : disposals.keySet()) {
            addedVolume = disposals.get(id).size() * 8;
            if (addedVolume != 0){
                newVolume = addedVolume + SystemSetup.getLevel(id);
                SystemSetup.levelUpdate(id, newVolume);
            }
        }
    }


}

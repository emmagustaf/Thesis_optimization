import java.util.List;
import java.util.Map;

public class LevelHandler {

    private final static int BAG_CONVERTER = 8;
    private final static double MAX_VOLUME = 188.5;
    private final static double MAX_BAGS = MAX_VOLUME/BAG_CONVERTER;
    public final static double MAX_LEVEL = 0.6;

    public static void updateLevels(Map<String,List<Disposal>> disposals) {
        double addedVolume;
        double newLevel;
        double oldLevel;

        for (String inletID : disposals.keySet()) {
            if (SystemSetup.inletsMap.get(inletID) == null) {
                //Main.output.add("ID: " + inletID);
                //System.out.println("ID: " + inletID);
            } else {
                oldLevel = SystemSetup.getLevel(inletID);
                addedVolume = (disposals.get(inletID).size() * BAG_CONVERTER) / MAX_VOLUME;
                newLevel = addedVolume + oldLevel;

                if (newLevel >= MAX_LEVEL) {
                    Main.output.add("Level of: " + newLevel + " triggered by: " + inletID + ", fraction: " + SystemSetup.inletsMap.get(inletID).getFraction());
                    //System.out.println("Level of: " + newLevel + " triggered by: " + inletID);
                    SystemSetup.levelUpdate(inletID, newLevel);
                    triggerEmptying(inletID);
                } else if (addedVolume != 0) {
                    SystemSetup.levelUpdate(inletID, newLevel);
                }

            }
        }
    }

    // TODO : Gör denna funktion!
    private static void triggerEmptying(String id){

    }


}

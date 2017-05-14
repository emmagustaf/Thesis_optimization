import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LevelHandler {

    private final static int RESIDUAL_DISPOSAL = 8;
    private final static int PLASTIC_DISPOSAL = 8;
    private final static int PAPER_DISPOSAL = 8;
    public static int bagConverter = 8;

    public final static double MAX_VOLUME = 188.5;
    public final static double MAX_LEVEL = 0.8;
    public final static double MIN_EMPTY_LEVEL = 0.5;

    public static List<Integer> updateLevels(Map<String,List<Disposal>> disposals) {
        double addedVolume, newLevel, oldLevel;
        int fraction;
        List<Integer> fractionsToEmpty = new ArrayList<>();

        for (String inletID : disposals.keySet()) {
            if (SystemSetup.inletsMap.get(inletID) == null) {
                //Main.output.add("ID: " + inletID);
                //System.out.println("ID: " + inletID);
            } else {
                fraction = SystemSetup.inletsMap.get(inletID).getFraction();
                bagConverter = fraction == 1 ? RESIDUAL_DISPOSAL : fraction == 2 ? PLASTIC_DISPOSAL : PAPER_DISPOSAL;
                oldLevel = SystemSetup.getLevel(inletID);
                addedVolume = (disposals.get(inletID).size() * bagConverter) / MAX_VOLUME;
                newLevel = addedVolume + oldLevel;

                if (newLevel >= MAX_LEVEL) {
                    Main.output.add("Level of: " + newLevel + " triggered by: " + inletID + ", fraction: " + SystemSetup.inletsMap.get(inletID).getFraction());
                    //System.out.println("Level of: " + newLevel + " triggered by: " + inletID);
                    SystemSetup.levelUpdate(inletID, newLevel);
                    if (newLevel >= 1) { // && !Main.overLimit.contains(inletID)
                        Main.overLimit.add(inletID);
                    }

                    if (!fractionsToEmpty.contains(fraction)) {
                        fractionsToEmpty.add(fraction);
                    }
                } else if (addedVolume != 0) {
                    SystemSetup.levelUpdate(inletID, newLevel);
                }

            }
        }

        return fractionsToEmpty;
    }

    // TODO : Gör denna funktion!
    private static void triggerEmptying(String id){

    }


}

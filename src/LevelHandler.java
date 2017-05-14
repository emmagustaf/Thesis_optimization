import java.util.*;

public class LevelHandler {

    private final static int RESIDUAL_DISPOSAL = 8;
    private final static int PLASTIC_DISPOSAL = 8;
    private final static int PAPER_DISPOSAL = 8;
    public static int bagConverter = 8;

    public final static double MAX_VOLUME = 188.5;
    public final static double MAX_LEVEL = 0.8;
    public final static double MIN_EMPTY_LEVEL = 0.5;

    public static List<String> inletsToEmpty = new ArrayList<>();

    public static List<String> updateLevels(Map<String,List<Disposal>> disposals) {
        double addedVolume, newLevel, oldLevel;
        int fraction;
        List<String> inletsWithMaxLevel = new ArrayList<>();

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
                    Main.output.add("Level of: " + newLevel + ", triggered by: " + inletID + ", fraction: " + SystemSetup.inletsMap.get(inletID).getFraction());

                    //System.out.println("Level of: " + newLevel + " triggered by: " + inletID);
                    SystemSetup.levelUpdate(inletID, newLevel);
                    if (newLevel >= 1) { // && !Main.overLimit.contains(inletID)
                        Main.overLimit.add(inletID);
                    }

                    inletsWithMaxLevel.add(inletID);
                } else if (addedVolume != 0) {
                    SystemSetup.levelUpdate(inletID, newLevel);
                }

            }
        }

        return inletsWithMaxLevel;
    }

    /*
     * Sets all the inlets which should be emptied and returns the fractions they belong to.
     */
    public static List<Integer> setInletsToEmpty(List<String> inletsWithMaxLevel) {
        inletsToEmpty = new ArrayList<>();

        List<Integer> firstFractionsToEmpty = new ArrayList<>();
        List<Integer> fractionsToEmpty = new ArrayList<>();

        List<String> fraction1 = new ArrayList<>();
        List<String> fraction2 = new ArrayList<>();
        List<String> fraction3 = new ArrayList<>();
        Map<Integer,List<String>> inletsOver50 = new HashMap<>();
        inletsOver50.put(1, fraction1);
        inletsOver50.put(2, fraction2);
        inletsOver50.put(3, fraction3);

        Boolean[] fractionAdded = {false, false, false};

        for (String inletID : inletsWithMaxLevel) {
            int fraction = SystemSetup.inletsMap.get(inletID).getFraction();

            inletsToEmpty.add(inletID); // TODO REMOVE

            if (!firstFractionsToEmpty.contains(fraction)) {
                firstFractionsToEmpty.add(fraction);
            }
        }

        fractionsToEmpty.addAll(firstFractionsToEmpty);

        /*for (String inletID : SystemSetup.inletsMap.keySet()) {
            double level = SystemSetup.getLevel(inletID);
            double disposalAverage = Statistics.averageNbrOfdisposals(inletID, Main.currentEndTime, Main.currentEndTime.plusMinutes(60));
            double addedLevel = (disposalAverage * LevelHandler.bagConverter) / LevelHandler.MAX_VOLUME;
            double possibleLevel = level + addedLevel;
            int fraction = SystemSetup.inletsMap.get(inletID).getFraction();

            if (level >= MIN_EMPTY_LEVEL || possibleLevel > LevelHandler.MAX_LEVEL) {

                if (fractionsToEmpty.contains(fraction)) {
                    Main.output.add("Level of: " + level + " by: " + inletID + ", same fraction: " + SystemSetup.inletsMap.get(inletID).getFraction());
                    inletsToEmpty.add(inletID);
                } else {
                    if (possibleLevel > LevelHandler.MAX_LEVEL) {
                        Main.output.add("Level of: " + level + " and possible level of: " + possibleLevel + " by: " + inletID + ", will empty fraction: " + SystemSetup.inletsMap.get(inletID).getFraction());
                        inletsToEmpty.add(inletID);
                        fractionsToEmpty.add(fraction);
                        fractionAdded[fraction-1] = true;
                    } else {
                        Main.output.add("Level of: " + level + " by: " + inletID + ", added to fraction: " + SystemSetup.inletsMap.get(inletID).getFraction());
                        switch (fraction) {
                            case 1: fraction1.add(inletID);
                                    break;
                            case 2: fraction2.add(inletID);
                                    break;
                            case 3: fraction3.add(inletID);
                                    break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            if (fractionAdded[i]) {
                Main.output.add("Number of inlets over 50: " + inletsOver50.get(i+1).size() + " in fraction: " + (i+1));
                inletsToEmpty.addAll(inletsOver50.get(i+1));
            }
        }*/

        Main.output.add("Fractions to empty: " + fractionsToEmpty.size());
        return fractionsToEmpty;
    }

    // TODO : Gör denna funktion!
    private static void triggerEmptying(String id){

    }


}

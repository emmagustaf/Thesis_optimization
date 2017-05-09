/*import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Setup {

    // variable to convert map scale to real length
    private final double METER_CONVERSION = 0.05;

    public static Junction rootNode;

    public Junction J1, J2, J3, J4, J5, J6, J7, J8, J9, J10, J11, J12, J13, J14, J15, J16,
            J17, J18, J19, J20, J21, J22, J23, J24, J25, J26, J27, J28, J29, J30, J31, J32, J33, J34,
            J35, J36, J37, J38, J39, J40, J41, J42, J43, J44, J45, J46, J47, J48, J49, J50, J51, J52, J53;

    private AV AV3, AV4, AV5, AV6, AV7, AV8, AV9, AV10, AV11, AV12, AV13, AV14, AV15, AV16, AV17, AV18, AV19, AV20, AV21, AV22, AV23, AV24, AV25;

    public Map<String,Inlet> inlets;
    public Map<String,InletCluster> inletClusters;
    public Map<String,AV> avs;
    public Map<String,Junction> junctions;

    public Inlet I3_1, I3_2, I3_3, I3_4, I3_5, I3_6, I3_7, I3_8, I3_18, I3_19, I3_20,
            I4_1, I4_2, I4_3, I4_4, I5_1, I5_2, I5_3, I5_4, I5_5,
            I6_1, I6_2, I6_3, I6_4, I6_5, I6_6, I6_7, I6_8, I6_9, I6_10, I6_11, I6_12, I6_13, I6_14, I6_15,
            I6_16, I6_17, I6_18, I7_1, I7_2, I7_3, I7_4, I7_5, I7_6, I7_7, I7_8, I7_9, I7_10, I7_11, I7_12, I8_1, I8_2,
            I8_3, I8_4, I8_5, I8_6, I8_7, I8_8, I8_9, I9_3, I10_1, I10_2, I10_3, I10_4,I10_5, I10_6, I10_7, I11_1, I11_2, I11_3,
            I11_4, I11_5, I11_6, I11_7, I11_8, I11_9, I11_10, I12_1, I12_2, I12_3, I12_4, I12_5, I13_1, I13_2, I13_3, I14_1,
            I14_2, I14_3, I14_4, I14_5, I14_6, I14_7, I14_8, I14_9, I14_10, I14_11, I14_12, I14_13, I15_1, I15_2, I15_3, I15_4,
            I15_5, I15_16, I16_1, I16_2, I16_3, I16_4, I16_5, I16_6, I16_7, I16_8, I16_9,
            I16_10, I16_11, I17_1, I17_2, I17_3, I17_4, I17_5, I17_6, I17_7, I17_8, I17_9, I18_1,
            I18_2, I18_3, I18_4, I18_5, I18_6, I18_7, I18_8, I18_9, I18_10, I19_1, I19_2, I19_3, I20_1, I20_2, I20_3,
            I21_1, I21_2, I21_3, I21_4, I21_5, I21_6, I21_7, I21_8, I21_9, I21_10, I21_11, I21_12, I21_13, I21_14,
            I21_15, I22_1, I22_2, I22_3, I23_1, I23_2, I23_3, I23_4, I23_5, I23_6, I23_7, I24_1, I24_2, I24_3, I24_4, I25_1, I25_2, I25_3;

    private List<String> inletList3_1, inletList3_2, inletList3_3, inletList4, inletList5, inletList6_1, inletList6_2,
            inletList6_3, inletList6_4, inletList7_1, inletList7_2, inletList7_3, inletList7_4, inletList8_1,
            inletList8_2, inletList8_3, inletList8_4, inletList8_5, inletList8_6, inletList9, inletList10_1, inletList10_2,
            inletList10_3, inletList10_4, inletList11, inletList12_1, inletList12_2, inletList12_3, inletList13,
            inletList14_1, inletList14_2, inletList15_1, inletList15_2, inletList15_3, inletList16_1, inletList16_2,
            inletList17_1, inletList17_2, inletList17_3, inletList17_4, inletList18_1,
            inletList18_2, inletList18_3, inletList19, inletList20, inletList21_1, inletList21_2, inletList21_3, inletList21_4, inletList22,
            inletList23_1, inletList23_2, inletList24, inletList25;

    private InletCluster inletCluster3_1, inletCluster3_2, inletCluster3_3, inletCluster4, inletCluster5, inletCluster6_1,
            inletCluster6_2, inletCluster6_3, inletCluster6_4, inletCluster7_1, inletCluster7_2, inletCluster7_3, inletCluster7_4,
            inletCluster8_1, inletCluster8_2, inletCluster8_3, inletCluster8_4, inletCluster8_5, inletCluster8_6,
            inletCluster9, inletCluster10_1, inletCluster10_2, inletCluster10_3, inletCluster10_4, inletCluster11, inletCluster12_1, inletCluster12_2, inletCluster12_3,
            inletCluster13, inletCluster14_1, inletCluster14_2, inletCluster15_1, inletCluster15_2, inletCluster15_3, inletCluster16_1, inletCluster16_2,
            inletCluster17_1, inletCluster17_2, inletCluster17_3, inletCluster17_4, inletCluster18_1, inletCluster18_2, inletCluster18_3,
            inletCluster19, inletCluster20, inletCluster21_1, inletCluster21_2,
            inletCluster21_3,inletCluster21_4, inletCluster22, inletCluster23_1, inletCluster23_2,
            inletCluster24, inletCluster25;

    public Setup(){

        instantiateAllInlets();
        instantiateAllInletLists();
        instantiateAllJunctions();
        instantiateAllInletClusters();
        instantiateAllAv();
        setChildren();
        setJunctionDepth(rootNode);

    }
    public static void levelUpdate(String id, int newLevel){


    }

    public static int getLevel(String id) {
        return 1;
    }

    public void instantiateAllInlets(){
        inlets.put("3:1",new Inlet("3:1",0,3));
        inlets.put("3:2",new Inlet("3:2",0,2));
        inlets.put("3:3",new Inlet("3:3",0,2));
        inlets.put("3:4",new Inlet("3:4",0,1));
        inlets.put("3:5",new Inlet("3:5",0,1));
        inlets.put("3:6",new Inlet("3:6",0,3));
        inlets.put("3:7",new Inlet("3:7",0,2));
        inlets.put("3:8",new Inlet("3:8",0,2));
        inlets.put("3:18",new Inlet("3:18",0,3));
        inlets.put("3:19",new Inlet("3:19",0,1));
        inlets.put("3:20",new Inlet("3:20",0,1));

        inlets.put("4:1",new Inlet("4:1",0,1));

       inlets.put("4:2",new Inlet("4:2",0,2));
       inlets.put("4:3",new Inlet("4:3",0,1));
       inlets.put("4:4",new Inlet("4:4",0,3));
       inlets.put("5:1",new Inlet("5:1",0,1));
       inlets.put("5:2",new Inlet("5:2",0,1));
       inlets.put("5:3",new Inlet("5:3",0,2));
       inlets.put("5:4",new Inlet("5:4",0,2));
       inlets.put("5:5",new Inlet("5:5",0,3));

       inlets.put("6:1",new Inlet("6:1",0,3));
       inlets.put("6:2",new Inlet("6:2",0,2));
       inlets.put("6:3",new Inlet("6:3",0,2));
       inlets.put("6:4",new Inlet("6:4",0,1));
       inlets.put("6:5",new Inlet("6:5",0,1));
       inlets.put("6:6",new Inlet("6:6",0,3));
       inlets.put("6:7",new Inlet("6:7",0,2));
       inlets.put("6:8",new Inlet("6:8",0,1));
       inlets.put("6:9",new Inlet("6:9",0,1));
       inlets.put("6:10",new Inlet("6:10",0,1));
       inlets.put("6:11",new Inlet("6:11",0,3));
       inlets.put("6:12",new Inlet("6:12",0,2));
       inlets.put("6:13",new Inlet("6:13",0,2));
       inlets.put("6:14",new Inlet("6:14",0,1));
       inlets.put("6:15",new Inlet("6:15",0,1));
       inlets.put("6:16",new Inlet("6:16",0,3));
       inlets.put("6:17",new Inlet("6:17",0,2));
       inlets.put("6:18",new Inlet("6:18",0,1));

       inlets.put("7:1",new Inlet("7:1",0,1));
       inlets.put("7:2",new Inlet("7:2",0,2));
       inlets.put("7:3",new Inlet("7:3",0,3));
       inlets.put("7:4",new Inlet("7:4",0,1));
       inlets.put("7:5",new Inlet("7:5",0,1));
       inlets.put("7:6",new Inlet("7:6",0,1));
       inlets.put("7:7",new Inlet("7:7",0,2));
       inlets.put("7:8",new Inlet("7:8",0,2));
       inlets.put("7:9",new Inlet("7:9",0,3));
       inlets.put("7:10",new Inlet("7:10",0,3));
       inlets.put("7:11",new Inlet("7:11",0,1));
       inlets.put("7:12",new Inlet("7:12",0,1));

       inlets.put("8:1",new Inlet("8:1",0,3));
       inlets.put("8:2",new Inlet("8:2",0,2));
       inlets.put("8:3",new Inlet("8:3",0,1));
       inlets.put("8:4",new Inlet("8:4",0,1));
       inlets.put("8:5",new Inlet("8:5",0,1));
       inlets.put("8:6",new Inlet("8:6",0,1));
       inlets.put("8:7",new Inlet("8:7",0,1));
       inlets.put("8:8",new Inlet("8:8",0,1));
       inlets.put("8:9",new Inlet("8:9",0,1));

       inlets.put("9:3",new Inlet("9:3",0, 1));

       inlets.put("10:1",new Inlet("10:1",0,3));
       inlets.put("10:2",new Inlet("10:2",0,2));
       inlets.put("10:3",new Inlet("10:3",0,1));
       inlets.put("10:4",new Inlet("10:4",0,1));
       inlets.put("10:5",new Inlet("10:5",0,1));
       inlets.put("10:6",new Inlet("10:6",0,1));
       inlets.put("10:7",new Inlet("10:7",0,1));

       inlets.put("11:1",new Inlet("11:1",0,2));
       inlets.put("11:2",new Inlet("11:2",0,2));
       inlets.put("11:3",new Inlet("11:3",0,2));
       inlets.put("11:4",new Inlet("11:4",0,1));
       inlets.put("11:5",new Inlet("11:5",0,1));
       inlets.put("11:6",new Inlet("11:6",0,3));
       inlets.put("11:7",new Inlet("11:7",0,3));
       inlets.put("11:8",new Inlet("11:8",0,3));
       inlets.put("11:9",new Inlet("11:9",0,1));
       inlets.put("11:10",new Inlet("11:10",0,1));

       inlets.put("12:1",new Inlet("12:1",0,3));
       inlets.put("12:2",new Inlet("12:2",0,2));
       inlets.put("12:3",new Inlet("12:3",0,1));
       inlets.put("12:4",new Inlet("12:4",0,1));
       inlets.put("12:5",new Inlet("12:5",0,1));

       inlets.put("13:1",new Inlet("13:1",0,3));
       inlets.put("13:2",new Inlet("13:2",0,2));
       inlets.put("13:3",new Inlet("13:3",0,1));

       inlets.put("14:1",new Inlet("14:1",0,1));
       inlets.put("14:2",new Inlet("14:2",0,1));
       inlets.put("14:3",new Inlet("14:3",0,1));
       inlets.put("14:4",new Inlet("14:4",0,1));
       inlets.put("14:5",new Inlet("14:5",0,1));
       inlets.put("14:6",new Inlet("14:6",0,1));
       inlets.put("14:7",new Inlet("14:7",0,2));
       inlets.put("14:8",new Inlet("14:8",0,2));
       inlets.put("14:9",new Inlet("14:9",0,2));
       inlets.put("14:10",new Inlet("14:10",0,2));
       inlets.put("14:11",new Inlet("14:11",0,3));
       inlets.put("14:12",new Inlet("14:12",0,3));
       inlets.put("14:13",new Inlet("14:13",0,3));

       inlets.put("15:1",new Inlet("15:1",0,1));
       inlets.put("15:2",new Inlet("15:2",0,1));
       inlets.put("15:3",new Inlet("15:3",0,2));
       inlets.put("15:4",new Inlet("15:4",0,3));
       inlets.put("15:5",new Inlet("15:5",0,1));
       inlets.put("15:16",new Inlet("15:16",0,1));

       inlets.put("16:1",new Inlet("16:1",0,3));
       inlets.put("16:2",new Inlet("16:2",0,2));
       inlets.put("16:3",new Inlet("16:3",0,2));
       inlets.put("16:4",new Inlet("16:4",0,1));
       inlets.put("16:5",new Inlet("16:5",0,1));
       inlets.put("16:6",new Inlet("16:6",0,3));
       inlets.put("16:7",new Inlet("16:7",0,3));
       inlets.put("16:8",new Inlet("16:8",0,2));
       inlets.put("16:9",new Inlet("16:9",0,2));
       inlets.put("16:10",new Inlet("16:10",0,1));
       inlets.put("16:11",new Inlet("16:11",0,1));

       inlets.put("17:1",new Inlet("17:1",0,3));
       inlets.put("17:2",new Inlet("17:2",0,2));
       inlets.put("17:3",new Inlet("17:3",0,1));
       inlets.put("17:4",new Inlet("17:4",0,1));
       inlets.put("17:5",new Inlet("17:5",0,1));
       inlets.put("17:6",new Inlet("17:6",0,1));
       inlets.put("17:7",new Inlet("17:7",0,1));
       inlets.put("17:8",new Inlet("17:8",0,1));
       inlets.put("17:9",new Inlet("17:9",0,1));

       inlets.put("18:1",new Inlet("18:1",0,3));
       inlets.put("18:2",new Inlet("18:2",0,2));
       inlets.put("18:3",new Inlet("18:3",0,2));
       inlets.put("18:4",new Inlet("18:4",0,1));
       inlets.put("18:5",new Inlet("18:5",0,1));
       inlets.put("18:6",new Inlet("18:6",0,3));
       inlets.put("18:7",new Inlet("18:7",0,2));
       inlets.put("18:8",new Inlet("18:8",0,1));
       inlets.put("18:9",new Inlet("18:9",0,1));
       inlets.put("18:10",new Inlet("18:10",0,1));

       inlets.put("19:1",new Inlet("19:1",0,3));
       inlets.put("19:2",new Inlet("19:2",0,2));
       inlets.put("19:3",new Inlet("19:3",0,1));

       inlets.put("20:1",new Inlet("20:1", 0, 3));
       inlets.put("20:2",new Inlet("20:2", 0, 2));
       inlets.put("20:3",new Inlet("20:3", 0, 1));

       inlets.put("21:1",new Inlet("21:1",0,3));
       inlets.put("21:2",new Inlet("21:2",0,2));
       inlets.put("21:3",new Inlet("21:3",0,1));
       inlets.put("23:4",new Inlet("23:4",0,3));
       inlets.put("23:5",new Inlet("23:5",0,2));
       inlets.put("23:6",new Inlet("23:6",0,1));
       inlets.put("23:7",new Inlet("23:7",0,3));
       inlets.put("23:8",new Inlet("23:8",0,2));
       inlets.put("23:9",new Inlet("23:9",0,1));
       inlets.put("23:10",new Inlet("23:10",0,3));
       inlets.put("23:11",new Inlet("23:11",0,2));
       inlets.put("23:12",new Inlet("23:12",0,1));
       inlets.put("23:13",new Inlet("23:13",0,3));
       inlets.put("23:14",new Inlet("23:14",0,2));
       inlets.put("23:15",new Inlet("23:15",0,1));
                       
       inlets.put("22:1",new Inlet("22:1",0,3));
       inlets.put("22:2",new Inlet("22:2",0,2));
       inlets.put("22:3",new Inlet("22:3",0,1));

       inlets.put("23:1",new Inlet("23:1",0,3));
       inlets.put("23:2",new Inlet("23:2",0,2));
       inlets.put("23:3",new Inlet("23:3",0,1));
       inlets.put("23:4",new Inlet("23:4",0,3));
       inlets.put("23:5",new Inlet("23:5",0,2));
       inlets.put("23:6",new Inlet("23:6",0,1));
       inlets.put("23:7",new Inlet("23:7",0,1));

       inlets.put("24:1",new Inlet("24:1",0,1));
       inlets.put("24:2",new Inlet("24:2",0,2));
       inlets.put("24:3",new Inlet("24:3",0,3));
       inlets.put("24:4",new Inlet("24:4",0,1));

       inlets.put("25:1",new Inlet("25:1",0,3));
       inlets.put("25:2",new Inlet("25:2",0,2));
       inlets.put("25:3",new Inlet("25:3",0,1));

    }

    public void instantiateAllInletLists() {
        inletList3_1 = Arrays.asList("3:1", "3:2", "3:3", "3:4", "3:5");
        inletList3_2 = Arrays.asList("3:6", "3:7", "3:8");
        inletList3_3 = Arrays.asList("3:18", "3:19", "3:20");

        inletList4 = Arrays.asList("4:1", "4:2", "4:3", "4:4");

        inletList5 = Arrays.asList("5:1", "5:2", "5:3", "5:4", "5:5");

        inletList6_1 = Arrays.asList("6_1", "6:2", "6:3", "6:4", "6:5");
        inletList6_2 = Arrays.asList("6_6", "6:7", "6:8", "6:9", "6:10");
        inletList6_3 = Arrays.asList("6_11","6:12","6:13","6:14","6:15", "6:16");
        inletList6_4 = Arrays.asList("6_16","6:17","6:18");

        inletList7_1 = Arrays.asList("7:1", "7:2", "7:3");
        inletList7_2 = Arrays.asList("7:4", "7:5", "7:6", "7:7", "7:8", "7:8", "7:9", "7:10");
        inletList7_3 = Arrays.asList("7:11");
        inletList7_4 = Arrays.asList("7:12");

        inletList8_1 = Arrays.asList("8:1", "8:2", "8:3", "8:4");
        inletList8_2 = Arrays.asList("8:5");
        inletList8_3 = Arrays.asList("8:6");
        inletList8_4 = Arrays.asList("8:7");
        inletList8_5 = Arrays.asList("8:8");
        inletList8_6 = Arrays.asList("8:9");

        inletList9 = Arrays.asList("9:3");

        inletList10_1 = Arrays.asList("10:1", "10:2", "10:3", "10:4");
        inletList10_2 = Arrays.asList("10:5");
        inletList10_3 = Arrays.asList("10:6");
        inletList10_4 = Arrays.asList("10:7");

        inletList11 = Arrays.asList("11:1", "11:2", "11:3", "11:4", "11:5", "11:6", "11:7", "11:8", "11:9", "11:10");

        inletList12_1 = Arrays.asList("12:1", "12:2", "12:3");
        inletList12_2 = Arrays.asList("12:4");
        inletList12_3 = Arrays.asList("12:5");

        inletList13 = Arrays.asList("13:1", "13:2", "13:3");

        inletList14_1 = Arrays.asList("14:1", "14:2", "14:3", "14:4", "14:5", "14:6", "14:7", "14:8", "14:9", "14:10", "14:11", "14:12");
        inletList14_2 = Arrays.asList("14:13");

        inletList15_1 = Arrays.asList("15:1", "15:2", "15:3", "15:4");
        inletList15_2 = Arrays.asList("15:5");
        inletList15_3 = Arrays.asList("15:16");

        inletList16_1 = Arrays.asList("16:1", "16:2", "16:3", "16:4", "16:5");
        inletList16_2 = Arrays.asList("16:6", "16:7", "16:8", "16:9", "16:10", "16:11");

        inletList17_1 = Arrays.asList("17:1", "17:2", "17:3","17:4","17:5","17:6");
        inletList17_2 = Arrays.asList("17:7");
        inletList17_3 = Arrays.asList("17:8");
        inletList17_4 = Arrays.asList("17:9");

        inletList18_1 = Arrays.asList("18:1", "18:2", "18:3", "18:4", "18:5");
        inletList18_2 = Arrays.asList("18:6", "18:7", "18:8", "18:9");
        inletList18_3 = Arrays.asList("18:10");

        inletList19 = Arrays.asList("19:1", "19:2", "19:3");
        inletList20 = Arrays.asList("20:1", "20:2", "20:3");

        inletList21_1 = Arrays.asList("21:1", "21:2", "21:3", "21:4", "21:5", "21:6");
        inletList21_2 = Arrays.asList("21:7", "21:8", "21:9");
        inletList21_3 = Arrays.asList("21:10", "21:11", "21:12");
        inletList21_4 = Arrays.asList("21:13", "21:14", "21:15");

        inletList22 = Arrays.asList("22:1", "22:2", "22:3");

        inletList23_1 = Arrays.asList("23:1", "23:2", "23:3");
        inletList23_2 = Arrays.asList("23:4", "23:5", "23:6", "23:7");

        inletList24 = Arrays.asList("24:1", "24:2", "24:3", "24:4");
        inletList25 = Arrays.asList("25:1", "25:2", "25:3");

    }

    public void instantiateAllInletClusters() {

        inletCluster3_1 = new InletCluster(15,42.8/METER_CONVERSION,1.6/METER_CONVERSION, J16, null, inletList3_1);
        inletCluster3_2 = new InletCluster(13,38.5/METER_CONVERSION,3.5/METER_CONVERSION, J13, null, inletList3_2);
        inletCluster3_3 = new InletCluster(12,34.1/METER_CONVERSION,1.3/METER_CONVERSION, J12, null, inletList3_3);

        inletCluster4 = new InletCluster(16,44.1/METER_CONVERSION, 1.8/METER_CONVERSION, J17, null, inletList4);

        inletCluster5 = new InletCluster(18,45.9/METER_CONVERSION,1.0/METER_CONVERSION, J19, null, inletList5);

        inletCluster6_1 = new InletCluster(22,43.1/METER_CONVERSION,0.3/METER_CONVERSION, J23, null, inletList6_1);
        inletCluster6_2 = new InletCluster(23,44.7/METER_CONVERSION,0.2/METER_CONVERSION, J24, null, inletList6_2);
        inletCluster6_3 = new InletCluster(24,47.2/METER_CONVERSION,0.1/METER_CONVERSION, J25, null, inletList6_3);
        inletCluster6_4 = new InletCluster(25,48.7/METER_CONVERSION,1.6/METER_CONVERSION, J25, null, inletList6_4);

        inletCluster7_1 = new InletCluster(19,45.5/METER_CONVERSION,0.6/METER_CONVERSION, J20, null, inletList7_1);
        inletCluster7_2 = new InletCluster(17, 43.2/METER_CONVERSION,0.7/METER_CONVERSION, J18, null, inletList7_2);
        inletCluster7_3 = new InletCluster(20,47.5/METER_CONVERSION, 0.7/METER_CONVERSION, J21, null, inletList7_3);
        inletCluster7_4 = new InletCluster(21,48.1/METER_CONVERSION,1.1/METER_CONVERSION, J21, null, inletList7_4);

        inletCluster8_1 = new InletCluster(27,50.1/METER_CONVERSION,0.4/METER_CONVERSION, J29, null, inletList8_1);
        inletCluster8_2 = new InletCluster(26,43.5/METER_CONVERSION, 0.3/METER_CONVERSION, J26, null, inletList8_2);
        inletCluster8_3 = new InletCluster(53,43.9/METER_CONVERSION, 0.6/METER_CONVERSION, J27, null, inletList8_3);
        inletCluster8_4 = new InletCluster(29,49.5/METER_CONVERSION,1.5/METER_CONVERSION, J30, null, inletList8_4);
        inletCluster8_5 = new InletCluster(30,49/METER_CONVERSION,0.6/METER_CONVERSION, J31, null, inletList8_5);
        inletCluster8_6 = new InletCluster(28,52/METER_CONVERSION,2.3/METER_CONVERSION, J29, null, inletList8_6);

        inletCluster9 = new InletCluster(14,42.8/METER_CONVERSION, 4.4/METER_CONVERSION, J14, null, inletList9);

        inletCluster10_1 = new InletCluster(38,56/METER_CONVERSION,1.2/METER_CONVERSION, J39, null, inletList10_1);
        inletCluster10_2 = new InletCluster(31,51.8/METER_CONVERSION,0.8/METER_CONVERSION, J34, null, inletList10_2);
        inletCluster10_3 = new InletCluster(32,52.6/METER_CONVERSION,0/METER_CONVERSION, J33, null, inletList10_3);
        inletCluster10_4 = new InletCluster(33,57/METER_CONVERSION,4.4/METER_CONVERSION, J33, null, inletList10_4);

        inletCluster11 = new InletCluster(50,60.8/METER_CONVERSION,1.5/METER_CONVERSION, J46, null, inletList11);

        inletCluster12_1 = new InletCluster(52,59.8/METER_CONVERSION,0.5/METER_CONVERSION, J47, null, inletList12_1);
        inletCluster12_2 = new InletCluster(49,58.8/METER_CONVERSION,0.5/METER_CONVERSION, J45, null, inletList12_2);
        inletCluster12_3 = new InletCluster(51,61.7/METER_CONVERSION,1.9/METER_CONVERSION, J47, null, inletList12_3);

        inletCluster13 = new InletCluster(54, 62.0/METER_CONVERSION, 3.1/METER_CONVERSION, J44, null, inletList13);

        inletCluster14_1 = new InletCluster(43,62.1/METER_CONVERSION,0.6/METER_CONVERSION, J49, null, inletList14_1);
        inletCluster14_2 = new InletCluster(42,58.9/METER_CONVERSION,0.4/METER_CONVERSION, J50, null, inletList14_2);

        inletCluster15_1 = new InletCluster(46,61.9/METER_CONVERSION,0.3/METER_CONVERSION, J52, null, inletList15_1);
        inletCluster15_2 = new InletCluster(44,59.7/METER_CONVERSION,0.2/METER_CONVERSION, J50, null, inletList15_2);
        inletCluster15_3 = new InletCluster(45,64.2/METER_CONVERSION,2.9/METER_CONVERSION, J51, null, inletList15_3);

        inletCluster16_1 = new InletCluster(48,62.1/METER_CONVERSION, 0.0/METER_CONVERSION, J53, null, inletList16_1);
        inletCluster16_2 = new InletCluster(47,62.6/METER_CONVERSION,0.5/METER_CONVERSION, J53, null, inletList16_2);

        inletCluster17_1 = new InletCluster(40,56.9/METER_CONVERSION,0.8/METER_CONVERSION, J41, null, inletList17_1);
        inletCluster17_2 = new InletCluster(41,53.0/METER_CONVERSION,0.8/METER_CONVERSION, J42, null, inletList17_2);
        inletCluster17_3 = new InletCluster(39,56.9/METER_CONVERSION,0.8/METER_CONVERSION, J41, null, inletList17_3);
        inletCluster17_4 = new InletCluster(34,53.7/METER_CONVERSION,0.8/METER_CONVERSION, J36, null, inletList17_4);

        inletCluster18_1 = new InletCluster(35,53.9/METER_CONVERSION,0.4/METER_CONVERSION, J37, null, inletList18_1);
        inletCluster18_2 = new InletCluster(36,57.8/METER_CONVERSION,1.3/METER_CONVERSION, J38, null, inletList18_2);
        inletCluster18_3 = new InletCluster(37,57.9/METER_CONVERSION,1.4/METER_CONVERSION, J38, null, inletList18_3);

        inletCluster19 = new InletCluster(6,27.4/METER_CONVERSION,0.2/METER_CONVERSION, J6, null, inletList19);

        inletCluster20 = new InletCluster(1, 1.3/METER_CONVERSION, 25.1/METER_CONVERSION, J2, null, inletList20);

        inletCluster21_1 = new InletCluster(7,31.4/METER_CONVERSION,0/METER_CONVERSION, J8, null, inletList21_1);
        inletCluster21_2 = new InletCluster(8,34.9/METER_CONVERSION,0.8/METER_CONVERSION, J10, null, inletList21_2);
        inletCluster21_3 = new InletCluster(10,35.7/METER_CONVERSION,1.5/METER_CONVERSION, J11, null, inletList21_3);
        inletCluster21_4 = new InletCluster(11,34/METER_CONVERSION,0.3/METER_CONVERSION, J11, null, inletList21_4);

        inletCluster22 = new InletCluster(9,37.1/METER_CONVERSION,3.0/METER_CONVERSION, J10, null, inletList22);
        inletCluster23_1 = new InletCluster(2,25.3/METER_CONVERSION,0.9/METER_CONVERSION, J3, null, inletList23_1);
        inletCluster23_2 = new InletCluster(4,26.9/METER_CONVERSION,0.8/METER_CONVERSION, J4, null, inletList23_2);
        inletCluster24 = new InletCluster(5,27.3/METER_CONVERSION,1.5/METER_CONVERSION, J6, null, inletList24);
        inletCluster25 = new InletCluster(3,28.3/METER_CONVERSION,2.2/METER_CONVERSION, J4, null, inletList25);

    }

    public void instantiateAllJunctions() {
        rootNode = new Junction(0, 0,0, null, J1, J1, 1, 1);
        J1 = new Junction(1,22.6/METER_CONVERSION,22.6/METER_CONVERSION, rootNode, J2, J5, 1, 1);
        J2 = new Junction(2,23.8/METER_CONVERSION,1.2/METER_CONVERSION, J1, inletCluster20, J3,1,1);
        J3 = new Junction(3,24.4/METER_CONVERSION,0.6/METER_CONVERSION, J2, J4, inletCluster23_1, 1, 1);
        J4 = new Junction(4,26.1/METER_CONVERSION,1.7/METER_CONVERSION, J3, inletCluster25, inletCluster23_2, 1, 1);
        J5 = new Junction(5,25.8/METER_CONVERSION,3.2/METER_CONVERSION, J1, inletCluster24, J6, 1, 1);
        J6 = new Junction(6,27.2/METER_CONVERSION,1.4/METER_CONVERSION, J5, J7, inletCluster19,1,1);
        J7 = new Junction(7,27.7/METER_CONVERSION,0.5/METER_CONVERSION, J6, J8, J12,1,1);
        J8 = new Junction(8,31.4/METER_CONVERSION,3.7/METER_CONVERSION, J7, inletCluster21_1, J9,1,1);
        J9 = new Junction(9,33.4/METER_CONVERSION,2.0/METER_CONVERSION, J8, J10, J11,1,1);
        J10 = new Junction(10,34.1/METER_CONVERSION,0.7/METER_CONVERSION, J9, inletCluster21_2, inletCluster22,1,1);
        J11 = new Junction(11,33.7/METER_CONVERSION,1.3/METER_CONVERSION, J9, inletCluster21_3, inletCluster21_4,1,1);
        J12 = new Junction(12,32.8/METER_CONVERSION,5.1/METER_CONVERSION, J7, J13, inletCluster3_3, 1, 1);
        J13 = new Junction(13,35.0/METER_CONVERSION,2.2/METER_CONVERSION, J12, inletCluster3_2, J14, 1, 1);
        J14 = new Junction(14,38.4/METER_CONVERSION,3.4/METER_CONVERSION, J13, J15, inletCluster9,1,1);
        J15 = new Junction(15,40.7/METER_CONVERSION,2.3/METER_CONVERSION, J14, J16, J22, 1, 1);
        J16 = new Junction(16,41.2/METER_CONVERSION,0.5/METER_CONVERSION, J15, inletCluster3_1, J17, 1, 1);
        J17 = new Junction(17,42.3/METER_CONVERSION,1.1/METER_CONVERSION, J16, inletCluster4, J18, 1,1);
        J18 = new Junction(18,42.5/METER_CONVERSION,0.2/METER_CONVERSION, J17, J19, inletCluster7_2,1,1);
        J19 = new Junction(19,44.9/METER_CONVERSION,2.4/METER_CONVERSION, J18, inletCluster5, J20,1,1);
        J20 = new Junction(20,45.2/METER_CONVERSION,0.3/METER_CONVERSION, J19, J21, inletCluster7_1,1,1);
        J21 = new Junction(21,47.0/METER_CONVERSION,1.8/METER_CONVERSION, J20, inletCluster7_3, inletCluster7_4,1,1);
        J22 = new Junction(22,41.5/METER_CONVERSION,0.8/METER_CONVERSION, J15, J26, J23,1,1);
        J23 = new Junction(23,42.8/METER_CONVERSION,1.3/METER_CONVERSION, J22, J24, inletCluster6_1,1,1);
        J24 = new Junction(24,44.5/METER_CONVERSION,1.7/METER_CONVERSION, J23, J25, inletCluster6_2, 1,1);
        J25 = new Junction(25,47.1/METER_CONVERSION,2.6/METER_CONVERSION, J24, inletCluster6_3, inletCluster6_4,1,1);
        J26 = new Junction(26,43.2/METER_CONVERSION,1.7/METER_CONVERSION, J22, inletCluster8_2, J27, 1, 1);
        J27 = new Junction(27,43.3/METER_CONVERSION,0.1/METER_CONVERSION, J26, J28, inletCluster8_3,1,1);
        J28 = new Junction(28,47.7/METER_CONVERSION,4.4/METER_CONVERSION, J27, J29, J30, 1,1);
        J29 = new Junction(29,49.7/METER_CONVERSION,2.0/METER_CONVERSION, J28, inletCluster8_1, inletCluster8_6,1,1 );
        J30 = new Junction(30,47.9/METER_CONVERSION,0.2/METER_CONVERSION, J28, J31, inletCluster8_4, 1,1);
        J31 = new Junction(31,48.4/METER_CONVERSION,0.5/METER_CONVERSION, J30, inletCluster8_5, J32,1,1);
        J32 = new Junction(32,50.9/METER_CONVERSION,2.5/METER_CONVERSION, J31, J34, J33, 1,1);
        J33 = new Junction(33,52.6/METER_CONVERSION,1.7/METER_CONVERSION, J32, inletCluster10_3, inletCluster10_4,1,1);
        J34 = new Junction(34,51.0/METER_CONVERSION,0.1/METER_CONVERSION, J32, inletCluster10_2, J35,1,1);
        J35 = new Junction(35,52.0/METER_CONVERSION,1/METER_CONVERSION, J34, J39, J36, 1,1);
        J36 = new Junction(36,52.9/METER_CONVERSION,0.9/METER_CONVERSION, J35, J37, inletCluster17_4, 1,1);
        J37 = new Junction(37,53.5/METER_CONVERSION,0.6/METER_CONVERSION, J36, inletCluster18_1, J38,1,1);
        J38 = new Junction(38,56.5/METER_CONVERSION,3/METER_CONVERSION, J37, inletCluster18_2, inletCluster18_3,1,1);
        J39 = new Junction(39,54.8/METER_CONVERSION,2.8/METER_CONVERSION, J35, inletCluster10_1, J40, 1,1);
        J40 = new Junction(40,55.1/METER_CONVERSION,0.3/METER_CONVERSION, J39, J42, J41, 1,1);
        J41 = new Junction(41,56.1/METER_CONVERSION,1/METER_CONVERSION, J40, inletCluster17_3, inletCluster17_1,1,1);
        J42 = new Junction(42,55.2/METER_CONVERSION,0.1/METER_CONVERSION, J40, J43, inletCluster17_2,1,1);
        J43 = new Junction(43,56.6/METER_CONVERSION,1.4/METER_CONVERSION, J42, J44, J48,1,1);
        J44 = new Junction(44,58.9/METER_CONVERSION,2.3/METER_CONVERSION, J43, J45, inletCluster13, 1,1);
        J45 = new Junction(45,58.3/METER_CONVERSION,0.5/METER_CONVERSION, J44, J46, inletCluster12_2,1,1);
        J46 = new Junction(46,59.3/METER_CONVERSION,1.0/METER_CONVERSION, J45, inletCluster11, J47,1,1);
        J47 = new Junction(47,59.8/METER_CONVERSION,0.5/METER_CONVERSION, J46, inletCluster12_3, inletCluster12_1,1,1);
        J48 = new Junction(48,58.5/METER_CONVERSION, 1.9/METER_CONVERSION, J43, J49, inletCluster14_2, 1,1);
        J49 = new Junction(49,61.5/METER_CONVERSION,3.0/METER_CONVERSION, J48, inletCluster14_1, J50,1,1);
        J50 = new Junction(50,59.5/METER_CONVERSION,1.0/METER_CONVERSION, J49, J51, inletCluster15_2,1,1);
        J51 = new Junction(51,61.2/METER_CONVERSION,1.6/METER_CONVERSION, J50, J52, inletCluster15_3,1,1);
        J52 = new Junction(52,61.6/METER_CONVERSION,0.4/METER_CONVERSION, J51, J53, inletCluster15_1,1,1);
        J53 = new Junction(53,62.1/METER_CONVERSION,0.5/METER_CONVERSION, J52, inletCluster16_1, inletCluster16_2, 1,1);
    }

    public void setChildren() {
        rootNode.setLeftChild(J1);
        rootNode.setRightChild(J1);

        J1.setLeftChild(J2);
        J1.setRightChild(J5);

        J2.setLeftChild(inletCluster20);
        J2.setRightChild(J3);

        J3.setLeftChild(J4);
        J3.setRightChild(inletCluster23_1);

        J4.setLeftChild(inletCluster25);
        J4.setRightChild(inletCluster23_2);

        J5.setLeftChild(inletCluster24);
        J5.setRightChild(J6);

        J6.setLeftChild(J7);
        J6.setRightChild(inletCluster19);

        J7.setLeftChild(J8);
        J7.setRightChild(J12);

        J8.setLeftChild(inletCluster21_1);
        J8.setRightChild(J9);

        J9.setLeftChild(J10);
        J9.setRightChild(J11);

        J10.setLeftChild(inletCluster21_2);
        J10.setRightChild(inletCluster22);

        J11.setLeftChild(inletCluster21_3);
        J11.setRightChild(inletCluster21_4);

        J12.setLeftChild(J13);
        J12.setRightChild(inletCluster3_3);

        J13.setLeftChild(inletCluster3_2);
        J13.setRightChild(J14);

        J14.setLeftChild(J15);
        J14.setRightChild(inletCluster9);

        J15.setLeftChild(J16);
        J15.setRightChild(J22);

        J16.setLeftChild(inletCluster3_1);
        J16.setRightChild(J17);

        J17.setLeftChild(inletCluster4);
        J17.setRightChild(J18);

        J18.setLeftChild(J19);
        J18.setRightChild(inletCluster7_2);

        J19.setLeftChild(inletCluster5);
        J19.setRightChild(J20);

        J20.setLeftChild(J21);
        J20.setRightChild(inletCluster7_1);

        J21.setLeftChild(inletCluster7_3);
        J21.setRightChild(inletCluster7_4);

        J22.setLeftChild(J26);
        J22.setRightChild(J23);

        J23.setLeftChild(J24);
        J23.setRightChild(inletCluster6_1);

        J24.setLeftChild(J25);
        J24.setRightChild(inletCluster6_2);

        J25.setLeftChild(inletCluster6_3);
        J25.setRightChild(inletCluster6_4);

        J26.setLeftChild(inletCluster8_2);
        J26.setRightChild(J27);

        J27.setLeftChild(J28);
        J27.setRightChild(inletCluster8_3);

        J28.setLeftChild(J29);
        J28.setRightChild(J30);

        J29.setLeftChild(inletCluster8_1);
        J29.setRightChild(inletCluster8_6);

        J30.setLeftChild(J31);
        J30.setRightChild(inletCluster8_4);

        J31.setLeftChild(inletCluster8_5);
        J31.setRightChild(J32);

        J32.setLeftChild(J34);
        J32.setRightChild(J33);

        J33.setLeftChild(inletCluster10_3);
        J33.setRightChild(inletCluster10_4);

        J34.setLeftChild(inletCluster10_2);
        J34.setRightChild(J35);

        J35.setLeftChild(J39);
        J35.setRightChild(J36);

        J36.setLeftChild(J37);
        J36.setRightChild(inletCluster17_4);

        J37.setLeftChild(inletCluster18_1);
        J37.setRightChild(J38);

        J38.setLeftChild(inletCluster18_2);
        J38.setRightChild(inletCluster18_3);

        J39.setLeftChild(inletCluster10_1);
        J39.setRightChild(J40);

        J40.setLeftChild(J42);
        J40.setRightChild(J41);

        J41.setLeftChild(inletCluster17_3);
        J41.setRightChild(inletCluster17_1);

        J42.setLeftChild(J43);
        J42.setRightChild(inletCluster17_2);

        J43.setLeftChild(J44);
        J43.setRightChild(J48);

        J44.setLeftChild(J45);
        J44.setRightChild(inletCluster13);

        J45.setLeftChild(J46);
        J45.setRightChild(inletCluster12_2);

        J46.setLeftChild(inletCluster11);
        J46.setRightChild(J47);

        J47.setLeftChild(inletCluster12_3);
        J47.setRightChild(inletCluster12_1);

        J48.setLeftChild(J49);
        J48.setRightChild(inletCluster14_2);

        J49.setLeftChild(inletCluster14_1);
        J49.setRightChild(J50);

        J50.setLeftChild(J51);
        J50.setRightChild(inletCluster15_2);

        J51.setLeftChild(J52);
        J51.setRightChild(inletCluster15_3);

        J52.setLeftChild(J53);
        J52.setRightChild(inletCluster15_1);

        J53.setLeftChild(inletCluster16_1);
        J53.setRightChild(inletCluster16_2);
    }

    public void instantiateAllAv() {
        AV3 = new AV(3,inletCluster3_1.getLengthToParent(),Arrays.asList(inletCluster3_1,inletCluster3_2,inletCluster3_3));
        inletCluster3_1.setAV(AV3);
        inletCluster3_2.setAV(AV3);
        inletCluster3_3.setAV(AV3);

        AV4 = new AV(4,inletCluster4.getLengthToParent(),Arrays.asList(inletCluster4));
        inletCluster4.setAV(AV4);

        AV5 = new AV(5,inletCluster5.getLengthToParent(),Arrays.asList(inletCluster5));
        inletCluster5.setAV(AV5);

        AV6 = new AV(6,inletCluster6_4.getLengthToParent(),Arrays.asList(inletCluster6_1,inletCluster6_2,inletCluster6_3,inletCluster6_4));
        inletCluster6_1.setAV(AV6);
        inletCluster6_2.setAV(AV6);
        inletCluster6_3.setAV(AV6);
        inletCluster6_4.setAV(AV6);

        AV7 = new AV(7,inletCluster7_1.getLengthToParent(),Arrays.asList(inletCluster7_1,inletCluster7_2,inletCluster7_3,inletCluster7_4));
        inletCluster7_1.setAV(AV7);
        inletCluster7_2.setAV(AV7);
        inletCluster7_3.setAV(AV7);
        inletCluster7_4.setAV(AV7);

        AV8 = new AV(8,inletCluster8_1.getLengthToParent(),Arrays.asList(inletCluster8_1,inletCluster8_2,inletCluster8_3,inletCluster8_4,inletCluster8_5,inletCluster8_6));
        inletCluster8_1.setAV(AV8);
        inletCluster8_2.setAV(AV8);
        inletCluster8_3.setAV(AV8);
        inletCluster8_4.setAV(AV8);
        inletCluster8_5.setAV(AV8);
        inletCluster8_6.setAV(AV8);

        AV9 = new AV(9,inletCluster9.getLengthToParent(),Arrays.asList(inletCluster9));
        inletCluster9.setAV(AV9);

        AV10 = new AV(10,inletCluster10_1.getLengthToParent(),Arrays.asList(inletCluster10_1,inletCluster10_2,inletCluster10_3,inletCluster10_4));
        inletCluster10_1.setAV(AV10);
        inletCluster10_2.setAV(AV10);
        inletCluster10_3.setAV(AV10);
        inletCluster10_4.setAV(AV10);

        AV11 = new AV(11,inletCluster11.getLengthToParent(),Arrays.asList(inletCluster11));
        inletCluster11.setAV(AV11);

        AV12 = new AV(12,inletCluster12_1.getLengthToParent(),Arrays.asList(inletCluster12_1,inletCluster12_2,inletCluster12_3));
        inletCluster12_1.setAV(AV12);
        inletCluster12_2.setAV(AV12);
        inletCluster12_3.setAV(AV12);

        AV13 = new AV(13,inletCluster13.getLengthToParent(),Arrays.asList(inletCluster13));
        inletCluster13.setAV(AV13);

        AV14 = new AV(14,inletCluster14_1.getLengthToParent(),Arrays.asList(inletCluster14_1,inletCluster14_2));
        inletCluster14_1.setAV(AV14);
        inletCluster14_2.setAV(AV14);

        AV15 = new AV(15,inletCluster15_1.getLengthToParent(),Arrays.asList(inletCluster15_1,inletCluster15_2,inletCluster15_3));
        inletCluster15_1.setAV(AV15);
        inletCluster15_2.setAV(AV15);
        inletCluster15_3.setAV(AV15);

        AV16 = new AV(16,inletCluster16_2.getLengthToParent(),Arrays.asList(inletCluster16_1,inletCluster16_2));
        inletCluster16_1.setAV(AV16);
        inletCluster16_2.setAV(AV16);

        AV17 = new AV(17,inletCluster17_1.getLengthToParent(),Arrays.asList(inletCluster17_1,inletCluster17_2,inletCluster17_3,inletCluster17_4));
        inletCluster17_1.setAV(AV17);
        inletCluster17_2.setAV(AV17);
        inletCluster17_3.setAV(AV17);
        inletCluster17_4.setAV(AV17);

        AV18 = new AV(18,inletCluster18_1.getLengthToParent(),Arrays.asList(inletCluster18_1,inletCluster18_2,inletCluster18_3));
        inletCluster18_1.setAV(AV18);
        inletCluster18_2.setAV(AV18);
        inletCluster18_3.setAV(AV18);

        AV19 = new AV(19,inletCluster19.getLengthToParent(),Arrays.asList(inletCluster19));
        inletCluster19.setAV(AV19);

        AV20 = new AV(20,inletCluster20.getLengthToParent(),Arrays.asList(inletCluster20));
        inletCluster20.setAV(AV20);

        AV21 = new AV(21,inletCluster21_3.getLengthToParent(),Arrays.asList(inletCluster21_1,inletCluster21_2,inletCluster21_3,inletCluster21_4));
        inletCluster21_1.setAV(AV21);
        inletCluster21_2.setAV(AV21);
        inletCluster21_3.setAV(AV21);
        inletCluster21_4.setAV(AV21);

        AV22 = new AV(22,inletCluster22.getLengthToParent(),Arrays.asList(inletCluster22));
        inletCluster22.setAV(AV22);

        AV23 = new AV(23,inletCluster23_2.getLengthToParent(),Arrays.asList(inletCluster23_1,inletCluster23_2));
        inletCluster23_1.setAV(AV23);
        inletCluster23_2.setAV(AV23);

        AV24 = new AV(24,inletCluster24.getLengthToParent(),Arrays.asList(inletCluster24));
        inletCluster24.setAV(AV24);

        AV25 = new AV(25,inletCluster25.getLengthToParent(),Arrays.asList(inletCluster25));
        inletCluster25.setAV(AV25);

    }

    public static double setJunctionDepth(Vertex v) {

        if (v instanceof InletCluster) {
            return v.getLengthToParent();

        } else {
            double dLeft = setJunctionDepth(((Junction) v).getLeftChild());
            double dRight = setJunctionDepth(((Junction) v).getRightChild());

            ((Junction) v).setLeftDepth(dLeft);
            ((Junction) v).setRightDepth(dRight);

            double deepest = dRight >= dLeft ? dRight : dLeft;

            return v.getLengthToParent() + deepest;

        }
    }

}
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SystemSetup {
    // variable to convert map scale to real length
    private final double METER_CONVERSION = 0.05;

    private Junction rootNode, J1, J2, J3, J4, J5, J6, J7, J8, J9, J10, J11, J12, J13, J14, J15, J16,
            J17, J18, J19, J20, J21, J22, J23, J24, J25, J26, J27, J28, J29, J30, J31, J32, J33, J34,
            J35, J36, J37, J38, J39, J40, J41, J42, J43, J44, J45, J46, J47, J48, J49, J50, J51, J52;

    private List <AV> AVList = new ArrayList<>();
    private AV AV3, AV4, AV5, AV6, AV7, AV8, AV10, AV11, AV12, AV13, AV14, AV15, AV16, AV17, AV18, AV19, AV20, AV21, AV22, AV23, AV24, AV25;
    private List <Inlet> AVInlets3, AVInlets4, AVInlets5, AVInlets6, AVInlets7, AVInlets8, AVInlets10, AVInlets11, AVInlets12, AVInlets13, AVInlets14, AvInlets15, AvInlets16, AvInlets17, AvInlets18, AVInlets19, AVInlets20, AVInlets21, AVInlets22, AVInlets23;

    private Inlet I3_1, I3_2, I3_3, I3_4, I3_5, I3_6, I3_7, I3_8, I3_18, I3_19, I3_20,
            I4_1, I4_2, I4_3, I4_4, I5_1, I5_2, I5_3, I5_4, I5_5,
            I6_1, I6_2, I6_3, I6_4, I6_5, I6_6, I6_7, I6_8, I6_9, I6_10, I6_11, I6_12, I6_13, I6_14, I6_15,
            I6_16, I6_17, I6_18, I7_1, I7_2, I7_3, I7_4, I7_5, I7_6, I7_7, I7_8, I7_9, I7_10, I8_1, I8_2,
            I8_3, I8_4, I10_1, I10_2, I10_3, I10_4, I11_1, I11_2, I11_3, I11_4, I11_5, I11_6, I11_7, I11_8,
            I11_9, I11_10, I12_1, I12_2, I12_3, I13_1, I13_2, I13_3, I14_1, I14_2, I14_3, I14_4, I14_5, I14_6,
            I14_7, I14_8, I14_9, I14_10, I14_11, I14_12, I15_1, I15_2, I15_3, I15_4, I16_1, I16_2, I16_3, I16_4,
            I16_5, I16_6, I16_7, I16_8, I16_9, I16_10, I16_11, I17_1, I17_2, I17_3, I17_4, I17_5, I17_6, I18_1,
            I18_2, I18_3, I18_4, I18_5, I18_6, I18_7, I18_8, I18_9, I19_1, I19_2, I19_3, I20_1, I20_2, I20_3,
            I21_1, I21_2, I21_3, I21_4, I21_5, I21_6, I21_7, I21_8, I21_9, I21_10, I21_11, I21_12, I21_13, I21_14,
            I21_15, I22_1, I22_2, I22_3, I23_1, I23_2, I23_3, I23_4, I23_5, I23_6, I23_7, I24_1, I24_2, I24_3, I24_4, I25_1, I25_2, I25_3;

    private final int lengthToRoot = 1;

    private List<Inlet> inletList3_1, inletList3_2, inletList3_3, inletList4, inletList9, inletList19, inletList20, inletList21_1, inletList21_2, inletList21_3, inletList21_4, inletList22, inletList23_1, inletList23_2, inletList24, inletList25;
    private InletCluster inletCluster3_1, inletCluster3_2, inletCluster3_3, inletCluster4, inletCluster9, inletCluster14, inletCluster19, inletCluster20, inletCluster21_1, inletCluster21_2, inletCluster21_3,inletCluster21_4, inletCluster22, inletCluster23_1, inletCluster23_2, inletCluster24, inletCluster25;

    public SystemSetup(){
        instantiateAllInlets();
        instantiateAllJunctions();
        instantiateAllAv();
        instantiateAllInletLists();
    }

    public void instantiateAllInlets(){
        I3_1 = new Inlet("3:1",0,3);
        I3_2 = new Inlet("3:2",0,2);
        I3_3 = new Inlet("3:3",0,2);
        I3_4 = new Inlet("3:4",0,1);
        I3_5 = new Inlet("3:5",0,1);
        I3_6 = new Inlet("3:6",0,3);
        I3_7 = new Inlet("3:7",0,2);
        I3_8 = new Inlet("3:8",0,2);
        I3_18 = new Inlet("3:18",0,3);
        I3_19 = new Inlet("3:19",0,1);
        I3_20 = new Inlet("3:20",0,1);

        inletList3_1 = Arrays.asList(I3_1, I3_2, I3_3, I3_4, I3_5);

        I19_1 = new Inlet("19:1",0,3);
        I19_2 = new Inlet("19:2",0,2);
        I19_3 = new Inlet("19:3",0,1);

        inletList19 = Arrays.asList(I19_1, I19_2, I19_3);
        inletCluster19 = new InletCluster(6,27.4/METER_CONVERSION,0.2/METER_CONVERSION, J6, AV19, inletList19);

        I20_1 = new Inlet("20:1", 0, 3);
        I20_2 = new Inlet("20:2", 0, 2);
        I20_3 = new Inlet("20:3", 0, 1);

        inletList20 = Arrays.asList(I20_1, I20_2, I20_3);
        inletCluster20 = new InletCluster(1, 1.3/METER_CONVERSION, 25.1/METER_CONVERSION, J2, AV20, inletList20);

        I21_1 = new Inlet("21:1",0,3);
        I21_2 = new Inlet("21:2",0,2);
        I21_3 = new Inlet("21:3",0,1);
        I21_4 = new Inlet("23:4",0,3);
        I21_5 = new Inlet("23:5",0,2);
        I21_6 = new Inlet("23:6",0,1);
        I21_7 = new Inlet("23:7",0,3);
        I21_8 = new Inlet("23:8",0,2);
        I21_9 = new Inlet("23:9",0,1);
        I21_10 = new Inlet("23:10",0,3);
        I21_11 = new Inlet("23:11",0,2);
        I21_12 = new Inlet("23:12",0,1);
        I21_13 = new Inlet("23:13",0,3);
        I21_14 = new Inlet("23:14",0,2);
        I21_15 = new Inlet("23:15",0,1);

        inletList21_1 = Arrays.asList(I21_1, I21_2, I21_3, I21_4, I21_5, I21_6);
        inletList21_2 = Arrays.asList(I21_7, I21_8, I21_9);
        inletList21_3 = Arrays.asList(I21_10, I21_11, I21_12);
        inletList21_4 = Arrays.asList(I21_13, I21_14, I21_15);
        inletCluster21_1 = new InletCluster(7,31.4/METER_CONVERSION,0, J8, AV21, inletList21_1);
        inletCluster21_2 = new InletCluster(8,34.9/METER_CONVERSION,0.8/METER_CONVERSION, J10, AV21, inletList21_2);
        inletCluster21_3 = new InletCluster(10,35.7/METER_CONVERSION,1.5/METER_CONVERSION, J11, AV21, inletList21_3);
        inletCluster21_4 = new InletCluster(11,34/METER_CONVERSION,0.3/METER_CONVERSION, J11, AV21, inletList21_4);

        I22_1 = new Inlet("22:1",0,3);
        I22_2 = new Inlet("22:2",0,2);
        I22_3 = new Inlet("22:3",0,1);

        inletList22 = Arrays.asList(I22_1, I22_2, I22_3);
        inletCluster22 = new InletCluster(9,37.1/METER_CONVERSION,3.0/METER_CONVERSION, J10, AV22, inletList22);

        I23_1 = new Inlet("23:1",0,3);
        I23_2 = new Inlet("23:2",0,2);
        I23_3 = new Inlet("23:3",0,1);
        I23_4 = new Inlet("23:4",0,3);
        I23_5 = new Inlet("23:5",0,2);
        I23_6 = new Inlet("23:6",0,1);
        I23_7 = new Inlet("23:7",0,1);

        inletList23_1 = Arrays.asList(I23_1, I23_2, I23_3);
        inletList23_2 = Arrays.asList(I23_4, I23_5, I23_6, I23_7);
        inletCluster23_1 = new InletCluster(2,25.3/METER_CONVERSION,0.9/METER_CONVERSION, J3, AV23, inletList23_1);
        inletCluster23_2 = new InletCluster(4,26.9/METER_CONVERSION,0.8/METER_CONVERSION, J4, AV23, inletList23_2);

        I24_1 = new Inlet("24:1",0,1);
        I24_2 = new Inlet("24:2",0,2);
        I24_3 = new Inlet("24:3",0,3);
        I24_4 = new Inlet("24:4",0,1);

        inletList24 = Arrays.asList(I24_1, I24_2, I24_3, I24_4);
        inletCluster24 = new InletCluster(5,27.3/METER_CONVERSION,1.5/METER_CONVERSION, J6, AV24, inletList24);

        I25_1 = new Inlet("25:1",0,3);
        I25_2 = new Inlet("25:2",0,2);
        I25_3 = new Inlet("25:3",0,1);

        inletList25 = Arrays.asList(I25_1, I25_2, I25_3);
        inletCluster25 = new InletCluster(3,28.3,2.2, J4, AV25, inletList25);
    }

    public void instantiateAllJunctions(){
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
        J12 = new Junction(12,32.8/METER_CONVERSION,5.1/METER_CONVERSION, J7, J13, inletCluster3_3, 0, 1);
        J13 = new Junction(13,35/METER_CONVERSION,2.2/METER_CONVERSION, J12, inletCluster3_2, J14, 0, 1);
        J14 = new Junction(14,38.4/METER_CONVERSION,3.4/METER_CONVERSION, J13, J15, inletCluster14,0,1);
        J15 = new Junction(15,40.7/METER_CONVERSION,2.3/METER_CONVERSION, J14, J16, J22, 0, 1);
        J16 = new Junction(16,41.2/METER_CONVERSION,0.5/METER_CONVERSION, J15, inletCluster3_1, J17, 0, 1);
    }

    public void instantiateAllAv(){
        /*AV3 = new AV(3, lengthToRoot, AVInlets3);
        AV4 = new AV(4, lengthToRoot, AVInlets4);
        AV5 = new AV(5, lengthToRoot, AVInlets5);
        AV6 = new AV(6, lengthToRoot, AVInlets6);
        AV7 = new AV(6, lengthToRoot, AVInlets7);
        AV8 = new AV(8, lengthToRoot, AVInlets8);
        AV10 = new AV(10, lengthToRoot, AVInlets10);
        AV11 = new AV(11, lengthToRoot, AVInlets11);
        AV12 = new AV(12, lengthToRoot, AVInlets12);
        AV13 = new AV(13, lengthToRoot, AVInlets13);
        AV14 = new AV(14, lengthToRoot, AVInlets14);
        AV15 = new AV(15, lengthToRoot, AvInlets15);
        AV16 = new AV(16, lengthToRoot, AvInlets16);
        AV17 = new AV(17, lengthToRoot, AvInlets17);
        AV18 = new AV(18, lengthToRoot, AvInlets18);
        AV19 = new AV(19, lengthToRoot, AVInlets19);
        AV20 = new AV(20, lengthToRoot, AVInlets20);
        AV21 = new AV(21, lengthToRoot, AVInlets21);
        AV22 = new AV(22, lengthToRoot, AVInlets22);
        AV23 = new AV(23, lengthToRoot, AVInlets23);
        */
        /*AV3.setInlets(AVInlets3);
        AV4.setInlets(AVInlets4);
        AV5.setInlets(AVInlets5);
        AV6.setInlets(AVInlets6);
        AV7.setInlets(AVInlets7);
        AV8.setInlets(AVInlets8);
        AV10.setInlets(AVInlets10);
        AV11.setInlets(AVInlets11);
        AV12.setInlets(AVInlets12);
        AV13.setInlets(AVInlets13);
        AV14.setInlets(AVInlets14);
        AV15.setInlets(AvInlets15);
        AV16.setInlets(AvInlets16);
        AV17.setInlets(AvInlets17);
        AV18.setInlets(AvInlets18);
        AV19.setInlets(AVInlets19);
        AV21.setInlets(AVInlets21);
        AV22.setInlets(AVInlets22);
        AV23.setInlets(AVInlets23);*/
    }
    public void instantiateAllInletLists(){
        AVInlets3 = new ArrayList<Inlet>();
        AVInlets4 = new ArrayList<Inlet>();
        AVInlets5 = new ArrayList<Inlet>();
        AVInlets6 = new ArrayList<Inlet>();
        AVInlets7 = new ArrayList<Inlet>();
        AVInlets8 = new ArrayList<Inlet>();
        AVInlets10 = new ArrayList<Inlet>();
        AVInlets11 = new ArrayList<Inlet>();
        AVInlets12 = new ArrayList<Inlet>();
        AVInlets13 = new ArrayList<Inlet>();
        AVInlets14 = new ArrayList<Inlet>();
        AvInlets15 = new ArrayList<Inlet>();
        AvInlets16 = new ArrayList<Inlet>();
        AvInlets17 = new ArrayList<Inlet>();
        AvInlets18 = new ArrayList<Inlet>();
        AVInlets19 = new ArrayList<Inlet>();
        AVInlets20 = new ArrayList<Inlet>();
        AVInlets21 = new ArrayList<Inlet>();
        AVInlets22 = new ArrayList<Inlet>();
        AVInlets23 = new ArrayList<Inlet>();

        /*AVInlets3.add(I3_1);
        AVInlets3.add(I3_2);
        AVInlets3.add(I3_3);
        AVInlets3.add(I3_4);
        AVInlets3.add(I3_5);
        AVInlets3.add(I3_6);
        AVInlets3.add(I3_7);
        AVInlets3.add(I3_8);
        AVInlets3.add(I3_18);
        AVInlets3.add(I3_19);
        AVInlets3.add(I3_20);*/

        AVInlets4.add(I4_1);
        AVInlets4.add(I4_2);
        AVInlets4.add(I4_3);
        AVInlets4.add(I4_4);

        AVInlets5.add(I5_1);
        AVInlets5.add(I5_2);
        AVInlets5.add(I5_3);
        AVInlets5.add(I5_4);
        AVInlets5.add(I5_5);

        AVInlets6.add(I6_1);
        AVInlets6.add(I6_2);
        AVInlets6.add(I6_3);
        AVInlets6.add(I6_4);
        AVInlets6.add(I6_5);
        AVInlets6.add(I6_6);
        AVInlets6.add(I6_7);
        AVInlets6.add(I6_8);
        AVInlets6.add(I6_9);
        AVInlets6.add(I6_10);
        AVInlets6.add(I6_11);
        AVInlets6.add(I6_12);
        AVInlets6.add(I6_13);
        AVInlets6.add(I6_14);
        AVInlets6.add(I6_15);
        AVInlets6.add(I6_16);
        AVInlets6.add(I6_17);
        AVInlets6.add(I6_18);

        AVInlets7.add(I7_1);
        AVInlets7.add(I7_2);
        AVInlets7.add(I7_3);
        AVInlets7.add(I7_4);
        AVInlets7.add(I7_5);
        AVInlets7.add(I7_6);
        AVInlets7.add(I7_7);
        AVInlets7.add(I7_8);
        AVInlets7.add(I7_9);
        AVInlets7.add(I7_10);

        AVInlets8.add(I8_1);
        AVInlets8.add(I8_2);
        AVInlets8.add(I8_3);
        AVInlets8.add(I8_4);

        AVInlets10.add(I10_1);
        AVInlets10.add(I10_2);
        AVInlets10.add(I10_3);
        AVInlets10.add(I10_4);

        AVInlets11.add(I11_1);
        AVInlets11.add(I11_2);
        AVInlets11.add(I11_3);
        AVInlets11.add(I11_4);
        AVInlets11.add(I11_5);
        AVInlets11.add(I11_6);
        AVInlets11.add(I11_7);
        AVInlets11.add(I11_8);
        AVInlets11.add(I11_9);
        AVInlets11.add(I11_10);

        AVInlets12.add(I12_1);
        AVInlets12.add(I12_2);
        AVInlets12.add(I12_3);

        AVInlets13.add(I13_1);
        AVInlets13.add(I13_2);
        AVInlets13.add(I13_3);

        AVInlets14.add(I14_1);
        AVInlets14.add(I14_2);
        AVInlets14.add(I14_3);
        AVInlets14.add(I14_4);
        AVInlets14.add(I14_5);
        AVInlets14.add(I14_6);
        AVInlets14.add(I14_7);
        AVInlets14.add(I14_8);
        AVInlets14.add(I14_9);
        AVInlets14.add(I14_10);
        AVInlets14.add(I14_11);
        AVInlets14.add(I14_12);

        AvInlets15.add(I15_1);
        AvInlets15.add(I15_2);
        AvInlets15.add(I15_3);
        AvInlets15.add(I15_4);

        AvInlets16.add(I16_1);
        AvInlets16.add(I16_2);
        AvInlets16.add(I16_3);
        AvInlets16.add(I16_4);
        AvInlets16.add(I16_5);
        AvInlets16.add(I16_6);
        AvInlets16.add(I16_7);
        AvInlets16.add(I16_8);
        AvInlets16.add(I16_9);
        AvInlets16.add(I16_10);
        AvInlets16.add(I16_11);

        AvInlets17.add(I17_1);
        AvInlets17.add(I17_2);
        AvInlets17.add(I17_3);
        AvInlets17.add(I17_4);
        AvInlets17.add(I17_5);
        AvInlets17.add(I17_6);

        AvInlets18.add(I18_1);
        AvInlets18.add(I18_2);
        AvInlets18.add(I18_3);
        AvInlets18.add(I18_4);
        AvInlets18.add(I18_5);
        AvInlets18.add(I18_6);
        AvInlets18.add(I18_7);
        AvInlets18.add(I18_8);
        AvInlets18.add(I18_9);

        AVInlets19.add(I19_1);
        AVInlets19.add(I19_2);
        AVInlets19.add(I19_3);

        AVInlets20.add(I20_1);
        AVInlets20.add(I20_2);
        AVInlets20.add(I20_3);

        AVInlets21.add(I21_1);
        AVInlets21.add(I21_2);
        AVInlets21.add(I21_3);
        AVInlets21.add(I21_4);
        AVInlets21.add(I21_5);
        AVInlets21.add(I21_6);
        AVInlets21.add(I21_7);
        AVInlets21.add(I21_8);
        AVInlets21.add(I21_9);
        AVInlets21.add(I21_10);
        AVInlets21.add(I21_11);
        AVInlets21.add(I21_12);
        AVInlets21.add(I21_13);
        AVInlets21.add(I21_14);
        AVInlets21.add(I21_15);

        AVInlets22.add(I22_1);
        AVInlets22.add(I22_2);
        AVInlets22.add(I22_3);

        AVInlets23.add(I23_1);
        AVInlets23.add(I23_2);
        AVInlets23.add(I23_3);

    }
}

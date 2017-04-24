import java.util.ArrayList;
import java.util.List;

public class System {

    private List <AV> AVList = new ArrayList<>();
    private AV AV3, AV4, AV5, AV6, AV7, AV8, AV10, AV11, AV12, AV13, AV14, AV15, AV16, AV17, AV18, AV19, AV20, AV21, AV22, AV23;
    private List <Inlet> AVInlets3, AVInlets4, AVInlets5, AVInlets6, AVInlets7, AVInlets8, AVInlets10, AVInlets11, AVInlets12, AVInlets13, AVInlets14, AvInlets15, AvInlets16, AvInlets17, AvInlets18, AVInlets19, AVInlets20, AVInlets21, AVInlets22, AVInlets23;
    private String[] inlets = {"I3_1", "I3_2", "I3_3", "I3_4", "I3_5", "I3_6", "I3_7", "I3_8", "I3_18", "I3_19", "I3_20"};
    private List<Inlet> listOfInlets3 = new ArrayList<>();
    private Inlet I4_1, I4_2, I4_3, I4_4;
    private Inlet I5_1, I5_2, I5_3, I5_4, I5_5;
    private Inlet I6_1, I6_2, I6_3, I6_4, I6_5, I6_6, I6_7, I6_8, I6_9, I6_10, I6_11, I6_12, I6_13, I6_14, I6_15, I6_16, I6_17, I6_18;
    private Inlet I7_1, I7_2, I7_3, I7_4, I7_5, I7_6, I7_7, I7_8, I7_9, I7_10;
    private Inlet I8_1, I8_2, I8_3, I8_4;
    private Inlet I10_1, I10_2, I10_3, I10_4;
    private Inlet I11_1, I11_2, I11_3, I11_4, I11_5, I11_6, I11_7, I11_8, I11_9, I11_10;
    private Inlet I12_1, I12_2, I12_3;
    private Inlet I13_1, I13_2, I13_3;
    private Inlet I14_1, I14_2, I14_3, I14_4, I14_5, I14_6, I14_7, I14_8, I14_9, I14_10, I14_11, I14_12;
    private Inlet I15_1, I15_2, I15_3, I15_4;
    private Inlet I16_1, I16_2, I16_3, I16_4, I16_5, I16_6, I16_7, I16_8, I16_9, I16_10, I16_11;
    private Inlet I17_1, I17_2, I17_3, I17_4, I17_5, I17_6;
    private Inlet I18_1, I18_2, I18_3, I18_4, I18_5, I18_6, I18_7, I18_8, I18_9;
    private Inlet I19_1, I19_2, I19_3;
    private Inlet I20_1, I20_2, I20_3;
    private Inlet I21_1, I21_2, I21_3, I21_4, I21_5, I21_6, I21_7, I21_8, I21_9, I21_10, I21_11, I21_12, I21_13, I21_14, I21_15;
    private Inlet I22_1, I22_2, I22_3;
    private Inlet I23_1, I23_2, I23_3;


    public System(){
        instantiateAllAv();
        instantiateAllInletLists();
    }
    public void instantiateAllInlets(){ // Behöver skapa junctions innan inlets kopplas samman
        //Inlet I3_1 = new Inlet("I3_1", 1, 1, );
        /*for(int i = 0; i<inlets.length; i++){
            tmp = new Inlet(inlets[i],);
            listOfInlets3.add(tmp);
        }*/
    }
    public void instantiateAllAv(){
        AV3 = new AV(AVInlets3);
        AV4 = new AV(AVInlets4);
        AV5 = new AV(AVInlets5);
        AV6 = new AV(AVInlets6);
        AV7 = new AV(AVInlets7);
        AV8 = new AV(AVInlets8);
        AV10 = new AV(AVInlets10);
        AV11 = new AV(AVInlets11);
        AV12 = new AV(AVInlets12);
        AV13 = new AV(AVInlets13);
        AV14 = new AV(AVInlets14);
        AV15 = new AV(AvInlets15);
        AV16 = new AV(AvInlets16);
        AV17 = new AV(AvInlets17);
        AV18 = new AV(AvInlets18);
        AV19 = new AV(AVInlets19);
        AV20 = new AV(AVInlets20);
        AV21 = new AV(AVInlets21);
        AV22 = new AV(AVInlets22);
        AV23 = new AV(AVInlets23);

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

/**
 *   Created by Oksana on 05.06.2017.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class LabworkSecond {
    public static long SIZE_POP = 10000;
    static List<Double> populatoin = new ArrayList<>();

    public static void main(String[] args) {
        TaskA();
    }

    public static void initPop(long popSize) {
        populatoin.clear();
        // создаем генератор случайных чисел с границами
        Random rand = new Random(1);
        for (long i = 0; i < popSize; i++) {
            populatoin.add(rand.nextDouble());
        }
    }

    public static void TaskA() {
        initPop(SIZE_POP);


        long selection1 = 100;

        long selection2 = 1000;

        List<Double> ListOfSelection1 = new ArrayList<>();
        List<Double> ListOfSelection2 = new ArrayList<>();
        List<Double> ListOfSysSelection1 = new ArrayList<>();
        List<Double> ListOfSysSelection2 = new ArrayList<>();


        double sumOfPop = calculateSummFromPop(populatoin);
        double avrOfPop = calculateAVRFromPop(populatoin);
        double dispOfPop = calculateDispersionFromPop(populatoin);

        List<Double> tempList = populatoin;
        for (int i = 0; i < selection1; i++) {
            Random r = new Random(1);
            int selectionIdex = r.nextInt(tempList.size());
            ListOfSelection1.add(tempList.get(selectionIdex));
            tempList.remove(selectionIdex);
        }

        tempList = populatoin;
        for (int i = 0; i < selection1; i++) {

            int selectionIdex = (int) (i * (SIZE_POP/selection1-1));
            ListOfSysSelection1.add(tempList.get(selectionIdex));

        }

        tempList = populatoin;
        for (int i = 0; i < selection2; i++) {

            int selectionIdex = (int) (i * (SIZE_POP/selection2-1));
            ListOfSysSelection2.add(tempList.get(selectionIdex));

        }


        tempList = populatoin;
        for (int i = 0; i < selection2; i++) {
            Random r = new Random(1);
            int selectionIdex = r.nextInt(tempList.size());
            ListOfSelection2.add(tempList.get(selectionIdex));
            tempList.remove(selectionIdex);
        }

        double sumOfselection1 = calculateSummFromSelection(ListOfSelection1, SIZE_POP);
        double sumOfselection2 = calculateSummFromSelection(ListOfSelection2, SIZE_POP);
        double avrOfselection1 = calculateAVRFromSelection(ListOfSelection1);
        double avrOfselection2 = calculateAVRFromSelection(ListOfSelection2);
        double dispOfselection1 = calculateDispersionFromSelection(ListOfSelection1);
        double dispOfselection2 = calculateDispersionFromSelection(ListOfSelection2);

        double sumOfSysselection1 = calculateSummFromSelection(ListOfSysSelection1, SIZE_POP);
        double sumOfSysselection2 = calculateSummFromSelection(ListOfSysSelection2, SIZE_POP);
        double avrOfSysselection1 = calculateAVRFromSelection(ListOfSysSelection1);
        double avrOfSysselection2 = calculateAVRFromSelection(ListOfSysSelection2);
        double dispOfSysselection1 = calculateDispersionFromSelection(ListOfSysSelection1);
        double dispOfSysselection2 = calculateDispersionFromSelection(ListOfSysSelection2);


        double estimateAvr1 = dispOfselection1 / selection1 * (1 - selection1 / SIZE_POP);
        double estimateSumm1 = dispOfselection1 * Math.pow(SIZE_POP, 2) / selection1 * (1 - selection1 / SIZE_POP);

        double estimateAvr2 = dispOfselection2 / selection2 * (1 - selection2 / SIZE_POP);
        double estimateSumm2 = dispOfselection2 * Math.pow(SIZE_POP, 2) / selection2 * (1 - selection2 / SIZE_POP);



        System.out.println("Sum Of Population : " + sumOfPop);
        System.out.println("Sum by first selection " + selection1 + ": " + sumOfselection1);
        System.out.println("Sum by second selection " + selection2 + ": " + sumOfselection2);
        System.out.println("Sum by system selection " + selection1 + ": " + sumOfSysselection1);
        System.out.println("Sum by system selection " + selection2 + ": " + sumOfSysselection2);

        System.out.println("Average by population : " + avrOfPop);
        System.out.println("Avarage by selection " + selection1 + ": " + avrOfselection1);
        System.out.println("Avarage by selection " + selection2 + ": " + avrOfselection2);
        System.out.println("Avarage by system selection (1) " + selection1 + ": " + avrOfSysselection1);
        System.out.println("Avarage by system selection (2) " + selection2 + ": " + avrOfSysselection2);

        System.out.println("Dispertion of population : " + dispOfPop);
        System.out.println("Dispertion by selection" + selection1 + ": " + dispOfselection1);
        System.out.println("Dispertion by selection " + selection2 + ": " + dispOfselection2);
        System.out.println("Dispertion by system selection " + selection1 + ": " + dispOfSysselection1);
        System.out.println("Dispertion by system selection " + selection2 + ": " + dispOfSysselection2);

        System.out.println("Dispertion estimation by selection " + selection1 + ": " + estimateSumm1);
        System.out.println("Dispertion estimation by selection " + selection2 + ": " + estimateSumm2);
        System.out.println("Dispertion estimation of avarage by selection " + selection1 + ": " + estimateAvr1);
        System.out.println("Dispertion estimation of avarage by selection" + selection2 + ": " + estimateAvr2);

    }



  //  public static void TaskC() {

//    }

    public static double calculateSummFromPop(List<Double> list) {
        double sum = 0d;
        for (Double d : list) {
            sum = sum + d;
        }
        return sum;
    }

    public static double calculateSummFromSelection(List<Double> list, long popSize) {
        double sum = 0d;
        for (Double d : list) {
            sum = sum + d;
        }
        return popSize * sum / list.size();

    }

    public static double calculateAVRFromPop(List<Double> list) {
        return calculateSummFromPop(list) / list.size();
    }

    public static double calculateAVRFromSelection(List<Double> list) {
        return calculateSummFromPop(list) / list.size();

    }

    public static double calculateDispersionFromPop(List<Double> list) {
        double sum = 0d;
        double avr = calculateAVRFromPop(list);
        for (Double d : list) {
            sum = sum + Math.pow(d - avr, 2);
        }
        return sum / (list.size() - 1);
    }

    public static double calculateDispersionFromSelection(List<Double> list) {
        double sum = 0d;
        double avr = calculateAVRFromPop(list);
        for (Double d : list) {
            sum = sum + Math.pow(d - avr, 2);
        }
        return sum / (list.size() - 1);
    }



}

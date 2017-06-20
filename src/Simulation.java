import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;


public class Simulation {
//
//    public Simulation(int inputSize){
//        int size = inputSize;
//        ArrayList<Double>numArray = new ArrayList();
//    }

    public static void generateNormalRandomNumbers(ArrayList<Double> numArray, int num){
        Random randomGenerator = new Random();
        for (int i = 0; i < num; i++){
            numArray.add(i, randomGenerator.nextGaussian() * 100);
        }
    }

    public static int[] makeBins (ArrayList<Double> numArray, int numBins){
        Double binRange = getRange(numArray) / numBins;
        int buckets[] = new int[numBins];

        for (int i = 0; i < numArray.size(); i++){
            buckets[(int)(numArray.get(i)/binRange)] += 1;
        }

        return buckets;
    }

//    public static int getBin(double randNum){
//        return (int) (randNum/)
//    }

    public static int getBin(double randNum, double binSize, double minRandNum, double maxRandNum){
        return 0;
    }

    public static Double getMin(ArrayList<Double> numArray){
        return Collections.min(numArray);
    }

    public static Double getMax(ArrayList<Double> numArray){
        return Collections.max(numArray);
    }

    public static Double getRange(ArrayList<Double> numArray){
        return getMax(numArray) - getMin(numArray);
    }
}

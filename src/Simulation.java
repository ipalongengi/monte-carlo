import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;


public class Simulation {

    private final ArrayList<Double>numArray;
    private final int[] buckets;
    private final Double binRange;

    public Simulation(int numElements, int numBins){
        numArray = new ArrayList<>(numElements);
        generateNormalRandomNumbers(numArray, numElements);
        buckets = makeBins(numArray, numBins);
        binRange = getRange(numArray) / numBins;
    }

    private static void generateNormalRandomNumbers(ArrayList<Double> numArray, int num){
        Random randomGenerator = new Random();
        for (int i = 0; i < num; i++){
            numArray.add(i, randomGenerator.nextGaussian() * 100);
        }
    }

    private static int[] makeBins (ArrayList<Double> numArray, int numBins){
        Double binRange = getRange(numArray) / numBins;
        int buckets[] = new int[numBins];
        Double minArray = getMin(numArray);

        for (Double num: numArray){
            int index = (int)((num-minArray)/binRange);
//            System.out.printf("%f falls into bucket #%d\n", num, index);

            if (index == numBins){
                buckets[index - 1] += 1;
            }
            else{
                buckets[index] += 1;
            }
        }
        return buckets;
    }

    private static Double getMin(ArrayList<Double> numArray){
        return Collections.min(numArray);
    }

    private static Double getMax(ArrayList<Double> numArray){
        return Collections.max(numArray);
    }

    private static Double getRange(ArrayList<Double> numArray){
        return getMax(numArray) - getMin(numArray);
    }

    public int getBin(double randNum){
        return (int) ((randNum - getMin(numArray)) / binRange);
    }

    public ArrayList<Double> getArray(){
        return numArray;
    }

    public int[] getBuckets(){
        return buckets;
    }

    public String toString(){
        return String.format("Total Elements: %d, Num of Buckets: %d, Min: %f, Max: %f, Range: %f",
                numArray.size(), buckets.length,  getMin(numArray), getMax(numArray), getRange(numArray));
    }
}

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;


public class Simulation {

    private final ArrayList<Double>numArray;
    private final int[] freqBins;
    private final Double binRange;
    private final int maxFreq;

    public Simulation(int numElements, int numBins){
        numArray = new ArrayList<>(numElements);
        generateNormalRandomNumbers(numArray, numElements);
        freqBins = makeBins(numArray, numBins);
        binRange = getRange(numArray) / numBins;
        maxFreq = findMaxFreq(freqBins);
    }

    private static void generateNormalRandomNumbers(ArrayList<Double> numArray, int num){
        Random randomGenerator = new Random();
        for (int i = 0; i < num; i++){
            numArray.add(i, randomGenerator.nextGaussian());
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

    private static int findMaxFreq(int[] buckets){
        int max = 0;
        for (int freq: buckets){
            if (freq > max){
                max = freq;
            }
        }
        return max;
    }

    public int getBin(double randNum){
        return (int) ((randNum - getMin(numArray)) / binRange);
    }

    public ArrayList<Double> getArray(){
        return numArray;
    }

    public double getRange(){
        return binRange;
    }

    public int[] getBuckets(){
        return freqBins;
    }

    public int getSampleSize() {
        return numArray.size();
    }

    public int getMaxFreq(){
        return maxFreq;
    }

    public String toString(){
        return String.format("Total Elements: %d, Num of Buckets: %d, Min: %f, Max: %f, Range: %f, Max Freq: %d",
                getSampleSize(), freqBins.length,  getMin(numArray), getMax(numArray), getRange(numArray), getMaxFreq());
    }
}

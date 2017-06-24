import java.util.ArrayList;

public class Metrics {
    static double verifyDistribution(ArrayList<Double> numArray, double mean, double stdev, double stdevNum){
        double left = mean - (stdev * stdevNum);
        double right = mean + (stdev * stdevNum);
        int count = 0;

        for (Double val: numArray){
            if ((val >= left) && (val < right)){
                count += 1;
            }
        }

        return ((double)count/numArray.size()) * 100;
    }
}

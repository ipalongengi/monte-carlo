import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;

public class MonteCarlo {
    public static void main(String args[]){
        ArrayList<Double>randomNumbers = new ArrayList();
        Simulation.generateNormalRandomNumbers(randomNumbers, 100);
        System.out.println(randomNumbers);
        System.out.println(randomNumbers.size());
        System.out.println(Simulation.getMin(randomNumbers));
        System.out.println(Simulation.getMax(randomNumbers));
        System.out.println(Simulation.getRange(randomNumbers));
        System.out.println(Simulation.makeBins(randomNumbers, 10));
    }
}

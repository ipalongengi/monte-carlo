import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;

public class MonteCarlo {
    public static void main(String args[]){
        Simulation sim = new Simulation(100000, 11);
        System.out.println(sim.toString());
        for (int tot: sim.getBuckets()){
            System.out.println(tot);
        }
        System.out.println(Metrics.verifyDistribution(sim.getArray(), 0.0, 1.0, 1.0));
        System.out.println(Metrics.verifyDistribution(sim.getArray(), 0.0, 1.0, 2.0));
        System.out.println(Metrics.verifyDistribution(sim.getArray(), 0.0, 1.0, 3.0));
    }
}

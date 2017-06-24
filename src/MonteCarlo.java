import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;

public class MonteCarlo {
    public static void main(String args[]){
        Simulation sim = new Simulation(100, 20);
        System.out.println(sim.toString());
    }
}

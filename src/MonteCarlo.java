import javax.swing.*;

public class MonteCarlo {
    public static void main(String args[]){
        Simulation sim = new Simulation(1000000, 11);
        System.out.println(sim.toString());

        // Verify that the simulation above follow the Normal Distribution
        System.out.printf("The percentage of random variables that fall within 1 SD from the Mean is: %f%%\n",
                Metrics.verifyDistribution(sim.getArray(), 0.0, 1.0, 1.0));
        System.out.printf("The percentage of random variables that fall within 2 SD from the Mean is: %f%%\n",
                Metrics.verifyDistribution(sim.getArray(), 0.0, 1.0, 2.0));
        System.out.printf("The percentage of random variables that fall within 3 SD from the Mean is: %f%%\n",
                Metrics.verifyDistribution(sim.getArray(), 0.0, 1.0, 3.0));

        // Create the histogram using the simulation object instantiated earlier
        Histogram h = new Histogram(sim);
        JFrame visuals = new JFrame();

        visuals.setTitle("Histogram of Normally Distributed Random Variables");
        visuals.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        visuals.add(h);
        visuals.setSize(1200, 800);
        visuals.setVisible(true);
    }
}

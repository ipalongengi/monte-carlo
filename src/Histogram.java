import javax.swing.JPanel;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Collections;

public class Histogram extends JPanel{
    private final int TOP_MARGIN = 20;
    private final int BOTTOM_MARGIN = 20;
    private final int LEFT_MARGIN = 20;
    private final int RIGHT_MARGIN = 20;

    private final Double minRandNum;
    private final int bins[];
    private final int maxFreq;
    private final Double arrayRange;

    // Constructor
    public Histogram(Simulation s){
        setBackground(Color.WHITE);

        // Fields pertinent to the actual ArrayList of random numbers
        minRandNum = Collections.min(s.getArray());
        arrayRange = s.getRange();

        // Fields pertinent to the bucket array
        bins = s.getBuckets();
        maxFreq = s.getMaxFreq();
    }

    // Draws the histogram
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawXAxis(g);
        drawYAxis(g);
        drawBins(g);
        drawXLabels(g);
        drawYLabels(g);
    }

    // Draws the x-axis
    private void drawXAxis(Graphics g){
        int y1 = getHeight() - BOTTOM_MARGIN;
        int x2 = getWidth() - RIGHT_MARGIN;
        g.drawLine(LEFT_MARGIN, y1, x2, y1);
    }

    // Draws the y-axis
    private void drawYAxis(Graphics g){
        int y1 = getHeight() - BOTTOM_MARGIN;
        g.drawLine(LEFT_MARGIN, y1, LEFT_MARGIN, TOP_MARGIN);
    }

    // Draws the bins
    private void drawBins(Graphics g){
        g.setColor(Color.GRAY);

        // Find the optimal width for every bins from the available effective width of the frame
        int bestWidth = (getWidth() - LEFT_MARGIN - RIGHT_MARGIN)/bins.length;

        for (int i = 0; i < bins.length; i++){
            g.drawRect((bestWidth * i) + LEFT_MARGIN,
                    getHeight() - BOTTOM_MARGIN - scaleY(bins[i]),
                    bestWidth,
                    scaleY(bins[i]));
            g.fillRect((bestWidth * i) + LEFT_MARGIN,
                    getHeight() - BOTTOM_MARGIN - scaleY(bins[i]),
                    bestWidth - 1,
                    scaleY(bins[i]));
        }

    }

    // Draws the labels along the x-axis
    private void drawXLabels(Graphics g){
        g.setColor(Color.BLACK);

        // Format the output of labels on the x-axis
        // to only show up to 2 significant digits
        DecimalFormat formatter = new DecimalFormat();
        formatter.setMinimumFractionDigits(2);
        formatter.setMaximumFractionDigits(2);

        int bestWidth = (getWidth() - LEFT_MARGIN - RIGHT_MARGIN)/bins.length;

        // Sample Code - might be useful
        double labelVal = minRandNum;
        String label = formatter.format(labelVal);
        int x = LEFT_MARGIN;
        int y = getHeight() - BOTTOM_MARGIN + 12;
        for (int ignored : bins){
            g.drawString(label, x - 12, y);
            x += bestWidth;
            labelVal += arrayRange;
            label = formatter.format(labelVal);
        }
        g.drawString(label, x - 12, y);
    }

    // Draws the labels along the y-axis
    private void drawYLabels(Graphics g){
        g.setColor(Color.BLUE);

        DecimalFormat formatter = new DecimalFormat("#,###");

        int bestWidth = (getWidth() - LEFT_MARGIN - RIGHT_MARGIN)/bins.length;


        String label;
        int x = LEFT_MARGIN;
        int y = getHeight() - BOTTOM_MARGIN + 5;
        for (int b: bins){
            label = formatter.format(b);
            g.drawString(label, x + 5, y - scaleY(b) - 12);
            x += bestWidth;
        }
    }

    private int scaleY (int val){
        int effectiveArea = getHeight() - BOTTOM_MARGIN - TOP_MARGIN;
        return (int)(((float)val / maxFreq) * effectiveArea);
    }
}
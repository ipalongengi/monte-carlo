import javax.swing.JPanel;
import java.awt.*;
import java.text.DecimalFormat;

public class Histogram extends JPanel{
    final int TOP_MARGIN = 20;
    final int BOTTOM_MARGIN = 20;
    final int LEFT_MARGIN = 20;
    final int RIGHT_MARGIN = 20;

    // Declare instance variables here...

    // Constructor
    public Histogram(Simulation s){
        setBackground(Color.WHITE);

        // declarations of instance variables
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
    public void drawXAxis(Graphics g){
        int x1 = LEFT_MARGIN;
        int y1 = getHeight() - BOTTOM_MARGIN;
        int x2 = getWidth() - RIGHT_MARGIN;
        int y2 = y1;
        g.drawLine(x1, y1, x2, y2);
    }

    // Draws the y-axis
    public void drawYAxis(Graphics g){
        int x1 = LEFT_MARGIN;
        int y1 = getHeight() - BOTTOM_MARGIN;
        int x2 = x1;
        int y2 = TOP_MARGIN;
        g.drawLine(x1, y1, x2, y2);
    }

    // Draws the bins
    public void drawBins(Graphics g){
        g.setColor(Color.GRAY);
        // Put additional code over here
    }

    // Draws the labels along the x-axis
    public void drawXLabels(Graphics g){
        g.setColor(Color.BLACK);

        DecimalFormat formatter = new DecimalFormat();
        formatter.setMinimumFractionDigits(2);
        formatter.setMaximumFractionDigits(2);

//        // Sample Code - might be useful
//        double labelVal = min;
//        String label = formatter.format(labelVal);
//        int x = LEFT_MARGIN;
//        int y = getHeight() - BOTTOM_MARGIN + 12;
//        for (int b: bins){
//            g.drawString(label, x - 12, y);
//            x += binWidth;
//            labelVal += binSize;
//            label = formatter.format(labelVal);
//        }
//        g.drawString(label, x - 12, y);
    }

    // Draws the labels along the y-axis
    public void drawYLabels(Graphics g){
        g.setColor(Color.BLUE);

        DecimalFormat formatter = new DecimalFormat();
        formatter.setMinimumFractionDigits(2);
        formatter.setMaximumFractionDigits(2);

//        // Sample Code - might be useful
//        double labelVal = min;
//        String label = formatter.format(labelVal);
//        int x = LEFT_MARGIN;
//        int y = getHeight() - BOTTOM_MARGIN + 12;
//        for (int b: bins){
//            g.drawString(label, x - 12, y);
//            x += binWidth;
//            labelVal += binSize;
//            label = formatter.format(labelVal);
//        }
//        g.drawString(label, x - 12, y);
    }

    private Double scaleY (int val, Double ratio){
        return 0.0;
    }
}
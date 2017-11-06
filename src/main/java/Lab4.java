import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.awt.*;
import java.util.Random;

/**
 * Created by Oksana on 07.05.2017.
 */
public class Lab4 extends ApplicationFrame {
    private static Random random = new Random();

    private static int N = 13;
    private static int NG = 42;
    private static int n = 1000;
    private static double FisherConst = 1.03;
    private static double criteriaPoint;

    private static double a;
    private static double b;
    private static double R;


    private static double[] e = new double[n];
    private static double[] x = new double[n];
    private static double[] y = new double[n];
    private static double[] s = new double[n];
    private static double s2 = 0;
    private static double SofX = 0;
    private static double SofY = 0;
    private static double SofBeta = 0;
    private static double SofAlfa = 0;
    private static double[] dividionOfEAndS = new double[n];
    private static double dividionOfS2AndSofY = 0;

    private static double avgY;
    private static double avgX;
   // private XYSeries seriesAXplusB;

    public Lab4(String title) {
        super(title);

        final XYDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

    }

    private JFreeChart createChart(XYDataset dataset) {
        final JFreeChart chart = ChartFactory.createXYLineChart(
                "Lab 4",      // chart title
                "X",                      // x axis label
                "Y",                      // y axis label
                dataset,                  // data
                PlotOrientation.VERTICAL,
                true,                     // include legend
                true,                     // tooltips
                false                     // urls
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(Color.black);

//        final StandardLegend legend = (StandardLegend) chart.getLegend();
        //      legend.setDisplaySeriesShapes(true);

        // get a reference to the plot for further customisation...
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.black);
        //    plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, false);
        renderer.setSeriesShapesVisible(1, false);
        plot.setRenderer(renderer);

        // change the auto tick unit selection to integer units only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        // OPTIONAL CUSTOMISATION COMPLETED.

        return chart;

    }

    private XYDataset createDataset() {
        final XYSeries seriesY = new XYSeries("ChartY");
        final XYSeries seriesYWave = new XYSeries("ChartYWave");
        final XYSeries seriesAXplusB = new XYSeries("ax+b");
        for (int i = 0 ; i<n;++i) {
            seriesY.add(i,y[i]);
            seriesYWave.add(i,(y[i]-avgY));
            seriesAXplusB.add(i, (0.05*a*x[i]+b));
        }
        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(seriesY);
        dataset.addSeries(seriesYWave);
        dataset.addSeries(seriesAXplusB);
        return  dataset;
    }

    public static void main(String[] args) {

        int n = 1000;
        for (int i = 0; i < 1000; ++i) {
            x[i] = i+(( random.nextDouble() * N) / NG);
        }
        for (int i = 0; i < 1000; i++) {
            y[i] = N * random.nextDouble() * x[i] + NG * random.nextDouble() + N;

        }
        b = ((n * sumOfMultiplyOfXAndY() - sumOfXi() * sumofYi()) / (n * sumOfXiInPow() - sumOfXiPow()));
        a = (sumofYi() - b * sumOfXi()) / n;
        avgY = sumofYi() / n;
        avgX = sumOfXi() / n;

        //Found the value of e
        for (int i = 0; i < n; i++) {
            e[i] = y[i] - avgY;

        }
        // Here are we are counting S^2
        for (int i = 0; i < n; i++) {
            s[i] = (sumOfE() / (n - 2)) * (1 - 1 / n - ((x[i] - avgX) * (x[i] - avgX)) / (sumOfDifferenceBetweenXandAvgXinPow()));
        }

        //Dividion of E and S^2
        for (int i = 0; i < n; i++) {
            dividionOfEAndS[i] = Math.abs(e[i] / s[i]);

        }
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (dividionOfEAndS[maxIndex] < dividionOfEAndS[i]) {
                maxIndex = i;
            }
        }
        R = dividionOfEAndS[maxIndex];
        System.out.println(R + " This is R");
        //Hypotysis tha Beta = b

        // count S^2x

            SofX = (1 / (n - 1) * (sumOfDifferenceBetweenXandAvgXinPow()));


        //counr S2
        double v = sumForS2();
            s2=((double)1/((double) (n)-2))*v;


        //count S beta

            SofBeta=(Math.sqrt(s2)/(Math.sqrt(SofX)*Math.sqrt(n-1)));


        // Hypotysis 2

            SofAlfa = (Math.sqrt(s2)*Math.sqrt(((1 / n) + ((avgX * avgX) / ((n - 1) * SofX)))));


        // Hypotysis 3

            SofY = ((double)1 / ((double) n - 1) * sumOfDifferenceBetweenYAndAvgY());

            dividionOfS2AndSofY  = Math.abs(s2 / SofY);




        criteriaPoint = dividionOfS2AndSofY;
        System.out.println(criteriaPoint + " CriteriaPoint");


        //     System.out.println(e[2]+"  "+ e[3]);
        System.out.println(a + " This is a");
        System.out.println(b + " This is b");
        System.out.println(avgY + " This is avgX");
        System.out.println(avgX+ " This is avgY");
        System.out.println(s[1]);
        Lab4 lab4 = new Lab4("Lab4");
        lab4.pack();
        RefineryUtilities.centerFrameOnScreen(lab4);
        lab4.setVisible(true);
    }

    private static double sumOfXi() {
        double sum = 0;
        for (int i = 0; i < n; ++i) {

            sum += x[i];
        }
        return sum;
    }

    private static double sumofYi() {
        double sumY = 0;
        for (int i = 0; i < n; i++) {
            sumY += y[i];
        }
        return sumY;
    }

    private static double sumOfMultiplyOfXAndY() {
        double sumXY = 0;
        for (int i = 0; i < n; i++) {
            sumXY += x[i] * y[i];
        }
        return sumXY;
    }

    private static double sumOfXiInPow() {
        double sum = 0;
        for (int i = 0; i < n; ++i) {

            sum += x[i] * x[i];

        }

        return sum;
    }

    private static double sumOfXiPow() {
        double sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += x[i];
        }

        return sum * sum;
    }

    private static double sumOfE() {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += e[i] * e[i];

        }
        return sum;
    }

    private static double sumOfDifferenceBetweenXandAvgXinPow() {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (x[i] - avgX) * (x[i] - avgX);

        }
        return sum;
    }
    private static double sumOfDifferenceBetweenYAndAvgY(){
        double sum = 0;
        for (int i = 0; i <n ; i++) {
            sum += (y[i]-avgY)*(y[i]-avgY);
        }
        return sum;
    }

    private static double sumForS2() {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (y[i] - a - b * x[i]) * (y[i] - a - b * x[i]);

        }
        return sum;
    }

}

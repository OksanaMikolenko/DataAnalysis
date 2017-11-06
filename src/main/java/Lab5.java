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
 * Created by Oksana on 19.05.2017.
 */
public class Lab5 extends ApplicationFrame {
    public static int NG = 26;
    public static int n = NG/2;
    public static int N = (int) Math.pow(2,n);
    public static double M = 13;
    public static double L = N/2-1;
    public static double A0;
    public static double ANdividedon2;
    public static double Al;
    public static double[] Aj = new double[N/2];
    public static double[] Bj =  new double[N/2];
    public static double[] Cj = new double[N/2];
    public static double dl;
    public Lab5(String title) {
        super(title);

        final XYDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

    }



    private JFreeChart createChart(XYDataset dataset) {
        final JFreeChart chart = ChartFactory.createXYLineChart(
                "Lab 5",      // chart title
                "X",                      // x axis label
                "Y",                      // y axis label
                dataset,                  // data
                PlotOrientation.VERTICAL,
                true,                     // include legend
                true,                     // tooltips
                false                     // urls
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(Color.white);

//        final StandardLegend legend = (StandardLegend) chart.getLegend();
        //      legend.setDisplaySeriesShapes(true);

        // get a reference to the plot for further customisation...
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
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
 //       final XYSeries seriesY = new XYSeries("ChartY");
       final XYSeries seriesY1 = new XYSeries("ChartS2");


  //      for (int i = 0 ; i<N/2;++i) {
    //        seriesY.add(i,Cj[i]);
//
  //      }
        for (int i = 0; i<N;++i) {
           seriesY1.add(i,s2[i]);


       }
        final XYSeriesCollection dataset = new XYSeriesCollection();
      //  dataset.addSeries(seriesY);
        dataset.addSeries(seriesY1);
     //   dataset.addSeries(seriesYWave);
      //  dataset.addSeries(seriesAXplusB);
        return  dataset;
    }

    private  static Random random = new Random();

    private static double[] s = new double[N] ;
    private static double[] va = new double[N];
    private static double[] vb = new double[N];

    private static double[] s2 = new double[N] ;


    public static void main(String[] args) {

        for (int i = 0; i < N; i++) {
            s[i] = 2*random.nextDouble()+NG*Math.cos(2*M*Math.PI*(i/N))*(1+0.1*random.nextDouble())+17*Math.cos(4*M*i*Math.PI/N +random.nextDouble())+3*Math.cos(5*M*i*Math.PI/N)*(random.nextDouble()+NG);

        }

        A0 = sumForA0()/N;
        Al = sumForA1()*2/N;
        double v = sumForBj();
        double v1 = sumForAj();
        ANdividedon2 = sumForANdividedon2()/N;
        for (int i = 0; i <N/2 ; i++) {
           Bj[i] = v*2/N;
        }
        for (int i = 0; i < N/2; i++) {
          Aj[i] = v1*2/N;
        }

        for (int i = 0; i <N/2 ; i++) {
        Cj[i]= Math.sqrt((Math.pow(Aj[i],2)+Math.pow(Bj[i],2)));
        }
dl = sumOfAjAndSin()+sumOfBjAndSin();
        System.out.println(dl);


  /*  for (int i = 0; i <N ; i++) {
            s2[i] = s[i];
        }
*/

       for (int i = 0; i <N ; i++) {
          va[i] = 0.42 - 0.5*Math.cos(2*Math.PI*i/N)+0.08*Math.cos(4*Math.PI*i/N);
        }
        for (int i = 0; i <N ; i++) {
            s2[i]=s[i]*va[i];
        }

   for (int i = 0; i <N ; i++) {
            vb[i] = 0.54 -0.46*Math.cos(2*Math.PI*i/N);
        }
    /*    for (int i = 0; i <N ; i++) {
         s2[i] = s[i]*vb[i];
        }
        */
        Lab5 lab5 = new Lab5("Lab5");
        lab5.pack();
        RefineryUtilities.centerFrameOnScreen(lab5);
        lab5.setVisible(true);
    }
    private static double sumForA1(){
        double sum = 0;
        for (int i = 0; i <N-1 ; i++) {
            sum +=(s[i]*Math.cos(2*Math.PI*i*L/N));
        }
        return sum;
    }
    private static double sumForA0(){
        double sum = 0;
        for (int i = 0; i <N; i++) {
            sum += s[i]*Math.cos(0);

        }
        return sum;
    }
    private static double sumForBj(){
        double sum = 0;
        for (int i = 0; i <N-1 ; i++) {
            for (int j = 0; j <N/2 ; j++) {

            sum += s[i]*Math.sin(2*Math.PI*i*j/N);
            }
        }
        return sum;
    }
    private static double sumForAj(){
        double sum = 0;
        for (int i = 0; i <N-1 ; i++) {
            for (int j = 0; j <N/2 ; j++) {

                sum += s[i]*Math.cos(2*Math.PI*i*j/N);
            }
        }
        return sum;
    }
    private static double sumForANdividedon2(){
        double sum = 0;
        for (int i = 0; i <N-1 ; i++) {
            sum +=s[i]*Math.cos(Math.PI*i/L);

        }
        return sum;
    }
    private static double sumOfBjAndSin(){
        double sum = 0;
        for (int j = 0; j <N/2 ; j++) {
            for (int i = 0; i <N/2 ; i++) {


                sum += Bj[i] * Math.sin(2 * Math.PI * j * i / N);
            }
        }
        return sum;
    }
    private static double sumOfAjAndSin(){
        double sum = 0;
        for (int j = 0; j <N/2 ; j++) {
            for (int i = 0; i <N/2 ; i++) {


                sum += Aj[i] * Math.sin(2 * Math.PI * j * i / N);
            }
        }
        return sum;
    }



}


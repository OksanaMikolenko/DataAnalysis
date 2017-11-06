import java.util.Random;

/**
 * Created by Oksana on 29.05.2017.
 */
public class TaskC_Lab2 {
    public static int M = 100;
    public static int MG = 42;
    public static int N = 10000;
    public static double Yi;
    public static double Ys;
    public static double DYinpow;
    public static double DYwaveS;
    public static double DYwave;
    public static double Ywave;
    public static double YwaveS;
    public static double SinPow;
  //  public static double leftSideInterval;
   // public static double rightSideInterval;
    public static int a = M + 10;
    public static int b = MG + 2 * M;
    public static double[] arrayX = new double[M];
    public static double[] arrayY = new double[N];
    private static Random random = new Random();

    public static void main(String[] args) {
        for (int i = 0; i < M; i++) {
            arrayX[i] = random.nextDouble();

        }
        for (int i = 0; i < N; i++) {
            arrayY[i] = random.nextDouble();

        }
        Yi = sumOfY();
        Ys = sumOfY()/N;
        DYinpow = sumYiMinusYs()/(N-1);
        System.out.println("Task A");
        System.out.println(Yi + " Yi");
        System.out.println(Ys + " Ys");
        System.out.println(DYinpow + " DY^2");
        Ywave = N * sumOfXdevidedOnM();
        YwaveS = sumOfX()/M;
        SinPow = sumOfXminusYwaveS()/(M-1);
        DYwaveS = (SinPow/M)*(1-M/N);
        DYwave = (SinPow*N*N/M)*(1-M/N);
        System.out.println("Task B");
        System.out.println(Ywave + " Ywave" );
        System.out.println(YwaveS + " YwaveS");
        System.out.println(SinPow + " S^2");
        System.out.println(DYwaveS + " DYwaveS");
        System.out.println(DYwave + " DYwave");

        System.out.println("Task D");
    }

    public static double sumOfY() {
        double sum = 0;

        for (int i = 0; i < N; i++) {
            sum +=arrayY[i];

        }
        return sum;
    }
    public static double sumYiMinusYs(){
        double sum = 0;
        for (int i = 0; i <N ; i++) {
            sum += (arrayY[i]-Ys)*(arrayY[i]-Ys);
        }
        return sum;

    }
    public static double sumOfXdevidedOnM(){
        double sum = 0;
        for (int i = 0; i <M ; i++) {
            sum += arrayX[i]/M;
        }
        return sum;
    }
    public static double sumOfX(){
        double sum = 0;
        for (int i = 0; i <M ; i++) {
            sum += arrayX[i];
        }
        return sum;
    }
    public static double sumOfXminusYwaveS(){
        double sum = 0;
        for (int i = 0; i <M ; i++) {
            sum +=(arrayX[i]-YwaveS)*(arrayX[i]-YwaveS);
        }
        return sum;
    }
}

import java.util.Random;

/**
 * Created by Oksana on 29.05.2017.
 */
public class Lab6 {
    public static int NG = 42;
    public static int M = 13;
    public static int n = NG / 4;
    public static double g;
    public static double PSY;

    public static int N = (int) Math.pow(2, n);
    public static double x ;
    public static double[] S = new double[N];
    public static double [][] W = new double[N][N];
    public static double[][][] f = new double[N][N][N];
    private static Random random = new Random();

    public static void main(String[] args) {

            x = random.nextDouble();


         if(x >=0 && x < 1/2){
             PSY = 1;
         }else if (x >= 1/2 && x<1){
             PSY = -1;
         }else{
             PSY = 0;
         }
        for (int i = 0; i < N; i++) {
            S[i] = 2 * random.nextDouble() + NG * Math.cos(2 * M * Math.PI * i / N) * (1 + 0.1 * random.nextDouble()) + 17 * Math.cos(4 * M * Math.PI * i / N + random.nextDouble()) + 3 * Math.cos(7 * M * Math.PI * i / N) * (random.nextDouble() + NG);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {

                    f[i][j][k] = Math.pow(2, j / 2) *PSY;
                }

            }


        }
        for (int j = 0; j <N ; j++) {

        }
    }
    public static double sum(){
        double sum = 0;
        for (int i = 0; i <N-1 ; i++) {
            sum +=S[i]*f[i][N][N];
        }
        return sum;
    }
}

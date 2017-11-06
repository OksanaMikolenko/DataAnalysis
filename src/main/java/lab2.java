import java.util.Random;

/**
 * Created by Oksana on 29.05.2017.
 */
public class lab2 {
    public static int M = 13;
    public static int MG = 42;
    public static int N = 1000;
    public static double Yi;
    public static double Ys;
    public static double DYinpow;
    public static double DYwaveS;
    public static double DYwave;
    public static double Ywave;
    public static double YwaveS;
    public static double SinPow;
    public static double Wh;
    public static double n = N / 5;
    public static double leftSideInterval;
    public static double rightSideInterval;
    public static double leftSideIntervalForFullPopulation;
    public static double rightSideIntervalForFullPopulation;
    public static int a = M + 10;
    public static int b = MG + 2 * M;
    public static double avgYwave;
    public static double avgYu;
    public static double Yh;
    public static double Y;
    public static double YtwoWaves;
    public static double StrateAvgSum;
    public static double Sh;
    public static double sh;
    public static double DYst;
    public static double Dyst;
    public static double YwaveSt;
    public static double YtwoWavesSt;
    public static double z = 2.58;
    public static double[] arrayX = new double[M];
    public static double[] arrayY1 = new double[N / 5];
    public static double[] arrayY2 = new double[N / 5];
    public static double[] arrayY3 = new double[N / 5];
    public static double[] arrayY4 = new double[N / 5];
    public static double[] arrayY5 = new double[N / 5];
    public static double[] arrayY = new double[N];
    private static Random random = new Random();

    public static void main(String[] args) {
        for (int i = 0; i < M; i++) {
            arrayX[i] = Math.random();

        }
        for (int i = 0; i < N; i++) {
            arrayY[i] = Math.random();

        }

        Yi = sumOfY();
        Ys = sumOfY() / N;
        DYinpow = sumYiMinusYs() / (N - 1);
        System.out.println("Task A");
        System.out.println(Yi + " Yi");
        System.out.println(Ys + " Ys");
        System.out.println(DYinpow + " DY^2");
        Ywave = N * sumOfXdevidedOnM();
        YwaveS = sumOfX() / M;
        SinPow = sumOfXminusYwaveS() / (M - 1);
        DYwaveS = (SinPow / M) * (1 - M / N);
        DYwave = (SinPow * N * N / M) * (1 - M / N);
        leftSideInterval = YwaveS - z * Math.sqrt(SinPow) / M * Math.sqrt(1 - M / N);
        rightSideInterval = YwaveS + z * Math.sqrt(SinPow) / M * Math.sqrt(1 - M / N);
        leftSideIntervalForFullPopulation = N * YwaveS - z * Math.sqrt(SinPow) * N / Math.sqrt(M) * Math.sqrt(1 - M / N);
        rightSideIntervalForFullPopulation = N*YwaveS + z * Math.sqrt(SinPow)*N/Math.sqrt(M)* Math.sqrt(1 - M / N);
        System.out.println("Task B");
        System.out.println(Ywave + " Ywave");
        System.out.println(YwaveS + " YwaveS");
        System.out.println(SinPow + " S^2");
        System.out.println(DYwaveS + " DYwaveS");
        System.out.println(DYwave + " DYwave");
        System.out.println(leftSideInterval + " LeftsideInterval ");
        System.out.println(rightSideInterval + " RightSideInerval");
        System.out.println(leftSideIntervalForFullPopulation + " left");
        System.out.println(rightSideIntervalForFullPopulation + "right");


        System.out.println("Task D");
        Wh = (N / 10) / n;
        avgYwave = sumYhi() / (N / 5);
        Yh = sumYhi();
        Y = sumYhi() + sumYhi2() + sumYhi3() + sumYhi4() + sumYhi5();
        avgYu = Y / N * (5 * sumYhi() / N);
        Sh = sumOfXminusYwaveS() / (N / 5 - 1);
        YtwoWaves = Y / n;
        StrateAvgSum = (N / 5) / n * Y;
        sh = sumForS() / (n - 1);
        YwaveSt = StrateAvgSum * 5;
        YtwoWavesSt = YwaveSt / N;
        DYst = sumforDY();
        Dyst = DYst / (N * N);
        System.out.println(Yh + " Yh");
        System.out.println(Y + " Y");
        System.out.println(avgYu + " Y");
        System.out.println(DYst + " DYst");
        System.out.println(Dyst + "Dyst");
        System.out.println(Sh + " Sh");
        for (int i = 0; i < N / 5; i++) {
            arrayY1[i] = random.nextDouble();

        }
        for (int i = 0; i < N / 5; i++) {
            arrayY2[i] = random.nextDouble();
        }
        for (int i = 0; i < N / 5; i++) {
            arrayY3[i] = random.nextDouble();
        }
        for (int i = 0; i < N / 5; i++) {
            arrayY4[i] = random.nextDouble();
        }
        for (int i = 0; i < N / 5; i++) {
            arrayY5[i] = random.nextDouble();
        }
    }

    public static double sumOfY() {
        double sum = 0;

        for (int i = 0; i < N; i++) {
            sum += arrayY[i];

        }
        return sum;
    }

    public static double sumYiMinusYs() {
        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (arrayY[i] - Ys) * (arrayY[i] - Ys);
        }
        return sum;

    }

    public static double sumOfXdevidedOnM() {
        double sum = 0;
        for (int i = 0; i < M; i++) {
            sum += arrayX[i] / M;
        }
        return sum;
    }

    public static double sumOfX() {
        double sum = 0;
        for (int i = 0; i < M; i++) {
            sum += arrayX[i];
        }
        return sum;
    }

    public static double sumOfXminusYwaveS() {
        double sum = 0;
        for (int i = 0; i < M; i++) {
            sum += (arrayX[i] - YwaveS) * (arrayX[i] - YwaveS);
        }
        return sum;
    }

    public static double sumYhi() {
        double sum = 0;
        for (int i = 0; i < N / 5; i++) {
            sum += arrayY1[i];

        }
        return sum;
    }

    public static double sumYhi2() {
        double sum = 0;
        for (int i = 0; i < N / 5; i++) {
            sum += arrayY2[i];

        }
        return sum;
    }

    public static double sumYhi3() {
        double sum = 0;
        for (int i = 0; i < N / 5; i++) {
            sum += arrayY3[i];

        }
        return sum;
    }

    public static double sumYhi4() {
        double sum = 0;
        for (int i = 0; i < N / 5; i++) {
            sum += arrayY4[i];

        }
        return sum;
    }

    public static double sumYhi5() {
        double sum = 0;
        for (int i = 0; i < N / 5; i++) {
            sum += arrayY5[i];

        }
        return sum;
    }

    public static double sumYhiMinusAvgY() {
        double sum = 0;
        for (int i = 0; i < N / 5; i++) {
            sum += 5 * (arrayY1[i] - avgYwave) * (arrayY1[i] - avgYwave);

        }
        return sum;
    }

    public static double sumForS() {
        double sum = 0;
        for (int i = 0; i < N / 5; i++) {
            sum += 5 * (arrayY1[i] - YtwoWaves) * (arrayY1[i] - YtwoWaves);

        }
        return sum;
    }

    public static double sumforDY() {
        double sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += (1 - n / (N / 5)) * (N / 5 * N / 5) * sh / n;
        }
        return sum;
    }


}

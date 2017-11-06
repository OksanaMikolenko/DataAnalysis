package com.company;

import java.util.Random;

/**
 * Created by Oksana on 06.05.2017.
 */
public class TwoFactorAnalysis {
    private static int N = 100;
    private static int NUMBER = 4;
    private static int k = 5;
    private static int m = 4;
    private static Random random = new Random();
    private static double Q;
    private static double Q2;
    private static double Q3;
    private static double Q4;
    private static double Q5;
    private static double Q6;
    private static double S0;
    private static double Sa;
    private static double Sab;
    private static double Sb;
    private static double FTeora = 2.48;
    private static double FTeorb = 2.61;
    private static double FTeor1 = 1.6664;

    public static double[][][] mas = new double[m][k][N];
    private static double[][] array = new double[m][k];
    private static double sum = 0;

    //  private static int n;
    public static void main(String[] args) {
        double[][] koef = new double[][]{{1, 3.5, 3.8, 1.4, 2},
                {1, 2.5, 2.8, 2.4, 3},
                {1, 1.5, 1.8, 3.4, 4},
                {1, 0.5, 0.8, 4.4, 5}};


        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < k; ++j) {
                sum = 0;
                for (int q = 0; q < N; q++) {
                    mas[i][j][q] = NUMBER * koef[i][j] + random.nextDouble();
                    sum += mas[i][j][q];
                }
                array[i][j] = (sum) / N;
            }
        }
        Q = sumArrayAvg();
        Q2 = sumOfXi() / m;
        Q3 = sumOfXj() / k;
        Q4 = sumOfXiPow() / (m * k);
        Q5 = sumOfMasPow();
        S0 = (Q + Q4 - Q2 - Q3) / ((k - 1) * (m - 1));
        Sa = (Q2 - Q4) / (k - 1);
        Sb = (Q3 - Q4) / (m - 1);
        Sab = (Q5 - N * Q) / (m * k * (N - 1));
        System.out.println("Q1 = " + Q);
        System.out.println("Q2 = " + Q2);
        System.out.println("Q3 = " + Q3);
        System.out.println("Q4 = " + Q4);
        System.out.println("Q5 = " + Q5);
        System.out.println("S0 = " + S0);
        System.out.println("Sa = " + Sa);
        System.out.println("Sb = " + String.format("%(.7f", Sb));
        System.out.println("Sab = " + Sab);
        System.out.println("Sa / S0 =    " + Sa / S0 +
                "\n  Sb / S0  = " + Sb / S0 +
                "\n  N*S0/Sab = " + N * S0 / Sab);
        if (Sa / S0 > FTeora) {
            System.out.println("A is good criteria");
        } else
            System.out.println("A is bad criteria");
        if (Sb / S0 > FTeorb) {
            System.out.println("B is good criteria");
        } else
            System.out.println("B is bad criteria");
        if (N * S0 / Sab > FTeor1) {
            System.out.println("Both criterias are good");
        } else
            System.out.println("Both criterias are bad");
    }

    private static double sumOfMasPow() {
        double sum = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < k; ++j) {
                for (int q = 0; q < N; q++) {
                    sum += (mas[i][j][q] * mas[i][j][q]);
                }
            }
        }
        return sum;
    }

    private static double sumOfXiPow() {
        double sum = 0;
        for (int i = 0; i < k; ++i) {
            for (int j = 0; j < m; ++j) {
                sum += array[j][i];
            }
        }

        return sum * sum;
    }

    private static double sumOfXi() {
        double sum = 0;
        for (int i = 0; i < m; ++i) {
            double localSum = 0;
            for (int j = 0; j < k; ++j) {
                localSum += array[i][j];
            }
            sum += (localSum * localSum);
        }
        return sum;
    }

    private static double sumOfXj() {
        double sum = 0;
        for (int i = 0; i < m; ++i) {
            double localSum = 0;
            for (int j = 0; j < k; ++j) {
                localSum += array[i][j];
            }
            sum += (localSum * localSum);
        }
        return sum;
    }

    private static double sumArrayAvg() {
        double sum = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < k; ++j) {
                sum += (array[i][j] * array[i][j]);
            }
        }
        return sum;
    }


}

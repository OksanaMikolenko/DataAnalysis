package com.company;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Oksana on 06.05.2017.
 */
public class OneFactorAnalysis {
    private static int N = 1000;
    private static int NUMBER = 2;
    private static Random random = new Random();
    private static double[] S = new double[5];
    private static double S0;
    private static double GTEOR = 0.47;
    private static double FTEOR = 2.3719;
    private static double alfa = 0.95;
    private static double G;
    private static double maxS = 0;
    public static double S1 = 0;
    public static double SA = 0;
    public static double avg;

    public static void main(String[] args) {
        double[] koef = new double[]{1, 0.5, 0.8, 1.4, 2};
        Scanner scan = new Scanner(System.in);
        double[][] mas = new double[5][N];
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < N; ++j) {
                mas[i][j] = NUMBER * koef[i] + random.nextDouble();
            }
        }
        for (int i = 0; i < 5; ++i) {

            double localSum1 = 0;
            double localSum2 = 0;
            for (int j = 0; j < N; ++j) {
                localSum1 += mas[i][j] * mas[i][j];
                localSum2 += mas[i][j];
            }
            localSum2 = (localSum2 * localSum2) / N;
            localSum1 -= localSum2;
            S[i] = localSum1 / (N - 1);
            maxS = Math.max(S[i], maxS);
        }
        G = maxS / (S[0] + S[1] + S[2] + S[3] + S[4]);
        if (GTEOR < G) {
            System.out.println("END");
            System.exit(0);
        }
        /// Шукаю S0 в квадрате
        double sum1 = 0;
        double sum2 = 0;
        for (int i = 0; i < 5; ++i) {
            double localSum1 = 0;
            double localSum2 = 0;
            for (int j = 0; j < N; ++j) {
                localSum1 += mas[i][j] * mas[i][j];
                localSum2 += mas[i][j];
            }
            sum1 += localSum1;
            sum2 += localSum2 * localSum2;
        }
        sum2 /= N;
        sum1 -= sum2;
        S0 = sum1 / (5 * (N - 1));
        // Шукаю S^2
        sum1 = 0;
        sum2 = 0;
        for (int i = 0; i < 5; ++i) {
            double localSum1 = 0;
            double localSum2 = 0;
            for (int j = 0; j < N; ++j) {
                localSum1 += mas[i][j] * mas[i][j];
                localSum2 += mas[i][j];
            }
            sum1 += localSum1;
            sum2 += localSum2;
        }

        sum2 = sum2 * sum2 / (N * 5);
        sum1 -= sum2;
        S1 = sum1 / (5 * (N - 1));
        SA = 0;
        sum1 = 0;
        sum2 = 0;
        // Шукаю SA ^2
        for (int i = 0; i < 5; ++i) {
            sum1 = (x_(mas[i]) - x__(mas));
            sum1 *= sum1;
            sum2 += sum1;

        }
        SA = sum2 * (N / 4);
        System.out.println("SA  = " + SA);
        System.out.println("S0 = " + S0);
        System.out.println("SA/S0 = " + SA / S0);
        if (SA / S0 > FTEOR) System.out.println("A is good criteria");
        else System.out.println("A is bad criteria");

    }

    private static double x_(double... mas) {
        double f = 0;
        double sum = 0;
        for (double ma : mas) sum += ma;
        return sum / N;
    }

    private static double x__(double[][] mas) {
        double f = 0;
        double sum = 0;
        for (int i = 0; i < 5; ++i) {
            sum += x_(mas[i]);
        }
        return sum / 5;
    }
}
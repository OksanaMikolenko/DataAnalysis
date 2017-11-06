/**
 * Created by Oksana on 30.05.2017.
 */


import java.util.Random;

public class SecondLaba {
    public static void main(String[] args) {


        int a[];
        double Ys;
        double DY2 = 0;
        a = new int[1000];
        Random random = new Random();
        double Y = 0;
        int i;


        System.out.println("Завдання 1: ");
        for (i = 0; i < 1000; i++) {
            a[i] = random.nextInt(2);
            // System.out.println("i:"+ i + " " + a[i] );
            Y = Y + a[i];

        }
        System.out.println("Y= " + Y);
        Ys = Y / 1000;
        System.out.println("Ys " + Ys);

        for (i = 0; i < 1000; i++) {
            DY2 = DY2 + Math.pow((a[i] - Ys), 2);
        }
        DY2 = DY2 / 999;
        System.out.println("DY2 :" + DY2);


        int j;
        double Yvibrki;
        double Yii = 0;
        int x[];
        int y[];
        x = new int[10];
        y = new int[100];
        double Ysvibirki;
        double Skvadrat = 0;
        double DYser;
        double DYsum;

        System.out.println("Завдання 2: вибірка без повернення   M=100;  ");
        for (i = 0; i < 100; i++) {
            j = random.nextInt(1000);
            // System.out.println("вибірка"+ j+ " " + a[j]);
            x[i] = a[j];
            Yii = Yii + x[i];

        }
        Yvibrki = (Yii / 100) * 1000;
        System.out.println("~Y~ :" + Yvibrki);

        Ysvibirki = Yii / 100;
        System.out.println("~Ys~" + Ysvibirki);

        for (i = 0; i < 100; i++) {
            Skvadrat = Skvadrat + Math.pow((x[i] - Ysvibirki), 2);
        }
        Skvadrat = Skvadrat / 99;
        System.out.println("S^2 :" + Skvadrat);

        DYser = (Skvadrat/100)*(1- 0.01);
        DYsum = ((Skvadrat*(Math.pow(10000 , 2)))/100)*(1-0.1);
        System.out.println("D(Ys) : " + DYser + " D(~Y~) : " + DYsum);


        Yvibrki = 0;
        Yii = 0;
        Ysvibirki = 0;
        Skvadrat = 0;

        System.out.println("Завдання 2: вибірка без повернення   M=1000;  ");
        for (i = 0; i < 100; i++) {
            j = random.nextInt(1000);
            // System.out.println("вибірка"+ j+ " " + a[j]);
            y[i] = a[j];
            Yii = Yii + y[i];

        }
        Yvibrki = (Yii / 1000) * 10000;
        System.out.println("~Y~ :" + Yvibrki);

        Ysvibirki = Yii / 1000;
        System.out.println("~Ys~" + Ysvibirki);

        for (i = 0; i < 1000; i++) {
            Skvadrat = Skvadrat + Math.pow((y[i] - Ysvibirki), 2);
        }
        Skvadrat = Skvadrat / 999;
        System.out.println("S^2 :" + Skvadrat);

        DYser = (Skvadrat/1000)*(1- 0.1);
        DYsum = ((Skvadrat*(Math.pow(10000 , 2)))/1000)*(1-0.1);
        System.out.println("D(Ys) : " + DYser + " D(~Y~) : " + DYsum);


        Yvibrki = 0;
        Yii = 0;
        Ysvibirki = 0;
        Skvadrat = 0;


        System.out.println("Завдання 3: систематична вибірка   M=100;  ");

        for (i = 0; i < 100; i++) {

            // System.out.println("вибірка"+ j+ " " + a[j]);
            x[i] = a[i * 100];
            Yii = Yii + x[i];

        }
        Yvibrki = (Yii / 100) * 10000;
        System.out.println("~Y~ :" + Yvibrki);

        Ysvibirki = Yii / 100;
        System.out.println("~Ys~" + Ysvibirki);

        for (i = 0; i < 100; i++) {
            Skvadrat = Skvadrat + Math.pow((x[i] - Ysvibirki), 2);
        }
        Skvadrat = Skvadrat / 99;
        System.out.println("S^2 :" + Skvadrat);

        DYser = (Skvadrat/100)*(1- 0.01);
        DYsum = ((Skvadrat*(Math.pow(10000 , 2)))/100)*(1-0.1);
        System.out.println("D(Ys) : " + DYser + " D(~Y~) : " + DYsum);



        Yvibrki = 0;
        Yii = 0;
        Ysvibirki = 0;
        Skvadrat = 0;


        System.out.println("Завдання 3: систематична вибірка   M=1000;  ");

        for (i = 0; i < 1000; i++) {

            // System.out.println("вибірка"+ j+ " " + a[j]);
            y[i] = a[i * 10];
            Yii = Yii + y[i];

        }
        Yvibrki = (Yii / 1000) * 10000;
        System.out.println("~Y~ :" + Yvibrki);

        Ysvibirki = Yii / 1000;
        System.out.println("~Ys~" + Ysvibirki);

        for (i = 0; i < 1000; i++) {
            Skvadrat = Skvadrat + Math.pow((y[i] - Ysvibirki), 2);
        }
        Skvadrat = Skvadrat / 999;
        System.out.println("S^2 :" + Skvadrat);


        DYser = (Skvadrat/1000)*(1- 0.1);
        DYsum = ((Skvadrat*(Math.pow(10000 , 2)))/1000)*(1-0.1);
        System.out.println("D(Ys) : " + DYser + " D(~Y~) : " + DYsum);



        int h[];
        h = new int[100];
        Yvibrki = 0;
        Yii = 0;
        Ysvibirki = 0;
        Skvadrat = 0;



        System.out.println("Завдання 4: стратифікована вибірка ");
        int man[];
        int ym[];
        int yw[];
        man = new int[3000];
        ym = new int[1000];
        yw = new int[1000];
        int women[];
        double Yhm = 0 ;
        double Yhw = 0;
        double Yhz ;
        double Yiim = 0;
        double Yiiw = 0;
        double Shkvadratm = 0;
        double Shkvadratw = 0;
        double shkvadratm = 0;
        double shkvadratw = 0;
        double Dispersia;
        women = new int[7000];
        double Whm = 0.3 ;
        double Whw  = 0.7 ;
        for (i = 0;  i < 3000; i++) {
            man[i] = random.nextInt(2);
            // System.out.println("i:" + i + " " + man[i]);
            Yhm = Yhm + man[i];
        }

        System.out.println("Yhm : " + Yhm);
        System.out.println("Yhms : " + Yhm/3000);

        for (i = 0;  i < 7000; i++) {
            women[i] = random.nextInt(2);
            // System.out.println("i:" + i + " " + women[i]);
            Yhw= Yhw + women[i];
        }
        System.out.println("Yhw : " + Yhw);
        System.out.println("Yhws : " + Yhw/7000);
        Yhz = Yhm + Yhw;
        System.out.println("загальна сума для всієї популяції : " + Yhz);
        System.out.println("середнє значення для всієї популяції : " + Yhz/10000);

        for (i = 0; i < 1000; i++) {
            j = random.nextInt(3000);
            // System.out.println("вибірка"+ j+ " " + man[j]);
            ym[i] = man[j];
            Yiim = Yiim + ym[i];
        }

        for (i = 0; i < 3000; i++) {
            Shkvadratm = Shkvadratm + Math.pow((man[i] - Yhm/3000), 2);
        }
        Shkvadratm = Shkvadratm/2999;

        System.out.println("дисперсія в страті  : " + Shkvadratm );

        System.out.println("вага страти  : " + Whm );

        System.out.println("оцінка середнього для страти : " + Yiim/1000 );

        System.out.println("оцінка загальної суми для страти  : " +  3*Yiim );

        for (i = 0; i < 1000; i++) {
            shkvadratm = shkvadratm + Math.pow((ym[i] - Yiim/1000), 2);
        }
        shkvadratm = shkvadratm/999;

        System.out.println("оцінка вибіркової дисперсії для страти  : " +  shkvadratm );





        for (i = 0; i < 1000; i++) {
            j = random.nextInt(3000);
            // System.out.println("вибірка"+ j+ " " + woman[j]);
            yw[i] = women[j];
            Yiiw = Yiiw + yw[i];

        }

        for (i = 0; i < 7000; i++) {
            Shkvadratw = Shkvadratw + Math.pow((women[i] - Yhw/7000), 2);
        }
        Shkvadratw = Shkvadratw/6999;

        System.out.println("дисперсія в страті  : " + Shkvadratw );

        System.out.println("вага страти  : " + Whw );

        System.out.println("оцінка середнього для страти  : " + Yiiw/1000 );

        System.out.println("оцінка загальної суми для страти  : " +  7*Yiiw );

        for (i = 0; i < 1000; i++) {
            shkvadratw = shkvadratw + Math.pow((yw[i] - Yiiw/1000), 2);
        }
        shkvadratw = shkvadratw/999;

        System.out.println("оцінка вибіркової дисперсії для страти  : " +  shkvadratw );

        System.out.println("оцінка суми для  популяції (~Y~st) : " + (7*Yiiw + 3*Yiim) );

        System.out.println("оцінка середнього для  популяції (~y~st)  : " + (7*Yiiw + 3*Yiim)/10000 );

        Dispersia = (2/3*(3000*3000)*(shkvadratm/1000) + 0.3*(7000*7000)*(shkvadratw/1000));

        System.out.println("Незміщена оцінка для дисперсії (D(~Y~st)) :   " + Dispersia  );

        System.out.println("Незміщена оцінка для дисперсії (D(~y~st)) :   " + Dispersia/Math.pow(10000 , 2));

















    }
}

package ee.bcs.java.sample.solution;


import java.util.Scanner;

// TODO kasuta if/else. Ära kasuta Math librarit
public class Lesson1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - min");
        System.out.println("2 - max");
        int choise = scanner.nextInt();
        if (choise == 1) {
            System.out.println("Sisesta a");
            int a = scanner.nextInt();
            System.out.println("Sisesta b");
            int b = scanner.nextInt();
            System.out.println("Miinimum oli: " + min(a, b));
        } else if (choise == 2) {
            System.out.println("Sisesta a");
            int a = scanner.nextInt();
            System.out.println("Sisesta b");
            int b = scanner.nextInt();
            System.out.println(max(a, b));
        } else {
            System.out.println("Sisestasid tundmatu käsu");
        }
    }

    // TODO
    //  defineeri 3 muutujat a = 1, b = 1, c = 3
    //  Prindi välja a==b
    //  Prindi välja a==c
    //  Lisa rida a = c
    //  Prindi välja a==b
    //  Prindi välja a==c, mis muutus???
    public static void excersie0() {
        int a = 1;
        int b = 1;
        int c = 3;
        System.out.println(a == b);
        System.out.println(a == c);
        a = c; // a = 3
        System.out.println(a == b);
        System.out.println(a == c);
    }

    // TODO tagasta a ja b väikseim väärtus
    public static int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    // TODO tagasta a ja b suurim väärtus
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    // TODO tagasta a absoluut arv
    public static int abs(int a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }

    // TODO tagasta true, kui a on paaris arv
    // tagasta false kui a on paaritu arv
    public static boolean isEven(int a) {
        return a % 2 == 0;
        /*
        if(a % 2 == 0){
            return true;
        } else {
            return false;
        }*/
    }

    // TODO tagasta kolmest arvust kõige väiksem
    public static int min3(int a, int b, int c) {
        if (a <= b && a <= c) {
            return a;
        } else if (b <= a && b <= c) {
            return b;
        } else {
            return c;
        }
    }

    // TODO tagasta kolmest arvust kõige suurem
    public static int max3(int a, int b, int c) {
        return max(a, max(b, c));
    }

    // TODO
    //  Tagasta string mille väärtus oleks "\"\\""
    //  Trüki muutuja sisu välja
    public static String someString() {
        return "\"\\\"\\\\\"\"";
    }

}

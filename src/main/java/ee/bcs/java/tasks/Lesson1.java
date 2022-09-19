package ee.bcs.java.tasks;


// TODO kasuta if/else. Ära kasuta Math librarit
public class Lesson1 {
    public static void main(String[] args) {
        excersie0();
        System.out.println("Miinimum 2, 4 on: " + min(2, 4));
        System.out.println("Miinimum 5, 3 on: " + min(5, 3));
        System.out.println("Maksimum 5, 5, 3 on: " + max3(5, 5, 3));
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
        a = c;
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
            return a * (-1);
        } else {
            return a;
        }
    }

    // TODO tagasta true, kui a on paaris arv
    // tagasta false kui a on paaritu arv
    public static boolean isEven(int a) {
        int jääk = a % 2;
        if (jääk == 0) {        // jagada 2 ja % jääki
            return true;
        } else {
            return false;
        }
    }

    // TODO tagasta kolmest arvust kõige väiksem
    public static int min3(int a, int b, int c) {
        if (a < b && a < c) {
            return a;
        } else {
            if (b < a && b < c) {
                return b;
            } else {
                return c;
            }
        }
    }

    // TODO tagasta kolmest arvust kõige suurem
    public static int max3(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        } else {
            if (b >= a && b >= c) {
                return b;
            } else {
                    return c;
            }
        }
    }

    // TODO
    //  Tagasta string mille väärtus oleks "\"\\""
    //  Trüki muutuja sisu välja
    public static String someString() {
        String text = "siin on tekst \"lisa tekst\"";
        System.out.println(text);
        return text;
    }
}

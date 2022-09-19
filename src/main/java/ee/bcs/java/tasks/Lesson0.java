package ee.bcs.java.tasks;

public class Lesson0 {

    public static void main(String[] args) {
        int a = -6;

        if (a > 5) {
            System.out.println("a > 5");
        } else if (a > 4) {
            System.out.println("a > 4");
        } else if (a > 3) {
            System.out.println("a > 3");
        } else if (a > 2) {
            System.out.println("a > 2");
        } else if (a > 1) {
            System.out.println("a > 1");
        } else {
            System.out.println("a on väike number");
        }

        // kui a > 5, siis trüki välja "a > 5"
        // kui a > 4, siis trüki välja "a > 4";
        // kui a > 3, siis trüki välja "a > 3";
        // kui a > 2, siis trüki välja "a > 2";
        // kui a > 1, siis trüki välja "a > 1";
        // vastasel juhul trüki välja "a on väike number";

    }
}

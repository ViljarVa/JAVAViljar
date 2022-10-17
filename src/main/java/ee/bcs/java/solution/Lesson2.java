package ee.bcs.java.solution;

import java.util.Arrays;

public class Lesson2 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(sampleArray()));
//        System.out.println(Arrays.toString(yl3(3)));
        System.out.println(Arrays.toString(decreasingArray(9)));
        // TODO siia saab kirjutada koodi testimiseks
    }

    // TODO loo massiiv mis saab sisendiks n ja tagastab massiivi suurusega n
    // Kus esimene element on 1 ja iga järnev arv on 1 võrra suurem
    // näiteks:
    // sisend: 5
    // vastus: {1, 2, 3, 4, 5}
    public static int[] generateArray(int n) {
        int[] array = new int[n]; // [0, 0, 0, 0, 0]
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    // TODO
    // Tagastada massiiv kus oleks numbrid n-ist 0 ini
    // Näiteks: sisend: 5
    // Väljund: 5, 4, 3, 2, 1, 0
    // Näide2: siend: -3
    // Väljund: -3, -2, -1, 0
    public static int[] decreasingArray(int n) {
        // n = 5
        if (n >= 0) {
            int[] result = new int[n + 1];
            for (int i = 0; i < result.length; i++) {
                result[i] = n - i;
            }
            return result;
        } else {
            int[] result = new int[-n + 1]; // n = -3 | -3 +1 = -2
            for (int i = 0; i < result.length; i++){
                result[i] = n + i;
                // result[0] = -3  | i = 0 n = -3
                // result[1] = -2  | i = 1 n = -3
                // result[2] = -1  | i = 2 n = -3
                // result[3] = 0   | i = 3 n = -3
            }
            return result;
        }
    }

    // TODO
    // tagasta massiiv pikkusega n, mille kõigi elementide väärtused on 3
    public static int[] yl3(int n) {
        int[] array = new int[n];
        int i = 0;
        while (i < array.length) { // [0, 0, 0, 0, 0]
            array[i] = 3;
            i++;
        }
        return array;
    }

    // TODO tagasta massiiv milles oleks numbrid 1,2,3,4,5
    public static int[] sampleArray() {
        int[] a = new int[5];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        a[3] = 4;
        a[4] = 5;
        return a;
    }
}

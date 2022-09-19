public class MyProgram {

    public static void main(String[] args) {// - psvn  - lühend
        // sout
        System.out.println("Hello world");
        //MyProgram - CamelCase
        //my_program - SnakeCase
        int age = 36;
        int year = 2022;
        int birthYear = year - age;
        System.out.println(birthYear);

        int a = 9;
        if (a > 5) {
            System.out.println("a>5");
        } else if (a < 5) {
            System.out.println("a<5");
        } else {
            System.out.println("a =5");
        }
    }
}

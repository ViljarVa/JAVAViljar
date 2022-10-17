package ee.bcs.java.solution;

public class TestDto {

    public String a;
    public static String b;

    public TestDto(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "TestDto{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }
}

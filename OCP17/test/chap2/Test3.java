package test.chap2;

public class Test3 {
    private int b = 10;

    public class TestInner {
        public void sayIt() {
            System.out.println("hello");
            System.out.println(b);
        }
    }

    void test(int a, String b) {
        a = 1000;
        b = "Hello1";
    }

    void c(Integer a, Integer b) {
        System.out.println("INTEGER");
    }

    void c(long a, long b) {
        System.out.println("long");
    }

    public static void main(String[] args) {
        int i = 1234567890;
        float f = i;
        System.out.println(i - (int) f);
    }
}

package test.chap2;

public class Test1 {

    public Test1() {
        System.out.println("X");
    }

    static {
        System.out.println("E");
    }

    {
        System.out.println("A");
    }

    static {
        System.out.println("B");
    }

    {
        System.out.println("G");
    }

    public static void main(String[] args) {
        Test1 a = new Test1();
        System.out.println("C");
        Test3.TestInner b = new Test3.TestInner();
    }
}
package test.chap2;

public class Test2 {

    public static void haha(Integer A, Integer B) {
        System.out.println("INTEGER");
    }

    public static void haha(int A, int B) {
        System.out.println("int");
    }

    public static void main(String[] args) {
        Integer a = 0, b = 0;
        haha(b, a);
    }
}
package Concurrency.Test.test1;

public class App {
    private static final Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {
        // 1. Tạo luồng gây ra trạng thái BLOCKED
        Thread thread1 = new Thread(() -> {
            synchronized (LOCK) {
                System.out.println("Thread 1: Đã giữ LOCK và đang ngủ (không nhả khóa)...");
                try {
                    Thread.sleep(30000); // Ngủ rất lâu
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Ngu-Giu-Khoa-Thread");

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("Thread 2: Đang cố vào synchronized block nhưng bị chặn...");
            synchronized (LOCK) {
                try {
                    System.out.println("Thread 2: Cuối cùng cũng vào được!");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Bi-Blocked-Thread");

        // 2. Tạo luồng ở trạng thái WAITING
        Thread thread3 = new Thread(() -> {
            synchronized (LOCK) {
                try {
                    System.out.println("Thread 3: Đang gọi wait() (nhả khóa để đợi)...");
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Dang-Wait-Thread");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

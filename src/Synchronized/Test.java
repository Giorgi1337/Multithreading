package Synchronized;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {
    private int counter;
    public static void main(String[] args) throws InterruptedException {
        String input = "12345";

        try {
            int intValue = Integer.parseInt(input);
            System.out.println("Parsed as an Integer: " + intValue);
        } catch (NumberFormatException e) {
            System.out.println("Not an Integer");
        }

        try {
            double doubleValue = Double.parseDouble(input);
            System.out.println("Parsed as a Double: " + doubleValue);
        } catch (NumberFormatException e) {
            System.out.println("Not a Double");
        }
    }

    static class Worker {
        Random random = new Random();
        private List<Integer> list1 = new ArrayList<>();
        private List<Integer> list2 = new ArrayList<>();

        public void addToList1() {

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                list1.add(random.nextInt(), 100);

        }
        public void addToList2() {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                list2.add(random.nextInt(), 100);

        }

        public void work() {
            for (int i = 0; i < 1000; i++) {
                addToList1();
                addToList2();
            }
        }

        public void main() {
            long before = System.currentTimeMillis();

            work();

            long after = System.currentTimeMillis();

            System.out.println("Program tooks: " + (after - before));

            System.out.println("list1 " + list1.size());
            System.out.println("list1 " + list2.size());
        }
    }
}

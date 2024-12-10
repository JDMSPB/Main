import java.util.*;

public class ListPerformanceComparator {

    private static final int LIST_SIZE = 100000;
    private static final int ELEMENTS_TO_INSERT = 1000;

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        System.out.println("Filling lists with data...");
        compareFillTime(arrayList, linkedList);

        System.out.println("Random access comparison...");
        compareRandomAccessTime(arrayList, linkedList);

        System.out.println("Sequential access comparison...");
        compareSequentialAccessTime(arrayList, linkedList);

        System.out.println("Insertion at the beginning...");
        compareInsertionAtBeginning(arrayList, linkedList);

        System.out.println("Insertion at the end...");
        compareInsertionAtEnd(arrayList, linkedList);

        System.out.println("Insertion in the middle...");
        compareInsertionInMiddle(arrayList, linkedList);
    }

    private static void compareFillTime(List<Integer> arrayList, List<Integer> linkedList) {
        long start = System.nanoTime();
        fillList(arrayList);
        long end = System.nanoTime();
        System.out.println("ArrayList fill time: " + (end - start) + " ns");

        start = System.nanoTime();
        fillList(linkedList);
        end = System.nanoTime();
        System.out.println("LinkedList fill time: " + (end - start) + " ns");
    }

    private static void fillList(List<Integer> list) {
        Random random = new Random();
        for (int i = 0; i < LIST_SIZE; i++) {
            list.add(random.nextInt(LIST_SIZE));
        }
    }

    private static void compareRandomAccessTime(List<Integer> arrayList, List<Integer> linkedList) {
        Random random = new Random();
        int index = random.nextInt(LIST_SIZE);

        long start = System.nanoTime();
        arrayList.get(index);
        long end = System.nanoTime();
        System.out.println("ArrayList random access time: " + (end - start) + " ns");

        start = System.nanoTime();
        linkedList.get(index);
        end = System.nanoTime();
        System.out.println("LinkedList random access time: " + (end - start) + " ns");
    }

    private static void compareSequentialAccessTime(List<Integer> arrayList, List<Integer> linkedList) {
        long start = System.nanoTime();
        for (Integer ignored : arrayList) {
            // Sequential access
        }
        long end = System.nanoTime();
        System.out.println("ArrayList sequential access time: " + (end - start) + " ns");

        start = System.nanoTime();
        for (Integer ignored : linkedList) {
            // Sequential access
        }
        end = System.nanoTime();
        System.out.println("LinkedList sequential access time: " + (end - start) + " ns");
    }

    private static void compareInsertionAtBeginning(List<Integer> arrayList, List<Integer> linkedList) {
        long start = System.nanoTime();
        for (int i = 0; i < ELEMENTS_TO_INSERT; i++) {
            arrayList.add(0, i);
        }
        long end = System.nanoTime();
        System.out.println("ArrayList insertion at beginning: " + (end - start) + " ns");

        start = System.nanoTime();
        for (int i = 0; i < ELEMENTS_TO_INSERT; i++) {
            linkedList.add(0, i);
        }
        end = System.nanoTime();
        System.out.println("LinkedList insertion at beginning: " + (end - start) + " ns");
    }

    private static void compareInsertionAtEnd(List<Integer> arrayList, List<Integer> linkedList) {
        long start = System.nanoTime();
        for (int i = 0; i < ELEMENTS_TO_INSERT; i++) {
            arrayList.add(i);
        }
        long end = System.nanoTime();
        System.out.println("ArrayList insertion at end: " + (end - start) + " ns");

        start = System.nanoTime();
        for (int i = 0; i < ELEMENTS_TO_INSERT; i++) {
            linkedList.add(i);
        }
        end = System.nanoTime();
        System.out.println("LinkedList insertion at end: " + (end - start) + " ns");
    }

    private static void compareInsertionInMiddle(List<Integer> arrayList, List<Integer> linkedList) {
        int middle = LIST_SIZE / 2;

        long start = System.nanoTime();
        for (int i = 0; i < ELEMENTS_TO_INSERT; i++) {
            arrayList.add(middle, i);
        }
        long end = System.nanoTime();
        System.out.println("ArrayList insertion in middle: " + (end - start) + " ns");

        start = System.nanoTime();
        for (int i = 0; i < ELEMENTS_TO_INSERT; i++) {
            linkedList.add(middle, i);
        }
        end = System.nanoTime();
        System.out.println("LinkedList insertion in middle: " + (end - start) + " ns");
    }
}

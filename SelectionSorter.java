import java.util.ArrayList;
import java.util.List;

public class SelectionSorter extends Sorter{

    public SelectionSorter(ArrayList< String> usersData) {
        super(usersData);
    }

    private static <T> void swap(List<T> challengers, int idx1, int idx2) {
        T temp = challengers.get(idx2);
        challengers.set(idx2, challengers.get(idx1));
        challengers.set(idx1, temp);
    }

    private static <T extends Comparable<T>> void selectionSort(List<T> unordered) {
        for (int i = 0; i < unordered.size(); i++) {
            System.out.println("Sorting: " + i + ", " + unordered);
            swap(unordered, i, champIndex(unordered, i));
        }
    }

    private static <T extends Comparable<T>> int champIndex(List<T> challengers, int start) {
        T minVal = null;
        int minIndex = 0;
        for (int i = start; i < challengers.size(); i++) {
            if (challengers.get(i) != null && (minVal == null || challengers.get(i).compareTo(minVal) < 0)) {
                minVal = challengers.get(i);
                minIndex = i;
            }
        }
        return minIndex;
    }

    public void mySort() {
        selectionSort(elements);
    }
}

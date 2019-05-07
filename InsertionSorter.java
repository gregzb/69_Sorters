import java.util.ArrayList;
import java.util.List;

public class InsertionSorter extends Sorter{

    public InsertionSorter(ArrayList< String> usersData) {
        super(usersData);
    }

    public static <T extends Comparable<T>> void insertionSort(List<T> list) {
        for (int currentIndex = 1; currentIndex < list.size(); currentIndex++) {
            System.out.println("Sorting: " + currentIndex + ", " + list);
            insert1(list, currentIndex);
        }
    }

    private static <T extends Comparable<T>> void insert1(List<T> list, int numSorted) {
        T valueToInsert = list.get(numSorted);
        int indexToCompare;
        for (indexToCompare = numSorted - 1; indexToCompare >= 0; indexToCompare--) {
            T valueToCompare = list.get(indexToCompare);
            if (valueToInsert.compareTo(valueToCompare) < 0) list.set(indexToCompare + 1, valueToCompare);
            else {
                list.set(indexToCompare + 1, valueToInsert);
                break;
            }
        }
        if (indexToCompare == -1) list.set(0, valueToInsert);
    }

    public void mySort() {
        insertionSort(elements);
    }
}

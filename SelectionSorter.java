import java.util.ArrayList;
import java.util.List;

public class SelectionSorter extends Sorter{

    public SelectionSorter(ArrayList< String> usersData) {
        super(usersData);
    }

    /**
     * pre-conditions: challengers != null, idx1 and idx2 are valid indices of challenges
     * post-conditions: the values at index idx1 and idx2 will have been swapped
     */
    private <T> void swap(List<T> challengers, int idx1, int idx2) {
        T temp = challengers.get(idx2);
        challengers.set(idx2, challengers.get(idx1));
        challengers.set(idx1, temp);
    }

    /**
     * pre-conditions: unordered != null
     * synopsis: runs champIndex for positions 0 through unordered.size()-1 in the list and
     * swaps the index from champIndex with the index currently being iterated through
     * post-conditions: unordered will be sorted by its natural ordering
     */
    private <T extends Comparable<T>> void selectionSort(List<T> unordered) {
        for (int i = 0; i < unordered.size(); i++) {
            System.out.println("Sorting: " + i + ", " + unordered);
            swap(unordered, i, champIndex(unordered, i));
        }
    }

    /**
     * pre-conditions: unordered != null
     * synopsis: finds the minimum value in the unsorted portion of the list
     * post-conditions: N/A
     */
    private <T extends Comparable<T>> int champIndex(List<T> challengers, int start) {
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

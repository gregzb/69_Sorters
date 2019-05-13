import java.util.ArrayList;

public class SubSortThenMergeSorter extends Sorter{

    ArrayList<String> tempData;

    public SubSortThenMergeSorter(ArrayList< String> usersData) {
        super(usersData);
        tempData = new ArrayList<>(usersData);
    }

    /**
     * pre-conditions: unordered != null
     * synopsis: runs insert1 for positions 1 through unordered.size()-1 in the list
     * post-conditions: unordered will be sorted by its natural ordering
     */
    public void mergeSort(ArrayList<String> list, int start, int end) {
        if (end - start > 1) {
            int middle = (start + end) / 2;
            mergeSort(list, start, middle);
            mergeSort(list, middle, end);
            System.out.println(start + ", " + end);
            merge(start, middle, end);
        }
    }
    /**
     * pre-conditions: unordered != null
     * synopsis: insert the first unsorted element in to the correct sorted position within
     * the sorted region shifting values to the right to make space
     * post-conditions: the next value will have been sorted and the sorted
     * region will have expanded by 1
     */
    public void merge(int start, int middle, int end) {
        int tempInsertIdx = start;
        int originalMid = middle;
        while (tempInsertIdx < end) {
            if (start >= originalMid) {
                tempData.set(tempInsertIdx++, elements.get(middle++));
            } else if (middle >= end){
                tempData.set(tempInsertIdx++, elements.get(start++));
            } else {
                if (elements.get(start).compareTo(elements.get(middle)) <= 0) {
                    tempData.set(tempInsertIdx++, elements.get(start++));
                } else {
                    tempData.set(tempInsertIdx++, elements.get(middle++));
                }
            }
        }

        ArrayList<String> temp = elements;
        elements = tempData;
        tempData = temp;
    }

    public void mySort() {
        mergeSort(elements, 0, elements.size());
    }
}

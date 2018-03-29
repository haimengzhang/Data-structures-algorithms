public class InsertionSort {
    
    // Precondition: elements 0 through k-1 of list are in increasing order.
    // Postcondition: elements 0 through k of list are in increasing order.
    public static void insert (int list[], int k) {

        // YOUR CODE HERE
        for (int i = k; i > 0; i--) {
            if (list[i] < list[i - 1]) {
                int temp = list[i - 1];
                list[i - 1] = list[i];
                list[i] = temp;
            }
        }
        try {
            isOK(list, k);
        } catch (IllegalStateException e) {
            System.err.println("");
        }

    }
    
    // Does nothing when elements 0 through k of list are sorted in
    // increasing order.
    // Throws an IllegalStateException otherwise.
    public static void isOK (int[] list, int k) {

        // YOUR CODE HERE
        for (int i = 0; i < k; i++) {
            if (list[i] > list[i + 1]) {
                throw new IllegalStateException("");
            }
        }

    }

    public static int[] insertionSort(int[] list) {
        int[] rtn = new int[list.length];
        for (int k = 0; k < list.length; k++) {
            rtn[k] = list[k];
        }
        for (int k = 0; k < rtn.length; k++) {
            insert(rtn, k);
            try {
                isOK(rtn, k);
            } catch (IllegalStateException e) {
                System.err.println("inconsistency at position " + k);
            }
        }
        return rtn;
    }
    
    public static void main (String[] args) {
        int[] list = {3, 1, 7, 4, 5, 9, 2, 8, 6};
        list = insertionSort(list);
        for (int k = 0; k < list.length; k++) {
            System.out.print(list[k]);
        }
        System.out.println();
    }

}

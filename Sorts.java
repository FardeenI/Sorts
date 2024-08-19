import java.util.Arrays;
public class Sorts
{
    public static <T extends Comparable<? super T>> void heapSort(T[] array)
    {
        int heapSize = array.length;


        // Build heap
        // Iterate through every element, and build the heap.
        // Root nodes do not need to be 'heap-ified', so begin at the first root node, the middle element
        for (int i = (heapSize / 2) - 1; i >= 0; i--)
        {
            heapify(array, heapSize, i);
        }


        // Swap the value at the root with the value at the end of the array of elements, 'decrementing' the size of the array
        // Sift down from root to children and make appropriate swaps ('re-heapify')
        // Repeat this process until the heap is reduced to nothing; The array is then sorted
        for (int i = heapSize - 1; i >= 0; i--)
        {
            // Move current root to end
            T temp = array[0];
            array[0] = array[i];
            array[i] = temp;


            // Build heap on decremented array
            heapify(array, i, 0);
        }
    }


    private static <T extends Comparable<? super T>> void heapify(T[] array, int heapSize, int rootInd)
    {
        int maxInd = rootInd; // Initialize largest as root
        int leftInd = 2 * rootInd + 1; // Index of left child given by parent
        int rightInd = 2 * rootInd + 2; // Index of right child given by parent


        // If left child is within the size of the heap and left child is larger than root
        if (leftInd < heapSize && array[leftInd].compareTo(array[maxInd]) > 0)
        {
            maxInd = leftInd; // Swap root index and left child index
        }


        // If right child is within the size of the heap and right child is larger than root
        if (rightInd < heapSize && array[rightInd].compareTo(array[maxInd]) > 0)
        {
            maxInd = rightInd; // Swap root index and right child index
        }


        // If largest is not root, perform swap
        if (maxInd != rootInd)
        {
            T temp = array[rootInd];
            array[rootInd] = array[maxInd];
            array[maxInd] = temp;


            // Call heapify on the modified subtree, passing in the new largest node as the next root
            // Ultimately results in every parent node being larger than its children, 'heapify-ing' the array
            heapify(array, heapSize, maxInd);
        }
    }


    public static <T extends Comparable<? super T>> void bubbleSort(T[] array)
    {
        T temp;
        boolean sorted;
        for (int i = array.length - 1; i > 0; --i) {
            sorted = true;
            for (int j = 0; j < i; ++j) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    sorted = false;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (sorted) {
                break;
            }
        }
    }
    public static <T extends Comparable<? super T>> void insertSort(T[] array)
    {
        T temp;
        int j;
        for (int i = 1; i < array.length; ++i) {
            temp = array[i];
            for (j = i; j > 0; --j) {
                if (array[j - 1].compareTo(temp) > 0) {
                    array[j] = array[j - 1];
                }
                else {
                    break;
                }
            }
            if (j < i) {
                array[j] = temp;
            }
        }
    }
    public static <T extends Comparable<? super T>> void mergeSort(T[] array)
    {
        if (array.length > 1) {
            T[] left = Arrays.copyOfRange(array, 0, array.length / 2);
            T[] right = Arrays.copyOfRange(array, array.length / 2,
                    array.length);
            mergeSort(left);
            mergeSort(right);
            int i, l = 0, r = 0;
            for (i = 0; i < array.length && l < left.length && r <
                    right.length; ++i) {
                if (left[l].compareTo(right[r]) <= 0) {
                    array[i] = left[l++];
                }
                else {
                    array[i] = right[r++];
                }
            }
            if (i < array.length) {
                if (l < left.length) {
                    while (i < array.length) {
                        array[i++] = left[l++];
                    }
                }
                else {
                    while (i < array.length) {
                        array[i++] = right[r++];
                    }
                }
            }
        }
    }
    public static <T extends Comparable<? super T>> void quickSort(T[] array)
    {
        quickSort(array, 0, array.length - 1);
    }
    private static <T extends Comparable<? super T>> void quickSort(T[] array, int left, int right)
    {
        int pivot = right;
        int l = left, r = right;
        if (left < right) {
            while (l < r) {
                while (l < r && array[l].compareTo(array[pivot]) <= 0) {
                    ++l;
                }
                while (l < r && array[pivot].compareTo(array[r]) <= 0) {
                    --r;
                }
                if (l < r) {
                    T temp = array[l];
                    array[l] = array[r];
                    array[r] = temp;
                }
            }
            if (r != pivot) {
                T temp = array[pivot];
                array[pivot] = array[r];
                array[r] = temp;
            }
            quickSort(array, left, r - 1);
            quickSort(array, r + 1, right);
        }
    }
    public static <T extends Comparable<? super T>> void selectSort(T[] array)
    {
        T temp;
        int mini;
        for (int i = 0; i < array.length - 1; ++i) {
            mini = i;
            for (int j = i + 1; j < array.length; ++j) {
                if (array[j].compareTo(array[mini]) < 0) {
                    mini = j;
                }
            }
            if (i != mini) {
                temp = array[i];
                array[i] = array[mini];
                array[mini] = temp;
            }
        }
    }
}
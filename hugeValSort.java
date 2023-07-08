//region imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
//endregion

public class hugeValSort {
    public static void main(String[] args) throws FileNotFoundException {
        //region printing thingys
        // gets the arr
        int[] arr = getArrayFromFile("src/hugeValList.txt");

        // sorts the array with selection and then insertion
        int[] selectionSorted = selectionSort(arr);
        int[] insertionSorted = insertionSort(arr);

        // array with target values
        int[] searchValues = {596656, 357561, 749205};

        // prints the results
        for (int searchValue : searchValues) {
            System.out.println();
            System.out.println("Selection sorting, Binary: " + binarySearch(selectionSorted, searchValue));
            System.out.println("Selection sorting, Linear: " + linearSearch(selectionSorted, searchValue));
            System.out.println("Insertion sorting, Binary: " + binarySearch(insertionSorted, searchValue));
            System.out.println("Insertion sorting, Linear: " + linearSearch(insertionSorted, searchValue));
            System.out.println();
        }
        //endregion
    }
    // File to array algorithm
    //region file to int[]
    private static int[] getArrayFromFile(String fileName) throws FileNotFoundException {
        // scans the file
        Scanner sc = new Scanner(new File(fileName));
        // splits the line into the str[]
        String[] stringArr = sc.nextLine().split(" ");
        // makes new int[]
        int[] intArr = new int[stringArr.length];
        // copies str[] to the new int[]
        for (int i = 0; i < stringArr.length; i++) {
            intArr[i] = Integer.parseInt(stringArr[i]);
        }
        // returns the int[]
        return intArr;
    }
    //endregion
    // Selection and insertion sorting
    //region Insertion
    public static int[] insertionSort(int[] arr) {
        // counts the comparison and swaps
        long swaps = 0;
        long count = 0;
        // loops through the list
        for (int i = 1; i < arr.length; i++) {
            // setting a beginning key at index 1
            int key = arr[i];
            // index value of on less than the key, has to be greater than 0
            int j = i - 1;
            // we shift everything to the right until we find a value that is smaller
            while (j >= 0 && arr[j] > key) {
                swaps++;
                count++;
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            // we then set the value to key and repeat until list is sorted
            arr[j + 1] = key;
        }
        // returns the sorted array
        System.out.println("It took: " + count + " comparisons and " + swaps + " swaps to sort this array using insertion");
        return arr;
    }
    //endregion
    //region Selection
    public static int[] selectionSort(int[] arr) {
        // counts the comparison and swaps
        long swaps = 0;
        long count = 0;
        // loops though the array
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            // loops through the array but is 1 index more than the first loop
            for (int j = i + 1; j < arr.length; j++) {
                count++;
                // if the second value is smaller than the first value, we set the second value equal to the first(finding smallest)
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // switching the larger and smaller values
            swaps++;
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        // returns sorted arr
        System.out.println("It took: " + count + " comparisons and " + swaps + " swaps to sort this array using selection");
        return arr;
    }
    //endregion
    //Binary and linear search
    //region Binary
    public static String binarySearch(int[] arr, int val){
        // sets the count left max and right max
        int count = 0;
        int lMax = 0;
        int rMax = arr.length - 1;

        // when the left max is less than or equal to the right max
        while (lMax <= rMax) {
            // upping count
            count++;
            // the mid is the average of lmax and rmax
            int mid = (lMax + rMax) / 2;
            // if the mid is our target value
            if(arr[mid] == val) {
                return "The index of the word: " + val + ", in the array is: " + mid + "\nIt took " + count + " tries";
            }
            // if the mid is less than the value, we move the lmax over one
            else if(arr[mid] < val) {
                lMax = mid + 1;
            }
            // if the mid is greater, we move the rmax over one
            else{
                rMax = mid - 1;
            }
        }
        // if the target value is not in the array
        return "The word: " + val + " is not in the list" + "\nIt took " + count + " tries";
    }
    //endregion
    //region Linear
    public static String linearSearch(int[] arr, int val){
        // sets count
        int count = 0;
        // loops through the entire array
        for (int i = 0; i < arr.length; i++) {
            // adding count
            count++;
            // if the value at index i is the target value
            if (arr[i] == val) {
                return "The index of the word: " + val + ", in the array is: " + i + "\nIt took " + count + " tries";
            }
        }
        // if target value is not in the array
        return "The word: " + val + " is not in the list" + "\nIt took " + count + " tries";
    }
    //endregion
}

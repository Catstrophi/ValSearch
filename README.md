# ValSearch
Using Linear and Binary search to find certain values 

The hugeValSort class is defined, which contains the main method as the entry point of the program.
The main method is divided into regions for better organization and readability.

The program reads an array of integers from a file called "hugeValList.txt" using the getArrayFromFile method.
The array is sorted using both selection sort and insertion sort algorithms, and the sorted arrays are stored in selectionSorted and insertionSorted respectively.

An array searchValues is declared, containing three target values for searching.
The program performs searches on the sorted arrays using binary search and linear search algorithms for each target value.
The search results are printed for each search value, including the index of the value in the array and the number of tries it took for the search.

The code includes several helper methods for file-to-array conversion (getArrayFromFile), insertion sort (insertionSort), selection sort (selectionSort), binary search (binarySearch), and linear search (linearSearch).

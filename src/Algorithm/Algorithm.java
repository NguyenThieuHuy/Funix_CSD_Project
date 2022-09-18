package Algorithm;
import java.io.*;
import java.util.*;
public class Algorithm {
    /**
     * Writing the array read from input array arr to file
     * @param fileName The file name of file to write value
     * @param arr      The input float array
     * @throws IOException
     */
    public void writeFile(String fileName, float arr[]) throws IOException {
        FileWriter csvWriter = new FileWriter(fileName);
        for (float f : arr) {
            csvWriter.append(Float.toString(f));
            csvWriter.append(",");
        }
        csvWriter.flush();
        csvWriter.close();
    }
    /**
     * Reading the file then input to the array arr
     * @param fileName The file name of file to read
     * @return Returning a array read from the file
     * @throws IOException
     */
    public float[] readFile(String fileName) throws IOException {
        String row = "";
        BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
        row = csvReader.readLine();
        String[] data = row.split(",");
        // do something with the data
        float[] arr = new float[data.length];
        for (int i = 0; i < data.length; i++) {
            arr[i] = Float.parseFloat(data[i]);
        }
        csvReader.close();
        return arr;
    }
    /**
     * Sorting the input array arr using Bubble Sort algorithm.
     * @param arr Input array using for sorting
     * @return Returning a sorted array by using the Bubble Sort algorithm
     * @throws IOException
     */
    public float[] bubbleSort(float arr[]) throws IOException {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - i - 1; j++){
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    Float temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    for (float a : arr) {
                        System.out.print(a+" ");
                    }
                    System.out.println("");    
                }
            }
        }
        writeFile("OUTPUT1.txt", arr);
        return arr;
    }
    /**
     * Sorting the input array arr using Selection Sort algorithm.
     * @param arr Input array using for sorting
     * @return Returning a sorted array by using the Selection Sort algorithm
     * @throws IOException
     */
    public float[] selectionSort(float arr[]) throws IOException {
        int n = arr.length;
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++){
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++){
                if (arr[j] < arr[min_idx]){
                    min_idx = j;
                    for (float a : arr) {
                        System.out.print(a+" ");
                    }
                    System.out.println("");    
                }
            }
            // Swap the found minimum element with the first
            // element
            Float temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
        writeFile("OUTPUT2.txt", arr);
        return arr;
    }
    /**
     * Sorting the input array arr using Insertion Sort algorithm.
     * @param arr Input array using for searching
     * @return Returning a sorted array by using the Insertion Sort algorithm
     * @throws IOException
     */
    public float[] insertionSort(float arr[]) throws IOException {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            Float key = arr[i];
            int j = i - 1;
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;

                for (float a : arr) {
                    System.out.print(a+" ");
                }
                System.out.println("");    
            }
            arr[j + 1] = key;
        }
        writeFile("OUTPUT3.txt", arr);
        return arr;
    }
    /**
     * Searching the indices of elements in array [arr] greater than value. Printing
     * and writing all indices to the console screen and file OUTPUT4.TXT separated by space.
     * @param arr   Input array using for searching
     * @param value The value for searching
     * @throws IOException
     */
    public void search(float arr[], float value) throws IOException {
        int n = arr.length;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++){
            if (arr[i] > value){
                list.add(i);
            }
        }
        System.out.print("Output indexes: ");
        float[] output = new float[list.size()];
        for (int i = 0; i < output.length; i++) {
            output[i] = Float.parseFloat(Integer.toString(list.get(i)));
        }
        for (float f : output) {
            System.out.print(f+" ");
        }
        System.out.println("");
        writeFile("OUTPUT4.txt", output);
    }
    /**
     * Searching by using the Binary Search algorithm. Returning the first index of
     * value if it is present in array arr, otherwise, return -1. The index also
     * written to file OUTPUT5.TXT and shown on the console screen.
     * @param arr   Input array using for searching
     * @param left  The left index
     * @param right The right index
     * @param value The value for searching
     * @return The index of the element if found, otherwise, return -1
     * @throws IOException
     */
    public int binarySearch(float arr[], int left, int right, float value) throws IOException {
        if (right >= left) {
            int mid = left + (right - left) / 2;
            // If the element is present at the
            // middle itself
            if (arr[mid] == value){
                float[] ans = new float[1];
                System.out.print(mid+"\n");
                ans[0] = mid;
                writeFile("OUTPUT5.txt", ans);
                return mid;
            }
            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > value){
                return binarySearch(arr, left, mid - 1, value);
            }
            // Else the element can only be present
            // in right subarray
            else{
                return binarySearch(arr, mid + 1, right, value);
            }
        }
        // We reach here when element is not present
        // in array
        return -1;    
    }
   }
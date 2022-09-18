package Algorithm;
import java.io.IOException;
import java.util.*;

public class Main_Sort {
    public static void main(String[] args) throws IOException {
        Algorithm algorithm = new Algorithm();
        Scanner sc = new Scanner(System.in);
        String[] menu = {"Input","Output","Bubble sort","Selection sort","Insertion sort","Search > value","Search = value"};
        int index = 1;

        System.out.println("+-------------------Menu-----------------+");
        for (String menui : menu) {
            System.out.printf("|%-40s|%n", (index++) + "." + menui);
        }
        System.out.printf("|%-40s|%n", "0.Exit");
        System.out.println("+----------------------------------------+");
        int choice;
        boolean repeate = true;
        do {
            System.out.print("\nChoice: ");
            choice = sc.nextInt();
            if (choice == 1) {
                System.out.print("Input number of elements: ");
                int num = sc.nextInt();
                float[] arr = new float[num];
                System.out.println("Input elements: ");
                for (int i = 0; i < num; i++) {
                    arr[i] = sc.nextFloat();
                }
                algorithm.writeFile("INPUT.txt", arr);
            }
            else if (choice == 2) {
                System.out.println("Read from file");
                System.out.print("Array 'arr': ");
                float[] arr = algorithm.readFile("INPUT.txt");
                for (float i : arr) {
                    System.out.print(i+" ");
                }
                System.out.println("");
            }
            else if (choice == 3) {
                System.out.println("Bubble sort");
                float[] arr = algorithm.readFile("INPUT.txt");
                long startTime = System.nanoTime();
                algorithm.bubbleSort(arr);
                long endTime   = System.nanoTime();
                long totalTime = endTime - startTime;
                System.out.println("Your sorting algorithm ran in "+totalTime/1_000_000_000.0+" second(s)");
            }
            else if (choice == 4) {
                float[] arr = algorithm.readFile("INPUT.txt");
                System.out.println("Selection sort");
                long startTime = System.nanoTime();
                algorithm.selectionSort(arr);
                long endTime   = System.nanoTime();
                long totalTime = endTime - startTime;
                for (float i : arr) {
                    System.out.print(i+" ");
                }
                System.out.println("\nYour sorting algorithm ran in "+totalTime/1_000_000_000.0+" second(s)");
            }
            else if (choice == 5) {
                float[] arr = algorithm.readFile("INPUT.txt");
                System.out.println("Insertion sort");
                long startTime = System.nanoTime();
                algorithm.insertionSort(arr);
                long endTime   = System.nanoTime();
                long totalTime = endTime - startTime;
                for (float i : arr) {
                    System.out.print(i+" ");
                }
                System.out.println("\nYour sorting algorithm ran in "+totalTime/1_000_000_000.0+" second(s)");
            }
            else if (choice == 6) {
                float[] arr = algorithm.readFile("INPUT.txt");
                System.out.println("Linear Search");
                System.out.print("Input value: ");
                float value = sc.nextFloat();
                algorithm.search(arr, value);
            }
            else if (choice == 7) {
                float[] arr = algorithm.readFile("OUTPUT1.txt");

                System.out.println("Binary Search");
                System.out.print("Input value: ");
                float value = sc.nextFloat();
                int left = 0;
                int right = arr.length;
                System.out.print("Index of first element: ");
                algorithm.binarySearch(arr, left, right, value);
            }
            else if(choice == 0){
                System.out.println("Thanks!!!");
                repeate = false;
            }
            else{
                System.out.println("Invalid choice!");
            }
        } while (repeate == true);
        sc.close();
    }
}

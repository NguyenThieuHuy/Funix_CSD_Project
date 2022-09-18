package AS2;
import java.io.*;
import java.util.*;
/**
* This class manages all functions relate to the product
*/
public class OperationToProduct {
    /**
     * Searching and returning the index of product p in the list. If not found
     * return -1.
     * @param p    Product for searching
     * @param list The Linked List
     * @return The index of product p in the list
     */
    public int index(Product p, MyList<Product> list) {
        int count = 0;
        int index = -1;
        Node<Product> curr = list.head;
        if(curr != null){
            while (curr.next != null) {
                if(curr.info == p){
                    index = count;
                    break;
                }
                curr = curr.next;
                count++;
            }
            return index;
        }
        return -1;
    }
   
    /**
     * Creating and returning a product with info input from keyboard.
     * @return The product
     */
    public Product createProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Barcode: ");
        String bcode = sc.next();
        System.out.println("Title: ");
        String title = sc.next();
        System.out.println("Quantity: ");
        int quantity = sc.nextInt();
        System.out.println("Price: ");
        double price = sc.nextDouble();

        Product p = new Product(bcode, title, quantity, price);
        return p;
    }
   
    /**
     * Reading all products from the file and insert them to the list at tail.
     * @param fileName The file name of the file
     * @param list     The Linked List contains all products that read from file
     * @throws IOException
     */
    public void getAllItemsFromFile(String fileName, MyList<Product> list) throws IOException {
        String row = "";
        BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            // do something with the data
            Product p = new Product(data[0],data[1],Integer.parseInt(data[2]),Double.parseDouble(data[3]));
            Node<Product> current = list.head;
            Node<Product> node = new Node<Product>(p,null);
            // special case for length 0
            if (current == null) {
                list.head = node;
            }
            else {
                // locate the last node
                while (current.next != null) {
                    current = current.next;
                }
                current.next = node;
                list.tail = node;
            }
        }
        csvReader.close();
    }
   
    /**
     * Reading all products from the file and insert them to the stack.
     * @param fileName The file name of the file
     * @param stack     The Stack contains all products that read from file
     * @throws IOException
     */
    public void getAllItemsFromFile(String fileName, MyStack<Product> stack) throws IOException {
        String row = "";
        BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            // do something with the data
            Product p = new Product(data[0],data[1],Integer.parseInt(data[2]),Double.parseDouble(data[3]));
            Node<Product> node = new Node<Product>(p,stack.head);
            stack.head = node;
        }
        csvReader.close();
    }

    /**
     * Reading all products from the file and insert them to the queue.
     * @param fileName The file name of the file
     * @param queue     The Queue contains all products that read from file
     * @throws IOException
     */
    public void getAllItemsFromFile(String fileName, MyQueue<Product> queue) throws IOException {
        String row = "";
        BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            // do something with the data
            Product p = new Product(data[0],data[1],Integer.parseInt(data[2]),Double.parseDouble(data[3]));
            Node<Product> current = queue.head;
            Node<Product> node = new Node<Product>(p,null);
            // special case for length 0
            if (current == null) {
                queue.head = node;
            }
            else {
                // locate the last node
                while (current.next != null) {
                    current = current.next;
                }
                current.next = node;
                queue.tail = node;
            }
        }
        csvReader.close();
    }
   
    /**
     * Adding a product to the list, info of the product input from keyboard.
     * @param list The Linked list
     */
    public void addLast(MyList<Product> list) {
        Product p = createProduct();
        Node<Product> current = list.head;
        Node<Product> node = new Node<Product>(p,null);
        // special case for length 0
        if (list.isEmpty() == true) {
            list.head = node;
        }
        else {
            // locate the last node
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
            list.tail = node;
        }
    }
   
    /**
     * Printing all products of the list to console screen
     * @param list
     */
    public void displayAll(MyList<Product> list) {
        Node<Product> current = list.head;
        if (list.isEmpty() == true) {
            System.out.println("Your list is empty!!!");
        }
        else {
            System.out.printf("| %5s","Bcode");
            System.out.printf("| %50s", "Title");
            System.out.printf("| %15s", "Quantity");
            System.out.printf("| %15s", "Price\n");
            while (current.next != null) {
                current.info.display();
                current = current.next;
            }
            list.tail.info.display();
        }
}
   
    /**
     * Writing all products from the list to the file
     * @param fileName Input file name
     * @param list     Input Linked list
     * @throws IOException
     */
    public void writeAllItemsToFile(String fileName, MyList<Product> list) throws IOException {

        FileWriter csvWriter = new FileWriter(fileName);
        Node<Product> current = list.head;
        if (list.isEmpty() == true) {
            System.out.println("\nYour list is empty!!!");
        }else {
            while (current != null) {
                csvWriter.append(current.info.toString());
                csvWriter.append("\n");
                current = current.next;
            }
            System.out.println("Successful!!!");
        }
        csvWriter.flush();
        csvWriter.close();
    }
   
    /**
     * Searching product by ID input from keyboard.
     * @param list
     */
    public Product searchByCode(MyList<Product> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Barcode: ");
        String bcode = sc.next();

        Node<Product> current = list.head;
        if (list.isEmpty() == true) {
            System.out.println("Your list is empty!!!");;
        }
        else {
            while (current != null) {
                if (current.info.getBcode().equals(bcode)) {
                    System.out.printf("| %5s","Bcode");
                    System.out.printf("| %50s", "Title");
                    System.out.printf("| %15s", "Quantity");
                    System.out.printf("| %15s", "Price\n");        
                    current.info.display();
                    return current.info;
                }
                current = current.next;
            }
        }
        System.out.println("No match!!!");
        return null;
    }
   
    /**
     * Deleting first product that has the ID input from keyboard from the list.
     * @param list
     */
    public void deleteByCode(MyList<Product> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Barcode: ");
        String bcode = sc.next();

        Node<Product> current = list.head;
        if (list.isEmpty() == true) {
            System.out.println("Your list is empty!!!");;
        }
        else {
            while (current != null) {
                if (current.info.getBcode().equals(bcode)) {
                    list.deleteElement(current.info);
                    System.out.println("Successful!!!");
                    return;
                }
                current = current.next;
            }
            System.out.println("No match!!!");
        }
    }
   
    /**
     * Sorting products in linked list by ID
     * @param list The Linked list
     */
    public void sortByCode(MyList<Product> list, int n) {
        //Recursive Bubble sort
        if (list.isEmpty() == true) {
            System.out.println("Your list is empty!!!");
            return;
        }else{
            // Base case
            if (n <= 1){
                System.out.println("Successful!!!");
                return;
            }
            // One pass of bubble sort. After
            // this pass, the largest element
            // is moved (or bubbled) to end.
            Node<Product> current = list.head;
            for (int i=0; i<n-1; i++){
                if (current.info.getBcode().compareTo(current.next.info.getBcode()) > 0){
                    // swap arr[i], arr[i+1]
                    list.swap(current, current.next);
                }
                current = current.next;
            }
            // recur for remaining array
            sortByCode(list, n-1);
        }

        //Iterative Bubble sort
        // if (list.isEmpty() == true) {
        //     System.out.println("Your list is empty!!!");
        //     return;
        // } else {
        //     for (int i = 0; i < list.length(); i++) {
        //         Node<Product> current = list.head;
        //         while (current != null && current.next != null){
        //             if (current.info.getBcode().compareTo(current.next.info.getBcode()) > 0){
        //                 // Swap node values
        //                 list.swap(current, current.next);
        //             }
        //             // Visit to next node
        //             current = current.next;
        //         }
        //     }
        //     System.out.println("Successful!!!");
        // }
    }
   
    /**
     * Adding new product to head of Linked List. The info input from keyboard.
     * @param list The linked list
     */
    public void addFirst(MyList<Product> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Barcode: ");
        String bcode = sc.next();
        System.out.println("Title: ");
        String title = sc.next();
        System.out.println("Quantity: ");
        int quantity = sc.nextInt();
        System.out.println("Price: ");
        double price = sc.nextDouble();
        Product p = new Product(bcode, title, quantity, price);
        list.insertToHead(p);
    }
   
    /**
     * Convert a decimal to a integer number. Example: input i = 18 -> Output = 10010
     * @param i Input decimal number
     * @return a integer numbers
     */
    public static String bin_num = "";        
    public int convertToBinary(int i) {
        // Base Case
        if (i <= 1){
            bin_num += (char)(i + '0');
        }else { 
            // Recursion call
            convertToBinary(i / 2);
            // If x is divisible by 2
            if(i%2 != 0){
                bin_num += '1';
            }   
            // otherwise
            else{
                bin_num += '0';
            }
        }
        return Integer.parseInt(bin_num);
    }
   
    /**
     * Deleting the product at position
     * @param list The Linked List
     * @param pos  The position of product to be deleted
     */
    public void deleteAtPosition(MyList<Product> list, int pos) {
        Node<Product> curr = list.head;
        int count = 0;
        while (curr.next != null) {
            if (count == pos) {
                break;
            }
            curr = curr.next;
            count ++;
        }
        list.deleteElement(curr.info);
    }
}
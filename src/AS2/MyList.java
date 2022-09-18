package AS2;
/**
* Generic version of the LinkedList class.
* @param <T> the type of the value
*/
public class MyList<T> {
    /**
     * Head node, default is null
     */
    Node<T> head;
    /**
     * Tail node, default is null
     */
    Node<T> tail;
    /**
     * Default constructor
     */
    public MyList() {
        head = null;
        tail = null;
    }
    /**
     * Constructor with head and tail
     * @param head Head node of this list
     * @param tail Tail node of this list
     */
    public MyList(Node<T> head, Node<T> tail) {
        this.head = head;
        this.tail = tail;
    }
    /**
     * Checking if this list is empty
     * @return true if list is empty
     */
    public boolean isEmpty() {
        return head == null;
    }
    /**
     * Returning the length of this list
     * @return The length of this list
     */
    public int length() {
        Node<T> temp = head;
        int count = 0;
        while (temp != null)
        {
            count++;
            temp = temp.next;
        }
        return count;
    }
    /**
     * Insert an item to the head of this list
     * @param item The item to be inserted
     */
    public void insertToHead(T item) {
        /* 1 & 2: Allocate the Node &
        Put in the data*/
        Node<T> new_node = new Node<T>(item,head);

        /* 3. Move the head to point to new Node */
        head = new_node;
    }
    /**
     * Insert an item at position to this list
     * @param position The position of new item
     * @param item     The item to be inserted
     */
    public void insertAfterPosition(int position, T item) {
        /* 1. Get Node obj from position */
        Node<T> nodeP = head;
        int count = 0;
        while (nodeP != null) {
            if (count == position) {
                break;
            }
            count++;
            nodeP = nodeP.next;
        }
        /* 2. Allocate the Node &
        3. Put in the data*/
        Node<T> new_node = new Node<T>(item,nodeP.next);
        
        /* 4. make next of prev_node as new_node */
        nodeP.next = new_node;
    }
    /**
     * Deleting the tail of this list
     */
    public void deleteTail() {
        // Find the second last node
        Node<T> second_last = head;
        while (second_last.next.next != null){
            second_last = second_last.next;
        }
 
        // Change next of second last
        second_last.next = null;
    }
    /**
     * Searching and deleting an item from this list by comparing the ID of items
     * @param item The item to be deleted
     */
    public void deleteElement(T item) {
        Node<T> temp = head, prev = null;
        // If head node itself holds the item to be deleted
        if (temp != null && temp.info == item) {
            head = temp.next; // Changed head
            return;
        }
        // If tail node itself holds the item to be deleted
        if (tail.info == item) {
            deleteTail(); // Delete tail
            return;
        }
        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (temp != null && temp.info != item) {
            prev = temp;
            temp = temp.next;
        }
        // If key was not present in linked list
        if (temp == null){
            return;
        }
        // Unlink the node from linked list
        prev.next = temp.next;
    }
    /**
     * Swaping two nodes [firstNode] and [secondNode]
     * @param firstNode
     * @param secondNode
     */
    public void swap(Node<T> firstNode, Node<T> secondNode) {
        // Nothing to do if x and y are same
        if (firstNode.info == secondNode.info){
            return;
        }else{
            T temp = firstNode.info;
            firstNode.info = secondNode.info;
            secondNode.info = temp;
        }
    }
    /**
     * Deleting all items in the list
     */
    public void clear() {
        head = null;
    }
}

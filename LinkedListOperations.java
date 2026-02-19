public class LinkedListOperations {

    /*
     * ============================
     * 1. Node Class
     * ============================
     * Each node must contain:
     *  - an integer key
     *  - a reference to the next node
     */

    static class Node {
        int key;       // stores the value
        Node next;     // pointer to next node in the list

        Node(int key) {
            this.key = key;
            this.next = null;  // initially does not point to anything
        }
    }

    /*
     * ============================
     * 2. LIST-INSERT(L, x)
     * Inserts node x at the head of the list.
     * Returns the new head.
     * ============================
     */

    static Node listInsert(Node head, Node x) {

        x.next = head;   // new node points to current head
        head = x;        // update head to be x

        return head;
    }

    /*
     * ============================
     * 3. LIST-SEARCH(L, k)
     * Searches for a node with key k.
     * Returns the node if found,
     * otherwise returns null.
     * ============================
     */

    static Node listSearch(Node head, int key) {

        Node current = head;

        while (current != null) {

            if (current.key == key) {
                return current;  // key found
            }

            current = current.next;
        }

        return null;  // key not found
    }

    /*
     * ============================
     * 4. LIST-DELETE(L, x)
     * Deletes the given node x
     * (passed by reference).
     * Returns possibly updated head.
     * ============================
     */

    static Node listDelete(Node head, Node x) {

        if (head == null || x == null) {
            return head;
        }

        // Case 1: x is the head node
        if (head == x) {
            return head.next;
        }

        // Case 2: find the node before x
        Node previous = head;

        while (previous.next != null && previous.next != x) {
            previous = previous.next;
        }

        // unlink x from the list
        if (previous.next == x) {
            previous.next = x.next;
        }

        return head;
    }

    /*
     * Helper method to print the list
     * (used to verify changes visually)
     */

    static void printList(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.key);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }

        System.out.println();
    }

    /*
     * ============================
     * Main Method (as required)
     * ============================
     * Steps:
     * 1. Create empty list
     * 2. Insert at least three nodes
     * 3. Print the list
     * 4. Search for a node
     * 5. Delete a node by reference
     * 6. Print list again
     */

    public static void main(String[] args) {

        // 1. Create empty list
        Node head = null;

        // 2. Insert at least three nodes
        Node node1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);

        head = listInsert(head, node1);
        head = listInsert(head, node2);
        head = listInsert(head, node3);

        // 3. Print the list
        System.out.println("List after inserting three nodes:");
        printList(head);

        // 4. Search for a node
        int searchKey = 20;
        Node foundNode = listSearch(head, searchKey);

        if (foundNode != null) {
            System.out.println("Node with key " + searchKey + " was found.");
        } else {
            System.out.println("Node with key " + searchKey + " was not found.");
        }

        // 5. Delete a node (by passing reference)
        head = listDelete(head, foundNode);

        // 6. Print the list again to show change
        System.out.println("List after deleting node with key " + searchKey + ":");
        printList(head);
    }
}

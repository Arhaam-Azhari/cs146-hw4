public class PalindromeLinkedList {

    /*
     * Node Class
     * Each node contains:
     *  - an integer key
     *  - a reference to the next node
     */

    static class Node {
        int key;        // stores value
        Node next;      // pointer to next node

        Node(int key) {
            this.key = key;
            this.next = null;
        }
    }

    /*
     * Helper method to build a linked list
     * from an integer array.
     * This is just to make testing easier.
     */

    static Node buildList(int[] arr) {

        Node head = null;
        Node tail = null;

        for (int value : arr) {

            Node newNode = new Node(value);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return head;
    }

    /*
     * Helper method to print the list
     * Used to visually check the structure.
     */

    static void printList(Node head) {

        Node current = head;

        while (current != null) {
            System.out.print(current.key);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }

        System.out.println();
    }

    /*
     * Reverse a linked list starting from head.
     * Returns the new head after reversal.
     */

    static Node reverse(Node head) {

        Node previous = null;
        Node current = head;

        while (current != null) {

            Node nextNode = current.next;

            current.next = previous;

            previous = current;
            current = nextNode;
        }

        return previous;
    }

    /*
     * Function required in assignment:
     * Determine whether a singly linked list
     * represents a palindrome.
     *
     * A palindrome reads the same forward and backward.
     */

    static boolean isPalindrome(Node head) {

        // Empty list or single node is always palindrome
        if (head == null || head.next == null) {
            return true;
        }

        /*
         * Step 1:
         * Use slow and fast pointers
         * to find the middle of the list.
         */

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        /*
         * If list has odd number of nodes,
         * skip the middle element.
         */

        if (fast != null) {
            slow = slow.next;
        }

        /*
         * Step 2:
         * Reverse the second half of the list.
         */

        Node secondHalf = reverse(slow);

        /*
         * Step 3:
         * Compare first half and reversed second half.
         */

        Node pointer1 = head;
        Node pointer2 = secondHalf;

        while (pointer2 != null) {

            if (pointer1.key != pointer2.key) {
                return false;
            }

            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return true;
    }

    /*
     * Main Method
     * Testing examples given in assignment:
     *
     * 1 → 2 → 3 → 2 → 1 → Palindrome
     * 10 → 20 → 20 → 10 → Palindrome
     * 5 → 10 → 17 → Not a palindrome
     */

    public static void main(String[] args) {

        int[][] testCases = {
                {1, 2, 3, 2, 1},
                {10, 20, 20, 10},
                {5, 10, 17}
        };

        for (int i = 0; i < testCases.length; i++) {

            Node head = buildList(testCases[i]);

            printList(head);

            if (isPalindrome(head)) {
                System.out.println("Palindrome");
            } else {
                System.out.println("Not a palindrome");
            }

            System.out.println();
        }
    }
}

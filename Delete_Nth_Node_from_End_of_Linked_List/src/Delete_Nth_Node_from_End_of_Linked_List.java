/* Problem Statement

You are given the head of a singly linked list and an integer n.

Your task is to delete the n-th node from the end of the linked list and return the updated head of the list.

🔹 Input

Head of a singly linked list

Integer n (1 ≤ n ≤ length of the list)

🔹 Output

Head of the linked list after deleting the n-th node from the end

🔹 Example

Input

Linked List: 1 → 2 → 3 → 4 → 5
n = 2


Output

1 → 2 → 3 → 5

⏱ Time Complexity (TC)

O(n)

The linked list is traversed only once using two pointers

Each pointer moves at most n times

📦 Space Complexity (SC)

O(1)

Only constant extra space is used

No additional data structures are required */

import java.util.Scanner;

public class Delete_Nth_Node_from_End_of_Linked_List {

    public static class Node{
        int val;
        Node next;

        public Node(int val)
        {
            this.val = val;
            this.next = null;
        }
    }

    public static Node removeNode(Node head, int n){

        Node dummy = new Node(0);
        dummy.next = head;
        Node fast = dummy;
        Node slow = dummy;

        for(int i=0; i <= n; i++)
        {
            if(fast == null)
                return head; // If n > length of the list, fast will become null and the next .next will crash
            fast = fast.next;
        }

        while(fast != null)
        {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;

    }

    public static void main(String[] args)
    {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.print("The linked list before deletion: ");
        Node first = head;
        while(first != null)
        {
            System.out.print(first.val + " ");
            first = first.next;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the node number from last to be deleted: ");
        int n = sc.nextInt();

        Node formatted = removeNode(head,n);

        System.out.print("The linked list after deletion: ");
        Node travel = formatted;

        while(travel != null)
        {
            System.out.print(travel.val + " ");
            travel = travel.next;
        }


    }
}

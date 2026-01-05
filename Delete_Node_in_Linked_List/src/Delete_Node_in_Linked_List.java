/* Problem Statement: Delete Node in a Linked List

You are given a node to be deleted in a singly linked list.

⚠️ You are NOT given the head of the linked list.

Each node contains an integer value and a reference to the next node.

Your task is to delete the given node from the linked list.

🔒 Constraints

The given node is not the tail node

The linked list contains at least two nodes

You cannot access the head of the list

💡 Key Insight

Since we cannot move backward or access the previous node:

👉 Copy the value of the next node into the current node,
👉 Then bypass the next node.

This effectively removes the given node.

Metric	Complexity
Time Complexity	    O(1)
Space Complexity	O(1)

*/

public class Delete_Node_in_Linked_List {

    public static class Node{
        int val;
        Node next;

        public Node(int n)
        {
            this.val = n;
            this.next = null;
        }

        public static void delNode(Node n)
        {
            if(n == null || n.next == null)
                return;
            n.val = n.next.val;
            n.next = n.next.next;

        }
    }

    public static void main(String[] args)
    {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node k = head;
        Node j = head;
        System.out.print("Linked List before Node Deletion: ");
        while(k != null)
        {
            System.out.print(k.val + " ");
            k = k.next;
        }

        System.out.print("\nLinked List after Node Deletion: ");
        Node.delNode(head.next.next);
        while(j != null)
        {
            System.out.print(j.val + " ");
            j = j.next;
        }

    }
}

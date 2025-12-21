/* Problem Statement: Detect the Start of a Loop in a Linked List

You are given the head of a singly linked list.

Each node contains an integer value and a reference to the next node.

A loop (cycle) exists in the linked list if a node’s next pointer points to a previous node in the list.

Your task is to detect whether a loop exists and, if it does, return the node where the loop starts.

If no loop is present, return null.

🔹 Example

Input Linked List:

1 → 2 → 3 → 4
        ↑   ↓
        ← ← ←


Output:

Loop starts at node with value 3

🔹 Another Example (No Loop)

Input:

1 → 2 → 3 → 4 → 8 → null


Output:

No loop detected

⏱ Time Complexity (TC)
O(n)


Each node is visited at most once.

HashSet lookup and insertion take O(1) average time.

💾 Space Complexity (SC)
O(n)


Extra space is used to store visited nodes in a HashSet.

📝 Notes (Optional for Interview)

This solution uses extra space to track visited nodes.

A more optimal solution exists using Floyd’s Cycle Detection Algorithm with O(1) space.

*/

import java.util.HashSet;

public class Loop_Detection_in_Linked_List_using_HashSet {

    public static class Node{
        int val;
        Node next;

        public Node(int n)
        {
            this.val = n;
            this.next =  null;
        }
    }

    public static Node start_of_loop_Node(Node head)
    {
//        if(head == null)
//            return null;

       HashSet<Node> set1 = new HashSet<>();
       Node p1 = head;

           while(p1 != null && !set1.contains(p1))
           {
               set1.add(p1);
               p1 = p1.next;
           }

       return p1;

    }

    public static void main(String[] args)
    {
        Node list = new Node(1);
        list.next = new Node(2);
        list.next.next = new Node(3);
        list.next.next.next = new Node(4);
        list.next.next.next.next = list.next.next;
        //list.next.next.next.next = new Node(8);

        Node start = start_of_loop_Node(list);

        if(start!=null)
        System.out.println("The Linked List has a loop at Node: " + start.val);
        else
            System.out.println("The Linked List is not cyclic! It does not contain any loop.");


    }
}

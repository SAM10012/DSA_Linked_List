/*
Problem Statement: Detect the Start of a Loop in a Linked List (Floyd’s Cycle Detection)

You are given the head of a singly linked list.

Each node contains an integer value and a reference to the next node.

A loop (cycle) exists in the linked list if a node’s next pointer points to a previous node in the list.

Your task is to detect whether a loop exists and, if it does, return the node where the loop starts.

If no loop is present, return null.

--------------------------------------------------

Approach: Floyd’s Cycle Detection Algorithm (Slow & Fast Pointers)

1. Use two pointers:
   - Slow pointer moves one step at a time.
   - Fast pointer moves two steps at a time.

2. If a loop exists, slow and fast pointers will eventually meet inside the loop.

3. After they meet:
   - Reset the slow pointer to the head.
   - Move both slow and fast pointers one step at a time.
   - The node where they meet again is the start of the loop.

--------------------------------------------------

Example (Loop Present):

1 → 2 → 3 → 4
        ↑   ↓
        ← ← ←

Output:
Loop starts at node with value 3

--------------------------------------------------

Example (No Loop):

1 → 2 → 3 → 4 → 8 → null

Output:
No loop detected

--------------------------------------------------

Time Complexity (TC):
O(n)

- Each pointer traverses the list at most a constant number of times.

Space Complexity (SC):
O(1)

- No extra data structures are used.
- Only two pointers are maintained.

*/

public class Loop_Detection_in_Linked_List_Floyd_Algo {

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

        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast)
                break;
        }

        if(fast == null || fast.next == null)
            return null;

        slow = head;

        while(slow != fast)
        {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

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

/*

Problem Statement: Intersection of Two Linked Lists (Return Node)

You are given the heads of two singly linked lists, headA and headB.

Each node in the linked list contains an integer value and a reference to the next node.

Your task is to find and return the node at which the two linked lists intersect.

Two linked lists are said to intersect if they share a common node by reference, meaning both linked lists point to the same memory location starting from that node onward.
Intersection is not determined by node values.

If the two linked lists do not intersect, return null.

Input

headA: head of the first singly linked list

headB: head of the second singly linked list

Output

The reference to the intersecting node if an intersection exists

null if no intersection exists

Constraints

0 ≤ length of each linked list ≤ 10⁵

Linked lists may have different lengths

No cycles are present in the lists

Do not modify the original linked lists

Intersection must be detected using node reference equality, not value equality

* Time Complexity (TC):

O(n + m)
where n = length of list A, m = length of list B
(each pointer traverses both lists at most once)

Space Complexity (SC):

O(1)
(only two pointers used, no extra data structures)
*
* */

import java.util.*;

public class Intersecting_Linked_Lists {

    public static class Node {
        int val;
        Node next;

        public Node(int n) {
            this.val = n;
            this.next = null;
        }
    }

        public static Node isIntersecting(Node headA, Node headB)
        {

            Node p1 = headA;
            Node p2 = headB;

            while(p1 != p2)
            {
                p1 = (p1 == null)?headB:p1.next;
                p2 = (p2 == null)?headA:p2.next;
            }

            return p1;

        }

        public static void main(String[] args)
        {
            Node list1 = new Node(1);
            list1.next = new Node(2);
            list1.next.next = new Node(3);

            Node list2 = new Node(4);
            list2.next = list1.next.next;
            list1.next.next.next = new Node(77);

            Node ans = isIntersecting(list1, list2);

            if(ans!=null)
            System.out.println("The two Linked Lists are intersecting at Node: " + ans.val);
            else
                System.out.println("The two Linked Lists are not intersecting!");
        }

}

/* Problem Statement: Add Two Numbers Represented by Linked Lists (Forward Order)

You are given two non-empty singly linked lists L1 and L2, each representing a non-negative integer.

Each node contains a single digit (0–9).

The digits are stored in forward order, meaning the most significant digit comes first.

Your task is to add the two numbers represented by the linked lists and return the sum as a new linked list.

The resulting linked list must also store digits in forward order.

🔹 Input

Two linked lists L1 and L2

Each node contains a single digit

Digits are stored in forward order

🔹 Output

A linked list representing the sum of the two numbers, in forward order

🔹 Example

Input

L1: 7 → 2 → 4 → 3
L2: 5 → 6 → 4


Explanation

7243 + 564 = 7807


Output

7 → 8 → 0 → 7

Time Complexity (TC)

O(n + m)

n = number of nodes in linked list L1

m = number of nodes in linked list L2

One traversal to push into stacks

One traversal to pop and add digits

💾 Space Complexity (SC)

O(n + m)

Extra space used by two stacks:

Stack s1 stores n digits

Stack s2 stores m digits

Result list also uses O(n + m) nodes

*/

import java.util.*;

public class Add_Two_Numbers {

    public static class Node{
        int val;
        Node next;

        Node(int n)
        {
            this.val = n;
            this.next = null;
        }
    }

    private static Node addNum(Node l1, Node l2)
    {
       Stack<Integer> s1 = new Stack<>();
       Stack<Integer> s2 = new Stack<>();

       while(l1 != null)
       {
           s1.push(l1.val);
           l1 = l1.next;
       }

       while(l2 != null)
       {
           s2.push(l2.val);
           l2 = l2.next;
       }

       Node tail = null;
       int carry = 0;
       int sum = 0;

       while(!s1.isEmpty() || !s2.isEmpty()|| carry != 0)
       {
           sum = carry;

           if(!s1.isEmpty())
           {
               sum += s1.pop();
           }

           if(!s2.isEmpty())
           {
               sum += s2.pop();
           }

           Node head = new Node(sum%10);
           head.next = tail;
           tail = head;

           carry = sum/10;
       }

       return tail;
    }

    public static void main(String[] args)
    {
        Node l1 = new Node(7);
        l1.next = new Node(1);
        l1.next.next = new Node(6);

        Node l2 = new Node(5);
        l2.next = new Node(9);
        l2.next.next = new Node(2);

//        Node l1 = new Node(9);
//        l1.next = new Node(9);
//        l1.next.next = new Node(9);
//
//        Node l2 = new Node(1);


        Node ans = addNum(l1,l2);

        Node one = ans;

        while(one != null)
        {
            System.out.print(one.val + " ");
            one = one.next;
        }
    }
}

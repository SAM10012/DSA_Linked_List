/* Problem Statement: Add Two Numbers Represented by Linked Lists

You are given two non-empty linked lists representing two non-negative integers.

Each linked list stores the digits of the number in reverse order, and each node contains a single digit.

Add the two numbers and return the sum as a linked list.

The digits of the result should also be stored in reverse order.

⏱ Time Complexity (TC)

O(n)

n = length of the longer linked list

Each node of both linked lists is visited once

All operations inside the loop are O(1)

✅ Works for equal and unequal list sizes

💾 Space Complexity (SC)

O(n)

A new linked list is created to store the result

In the worst case, the result list has n + 1 nodes (extra node for carry)

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
        Node dummy = new Node(0);
        Node curr = dummy;
        int carry = 0;
        int sum = 0;
        while(l1 != null || l2 != null || carry != 0)
        {
            sum = carry;

            if(l1 != null)
            {
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null)
            {
                sum += l2.val;
                l2 = l2.next;
            }

            curr.next = new Node(sum%10);
            carry = sum/10;
            curr = curr.next;
        }

        return dummy.next;
    }

    public static void main(String[] args)
    {
//        Node l1 = new Node(7);
//        l1.next = new Node(1);
//        l1.next.next = new Node(6);

//        Node l2 = new Node(5);
//        l2.next = new Node(9);
//        l2.next.next = new Node(2);

        Node l1 = new Node(9);
        l1.next = new Node(9);
        l1.next.next = new Node(9);

        Node l2 = new Node(1);


        Node ans = addNum(l1,l2);

        Node one = ans;

        while(one != null)
        {
            System.out.print(one.val + " ");
            one = one.next;
        }
    }
}

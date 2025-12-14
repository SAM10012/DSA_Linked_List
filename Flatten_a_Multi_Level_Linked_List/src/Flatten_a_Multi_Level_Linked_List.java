/*
* Problem: Flatten a Multilevel Linked List

You are given a special linked list where each node contains two pointers:

next → points to the node to the right (horizontal direction)

down → points to the node downward (vertical direction)

The list structure works like this:

The top-level list is formed using the next pointers.

Each node in the top-level list may have its own vertical linked list using down pointers.

Each vertical list is sorted in ascending order.

The horizontal list is not guaranteed to be sorted.

🔹 Your Task

Flatten the entire structure into one single sorted linked list, using only the down pointer.

After flattening:

All nodes must appear in sorted order.

Only down pointers should remain.

All next pointers should be removed/ignored.
* */

import java.util.*;

public class Flatten_a_Multi_Level_Linked_List {

    public static class Node{
        int val;
        Node next;
        Node down;

        public Node(int n)
        {
            val = n;
            next = null;
            down = null;
        }
    }

    private Node merge(Node list1, Node list2)
    {
        Node dummyNode = new Node(-1);
        Node res = dummyNode;

        while(list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                res.down = list1;
                res = res.down;
                list1 = list1.down;
            } else {
                res.down = list2;
                res = res.down;
                list2 = list2.down;
            }

            res.next = null;
        }

        if(list1!=null) res.down = list1;
        else res.down = list2;

        return dummyNode.down;
    }

    private Node flatten(Node head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }

        Node merged_head = flatten(head.next);
        head.next = null;
        return merge(head,merged_head);
    }

    public static void main(String[] args)
    {
        Flatten_a_Multi_Level_Linked_List obj = new Flatten_a_Multi_Level_Linked_List();
        Node head = new Node(1);
        head.down = new Node(2);
        head.next = new Node(4);
        head.next.down = new Node(5);

        head.next.next = new Node(3);
        head.next.next.down = new Node(6);
        head.next.next.down.down = new Node(7);

        Node flattened_head = obj.flatten(head);

        Node first = flattened_head;
        while(first != null)
        {
            System.out.println(first.val);
            first = first.down;
        }


    }
}

/* Problem Statement: Check if a Linked List is a Palindrome

You are given the head of a singly linked list.

Each node contains a single integer value.

Your task is to determine whether the linked list forms a palindrome.

A linked list is said to be a palindrome if the sequence of values read from left to right is the same as right to left.

🔹 Input

The head of a singly linked list

1 ≤ number of nodes ≤ 10⁵

0 ≤ Node.val ≤ 9

🔹 Output

Return true if the linked list is a palindrome

Return false otherwise

🔹 Examples

Example 1

Input:  1 → 2 → 2 → 1
Output: true


Example 2

Input:  1 → 2 → 3
Output: false

🔹 Constraints

The linked list is singly linked

The list may contain an even or odd number of nodes

*/

//=============================== Approach 1 : Using Stack ======================================

/* Time & Space Complexity
Metric	Complexity
Time	O(n)
Space	O(n/2) → O(n)

(Optimized stack-based solution)

*/

import java.util.*;
public class LL_Palindrome_using_stack {

    public static class Node{
        int val;
        Node next;

        Node(int n)
        {
            this.val = n;
            this.next = null;
        }
    }

    public static boolean isPalindrome(Node head)
    {
        if (head == null || head.next == null)
            return true;

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        if(fast != null)
            slow = slow.next;

        Stack<Integer> s1 = new Stack<>();

        while(slow != null)
        {
            s1.push(slow.val);
            slow = slow.next;
        }

        while(!s1.isEmpty())
        {
            if(head.val != s1.pop())
                return false;
            head = head.next;
        }

        return true;

    }


    public static void main(String[] args)
    {
        Node list = new Node(1);
        list.next = new Node(2);
        list.next.next = new Node(3);
        list.next.next.next = new Node(2);
        list.next.next.next.next = new Node(1);

        boolean ans = isPalindrome(list);

        System.out.println("The linked list is a Palindrome: " + ans);
    }
}
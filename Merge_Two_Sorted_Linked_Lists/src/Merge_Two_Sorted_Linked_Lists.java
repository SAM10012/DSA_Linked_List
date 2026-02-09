/* Problem Statement

Given the heads of two sorted singly linked lists, merge them into one sorted linked list by rearranging the existing nodes.
Return the head of the merged linked list.

🛠 Approach

Handle edge cases where one of the lists is null.

Compare the first nodes of both lists and choose the smaller one as the head of the merged list.

Maintain two pointers:

one pointer to build/traverse the merged list

one pointer to preserve the start of the merged list

Iterate while both lists have nodes:

compare current nodes

attach the smaller node to the merged list

move the corresponding pointer forward

Once one list is exhausted, attach the remaining nodes of the other list.

Return the preserved head of the merged list.

⏱ Time Complexity

O(n + m)
Where:

n = number of nodes in the first list

m = number of nodes in the second list

Each node is visited exactly once.

🧠 Space Complexity

O(1) (auxiliary space)
No extra data structures are used; the merge is done in-place by rearranging pointers.
*/

public class Merge_Two_Sorted_Linked_Lists {

    public static class Node{
        int val;
        Node next;

        public Node(int n)
        {
            val = n;
        }
    }

    public static Node mergeLists(Node head1, Node head2)
    {
        if(head1 == null) return head2;
        if(head2 == null) return head1;

        Node head = null;

        Node h1 = head1;
        Node h2 = head2;

        if(h1.val < h2.val)
        {
            head = h1;
            h1 = h1.next;
        }
        else {
            head = h2;
            h2 = h2.next;
        }

        Node first = head;

        while(h1 != null && h2 != null)
        {
            if(h1.val < h2.val)
            {
                head.next = h1;
                h1 = h1.next;
            }
            else {
                head.next = h2;
                h2 = h2.next;
            }
            head = head.next;
        }

        if(h1 != null)
        {
            head.next = h1;
        }
        else if(h2 != null) {
            head.next = h2;
        }

        return first;

    }

    public static void main(String[] args)
    {
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);

        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(7);

        Node final_list = mergeLists(head1,head2);
        Node i = final_list;

        System.out.println("The merged linked list is: ");
        while(i != null)
        {
            System.out.print(i.val + " ");
            i = i.next;
        }
    }
}

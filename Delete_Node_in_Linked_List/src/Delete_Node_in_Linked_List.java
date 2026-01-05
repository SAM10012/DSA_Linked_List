

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

package LinkedList;
import java.util.*;

/********************************************************************************************* */
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedList {
    Node head;

    void add(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
            return;
        }
        Node curr = head;
        while (curr.next != null)
            curr = curr.next;
        curr.next = new_node;
    }
}
/********************************************************************************************* */


public class P08_AddNo_ReprByLL {
    
    public static Node reverse(Node node) {
        Node prev = null;
        Node curr = node;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;
    }

    public static void combine(Node a, Node b, LinkedList ans) {

        int carry = 0;
        while (a != null && b != null) {
            int sum = a.data + b.data + carry;
            ans.add(sum % 10);
            carry = sum / 10;
            a = a.next;
            b = b.next;
        }

        while (a != null) {
            int sum = a.data + carry;
            ans.add(sum % 10);
            carry = sum / 10;
            a = a.next;
        }

        while (b != null) {
            int sum = b.data + carry;
            ans.add(sum % 10);
            carry = sum / 10;
            b = b.next;
        }

        if (carry > 0) {
            ans.add(carry);
        }
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        LinkedList a = new LinkedList();
        LinkedList b = new LinkedList();

        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }

        for (int i = 0; i < m; i++) {
            b.add(sc.nextInt());
        }
        // a= 4->5
        // b=3->4->5

        a.head = reverse(a.head);
        b.head = reverse(b.head);
        // a=5->4
        // b=5->4->3

        LinkedList ans = new LinkedList();
        combine(a.head, b.head, ans);
        // ans= 0->9->3

        ans.head = reverse(ans.head);
        // ans=3->9->0

        Node curr = ans.head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        sc.close();
    }
}
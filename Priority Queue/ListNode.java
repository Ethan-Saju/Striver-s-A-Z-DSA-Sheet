import java.util.*;

class mergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->{
            return Integer.compare(a.val , b.val);
        });

        for(ListNode head : lists)
            if (head!=null) pq.add(head);
        

        ListNode dummy = new ListNode();
        ListNode tail  = dummy;
        

        while (!pq.isEmpty()){

            ListNode node = pq.poll();
            tail.next = node;
            tail = node;

            if(node.next !=null) pq.add(node.next);

        }

        return dummy.next;
        
    }
}

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
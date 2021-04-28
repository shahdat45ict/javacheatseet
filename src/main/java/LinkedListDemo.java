import java.util.*;

public class LinkedListDemo {

    public static void main(String[] args) {


        //insert into linkedlist
        // insertIntoLinkedList( );

        //merge two sorted list
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));

        l1 =   traverseLinkedList(l1);

        ListNode l2 = new ListNode(2, new ListNode(2, new ListNode(
                3, new ListNode(6)
        )));
        ListNode result = mergeTwoSortedLists(l1, l2);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    static ListNode traverseLinkedList(ListNode head) {

        ListNode current = head;

        while (current != null) {

            System.out.println(current.val);
            current = current.next;

        }
        return head;
    }


    static ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {

        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // At least one of l1 and l2 can still have nodes at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;


    }
    public ListNode removeElements(ListNode head, int val) {

        ListNode preHead = new ListNode(-1);
        preHead.next = head;

        ListNode prev = preHead, curr = head;
        while(curr!=null ){
            if(curr.val == val){
                //remove element with val
                prev.next = curr.next;
            }
            else{
                //move forward
                prev = curr;
            }
            curr = curr.next;
        }

        return preHead.next;

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public boolean hasCycle1(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            }
            nodesSeen.add(head);
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Set<ListNode> nodesInB = new HashSet<ListNode>();

        while (headB != null) {
            nodesInB.add(headB);
            headB = headB.next;
        }

        while (headA != null) {
            // if we find the node pointed to by headA,
            // in our set containing nodes of B, then return the node
            if (nodesInB.contains(headA)) {
                return headA;
            }
            headA = headA.next;
        }
        return null;

    }
    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<>();

        // Convert LinkedList into ArrayList.
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // Use two-pointer technique to check for palindrome.
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            // Note that we must use ! .equals instead of !=
            // because we are comparing Integer, not int.
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public int getDecimalValue(ListNode head) {

        StringBuilder sb = new StringBuilder();

        ListNode current = head;
        while(current!=null){
            sb.append(current.val);
            current = current.next;
        }
        return Integer.parseInt(sb.toString(), 2);

    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}


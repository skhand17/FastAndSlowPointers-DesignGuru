
public class LengthOfLinkedListCycle {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        /*
         * Creating a cycle now
         * */

        head.next.next.next.next.next.next = head.next.next;

        ListNode node = findCycleStart(head);
        System.out.println(node.value);
    }


    public static ListNode findCycleStart(ListNode head) {
        int cycleLength = 0;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                cycleLength = cycleLength(slow);
                break;
            }
        }
        return findStart(head, cycleLength);
    }


    public static int cycleLength(ListNode slow) {
        int cycleLength = 0;

        ListNode current = slow;
        do {
            current = current.next;
            cycleLength++;
        } while (current != slow);

        return cycleLength;
    }

    private static ListNode findStart(ListNode head, int cycleLenght) {

        ListNode first = head;
        ListNode second = head;

        while (cycleLenght > 0) {
            second = second.next;
            cycleLenght--;
        }

        while (first != second) {
            first = first.next;
            second = second.next;
        }

        return second;

    }


}

package org.byron4j.leetcode.primary._03_list;

/**
 *  反转链表
 *  <pre>
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * </pre>
 */
public class _01_reverseList {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static ListNode reverseList(ListNode head) {
        // 和删除一样，需要3个节点
        ListNode preNode = null;  // 当前节点的前一个节点
        ListNode nextNode = null;  // 当前节点的下一个节点
        while (head != null){
            nextNode = head.next;   // 保留当前节点的下一个节点


            head.next = preNode;    // 指针逆向

            preNode = head;         // 保留当前节点的前一个节点   ----当前节点变成前一个节点
            head = nextNode;          // 当前节点的下一个节点变成下一次的当前节点


        }
        return preNode;  // 最后的null的前一个节点就是尾部节点---新的头结点
    }

    /**
     *递归实现
     * @param head
     * @return
     */
    private static ListNode reverseList2(ListNode head) {
        if( head == null || head.next == null ){
            // 这里：head是最后一个
            return head;
        }else{
            // 递归到最后一个节点
            ListNode listNode = reverseList2(head.next);

            // 这里head是倒数第二个：  倒数第二个和最后一个逆向
            // 则head.next.next变为倒数第二个;
            // 而head变为倒数第一个，其next为null;
            head.next.next = head;
            head.next = null;

            return listNode;
        }
    }

    private static void printNodes(ListNode head){
        ListNode node = head;
        ListNode tmp = head;
        while (tmp!=null){
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }

    /**
     * 尾插
     * @param head
     * @param node
     * @return
     */
    private static ListNode insertTail(ListNode head, ListNode node){
        ListNode tmp = head;
        while (tmp.next != null )
            tmp = tmp.next;
        tmp.next = node;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        printNodes(head);
        System.out.println("========================");
        insertTail(head, new ListNode(2));
        printNodes(head);
        System.out.println("========================");
        insertTail(head, new ListNode(3));
        //printNodes(head);
        insertTail(head, new ListNode(4));
        //printNodes(head);
        insertTail(head, new ListNode(5));
        printNodes(head);

        System.out.println("===========反转链表=========");
        head = reverseList(head);
        printNodes(head);

        System.out.println("===========反转链表2=========");
        head = reverseList2(head);
        printNodes(head);

    }

}

package org.byron4j.leetcode.primary._03_list;

/**
 * 合并两个有序链表
 * <pre>
 *     将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * </pre>
 */
public class _02_mergeTwoSortedList {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static void printNodes(ListNode head){
        ListNode node = head;
        ListNode tmp = head;
        while (tmp!=null){
            System.out.print(tmp.val + "  ");
            tmp = tmp.next;
        }

        System.out.println();
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

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // 新建一个链表； 插入操作
        ListNode result = new ListNode(-1);
        ListNode p = result;

        while (l1 !=null && l2 !=null){
            if( l1.val <= l2.val ){
                // 则l1不断后移
                // 完成插入链表p的操作
                ListNode tmp = new ListNode(l1.val);
                p.next = tmp;
                p = p.next;

                // l1 后移
                l1 = l1.next;
            }else{
                // l2不断后移
                ListNode tmp = new ListNode(l2.val);
                p.next = tmp;
                p = p.next;

                l2 = l2.next;
            }
        }

        // 判断剩余的
        if( l1 == null ){
            p.next = l2;
        }else{
            p.next = l1;
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        insertTail(l1, new ListNode(2));
        insertTail(l1, new ListNode(4));
        printNodes(l1);
        System.out.println("=========================");
        ListNode l2 = new ListNode(1);
        insertTail(l2, new ListNode(3));
        insertTail(l2, new ListNode(4));
        printNodes(l2);
        System.out.println("=========================");
        ListNode node = mergeTwoLists(l1, l2);
        printNodes(node);
    }
}

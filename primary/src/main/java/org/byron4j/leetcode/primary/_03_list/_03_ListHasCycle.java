package org.byron4j.leetcode.primary._03_list;

import java.util.HashSet;
import java.util.List;

/**
 * 环形链表
 * <pre>
 *     给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 *
 *
 *
 * 进阶：
 *
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 * </pre>
 */
public class _03_ListHasCycle {
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

    public static  boolean hasCycle(ListNode head) {
        if( head == null  || head.next == null ){
            return false;
        }

        // 快慢指针（跑步---快的会遇到慢的）
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if( fast == null  ||  fast.next == null ){
                return false;
            }
            slow = slow.next;
            // 走两步以上才追上
            fast = fast.next.next;
        }


        return true;
    }


    public static  boolean hasCycle2(ListNode head) {
        if( head == null  || head.next == null ){
            return false;
        }

        HashSet<ListNode> hashSet = new HashSet<>();
        while (head != null ){
            if( hashSet.contains(head) ){
                return true;
            }
            hashSet.add(head);
            head = head.next;
        }


        return false;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        insertTail(l1, new ListNode(2));

        printNodes(l1);
        System.out.println("=========================");

    }
}

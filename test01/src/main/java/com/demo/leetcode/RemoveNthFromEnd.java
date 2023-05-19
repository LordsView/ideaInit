package com.demo.leetcode;

import com.demo.leetcode.entity.ListNode;
import com.demo.leetcode.util.ListNodeUtil;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: workspace-IDEAInit
 * @description: 删除链表倒数第几个元素
 * @author: lzz
 * @create: 2022-03-17 14:25
 * <p>
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * <p>
 * 提示：
 * <p>
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *  
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {
//        ListNode listNode = ListNodeUtil.buildListNode(new int[]{1, 2, 3, 4, 5, 6});
        ListNode listNode = ListNodeUtil.buildListNode(new int[]{1, 2});
        ListNode remove = removeByTwoPointer2(listNode, 2);
        System.err.println(remove.toString());
    }

    //双指针-1
    //0 1 2 3 4 5 6
    private static ListNode removeByTwoPointer(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int count = 0;
        ListNode first = head;
        ListNode second = dummy;
        while (first != null) {
            if (count >= n) {
                second = second.next;
            }
            first = first.next;
            count++;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    //双指针-2
    //0 1 2 3 4 5 6
    private static ListNode removeByTwoPointer2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head), first = head, second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while(first!=null){
            second=second.next;
            first=first.next;
        }
        second.next=second.next.next;
        return dummy.next;
    }

    //栈方式
    private static ListNode removeByStack(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode pre = stack.peek();
        pre.next = pre.next.next;
        return dummy.next;
    }

    //计算链表长度方式
    private static ListNode removeHomemade(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = head;
        int count = 0;
        while (pre != null) {
            count++;
            pre = pre.next;
        }
        pre = dummy;
        for (int i = 1; i < count - n + 1; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }

    //递归方式
    public ListNode removeByRecursion(ListNode head, int n) {
        return removeNode(head, n) == n ? head.next : head;
    }

    private int removeNode(ListNode node, int n) {
        if (node.next == null) return 1;
        int m = removeNode(node.next, n);
        if (m == n)
            if (m == 1) node.next = null;
            else node.next = node.next.next;
        return m + 1;
    }


}

package com.demo.leetcode;

import com.demo.leetcode.entity.ListNode;

import java.util.Stack;

/**
 * @program: workspace-IDEAInit
 * @description: 反转链表中的一部分
 * @author: lzz
 * @create: 2022-03-17 10:34
 * <p>
 * 给你单链表的头指针 head 和两个整数 left 和 right ，
 * 其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *  
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 */
public class ReverseListNodePartially {

    //双指针
    private static ListNode reverseList(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head),pre=dummy,next;
        for (int i = 1; i <left ; i++) {
            pre=pre.next;
        }
        ListNode cursor=pre.next;
        for (int i = left; i < right; i++) {
            next=cursor.next;
            cursor.next = next.next;
            next.next = pre.next;
            pre.next= next;
        }
        return dummy.next;
    }

    //栈方式
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right || head == null)
            return head;
        int count = 1;
        ListNode start = head;
        ListNode end = null;
        ListNode start0 = head;
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            if (count < left)
                start = head;
            else {
                if (count <= right)
                    stack.push(head);
                else {
                    end = head;
                    break;
                }
            }
            head = head.next;
            count++;
        }
        ListNode start1 = stack.peek();
        ListNode cur = stack.pop();
        while (!stack.isEmpty()) {
            cur.next = stack.peek();
            cur = stack.pop();
        }
        cur.next = end;
        if (left == 1)
            return start1;
        start.next = start1;
        return start0;
    }
}

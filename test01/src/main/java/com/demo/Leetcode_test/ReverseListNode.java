package com.demo.Leetcode_test;

import com.demo.leetcode.entity.ListNode;

/**
 * @program: workspace-IDEAInit
 * @description:
 * @author: lzz
 * @create: 2022-03-24 10:46
 */
public class ReverseListNode {

    //1 2 3 4
    //递归
    private static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    //迭代
    private static ListNode reverse(ListNode head) {
        ListNode pre = null,next;
        while(head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
}

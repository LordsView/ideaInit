package com.demo.Leetcode_test;

import com.demo.leetcode.entity.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: workspace-IDEAInit
 * @description:
 * @author: lzz
 * @create: 2022-03-24 12:37
 */
public class PaindromListNode {

    //快慢指针
    //1 2 3 4 5 6
    private static boolean isPalin(ListNode head){
        ListNode slow=head,fast=head,pre=null,cur;
        while (fast!=null&&fast.next!=null){
            cur=slow;
            slow=slow.next;
            fast=fast.next.next;
            cur.next=pre;
            pre=cur;
        }
        if(fast!=null){
            slow=slow.next;
        }
        while (pre!=null&&slow!=null){
            if (pre.val!= slow.val){
                return false;
            }
            pre=pre.next;
            slow=slow.next;
        }
        return true;
    }

    //栈方式
    private static boolean isPalindrom(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        cur = head;
        while(cur!=null){
            if (cur.val!=stack.pop())
                return false;
            cur=cur.next;
        }
        return true;
    }
}

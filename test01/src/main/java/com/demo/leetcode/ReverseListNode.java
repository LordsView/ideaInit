package com.demo.leetcode;

import com.demo.leetcode.entity.ListNode;
import com.demo.leetcode.util.ListNodeUtil;

import java.util.Stack;

/**
 * @program: workspace-IDEAInit
 * @description: 单链表反转
 * @author: lzz
 * @create: 2022-03-16 11:26
 */
public class ReverseListNode {

    public static void main(String[] args) {
        int[] arr = new int[14000];
        for (int i = 0; i < 14000; i++) {
            arr[i] = i;
        }
        ListNode listNode = ListNodeUtil.buildListNode(arr);
        long start = System.currentTimeMillis();
//        ListNode newNode = reverseRecursion(listNode);//1ms
//        ListNode newNode = reverseByStack(listNode);//4ms
//        ListNode newNode = reverseByTwoPoint(listNode);//<1ms
        ListNode newNode = reverseByTwoPoint(listNode);//<1ms
        long end = System.currentTimeMillis();
        System.err.println("执行耗时：" + (end - start) + "ms");
//        ListNodeUtil.printListNode(newNode);

    }

    //递归方式-1ms
    private static ListNode reverseRecursion(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newNode = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    //栈方式-4ms
    private static ListNode reverseByStack(ListNode node) {
        Stack<ListNode> nodesStack = new Stack<>();
        ListNode head = null;
        while (node != null) {
            nodesStack.push(node);
            node = node.next;
        }
        if (!nodesStack.isEmpty()) {
            head = nodesStack.pop();
        }
        while (!nodesStack.isEmpty()) {
            ListNode listNode = nodesStack.pop();
            listNode.next.next = listNode;
            listNode.next = null;
        }
        return head;
    }

    //两个指针方式- <1ms
    private static ListNode reverseByTwoPoint(ListNode head) {
        ListNode pre = null, next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}

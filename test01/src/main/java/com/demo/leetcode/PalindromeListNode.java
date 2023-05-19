package com.demo.leetcode;

import com.demo.leetcode.entity.ListNode;
import com.demo.leetcode.util.ListNodeUtil;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: workspace-IDEAInit
 * @description: 判断链表是否是回文链表
 * @author: lzz
 * @create: 2022-03-23 16:06
 * <p>
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：head = [1,2]
 * 输出：false
 *  
 * 提示：
 * <p>
 * 链表中节点数目在范围[1, 105] 内
 * 0 <= Node.val <= 9
 * <p>
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class PalindromeListNode {

    public static void main(String[] args) {
        ListNode listNode = ListNodeUtil.buildListNode(new int[]{1, 2, 1});
        boolean palindrome = isPalindrome1(listNode);
        System.err.println(palindrome);
    }

    /**
     * 快慢指针-3ms
     * 判断头节点，空 or 单个直接返回 true
     * 定义快慢指针，快指针是慢指针后移速度的两倍，遍历链表，
     * 遍历的同时反转链表前半部分，
     * 遍历结束后，慢指针位于链表中间位置，
     * 根据链表长度调整慢指针位置使得其对准链表后半部分第一个位置
     * 遍历链表后半部分和已经反转的前半部分，如不一致则非回文链表
     *
     * @param head
     * @return
     */
    private static boolean isPalindrom(ListNode head) {
        // 判断头节点，空 or 单个直接返回 true
        if (head == null || head.next == null) {
            return true;
        }

        // 定义快慢指针
        ListNode slow = head, fast = head;
        // 定义指针 cur 记录当前位置 & pre 记录前一位置
        ListNode cur = head, pre = null;
        // 非空判断，注意 fast.next.next 要保证 fast != null && fast.next != null
        // 快指针是慢指针后移速度的两倍，使得循环结束后，慢指针位于链表中间位置
        // 在后移过程中反转链表前半部分
        while (fast != null && fast.next != null) {
            // 记录当前位置
            cur = slow;
            slow = slow.next;
            fast = fast.next.next;
            // 反转
            cur.next = pre;
            pre = cur;
        }
        // 如果链表长度为单数，慢指针后移
        // 0 1 2 3 4 5 ^; 0 1 2 3 4 5 6 ^
        //       s     f        s     f
        if (fast != null) {
            slow = slow.next;
        }
        // 遍历链表后半部分和已经反转的前半部分
        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    //栈方式-10ms
    private static boolean isPalindrome1(ListNode head) {
        ListNode cursor = head;
        Deque<Integer> stack = new LinkedList<>();
        while (cursor != null) {
            stack.push(cursor.val);
            cursor = cursor.next;
        }
        cursor = head;
        while (cursor != null) {
            if (cursor.val != stack.pop()) {
                return false;
            }
            cursor = cursor.next;
        }
        return true;
    }

}

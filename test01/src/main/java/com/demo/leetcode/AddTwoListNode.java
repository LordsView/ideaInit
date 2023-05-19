package com.demo.leetcode;

import com.demo.leetcode.entity.ListNode;
import com.demo.leetcode.util.ListNodeUtil;

/**
 * @program: workspace-IDEAInit
 * @description: 两数相加
 * @author: lzz
 * @create: 2022-03-03 13:22
 * <p>
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例 1：
 * 2->4->3
 * +
 * 5->6->4
 * =
 * 7->0->8
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *  
 * <p>
 * 提示：
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */
public class AddTwoListNode {

    public static void main(String[] args) {

        ListNode l1 = ListNodeUtil.buildListNode(new int[]{2, 4, 3});
        ListNode l2 = ListNodeUtil.buildListNode(new int[]{5, 6, 4});

        ListNodeUtil.printListNode(addTwoNumbers1(l1, l2));

    }

    //链表相加-可用于大数运算
    private static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), cursor = head;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }

            cursor.next = new ListNode(carry % 10);
            cursor = cursor.next;
            carry /= 10;
        }
        return head.next;
    }
}

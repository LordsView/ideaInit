package com.demo.Leetcode_test;

import com.demo.leetcode.entity.ListNode;
import com.demo.leetcode.util.ListNodeUtil;

/**
 * @program: workspace-IDEAInit
 * @description:
 * @author: lzz
 * @create: 2022-03-24 09:24
 */
public class MergeTwoListNode {

    public static void main(String[] args) {
        ListNode node1 = ListNodeUtil.buildListNode(new int[]{1, 2, 4});
        ListNode node2 = ListNodeUtil.buildListNode(new int[]{1, 3, 4});
        ListNode listNode = mergeTwoLists(node1, node2);
        System.err.println(listNode.toString());
    }

    //1 2 4
    //1 3 4
    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null)
            return list1 == null ? list2 : list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    private static ListNode mergerTwoListNode(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1), pre = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        pre.next = list1 == null ? list2 : list1;
        return dummy.next;
    }
}

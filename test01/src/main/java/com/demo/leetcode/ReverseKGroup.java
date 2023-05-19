package com.demo.leetcode;

import com.demo.leetcode.entity.ListNode;
import com.demo.leetcode.util.ListNodeUtil;

/**
 * @program: workspace-IDEAInit
 * @description: k个一组反转链表
 * @author: lzz
 * @create: 2022-03-17 17:02
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 *
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *  
 * 示例 1：
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 示例 2：
 *
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * 示例 3：
 *
 * 输入：head = [1,2,3,4,5], k = 1
 * 输出：[1,2,3,4,5]
 * 示例 4：
 *
 * 输入：head = [1], k = 1
 * 输出：[1]
 * 提示：
 *
 * 列表中节点的数量在范围 sz 内
 * 1 <= sz <= 5000
 * 0 <= Node.val <= 1000
 * 1 <= k <= sz
 *
 */
public class ReverseKGroup {

    public static void main(String[] args) {
        ListNode node = ListNodeUtil.buildListNode(new int[]{1, 2, 3, 4, 5, 6});
        ListNode reverse = reverse(node, 2);
        System.err.println(reverse.toString());
    }

    //双层循环 0 1 2 | 3 4 | 5 6 |
    private static ListNode reverse(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head),pre=dummy,cur=head,next;
        int count=0;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        cur=head;
        for (int i = 0; i < count / k; i++) {
            for (int j = 0; j < k - 1; j++) {
                next=cur.next;
                cur.next=next.next;
                next.next=pre.next;
                pre.next=next;
            }
            pre=cur;
            cur=cur.next;
        }
        return dummy.next;
    }
}

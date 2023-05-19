package com.demo.leetcode;

import com.demo.leetcode.entity.ListNode;
import com.demo.leetcode.util.ListNodeUtil;

/**
 * @program: workspace-IDEAInit
 * @description: 合并两个有序链表
 * @author: lzz
 * @create: 2022-03-18 16:48
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例 1：
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 * 提示：
 *
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 *
 */
public class MergeTwoListNode {

    public static void main(String[] args) {
        ListNode node1 = ListNodeUtil.buildListNode(new int[]{1, 2, 4});
        ListNode node2 = ListNodeUtil.buildListNode(new int[]{1, 3, 4});
        ListNode merge = mergeTwoLists2(node1, node2);
        System.err.println(merge.toString());
    }

    //迭代
    //1 2 4
    //1 3 4
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result=new ListNode(0,list1);//头结点
        ListNode before=result,temp;
        while(list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                before=list1;
                list1=list1.next;
                continue;
            }
            temp=list2;
            list2=list2.next;
            before.next=temp;
            temp.next=list1;
            before=temp;
        }
        if(list2!=null) before.next=list2;
        return result.next;
    }

    //迭代
    //7 8
    //1 3 4
    public static ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1),pre = dummy;
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
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        pre.next = list1 == null ? list2 : list1;
        return dummy.next;
    }

    /**
     * 递归
     * list1 1 2 4
     * list2 1 3 4
     *
     * 1->M(1,3)
     * 1->1->M(2,3)
     * 1->1->2->M(4,3)
     * 1->1->2->3>M(4,4)
     * 1->1->2->3->4->M(4,null)
     * 1->1->2->3->4->4
     *
     */
    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null)
            return list1 == null ? list2 : list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists2(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists2(list1, list2.next);
            return list2;
        }
    }

}

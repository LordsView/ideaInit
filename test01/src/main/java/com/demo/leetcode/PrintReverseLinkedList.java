package com.demo.leetcode;

import com.demo.leetcode.entity.ListNode;
import com.demo.leetcode.util.ListNodeUtil;

import java.util.Arrays;

/**
 * @program: workspace-IDEAInit
 * @description: 倒序输出链表
 * @author: lzz
 * @create: 2022-03-16 17:36
 *
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class PrintReverseLinkedList {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        ListNode listNode = ListNodeUtil.buildListNode(arr);
        int[] reverseArr = printList(listNode);
        System.err.println(Arrays.toString(reverseArr));
    }

    //倒序输出链表-数组形式
    private static int[] printList(ListNode head){
        int count=0;
        ListNode cursor=head;
        while(cursor!=null){
            count++;
            cursor=cursor.next;
        }
        cursor=head;
        int[] arr = new int[count];
        for (int i = count-1; i >=0 ; i--) {
            arr[i]=cursor.val;
            cursor=cursor.next;
        }
        return arr;
    }
}

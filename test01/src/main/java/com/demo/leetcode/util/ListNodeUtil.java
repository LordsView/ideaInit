package com.demo.leetcode.util;

import com.demo.leetcode.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: workspace-IDEAInit
 * @description: 链表工具类
 * @author: lzz
 * @create: 2022-03-16 11:28
 */
public class ListNodeUtil {

    //单链表构造ListNode
    public static ListNode buildListNode(int[] arr) {
        ListNode head = new ListNode(0), pre = head;
        for (int v : arr) {
            pre.next = new ListNode(v);
            pre = pre.next;
        }
        return head.next;
    }

    //单链表输出ListNode
    public static void printListNode(ListNode node) {
        ArrayList<Integer> nodeList = new ArrayList<>();
        while (node != null) {
            nodeList.add(node.val);
            node = node.next;
        }
        System.err.println(nodeList.toString());
    }

    //构建linklist-递归方式
    public static ListNode createLinkedListRecursion(List<Integer> list){
        if (list.isEmpty()){
            return null;
        }
        ListNode headNode = new ListNode(list.get(0));
        headNode.next= createLinkedListRecursion(list.subList(1, list.size()));
        return headNode;
    }

    //测试方便的打印函数
    public static void printList(ListNode node){
        while (node != null){
            System.out.print(node.next);
            System.out.print(" ");
            node = node.next;
        }
        System.out.println();
    }

}

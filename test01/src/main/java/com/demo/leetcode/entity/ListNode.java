package com.demo.leetcode.entity;

/**
 * @program: workspace-IDEAInit
 * @description: 模拟单链表类
 * @author: lzz
 * @create: 2022-03-03 13:28
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        ListNode cursor=this;
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(cursor.val);
        while(cursor.next!=null){
            sb.append(",").append(cursor.next.val);
            cursor=cursor.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

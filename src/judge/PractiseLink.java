package judge;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

public class PractiseLink {

    public static void main(String[] args) {
        PractiseLink practiseLink = new PractiseLink();
    }

    //206. 反转链表
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    //83. 删除排序链表中的重复元素
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pointer = head;
        while(pointer!=null){
            if (pointer.next!=null){
                if (pointer.val==pointer.next.val){
                    if (pointer.next.next==null){
                        pointer.next=null;
                    }
                    else {
                        pointer.next = pointer.next.next;
                    }
                }
                else {
                    pointer = pointer.next;
                }
            }
            else {
                pointer = pointer.next;
            }
        }
        return head;
    }
    //19. 删除链表倒数第n个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int total = 0;
        ListNode temp = head;
        while(temp!=null){
            temp=temp.next;
            total++;
        }
        int x = total - n + 1;
        if (x==0) return null;
        else if (x==1) {
            head = head.next;
            return head;
        }
        else {
            ListNode t = head;
            int p=1;
            while (p<x-1){
                p++;
                t=t.next;
            }
            t.next = t.next.next;
            return head;
        }
    }
    //2. 两数相加
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int jinwei = 0;
        while(l1!=null||l2!=null){
            int temp = 0;
            if (l1!=null&&l2!=null){
                temp = l1.val+l2.val+jinwei;
                jinwei = 0;
                if (temp>=10){
                    jinwei = 1;
                    temp = temp-10;
                }
                l1 = l1.next;
                l2 = l2.next;
            }
            else if (l1!=null&&l2==null){
                temp = l1.val+jinwei;
                jinwei = 0;
                if (temp>=10){
                    jinwei = 1;
                    temp = temp-10;
                }
                l1 = l1.next;
            }
            else{
                temp = l2.val+jinwei;
                jinwei = 0;
                if (temp>=10){
                    jinwei = 1;
                    temp = temp-10;
                }
                l2 = l2.next;
            }
            if (head == null) {
                head = tail = new ListNode(temp);
            }
            else {
                tail.next = new ListNode(temp);
                tail=tail.next;
            }
        }
        if (jinwei==1){
                tail.next = new ListNode(1);
                tail=tail.next;
        }
        return head;
    }
    //2582. 递枕头
    public int passThePillow(int n, int time) {
        if (time==0) return 0;
        else {
            int a = time/(n-1);
            int b = time%(n-1);
            if (a%2==0) return b+1;
            else return n-b;
        }
    }
}

package com.algorithm.swordoffer.run.Chapter7;

import com.algorithm.swordoffer.run.ListNode;

/**
 * Created by wkhuahuo on 2017/3/30.
 */
public class DeleteRepeatNode {
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead ==null ){
            return pHead;
        }

        ListNode lend =pHead;
        ListNode preNode = null;
        ListNode start = lend;
        ListNode end = start;
        boolean foo = true;
        boolean single = true;

        while(start !=null) {
            end = start.next;
            while (end != null && start.val == end.val) {//如果相等一直往下走
                single = false;
                start = end;
                end = start.next;
            }

            if(single){//如果是start指向的节点为单独的那么加入结果链表
                if(foo) {//确定头结点
                    preNode = start;
                    lend = start;
                    foo = false;
                    start = end;
                    single = true;
                }else{//头结点已经确定过了
                    lend.next = start;
                    lend = start;
                    start = end;
                    single = true;
                }
            }else{//跳过start指向的节点
                    start = end;
                    single = true;
                    if(start ==null){//如果此时到了链表结尾更新lend指针
                        lend.next = null;
                    }
            }

        }
        return preNode;
    }
}

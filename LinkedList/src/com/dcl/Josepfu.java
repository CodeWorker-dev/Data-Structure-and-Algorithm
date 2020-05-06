package com.dcl;

/**
 * @author dcl
 * @date 2020/5/6 - 10:51
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addNode(new Boy(2));
        circleSingleLinkedList.addNode(new Boy(3));
        circleSingleLinkedList.addNode(new Boy(4));
        circleSingleLinkedList.addNode(new Boy(5));
        circleSingleLinkedList.addNode(new Boy(6));

        circleSingleLinkedList.showList();

        //circleSingleLinkedList.outQueue(4,3);
    }
}

//单向环形链表
class CircleSingleLinkedList{
    //创建头节点
    Boy first = new Boy(1);
    //创建辅助节点
    Boy cur = first;

    //创建环形链表
    public void addNode(Boy boy){
        cur.next = boy;
        cur = cur.next;
        cur.next = first;
    }

    //打印环形链表
    public void showList(){
        cur = first;
        while (true){
            System.out.println(cur.getNo());
            if (cur.next == first){
                break;
            }
            cur = cur.next;
        }
        /*for (int i = 0;i<num ;i++){
            System.out.println(cur.getNo());
            cur = cur.next;
        }*/
    }

    //出链表序列
    public void outQueue(int k ,int m){
        cur = first;
        //brfore指向当前节点的前一个节点
        Boy before = null;
        //循环遍历到第K个节点
        for (int i = 1; i < k; i++) {
            cur = cur.next;
        }
        //出链表逻辑  --> before指向当前节点的下一个节点，当前节点的next置null，当前节点指向before的下一个节点
        while(cur != null){
            for (int i = 1; i < m; i++){
                before = cur;
                cur = cur.next;
            }
            System.out.println(cur.getNo());
            before.next = cur.next;
            cur.next = null;
            cur = before.next;
        }

    }

}

//boy节点
class Boy {
    private int no;
    public Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}

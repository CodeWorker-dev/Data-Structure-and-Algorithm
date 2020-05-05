package com.dcl;

/**
 * @author dcl
 * @date 2020/5/5 - 22:51
 */
public class LinkedList {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
        HeroNode hero4 = new HeroNode(4,"林冲","豹子头");
        singleLinkedList.addNode(hero1);
        singleLinkedList.addNode(hero2);
        singleLinkedList.addNode(hero3);
        singleLinkedList.addNode(hero4);
        singleLinkedList.list();
    }
}

/**
 * 链表
 */
class SingleLinkedList {
    //创建头节点，只有next域，没有数据域-->指针
    HeroNode head = new HeroNode(0, "", "");
    //创建辅助节点
    HeroNode temp = head;

    //向链表中添加元素
    public void addNode(HeroNode heroNode) {
        //如果temp的next为null，就跳出循环；否则，temp就指向temp的下一个节点
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //从while循环出来之后，temp是指向最后一个节点的
        temp.next = heroNode;
    }

    //遍历输出链表
    public void list() {
        //如果链表为空，就跳出循环
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //链表不为空，打印链表
        temp = head.next;
        while(true){
            //如果到了链表最后，就跳出循环
            if (temp == null){
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //辅助节点后移
            temp = temp.next;
        }
    }
}

/**
 * 创建节点Node
 */
class HeroNode {
    //数据域
    private int no;
    private String name;
    private String nickName;
    //next域-->指针
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

package com.dcl;


import java.util.ArrayList;
import java.util.Stack;

/**
 * @author dcl
 * @date 2020/5/5 - 23:23
 */
public class SortLinkedList {
    public static void main(String[] args) {
        HeroLinkedList heroLinkedList = new HeroLinkedList();

        SuperHeroNode hero1 = new SuperHeroNode(1,"宋江","及时雨");
        SuperHeroNode hero2 = new SuperHeroNode(2,"卢俊义","玉麒麟");
        SuperHeroNode hero3 = new SuperHeroNode(3,"吴用","智多星");
        SuperHeroNode hero4 = new SuperHeroNode(4,"林冲","豹子头");

        heroLinkedList.addNode2(hero2);
        heroLinkedList.addNode2(hero3);
        heroLinkedList.addNode2(hero4);
        heroLinkedList.addNode2(hero1);

        heroLinkedList.list();
//        System.out.println("------------------------");
//        heroLinkedList.deleteNode(2);
//        heroLinkedList.list();
        //System.out.println(heroLinkedList.getNodes());

        //heroLinkedList.getKNode(2);

        //反转链表测试
        //System.out.println("------------------------------------");
        //heroLinkedList.reversionList();
        //heroLinkedList.list();

        //测试使用栈倒序打印
        System.out.println("----------------------------------------");
        heroLinkedList.printReversionList();

    }
}

/**
 * 链表类
 */
class HeroLinkedList {
    //头节点
    SuperHeroNode head = new SuperHeroNode(0, null, null);
    //辅助节点
    SuperHeroNode temp;

    //向链表中添加节点【排序】
    public void addNode(SuperHeroNode heroNode) {
        //如果链表为空，直接添加到头节点后面
        if (head.next == null) {
            head.next = heroNode;
            return;
        }
        //如果链表不为空，遍历链表，找到插入位置，插入元素
        temp = head;
        while (true) {
            //如果排名重复，提示，跳出循环
            if (temp.getNo() == heroNode.getNo()) {
                System.out.println("排名重复，添加失败");
                break;
            }
            //最后一个节点的排名还是小于插入元素的排名，就直接插到最后
            if (temp.next == null && temp.getNo() < heroNode.getNo()) {
                temp.next = heroNode;
                break;
            }
            //找到中间插入的位置，插入数据
            if (temp.getNo() < heroNode.getNo() && temp.next.getNo() > heroNode.getNo()) {
                heroNode.next = temp.next;
                temp.next = heroNode;
                break;
            }
            //不符合上述情况，指针后移
            temp = temp.next;
        }
    }

    //向链表中添加节点【排序-->改进】-->使用temp作为添加位置：主要在于怎么找到temp的位置
    public void addNode2(SuperHeroNode heroNode) {
        temp = head;
        //判断是否已有相同排名元素的标识
        boolean flag = false;
        while(true){
            //如果已经到了最后一个位置，就返回
            if (temp.next == null){
                break;
            }
            //因为是按照排名的从小到大的顺序，所以只要找打后面一个元素的排名是大于给定元素的排名时，就可以返回了
            if(temp.next.getNo() > heroNode.getNo()){
                break;
            }else if(temp.next.getNo() == heroNode.getNo()){
                flag = true;
                break;
            }

            temp = temp.next;
        }
        if (flag){
            System.out.println("已有排名，不能重复添加");
        }else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //删除节点
    public void deleteNode(int no){
        //判断是否为空链表
        if (head.next == null){
            System.out.println("空链表");
            return;
        }
        temp = head.next;
        boolean flag =false;
        while (true) {
            //链表尾
            if (temp == null) {
                break;
            }
            if (temp.next.getNo() == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
        }
    }

    //查找倒数第K个节点
    public void getKNode(int k){
        int size = getNodes();
        int nodeNum = size - k + 1;
        temp = head;
        for(int i = 0;i < nodeNum;i++){
            if (temp.next == null){
                throw new RuntimeException("没有");
            }else {
                temp = temp.next;
            }
        }
        System.out.println(temp);
    }

    //链表的反转
    public void reversionList(){
        /*if (head.next == null){
            System.out.println("空表");
            return;
        }else if(head.next.next == null){
            System.out.println("只有一个节点，不存在反转");
            return;
        }*/
        SuperHeroNode t1 = null;
        SuperHeroNode t2 = head.next;
        SuperHeroNode t3 = head.next;
        while(t2!=null){
           t3 = t2.next;
           t2.next = t1;
           t1 = t2;
           t2 = t3;
        }

        head.next = t1;

    }

    //打印链表
    public void list() {
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        temp = head.next;
        while (true){
            System.out.println(temp);
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
    }

    //从尾到头打印链表
    public void printReversionList(){
        if (head.next == null){
            return;
        }
        Stack<SuperHeroNode> stack1 = new Stack<>();
        temp = head.next;
        while (true){
            if (temp != null){
                stack1.push(temp);
                temp = temp.next;
            }else{
                break;
            }
        }
        while (!stack1.empty()){
            System.out.println(stack1.pop());
        }

    }

    //获取链表中有效链表的个数
    public int getNodes(){
        int count =0;
        if (head.next == null){
            return count;
        }
        temp = head.next;
        while(true){
            if (temp != null){
                count++;
            }else{
                break;
            }
            temp = temp.next;
        }
        return count;
    }
}

/**
 * 节点类
 */
class SuperHeroNode {
    //数据域
    private Integer no;
    private String name;
    private String nickName;
    //指针域
    public SuperHeroNode next;

    public SuperHeroNode(Integer no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "SuperHeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public String toString1() {
        return "SuperHeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", next=" + next +
                '}';
    }
}

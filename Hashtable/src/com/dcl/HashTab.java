package com.dcl;

import jdk.nashorn.internal.ir.IfNode;

import java.util.Scanner;

/**
 * @author dcl
 * @date 2020/5/9 - 10:25
 */
public class HashTab {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        Scanner scanner = new Scanner(System.in);
        String key = "";
        while (true){
            System.out.println("add:添加员工");
            System.out.println("show:显示所有员工");
            System.out.println("fd:按id查找员工");
            System.out.println("del:按id删除员工");
            System.out.println("exit:退出系统");
            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("请输入员工id：");
                    int id = scanner.nextInt();
                    System.out.println("q请输入员工姓名:");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTable.add(emp);
                    break;
                case "show":
                    hashTable.list();
                    break;
                case "fd":
                    System.out.println("请输入要查询的id");
                    id = scanner.nextInt();
                    System.out.println(hashTable.findById(id));
                    break;
                case "del":
                    System.out.println("请输入要删除员工的id");
                    id = scanner.nextInt();
                    hashTable.deleteById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}

//HashTable(哈希表/散列表类)
class HashTable{
    private EmpLinkList[] empLinkLists;
    private int size;

    public HashTable(int size) {
        this.size = size;
        empLinkLists = new EmpLinkList[size];

    }

    public int hashFun(int id){
        return id % size;
    }

    public void add(Emp emp){
        int index = hashFun(emp.getId());
        if (empLinkLists[index] == null){
            empLinkLists[index] = new EmpLinkList();
        }
        int i = hashFun(emp.getId());
        empLinkLists[i].add(emp);
    }

    public void list(){
        for (int i = 0; i < size; i++) {
            if (empLinkLists[i] != null){
                empLinkLists[i].list(i);
            }
        }
    }

    public Emp findById(int id){
        int index = hashFun(id);
        if (empLinkLists[index] != null){
            return empLinkLists[index].findById(id);
        }
        return null;
    }

    public void deleteById(int id){
        int index = hashFun(id);
        if (empLinkLists[index] != null){
            empLinkLists[index].deleteById(id);
        }
        return;
    }
}

//链表类
class EmpLinkList{
    private Emp head;

    public void add(Emp emp){
        if (head == null){
            head = emp;
            return;
        }

        Emp curEmp = head;
        while (true){
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    public void list(int no){
        if (head == null){
            System.out.println("链表为空");
            return;
        }
        System.out.print("第"+(no+1)+"条链表为：");
        Emp curEmp = head;
        while (curEmp != null){
            System.out.print(curEmp);
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    public Emp findById(int id){
        Emp curEmp = head;
        while (curEmp != null){
            if (curEmp.getId() == id){
                return curEmp;
            }
            curEmp = curEmp.next;
        }
        return null;
    }

    public void deleteById(int id) {
        if (head == null){
            return;
        }
        if (head.getId() == id){
            head = null;
            return;
        }
        Emp curEmp = head.next;
        Emp preEmp = head;
        while (curEmp != null){
            if (curEmp.getId() == id){
                preEmp.next = curEmp.next;
                return;
            }
            preEmp = curEmp;
            curEmp = curEmp.next;

        }

    }
}

//雇员类
class Emp{
    private Integer id;
    private String name;
    public Emp next;

    public Emp(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

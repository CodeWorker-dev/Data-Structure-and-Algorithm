package com.dcl;

import java.awt.image.LookupOp;
import java.util.Scanner;

/**
 * @author dcl
 * @date 2020/5/6 - 12:49
 */
public class Stack {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("push:入栈");
            System.out.println("pop:出栈");
            System.out.println("show:打印栈中所有元素");
            System.out.println("exit:退出当前程序");
            System.out.println("请选择：");
            key = scanner.next();
            switch (key){
                case "push" :
                    System.out.println("请输入一个数字：");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop" :
                    try {
                        System.out.println(arrayStack.pop());
                    }catch (Exception e){
                        System.out.println("栈空，无元素");
                    }
                    break;
                case "show" :
                    try {
                        arrayStack.showStack();
                    }catch (Exception e){
                        System.out.println("栈空，无元素");
                    }
                    break;
                case "exit" :
                    scanner.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("程序退出~~");
    }
}

//数组模拟栈
class ArrayStack{
    //栈的最大值
    private int maxSize;
    //top开始指到-1位置
    private int top = -1;
    //创建数组
    private int stack[];

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //判断栈空
    public boolean isEmppty(){
        return top == -1;
    }

    //判断栈满
    public boolean isFull(){
        return top == maxSize - 1;
    }

    //入栈
    public void push(int value){
        if (isFull()){
            System.out.println("栈满，无法加入元素");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop(){
        if (isEmppty()){
            throw new RuntimeException("栈空，无元素");
        }
        return stack[top--];
    }

    //打印栈中所有元素
    public void showStack(){
        if (isEmppty()){
            System.out.println("栈空，无元素");
            return;
        }
        for (int i = top;i >=0;i--){
            System.out.println(stack[i]);
        }
    }
}
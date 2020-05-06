package com.dcl;

import org.omg.CORBA.INTERNAL;
import sun.plugin2.message.ShowDocumentMessage;

import javax.lang.model.element.VariableElement;
import javax.sound.midi.Soundbank;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dcl
 * @date 2020/5/6 - 15:25
 */
public class Cacluator {
    public static void main(String[] args) {
        //表达式
        String expersion = "7*2*2-5+1-5+3-4";
        //数栈
        ArrayStack1 numStack = new ArrayStack1(10);
        //符号栈
        ArrayStack1 signStack = new ArrayStack1(10);

        //对表达式进行拆分，拆分到一个数组中
        char[] exp = expersion.toCharArray();
        String[] expStrArr = new String[expersion.length()];
        int index = 0;
        String keyNum = "";
        for (char c : exp) {
            if (c != '+' && c != '-' && c != '*' && c != '/') {
                keyNum = keyNum + c;
            } else {
                expStrArr[index++] = keyNum;
                keyNum = "";
                expStrArr[index++] = String.valueOf(c);
            }
        }
        expStrArr[index++] = keyNum;

        //对表达式数组进行遍历
        for (String s : expStrArr) {
            if (s != null) {
                if (signStack.isOper(s.charAt(0))) {
                    char sign = s.charAt(0);
                    //是符号的情况,对符号栈进行判断
                    if (signStack.isEmppty()) {
                        //如果符号栈为空的情况
                        signStack.push(sign);
                    } else {
                        while (true) {
                            if (signStack.isEmppty()){
                                signStack.push(sign);
                                break;
                            }
                            if (signStack.priority(sign) <= signStack.priority(signStack.peek())) {
                                //当前符号的优先级小于等于栈顶符号的优先级，先进行运算
                                numStack.cal((char) signStack.pop());
                                //numStack.showStack();
                            } else {
                                //当前符号优先级大于栈顶符号的优先级，直接进栈
                                signStack.push(sign);
                                break;
                            }

                        }
                    }
                } else {
                    //是数字的情况，直接加入到数栈中
                    numStack.push(Integer.parseInt(s));
                }
            }

        }

        while (!signStack.isEmppty()) {
            //System.out.println((char) signStack.peek());
            numStack.cal((char) signStack.pop());
        }
        numStack.showStack();

    }
}

//数组模拟栈
class ArrayStack1 {
    //栈的最大值
    private int maxSize;
    //top开始指到-1位置
    private int top = -1;
    //创建数组
    private int stack[];

    public ArrayStack1(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //判断栈空
    public boolean isEmppty() {
        return top == -1;
    }

    //判断栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满，无法加入元素");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        if (isEmppty()) {
            throw new RuntimeException("栈空，无元素");
        }
        return stack[top--];
    }

    //返回栈顶元素的指
    public int peek() {
        if (isEmppty()) {
            throw new RuntimeException("栈空，无元素");
        }
        return stack[top];
    }

    //判断符号的优先级
    public int priority(int sign) {
        if (sign == '+' || sign == '-') {
            return 0;
        } else if (sign == '*' || sign == '/') {
            return 1;
        } else {
            return -1;
        }
    }

    //判断是不是一个运算符
    public boolean isOper(char sign) {
        return sign == '+' || sign == '-' || sign == '*' || sign == '/';
    }

    //计算方法
    public int cal(char sign) {
        int result = 0;
        int num2 = pop();
        int num1 = pop();
        switch (sign) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                break;
        }
        push(result);
        //System.out.println(num1+""+sign+""+num2+"="+result);
        return result;
    }

    //打印栈中所有元素
    public void showStack() {
        if (isEmppty()) {
            System.out.println("栈空，无元素");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}

import com.sun.java.browser.plugin2.DOM;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

/**
 * @author dcl
 * @date 2020/4/21 - 17:37
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        //创建一个对列
        ArrayQueue queue = new ArrayQueue(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列中");
            System.out.println("g(get):获取对头元素");
            System.out.println("h(head):查看队头元素");
            key = scanner.next().charAt(0);
            switch (key ){
                case 's' :
                    try {
                        queue.showQueue();
                    }catch (Exception e){
                        System.out.println("队列为空");
                    }
                    break;
                case 'a' :
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g' :
                    try {
                        System.out.println(queue.getQueue());
                    }catch (Exception e){
                        System.out.println("队列为空");
                    }
                    break;
                case 'h' :
                    try {
                        System.out.println(queue.headQueue());
                    }catch (Exception e){
                        System.out.println("队列为空");
                    }
                    break;
                case 'e' :
                    scanner.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("程序退出~~");
    }
}

/**
 * 数组模拟队列
 */
class ArrayQueue{
    //队列的大小
    private int maxSize;
    //队列头指针 --》指向队头元素的前一个位置
    private int front;
    //队列尾指针 --》指向队尾元素
    private int rear;
    //数组模拟队列
    private int[] arr;

    //创建队列
    public ArrayQueue(int maxQueueSize){
        maxSize = maxQueueSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize-1;
    }

    //添加数据到队列
    public void addQueue(int num){
        //判断队列是否满
        if(isFull()){
            System.out.println("队列满，不能添加元素");
            return;
        }
        rear ++;
        System.out.println("reat"+rear);
        System.out.println("front"+front);
        arr[rear] = num;
    }

    //取出队列中的数据
    public int getQueue(){
        //判断队列是否为空
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有数据可取");
        }
        front ++;
        int firstNum = arr[front];
        arr[front] = 0;
        System.out.println("reat"+rear);
        System.out.println("front"+front);
        return firstNum;
    }

    //显示队列中的所有元素
    public void showQueue(){
        System.out.println("reat"+rear);
        System.out.println("front"+front);
        //判断队列是否为空
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有数据");
        }
        for(int i = front+1;i<rear+1;i++){
            System.out.println("arr["+i+"]="+arr[i]);
        }
    }

    //显示队列的头数据,并不取出
    public int headQueue(){
        System.out.println("reat"+rear);
        System.out.println("front"+front);
        //判断队列是否为空
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有数据可取");
        }

        return arr[front+1];
    }


}

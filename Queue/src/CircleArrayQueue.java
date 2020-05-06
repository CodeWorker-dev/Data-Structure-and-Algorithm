import java.util.HashMap;
import java.util.Scanner;

/**
 * @author dcl
 * @date 2020/5/5 - 19:28
 */
public class CircleArrayQueue {
    public static void main(String[] args) {
        //创建一个对列
        CircleQueue queue = new CircleQueue(4);
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
 * 思路分析：
 *      front：指向队头元素
 *      rear：指向队尾元素的后一个位置
 *              因为是环形，所以在队头元素和队尾元素中间预留一个空位做保障
 *      队满条件：（rear+1）%maxSize = front【队尾和队头之间有一个空位置，队满条件达到的时候，rear指向的位置是空的，rear的下一个位置就是front】
 *      队空条件： rear = front 【这里因为在队尾和队头之间预留了一个空位，所以rear=front的时候，只有可能是队空情况】
 *      队中元素个数：（rear+maxSize-front）% maxSize
 */
class CircleQueue{
    //数组初始哈大小
    private int maxSize;
    //指向队头元素
    private int front;
    //指向队尾元素的后一个位置【一定要预留一个空位，这样才能保证rear=front的情况仅代表-->队空】
    private int rear;
    //创建数组
    private int[] arr;

    public CircleQueue(int queueMaxSize){
        maxSize = queueMaxSize;
        arr = new int[maxSize];
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //判断队列是否已满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    //计算堆中元素个数，用于遍历显示队列
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    //向队列中添加元素
    public void addQueue(int num){
        //判断队列是否已满
        if (isFull()){
            System.out.println("队列已满，不能添加元素");
            return;
        }
        arr[rear] = num;
        rear = (rear+1) % maxSize;
    }

    //从队列中取元素
    public int getQueue(){
        //判断队列是否为空
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有元素可取");
        }
        int num = arr[front];
        front = (front+1) % maxSize;
        return num;
    }

    //打印当前队列
    public void showQueue(){
        //判断队列是否为空
        if (isEmpty()){
            System.out.println("队列为空，没有元素可打印");
            return;
        }
        for(int i = front;i < front + size();i++){
            System.out.println("arr["+(i % maxSize)+"]="+arr[i % maxSize]);
        }
    }

    //打印头元素
    public int headQueue(){
        //判断队列是否为空
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }
}

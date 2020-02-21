package leetcode.test0601to0650;

public class Leetcode622 {
	public static void main(String[] args) {
		MyCircularQueue circularQueue = new MyCircularQueue(3);

		System.out.println(circularQueue.enQueue(2));

		System.out.println(circularQueue.Rear());

		System.out.println(circularQueue.Front());

		System.out.println(circularQueue.deQueue());

		System.out.println(circularQueue.Front());

		System.out.println(circularQueue.deQueue());

		System.out.println(circularQueue.Front());
		
		System.out.println(circularQueue.enQueue(4));
		
		System.out.println(circularQueue.enQueue(2));
		
		System.out.println(circularQueue.enQueue(2));
		
		System.out.println(circularQueue.enQueue(3));
	}
}

class MyCircularQueue {
	
	
	int len;
	int size;
	int[] nums;
	int front;
	int rear;
	
	
	/** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        len = k;
        nums = new int[len];
        size = 0;
//        front = -1;
//        rear = -1;
        front = 0;
        rear = -1;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
	/*public boolean enQueue(int value) {
	    if(isFull()) {
	    	return false;
	    }
	    rear += 1;
	    if(rear==len) {
	    	rear = 0;
	    }
	    nums[rear] = value;
	    size++;
	    if(front == -1) {
	    	front = 0;
	    }
	    return true;
	}*/
    public boolean enQueue(int value) {
        if(isFull()) {
        	return false;
        }
        rear += 1;
        if(rear==len) {
        	rear = 0;
        }
        nums[rear] = value;
        size++;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
	/*public boolean deQueue() {
	    if(isEmpty()) {
	    	return false;
	    }
	    front += 1;
	    if(front == len) {
	    	front = 0;
	    }
	    size--;
	    if(isEmpty()) {
	    	front = -1;
	    	rear = -1;
	    }
	    return true;
	}*/
    public boolean deQueue() {
        if(isEmpty()) {
        	return false;
        }
        front += 1;
        if(front == len) {
        	front = 0;
        }
        size--;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if(!isEmpty()) {
        	return nums[front];
        }
        return -1;
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if(!isEmpty()) {
        	return nums[rear];
        }
        return -1;
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size==0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size==len;
    }
    
}
/*
设计你的循环队列实现。 循环队列是一种线性数据结构，
其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。
它也被称为“环形缓冲器”。
循环队列的一个好处是我们可以利用这个队列之前用过的空间。
在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。
但是使用循环队列，我们能使用这些空间去存储新的值。

你的实现应该支持如下操作：

MyCircularQueue(k): 构造器，设置队列长度为 k 。
Front: 从队首获取元素。如果队列为空，返回 -1 。
Rear: 获取队尾元素。如果队列为空，返回 -1 。
enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
isEmpty(): 检查循环队列是否为空。
isFull(): 检查循环队列是否已满。
 

示例：

MyCircularQueue circularQueue = new MycircularQueue(3); // 设置长度为 3

circularQueue.enQueue(1);  // 返回 true

circularQueue.enQueue(2);  // 返回 true

circularQueue.enQueue(3);  // 返回 true

circularQueue.enQueue(4);  // 返回 false，队列已满

circularQueue.Rear();  // 返回 3

circularQueue.isFull();  // 返回 true

circularQueue.deQueue();  // 返回 true

circularQueue.enQueue(4);  // 返回 true

circularQueue.Rear();  // 返回 4
 
 

提示：

所有的值都在 0 至 1000 的范围内；
操作数将在 1 至 1000 的范围内；
请不要使用内置的队列库。
*/
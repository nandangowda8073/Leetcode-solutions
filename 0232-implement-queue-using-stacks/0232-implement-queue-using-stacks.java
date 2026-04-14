class MyQueue {
private int[] arr;
private int front;
private int rear;
private int capacity;

public MyQueue() {
    capacity = 100;
    arr = new int[capacity];
    front = 0;
    rear = -1;
}

public void push(int x) {
    if (rear == capacity - 1) {
        System.out.println("Queue Overflow");
        return;
    }
    rear++;
    arr[rear] = x;
}

public int pop() {
    if (empty()) {
        System.out.println("Queue Underflow");
        return -1;
    }
    int val = arr[front];
    front++;
    return val;
}

public int peek() {
    if (empty()) {
        System.out.println("Queue is Empty");
        return -1;
    }
    return arr[front];
}

public boolean empty() {
    return front > rear;
}


}

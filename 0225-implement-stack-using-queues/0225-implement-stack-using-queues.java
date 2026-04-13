class MyStack {

    int[] arr;
    int top;
    int size;

    public MyStack() {
        size = 10;         
        arr = new int[size];
        top = -1;
    }
    
    public void push(int x) {
        if (top == size - 1) {
            System.out.println("StackOverflow");
            return;
        }
        arr[++top] = x;
    }
    
    public int pop() {
        if (top == -1) {
            System.out.println("StackUnderflow");
            return -1;
        }
        return arr[top--];
    }
    
    public int top() {
        if (top == -1) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return arr[top];
    }
    
    public boolean empty() {
        return top == -1;
    }
}
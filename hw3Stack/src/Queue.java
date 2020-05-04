public class Queue {
    private int maxSize;
    private int[] queue;
    private int front;  //начало очереди
    private int rear;   //конец очереди
    private int items;

    public Queue(int s) {
        this.maxSize = s;
        this.queue = new int[this.maxSize];
        this.front = 0;
        this.rear = -1;
        this.items = 0;
    }

    public boolean isEmpty() {
        return (this.items==0);
    }

    public boolean isFull() {
        return (this.items==this.maxSize);
    }

    public int size() {
        return this.items;
    }

    public void insert(int i) {
        if(this.rear == this.maxSize-1)
            this.rear = -1;
        this.queue[++this.rear] = i;
        this.items++;
    }

    public long remove() {
        int temp = this.queue[this.front++];
        if(this.front == this.maxSize)
            this.front = 0;
        this.items--;
        return temp;
    }

    public int peek() {
        return queue[front];
    }


}

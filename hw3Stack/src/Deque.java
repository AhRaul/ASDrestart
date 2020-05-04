public class Deque {
    private int maxSize;
    private int[] deque;
    private int right;
    private int left;
    private int items;

    public Deque(int s) {
        this.maxSize = s;
        this.deque = new int[this.maxSize];
        this.right = 0;
        this.left = -1;
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

    public void insertLeft(int i) {
        if(this.left == this.maxSize-1)
            this.left = -1;
        this.deque[++this.left] = i;
        this.items++;
    }

    public void insertRight(int i) {
        if(this.right == 0)
            this.right = maxSize;
        this.deque[--this.right] = i;
        this.items++;
    }

    public long peekAndRemoveRight() {
        int temp = this.deque[this.right++];
        if(this.right == this.maxSize)
            this.right = 0;
        this.items--;
        return temp;
    }

    public long peekAndRemoveLeft() {
        if(this.left == -1)
            this.left = maxSize-1;
        int temp = this.deque[this.left--];
        this.items--;
        return temp;
    }

    public int peekRight() {
        return deque[right];
    }

    public int peekLeft() {
        return deque[left];
    }
}

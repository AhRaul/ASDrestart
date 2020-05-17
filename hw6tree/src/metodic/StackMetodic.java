package metodic;

public class StackMetodic {
    private int maxSize;
    private NodeMetodic[] stack;
    private int top;

    public StackMetodic(int size) {
        this.maxSize = size;
        this.stack = new NodeMetodic[this.maxSize];
        this.top = -1;
    }

    public void push(NodeMetodic n) {
        this.stack[++this.top] = n;
    }

    public NodeMetodic pop() {
        return this.stack[this.top--];
    }

    public NodeMetodic peek() {
        return this.stack[this.top];
    }

    public boolean isEmpty() {
        return (this.top == -1);
    }

    public boolean isFull() {
        return(this.top == this.maxSize-1);
    }
}

public class Stack {

    private int maxSize;
    private String[] stack;
    private int top;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new String[this.maxSize];
        this.top = -1;
    }

    public boolean isEmpty() {
        return (this.top == -1);
    }

    public boolean isFull() {
        return (this.top == this.maxSize - 1);
    }

    public void push(String i) {
        this.stack[++this.top] = i;
    }

    public String peekAndDelete() {
        return this.stack[this.top--];
    }

    public String peek() {
        return this.stack[this.top];
    }

    public void pushString(String string) {
        char[] strToArray = string.toCharArray();
        for(int i = 0; i<strToArray.length; i++) {
            push(String.valueOf(strToArray[i]));
        }
    }

    public void displayMirrorString() {
        int lengthSring = top;
        for(int i = 0; i <= lengthSring; i++) {
            System.out.print(peekAndDelete());
        }
    }
}

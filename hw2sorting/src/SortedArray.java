public class SortedArray {

    private int size;
    private int[] array;

    public SortedArray(int size) {
        this.size = 0;
        this.array = new int[size];
    }

    public int[] getArray() {
        return this.array;
    }

    public void display() {
        for (int i = 0 ; i < this.size ; i ++) {
            System.out.println(this.array[i]);
        }
    }

    public void delete(int value) {
        int i = 0;
        for (i = 0; i < this.size; i++) {
            if (this.array[i] == value) break;
        }

        for (int j = i; j < this.size - 1; j++) {
            this.array[j] = this.array[j+1];
        }

        this.size--;
    }

    public void insert(int value) {
        this.array[this.size] = value;
        this.size++;
    }
}

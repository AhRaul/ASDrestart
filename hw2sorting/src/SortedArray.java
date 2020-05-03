public class SortedArray {

    private int size;
    private int[] array;

    public SortedArray(int size) {
        this.size = 0;
        this.array = new int[size];
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

    public void sortBubble() {
        int out, in;
        for (out = this.size - 1; out >=1; out--) {
            for(in = 0; in < out; in++) {
                if (this.array[in] > this.array[in + 1]) {
                    change(in, in + 1);
                }
            }
        }
    }

    private void change(int a, int b) {
        int tmp = this.array[a];
        this.array[a] = this.array[b];
        this.array[b] = tmp;
    }

    public void sortSelect() {
        int out, in, mark;
        for(out = 0; out < this.size; out++) {
            mark = out;
            for(in = out+1; in<this.size; in++) {
                if (this.array[in] < this.array[mark]) {
                    mark = in;
                }
            }
            change(out, mark);
        }
    }

    public void sortInsert() {
        int in, out;
        for(out = 1; out < this.size; out++) {
            int temp = this.array[out];
            in = out;
            while (in > 0 && this.array[in - 1] >= temp) {
                this.array[in] = this.array[in - 1];
                --in;
            }
            this.array[in] = temp;
        }
    }

    public SortedArray clone() {
        SortedArray sortedArray = new SortedArray(this.size);
        for(int i = 0; i < this.size; i++) {
            sortedArray.insert(this.array[i]);
        }
        return sortedArray;
    }
}

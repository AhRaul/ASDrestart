public class StartSorting {
    public static void main(String[] args) {
        SortedArray sa = new SortedArray(1000000);
        for(int i = 0; i < 1000000; i++) {
            sa.insert((int)(100 * Math.random()));
        }
        sa.display();
    }
}

public class StartSorting {
    public static final int SIZE_ARRAY = 1000000;

    public static void main(String[] args) {
        SortedArray sa = new SortedArray(SIZE_ARRAY);
        for(int i = 0; i < SIZE_ARRAY; i++) {
            sa.insert((int)(100 * Math.random()));
        }

        SortedArray sarepid1 = sa.clone();

        SortedArray sarepid2 = sa.clone();

        long startTime = System.currentTimeMillis();
        sa.sortBubble();
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("Время пузырьковой сортировки " + timeSpent); //1756661


        startTime = System.currentTimeMillis();
        sarepid1.sortSelect();
        timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("Время сортировки выборкой " + timeSpent);   //383415

        startTime = System.currentTimeMillis();
        sarepid2.sortInsert();
        timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("Время сортировки вставкой " + timeSpent);   //100388
    }
}

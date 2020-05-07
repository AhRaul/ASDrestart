public class TestDeque {
    public static void main(String[] args) {
        Deque testedD = new Deque(5);
        testedD.insertLeft(3);
        testedD.insertLeft(2);
        testedD.insertRight(4);
        testedD.insertLeft(1);
        testedD.insertRight(5);
        while (!testedD.isEmpty()) {
            System.out.println(testedD.peekAndRemoveLeft());
        }

    }

}

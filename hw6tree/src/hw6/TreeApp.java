package hw6;

public class TreeApp {

    public static void main(String[] args) {

            Tree[] numericTree = new Tree[6];

            for(int j=0; j<numericTree.length; j++) {
                System.out.println("\nTree "+ (j+1) + "\n");
                numericTree[j] = new Tree();
                for (int i = 0; i < 15; i++) {
                    numericTree[j].insert((int) (200.0 * Math.random()) - 100);
                }
                numericTree[j].displayTree();
                System.out.println("Проверка сбалансированности: " + numericTree[j].isBalanced());
            }

            //опредедение процента сбалансированных деревьев
        double percent = 0;
        for(int j=0; j<numericTree.length; j++) {
            if(numericTree[j].isBalanced()){
                percent = percent + 100.0/numericTree.length;
            }
        }
        System.out.println("Процент сбалансированных деревьев: " + percent);
    }
}
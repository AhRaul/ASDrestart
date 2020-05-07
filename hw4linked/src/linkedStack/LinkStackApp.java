package linkedStack;

public class LinkStackApp {
    public static void main(String[] args) {
        StackList s1 = new StackList();
        s1.push("Artem", 30);
        s1.push("Viktor", 20);
        s1.push("Sergey", 10);
        s1.display();
        while (!s1.isEmpty()) {
            System.out.println("Элемент " + s1.pop() + " удален из стека");
        }
    }
}

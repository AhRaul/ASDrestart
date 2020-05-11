package linkIterator;

public class LinkIteratorApp {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        LinkIterator itr = new LinkIterator(list);

        itr.insertAfter("Artem", 20);
        itr.insertBefore("Sergey", 10);

        itr.reset();

        itr.insertBefore("MrX", 20);
        System.out.println(itr.atEnd());
        itr.nextLink();
        itr.nextLink();
        System.out.println(itr.atEnd());

        itr.deleteCurrent();
        list.display();

    }
}

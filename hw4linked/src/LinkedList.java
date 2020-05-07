public class LinkedList<T> {
    private Link<T> first;

    public LinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insert(T link) {
        Link<T> li = new Link(link);
        li.setNext(first);
        this.first = li;
    }

    public Link<T> delete() {
        Link<T> temp = first;
        first = first.getNext();
        return temp;
    }

    public void display() {
        Link<T> current = first;
        while (current != null) {
            System.out.println(current.getLink());
            current = current.getNext();
        }
    }

    public T find (T searchNode) {
        Link<T> findNode = new Link<>(searchNode);
        Link<T> current = first;
        while (current != null) {
            if (current.getLink().equals(findNode.getLink())) {
                return findNode.getLink();
            }
            current = current.getNext();
        }
        return null;
    }
}

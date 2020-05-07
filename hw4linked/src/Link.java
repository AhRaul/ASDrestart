public class Link<T> {
    public T link;
    public Link<T> next;

    public Link (T link) {
        this.link = link;
    }

    public Link<T> getNext() {
        return next;
    }

    public void setNext(Link<T> next) {
        this.next = next;
    }

    public T getLink() {
        return link;
    }
}

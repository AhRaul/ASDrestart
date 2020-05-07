package linkedQueue;

import linkedStack.Link;

public class LinkedList {
    public Link first;
    public Link last;

    public LinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insert(String name, int age) {
        Link newLink = new Link(name, age);
        if(this.isEmpty())
            first = newLink;
        else
            last.next = newLink;
        last = newLink;
    }

    public String delete() {
        Link temp = first;
        if(first.next == null)
            last = null;
        first = first.next;
        return temp.name;
    }

    public void display() {
        Link current = first;
        while (current != null) {
            current.display();
            current = current.next;
        }
    }
}

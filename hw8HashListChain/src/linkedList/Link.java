package linkedList;

public class Link {
    public String name;

    public Link next;

    public Link (String name) {
        this.name = name;
    }

    public void display () {
        System.out.println("Name: " + this.name);
    }
}

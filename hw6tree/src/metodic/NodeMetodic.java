package metodic;

public class NodeMetodic {
    public PersonMetodic personMetodic;
    public NodeMetodic leftChild;
    public NodeMetodic rightChild;

    public void display() {
        System.out.println("Name: " + personMetodic.name + ", age: " + personMetodic.age);
    }
}

public class Vertex {
    public String label;
    public int numLine;
    public int level;

    public boolean wasVisited;

    public Vertex(String label) {
        this.label = label;
        this.wasVisited = false;
        this.numLine = 0;
        this.level = 0;
    }
}

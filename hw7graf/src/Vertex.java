public class Vertex {
    public String label;
    public int numLine;          //номер пути
    public int level;            //глубина

    public boolean wasVisited;

    public Vertex(String label) {
        this.label = label;
        this.wasVisited = false;
        this.numLine = -1;
        this.level = 0;
    }
}

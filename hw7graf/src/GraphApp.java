public class GraphApp {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("Москва");   //0 - индекс в массиве, под которым хранится объект в графе
        graph.addVertex("Тула");   //1
        graph.addVertex("Липецк");   //2
        graph.addVertex("Воронеж");   //3
        graph.addVertex("Рязань");   //4
        graph.addVertex("Тамбов");   //5
        graph.addVertex("Саратов");   //6
        graph.addVertex("Калуга");   //7
        graph.addVertex("Орёл");   //8
        graph.addVertex("Курск");   //9

        //Москва - Тула - Липецк - Воронеж
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        //Москва - Рязань - Тамбов - Саратов - Воронеж
        graph.addEdge(0, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);

        //Москва - Калуга - Орёл - Курск - Воронеж
        graph.addEdge(0, 7);
        graph.addEdge(7, 8);
        graph.addEdge(8, 9);
        graph.addEdge(9, 3);

        graph.bfsFindShortest(3);

    }
}

public class Main {
    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();
        graph.insert(0, 1);
        graph.insert(1, 2);
        graph.insert(2, 3);
        graph.insert(2, 6);
        graph.insert(3, 4);
        graph.insert(3, 5);
        graph.insert(6, 7);
        graph.insert(6, 8);
        graph.print();
        System.out.println(graph.bfs());
        System.out.println(graph.dfs());
        System.out.println(graph.size());
        System.out.println(graph.contains(6));
        System.out.println(graph.contains(10));
        graph.delete(10);
        graph.print();
        graph.delete(2);
        graph.print();
        System.out.println(graph.size());
    }
}
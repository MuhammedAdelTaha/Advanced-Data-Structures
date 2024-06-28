import java.util.*;

public class Graph <T extends Comparable<T>>{
    //size, isEmpty, contains, clear,print, insert, delete, bfs, dfs
    //can't insert a node that is already in the graph
    HashMap<T, ArrayList<T>> graph = new HashMap<>();

    public Integer size(){
        return graph.size();
    }
    public boolean isEmpty(){
        return graph.isEmpty();
    }
    public boolean contains(T element){
        return graph.containsKey(element);
    }
    public void clear(){
        graph.clear();
    }
    public void print(){
        System.out.println(graph);
    }
    public boolean insert(T vertex1, T vertex2){
        if(contains(vertex1) && contains(vertex2)) return false;
        if(!graph.containsKey(vertex1)) graph.put(vertex1, new ArrayList<>());
        if(!graph.containsKey(vertex2)) graph.put(vertex2, new ArrayList<>());
        graph.get(vertex1).add(vertex2);
        graph.get(vertex2).add(vertex1);
        return true;
    }
    public boolean delete(T vertex){
        if(!contains(vertex)) return false;
        ArrayList<T> neighbours = graph.get(vertex);
        for (T neighbour : neighbours) {
            graph.get(neighbour).remove(vertex);
        }
        graph.remove(vertex);
        return true;
    }
    public ArrayList<T> bfs(){
        ArrayList<T> bfsList = new ArrayList<>();
        if (isEmpty()) return bfsList;
        Queue<T> queue = new LinkedList<>();
        List<T> keys = graph.keySet().stream().toList();
        T currentRoot = keys.get(new Random().nextInt(keys.size()));
        ArrayList<T> currentChildren = graph.get(currentRoot);
        Map<T, Boolean> visited = new HashMap<>();
        graph.keySet().forEach(key -> visited.put(key, false));
        queue.add(currentRoot);
        for(int i = 0; i < size(); i++){
            visited.put(currentRoot, true);
            for(T child : currentChildren){
                if(visited.get(child)) continue;
                queue.add(child);
                visited.put(child, true);
            }
            bfsList.add(queue.remove());
            currentRoot = queue.peek();
            currentChildren = graph.get(currentRoot);
        }
        return bfsList;
    }
    private void doDFS(Map<T, Boolean> visited, ArrayList<T> dfsList, T currentRoot){
        dfsList.add(currentRoot);
        visited.put(currentRoot, true);
        ArrayList<T> currentChildren = graph.get(currentRoot);
        for (T child : currentChildren){
            if(!visited.get(child)) doDFS(visited, dfsList, child);
        }
    }
    public ArrayList<T> dfs(){
        ArrayList<T> dfsList = new ArrayList<>();
        if (isEmpty()) return dfsList;
        List<T> keys = graph.keySet().stream().toList();
        T randomBegin = keys.get(new Random().nextInt(keys.size()));
        Map<T, Boolean> visited = new HashMap<>();
        graph.keySet().forEach(key -> visited.put(key, false));
        doDFS(visited, dfsList, randomBegin);
        return dfsList;
    }
}

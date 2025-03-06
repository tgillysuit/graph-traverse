import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Traverse {
  public static void main(String[] args) {
    // See below site for visualization of this graph
    // https://auberonedu.github.io/graph-explore/graph_site/viz.html
    Vertex<Integer> v3  = new Vertex<>(3);
    Vertex<Integer> v7  = new Vertex<>(7);
    Vertex<Integer> v12 = new Vertex<>(12);
    Vertex<Integer> v34 = new Vertex<>(34);
    Vertex<Integer> v56 = new Vertex<>(56);
    Vertex<Integer> v78 = new Vertex<>(78);
    Vertex<Integer> v91 = new Vertex<>(91);
    Vertex<Integer> v45 = new Vertex<>(45);
    Vertex<Integer> v23 = new Vertex<>(23);
    Vertex<Integer> v67 = new Vertex<>(67);

    v3.neighbors  = new ArrayList<>(List.of(v7, v34));
    v7.neighbors  = new ArrayList<>(List.of(v12, v45, v34, v56));
    v12.neighbors = new ArrayList<>(List.of(v7, v56, v78));
    v34.neighbors = new ArrayList<>(List.of(v34, v91)); 
    v56.neighbors = new ArrayList<>(List.of(v78));
    v78.neighbors = new ArrayList<>(List.of(v91));
    v91.neighbors = new ArrayList<>(List.of(v56));
    v45.neighbors = new ArrayList<>(List.of(v23));
    v23.neighbors = new ArrayList<>(List.of());
    v67.neighbors = new ArrayList<>(List.of(v91));

    Set<Vertex<Integer>> visited = new HashSet<>();
    dfs(v7, visited);
  }

  // Depth First Search method - Like Pre-order, In-order, and Post-order traversals in Binary Trees
  // Vertex<T> vertex = is the main the node (vertice)
  // Set<Vertex<T>> visited = takes the next node and stores it, since Set can help remove duplicates
  public static <T> void dfs(Vertex<T> vertex, Set<Vertex<T>> visited) {
    if (vertex == null) return; // checking to see there are any null nodes (vertices)
    if (visited.contains(vertex)) return; // checking to see if vertex and the visited contains the same value (data) then returns back.

    visited.add(vertex); // adding the current vertex to the visited Set
    System.out.println(vertex.data); // then print the value (data) of that current vertice
    
    if (vertex.neighbors == null) return; // if the vertices neighbor is null, return back

    // for-each neighbor in neighbors recurse dfs()
    for (Vertex<T> neighbor : vertex.neighbors) {
      dfs(neighbor, visited); // placing the current node/vertex as "neighbor", 
                              // then we recurse back to the top of the method to add the next duplicated value into the Set "visited"
    }

  }

}

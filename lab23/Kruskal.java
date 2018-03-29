
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeSet;

/** A class that runs Kruskal's algorithm on a Graph. Given a graph G, Kruskal's
 *  algorithm constructs a new graph T such that T is a spanning tree of G and
 *  the sum of its edge weights is less than the sum of the edge weights for
 *  every possible spanning tree T* of G. This is called the Minimum Spanning
 *  Tree (MST).
 *
 *  @author
 */
public class Kruskal {


    /** Returns the MST of INPUT using a naive isConnected implementation. */
    public static Graph minSpanTree(Graph input) {
        // TODO implement!
        Graph T = new Graph();
       // input.Neighbors;
        for (int v: input.getAllVertices()) {
            T.addVertex(v);
        }
        PriorityQueue<Edge> fringe = new PriorityQueue<>((a1, a2)-> a1.getLabel()-a2.getLabel()); // get weight
        for (Edge e : input.getAllEdges()) {
            fringe.add(e);
        }
        while (!fringe.isEmpty()) {
            Edge e = fringe.poll();
            if (!isConnected(T, e.getSource(), e.getDest())) {
                T.addEdge(e);
            }
        } return T;
    }

    /** Returns the MST of INPUT using the Union Find data structure. */
    public static Graph minSpanTreeFast(Graph input) {
        // TODO implement!
        Graph T = new Graph();
        for (int v: input.getAllVertices()) {
            T.addVertex(v);
        }
        UnionFind uf = new UnionFind(input.getAllVertices().size());
        PriorityQueue<Edge> fringe = new PriorityQueue<>((a1, a2)-> a1.getLabel()-a2.getLabel());
        for (Edge e : input.getAllEdges()) {
            fringe.add(e);
        }
        while (!fringe.isEmpty()) {
            Edge e = fringe.poll();
            if (!uf.isConnected(e.getDest(), e.getSource())) { // using unionfind, we can check if they have same root;
                T.addEdge(e); // add this edge to the graph and put the vertices into the same union
                uf.union(e.getDest(),e.getSource()); // we need to connect them into the same set.
            }
        } return T;
    }

    /** A naive implementation of BFS or DFS to check if two nodes are
     *  connected. */
    public static boolean isConnected(Graph g, int v1, int v2) {
        // TODO implement!
        Stack<Integer> stack = new Stack<>();
        TreeSet<Integer> visited = new TreeSet<>();
        visited.add(v1);

        if (g.getNeighbors(v1).contains(v2)) {
                return true;
        }
        for ( int neighbor: g.getNeighbors(v1)) {
            stack.add(neighbor);
        }
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while (visited.contains(temp)) {
                if (stack.isEmpty()) {
                    return false;
                }
                temp = stack.pop();
            }
            visited.add(temp);
            if (g.getNeighbors(temp).contains(v2)) {
                return true;
            }
            for ( int neighbor: g.getNeighbors(temp)) {
                stack.add(neighbor);
            }
        }
        return false;
    }
}

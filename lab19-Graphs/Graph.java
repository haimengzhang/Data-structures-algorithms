import sun.awt.image.ImageWatched;

import java.util.*;

public class Graph implements Iterable<Integer>{

    private LinkedList<Edge>[] adjLists;
    private int vertexCount;
    private int startVertex;

    // Initialize a graph with the given number of vertices and no edges.
    public Graph(int numVertices) {
        adjLists = new LinkedList[numVertices];
        startVertex = 0;
        for (int k = 0; k < numVertices; k++) {
            adjLists[k] = new LinkedList<Edge>();
        }
        vertexCount = numVertices;
    }

    // Change the vertex the iterator will start DFS from
    // Change the vertex the iterator will start DFS from
    public void setStartVertex(int v){
        if (v < vertexCount && v >= 0){
            startVertex = v;
        } else {
            throw new IllegalArgumentException("Cannot set iteration start vertex to " + v + ".");
        }
    }


    // Add to the graph a directed edge from vertex v1 to vertex v2.
    public void addEdge(int v1, int v2) {
        addEdge(v1, v2, null);
    }

    // Add to the graph an undirected edge from vertex v1 to vertex v2.
    public void addUndirectedEdge(int v1, int v2) {
        addUndirectedEdge(v1, v2, null);
    }

    // Add to the graph a directed edge from vertex v1 to vertex v2,
    // with the given edge information. If the edge already exists,
    // replaces the current edge with a new edge with edgeInfo.
    public void addEdge(int v1, int v2, Object edgeInfo) {

        Edge e = new Edge(v1, v2, edgeInfo);
        if(!adjLists[v1].contains(e))
            adjLists[v1].addLast(e);
    }

    // Add to the graph an undirected edge from vertex v1 to vertex v2,
    // with the given edge information. If the edge already exists,
    // replaces the current edge with a new edge with edgeInfo.
    public void addUndirectedEdge(int v1, int v2, Object edgeInfo) {
//        addEdge(v1, v2, edgeInfo);
//        addEdge(v2, v1, edgeInfo);
//        //your code here
        Edge edge1 = new Edge(v1, v2, edgeInfo);
        Edge edge2 = new Edge(v2, v1, edgeInfo);

        if(!adjLists[v1].contains(edge1)){
            adjLists[v1].addLast(edge1);
        }
        if(!adjLists[v2].contains(edge2)){
            adjLists[v2].addLast(edge2);
        }
    }

    // Return true if there is an edge from vertex "from" to vertex "to";
    // return false otherwise.
    public boolean isAdjacent(int from, int to) {
        for (Edge e: adjLists[from]) {
            if (e.to() == to) {
                return true;
            }
        }
        return false;
    }

    // Returns a list of all the neighboring  vertices 'u'
    // such that the edge (VERTEX, 'u') exists in this graph.
    public List<Integer> neighbors(int vertex) {
        LinkedList<Integer> lst = new LinkedList<>();
        for (Edge e: adjLists[vertex]) {
            lst.add(e.to());
        }
        return lst;
    }

    // Return the number of incoming vertices for the given vertex,
    // i.e. the number of vertices v such that (v, vertex) is an edge.
    public int inDegree(int vertex) {

        int counter = 0;
        if (adjLists != null) {
            for (LinkedList<Edge> e : adjLists) {
                if (e != null) {
                    for (Edge eE : e) {
                        if (eE.to() == vertex) {
                            counter++;
                        }
                    }
                }
            }
        }
        return counter;
    }

    public Iterator<Integer> iterator() {
        return new TopologicalIterator();
    }

    // A class that iterates through the vertices of this graph, starting with a given vertex.
    // Does not necessarily iterate through all vertices in the graph: if the iteration starts
    // at a vertex v, and there is no path from v to a vertex w, then the iteration will not
    // include w
    private class DFSIterator implements Iterator<Integer> {

        private Stack<Integer> fringe;
        private HashSet<Integer> visited;

        public DFSIterator(Integer start) {
            fringe = new Stack<Integer>();
            fringe.push(start);
            visited = new HashSet<>();
            visited.add(start);
        }

        public boolean hasNext() {
            return !fringe.isEmpty();
        }

        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("tree ran out of elements");
            }
            int v = fringe.pop();
            LinkedList<Integer> neighbs = (LinkedList) neighbors(v);
            for (int neigh : neighbs) {
                if (!visited.contains(neigh)) {
                    visited.add(neigh);
                    fringe.push(neigh);
                }
            }
            return v;
        }
        //ignore this method
        public void remove() {
            throw new UnsupportedOperationException(
                    "vertex removal not implemented");
        }

    }

    // Return the collected result of iterating through this graph's
    // vertices as an ArrayList, starting from STARTVERTEX.
    public ArrayList<Integer> visitAll(int startVertex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Iterator<Integer> iter = new DFSIterator(startVertex);

        while (iter.hasNext()) {
            result.add(iter.next());
        }
        return result;
    }

    // Returns true iff there exists a path from STARVETEX to
    // STOPVERTEX. Assumes both STARTVERTEX and STOPVERTEX are
    // in this graph. If STARVERTEX == STOPVERTEX, returns true.
    public boolean pathExists(int startVertex, int stopVertex) {
        if (startVertex == stopVertex) {
            return true;
        }
        Iterator it = new DFSIterator(startVertex);
        while (it.hasNext()) {
            if (it.next().equals(stopVertex))
                return true;
        }
        return false;
        //return visitAll(startVertex).contains(stopVertex);
    }

    // Returns the path from startVertex to stopVertex.
    // If no path exists, returns an empty arrayList.
    // If startVertex == stopVertex, returns a one element arrayList.

//    Pattern your method on visitAll, with the following differences.
// First, add code to stop calling next when you encounter the finish vertex.
// Then, trace back from the finish vertex to the start, by first finding a visited
// vertex u for which (u, finish) is an edge,
// then a vertex v visited earlier than u for which (v, u) is an edge, and so on,
// finally finding a vertex w for which (start, w) is an edge. Collecting all these vertices
// in the correct sequence produces the desired path. We recommend that
// you try this by hand with a graph or two to see that it works.


    public ArrayList<Integer> path(int startVertex, int stopVertex) {

        if (startVertex == stopVertex) {
            return new ArrayList<>(startVertex);
        } else if (pathExists(startVertex, stopVertex)) {
            ArrayList<Integer> it = visitAll(startVertex);
            Collections.reverse(it);
            boolean test = false;
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < it.size(); i++) {
                if (it.get(i) == stopVertex)
                    test = true;
                if (test)
                    temp.add(it.get(i));
            }

            ArrayList<Integer> ret = new ArrayList<>();
            ret.add(stopVertex);
            for (int i = 0; i < temp.size() - 1; i++) {
                if (isAdjacent(temp.get(i + 1), ret.get(ret.size() - 1))) {
                    ret.add(temp.get(i + 1));
                }
            }
            Collections.reverse(ret);
            return ret;
        } else {
            return new ArrayList<>();
        }
    }


        /*************************************************************** PART2 TOPOLOGICAL SORT **********************************************************/
// The algorithm for taking a graph and finding a topological sort uses an array
// named currentInDegree with one element per vertex. currentInDegree[v]
// is initialized with the in-degree of each vertex v.
// The algorithm also uses a fringe. The fringe is initialized with all
// vertices whose in-degree is 0. When a vertex is popped off the fringe and added
// to a results list, the currentInDegree value of its neighbors are reduced by 1.
// Then the fringe is updated again with vertices shows in-degree is now 0.


        public ArrayList<Integer> topologicalSort () {

            ArrayList<Integer> result = new ArrayList<Integer>();
            Iterator<Integer> iter = new TopologicalIterator();
            while (iter.hasNext()) {
                result.add(iter.next());
            }
            return result;
        }

        private class TopologicalIterator implements Iterator<Integer> {

            private Stack<Integer> fringe;
            // more instance variables go here
            int[] currentInDegree;
            LinkedList<Integer> result = new LinkedList<Integer>();
            private HashSet<Integer> visited;


            /*********************************Topological Iterator constructor ************************************/
            // The fringe is initialized with all vertices whose in-degree is 0. means the vertex has no one coming towards it.
            //Your task is to fill in the blanks in the TopologicalIterator class
            // so that it successively returns vertices in topological order as described above.
            // The TopologicalIterator class will resemble the DFSIterator class,
            // except that it will use a currentInDegree array as described above,
            // and instead of pushing unvisited vertices on the stack, it will push only vertices whose in-degree is 0.
            // Try to walk through this algorithm, where you succesively process vertices with in-degrees of 0, on our DAG example above.
            public TopologicalIterator() {
                fringe = new Stack<>();
                currentInDegree = new int[vertexCount];
                visited = new HashSet<>();

                if (adjLists != null) {
                    for (LinkedList<Edge> linked : adjLists) {
                        if (linked != null) {
                            for (Edge edge : linked) {
                                currentInDegree[edge.to()]++;
                            }
                        }
                    }
                }

                for (int i = 0; i < vertexCount; i++) {
                    if (currentInDegree[i] == 0) {
                        fringe.add(i);
                    }
                }
            }

            public boolean hasNext() {
                return !fringe.isEmpty();
            }

            //Your task is to fill in the blanks in the TopologicalIterator class
            // so that it successively returns vertices in topological order as described above.
            // The TopologicalIterator class will resemble the DFSIterator class,
            // except that it will use a currentInDegree array as described above,
            // and instead of pushing unvisited vertices on the stack, it will push only vertices whose in-degree is 0.
            // Try to walk through this algorithm, where you succesively process vertices with in-degrees of 0, on our DAG example above.
            public Integer next() {
                if (fringe.empty())
                    throw new NoSuchElementException("it is empty.");

                int visit = fringe.pop();
                for (int neighbor : neighbors(visit)) {
                    currentInDegree[neighbor]--;
                    visited.add(visit);
                    if (currentInDegree[neighbor] == 0) {
                        if (!visited.contains(neighbor)) {
                            fringe.add(neighbor);
                        }
                    }
                }
                return visit;
                // you supply the real body of this method
            }

            public void remove() {
                throw new UnsupportedOperationException(
                        "vertex removal not implemented");
            }

        }


    private class Edge {

            private Integer from;
            private Integer to;
            private Object edgeInfo;

            public Edge(int from, int to, Object info) {
                this.from = new Integer(from);
                this.to = new Integer(to);
                this.edgeInfo = info;
            }

            public Integer to() {
                return to;
            }

            public Object info() {
                return edgeInfo;
            }

            public String toString() {
                return "(" + from + "," + to + ",dist=" + edgeInfo + ")";
            }
        }


    public static void main(String[] args) {
        ArrayList<Integer> result;

        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(0, 4);
        g1.addEdge(1, 2);
        g1.addEdge(2, 0);
        g1.addEdge(2, 3);
        g1.addEdge(4, 3);
        System.out.println("Traversal starting at 0");
        result = g1.visitAll(0);
        Iterator<Integer> iter;
        iter = result.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Traversal starting at 2");
        result = g1.visitAll(2);
        iter = result.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Traversal starting at 3");
        result = g1.visitAll(3);
        iter = result.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Traversal starting at 4");
        result = g1.visitAll(4);
        iter = result.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Path from 0 to 3");
        result = g1.path(0, 3);
        iter = result.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Path from 0 to 4");
        result = g1.path(0, 4);
        iter = result.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Path from 1 to 3");
        result = g1.path(1, 3);
        iter = result.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Path from 1 to 4");
        result = g1.path(1, 4);
        iter = result.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Path from 4 to 0");
        result = g1.path(4, 0);
        if (result.size() != 0) {
            System.out.println("*** should be no path!");
        }

        Graph g2 = new Graph(5);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(0, 4);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.addEdge(4, 3);
        System.out.println();
        System.out.println();
        System.out.println("Topological sort");
        result = g2.topologicalSort();
        iter = result.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
    }

}
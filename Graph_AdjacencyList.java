import java.util.*;

class Main {
    static Graphnode graph;

    public static class Graphnode {
        private int v;
        private int e;
        private LinkedList<Integer>[] adjlist;

        public Graphnode(int data) {
            this.v = data;
            this.e = 0;
            this.adjlist = new LinkedList[data];
            for (int i = 0; i < data; i++) {
                this.adjlist[i] = new LinkedList<>();
            }
        }
    }

    static void addEdge(int v, int e) {
        graph.adjlist[v].add(e);
        graph.adjlist[e].add(v);
        graph.e++;
    }

    public static void main(String[] args) {
        int numVertices = 5;
        graph = new Graphnode(numVertices);
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 3);
        addEdge(2, 4);

        for (int i = 0; i < graph.v; i++) {
            System.out.print(i + "-->");
            for (int n : graph.adjlist[i]) {
                System.out.print(n + "  ");
            }
            System.out.println();
        }
    }
}

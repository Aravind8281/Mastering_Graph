import java.util.LinkedList;

class Main {
    static Graphnode graph;

    static class Graphnode {
        private int v;
        private int e;
        private LinkedList<Pair>[] adjlist;

        public Graphnode(int data) {
            this.v = data;
            this.e = 0;
            this.adjlist = new LinkedList[data];
            for (int i = 0; i < data; i++) {
                this.adjlist[i] = new LinkedList<>();
            }
        }
    }

    static void addEdge(int v, int e, int wt) {
        graph.adjlist[v].add(new Pair(e, wt));
        graph.adjlist[e].add(new Pair(v, wt));
        graph.e++;
    }

    public static void main(String[] args) {
        graph = new Graphnode(5);
        addEdge(0, 1, 2);
        addEdge(0, 2, 3);
        addEdge(1, 3, 4);
        addEdge(2, 4, 2);

        for (int i = 0; i < graph.v; i++) {
            System.out.print(i + " --> ");
            for (Pair pair : graph.adjlist[i]) {
                System.out.print("(" + pair.v + ", " + pair.wt + ") ");
            }
            System.out.println();
        }
    }

    static class Pair {
        int v;
        int wt;

        Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }
}

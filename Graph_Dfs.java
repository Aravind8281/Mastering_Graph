import java.util.*;

class Main {
    static Graphnode graph;

    static class Graphnode {
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

    static void dfs(int node, ArrayList<Integer> ls, boolean[] vis) {
        vis[node] = true;
        ls.add(node);
        for (int i : graph.adjlist[node]) {
            if (!vis[i]) {
                dfs(i, ls, vis);
            }
        }
    }

    static ArrayList<Integer> DfsList() {
        ArrayList<Integer> ls = new ArrayList<>();
        boolean[] vis = new boolean[graph.v];
        dfs(0, ls, vis);
        return ls;
    }

    public static void main(String[] args) {
        graph = new Graphnode(5);
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 3);
        addEdge(2, 4);

        ArrayList<Integer> dfsList = DfsList();
        System.out.println("DFS traversal: " + dfsList);
    }
}

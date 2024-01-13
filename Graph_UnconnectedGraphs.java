import java.util.*;

class Main {
    static GraphNode graph;

    static class GraphNode {
        private int v;
        private int e;
        private LinkedList<Integer>[] adjList;

        public GraphNode(int data) {
            this.v = data;
            this.e = 0;
            this.adjList = new LinkedList[data];
            for (int i = 0; i < data; i++) {
                this.adjList[i] = new LinkedList<>();
            }
        }
    }

    static void addEdge(int v, int e) {
        graph.adjList[v].add(e);
        graph.adjList[e].add(v);
        graph.e++;
    }

    static void dfs(int node, ArrayList<Integer> ls, boolean[] vis) {
        vis[node] = true;
        ls.add(node);
        for (int i : graph.adjList[node]) {
            if (!vis[i]) {
                dfs(i, ls, vis);
            }
        }
    }

    static int N_Provinces() {
        ArrayList<Integer> ls = new ArrayList<>();
        int count = 0;
        boolean[] vis = new boolean[graph.v];
        for (int i = 0; i < graph.v; i++) {
            if (!vis[i]) {
                count++;
                dfs(i, ls, vis);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        graph = new GraphNode(5);
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 3);
        addEdge(2, 4);
        System.out.print(N_Provinces());
    }
}

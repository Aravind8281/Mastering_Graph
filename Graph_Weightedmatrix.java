import java.util.*;

class Main {
    static Graphnode graph;
    public static class Graphnode{
        private int v;
        private int e;
        private int[][] adjMatrix;
        public Graphnode(int data){
            this.v=data;
            this.e=0;
            this.adjMatrix=new int[data][data];
        }
        
    }

    static void addEdge(int v,int e,int wt){
        graph.adjMatrix[v][e]=wt;
        graph.adjMatrix[e][v]=wt;
        graph.e++;
    }
    static void print(int ver) {
        for (int i = 0; i < ver; i++) {
            System.out.print(i + " : ");
            for (int j = 0; j < ver; j++) {
                System.out.print(graph.adjMatrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numVertices = 5;
        graph = new Graphnode(numVertices);
        addEdge(0, 1,2);
        addEdge(0, 2,3);
        addEdge(1, 3,4);
        addEdge(2, 4,2);
        print(numVertices);
    }
}

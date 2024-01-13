import java.util.*;
class Main{
    static Graphnode graph;
    static class Graphnode{
        private int v;
        private int e;
        private LinkedList<Integer>[] adjlist;
        public Graphnode(int data){
            this.v=data;
            this.e=0;
            this.adjlist=new LinkedList[data];
            for(int i=0;i<data;i++){
                this.adjlist[i]=new LinkedList<>();
            }
        }
    }
    static void addEdge(int v,int e){
        graph.adjlist[v].add(e);
        graph.adjlist[e].add(v);
        graph.e++;
    }
    static ArrayList<Integer> BFS(){
        ArrayList<Integer> bfs=new ArrayList<>(); // this array maintaned to return 
        boolean[] vis=new boolean[graph.v]; //mark visited node true 
        Queue<Integer> q=new LinkedList<>(); // helps to achieve bfs
        q.add(0);//add first element so that it manipulate
        vis[0]=true;
        while(!q.isEmpty()){//perform operation till q is empty
            int node=q.poll();//return element in queue 
            bfs.add(node);//add returned element
            for(int i:graph.adjlist[node]){
                if(vis[i]==false){
                    vis[i]=true;
                    q.add(i);//add visited element in queue for further manipulation
                }
            }
        }
        return bfs;
    }
    public static void main (String[] args) {
        graph=new Graphnode(5);
        addEdge(0,1);
        addEdge(0,2);
        addEdge(1,3);
        addEdge(2,4);
        System.out.print(BFS());
        /*for(int i=0;i<graph.v;i++){
            System.out.print(i+" -->");
            for(int n:graph.adjlist[i]){
                System.out.print(n+"  ");
            }
            System.out.println();
        }*/
    }
}

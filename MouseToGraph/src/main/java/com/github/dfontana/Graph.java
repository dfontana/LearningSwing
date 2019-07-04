package com.github.dfontana;

public class Graph {
    private double DISTANCE_THRESHOLD;    //Max distance to add an edge
    private int V = 0;                          //Tracks last vertex added
    private int E = 0;                          //Number of Edges
    private double[] lengths;                   //Stores distance between vertices
    Bag<Integer>[] adj;                         //Array of Vertex adjacency
    private Vertex[] vertices;                  //Stores the vertices in an array

    class Vertex {
        int x;
        int y;

        Vertex(int xCoor, int yCoor){
            x = xCoor;
            y = yCoor;
        }
    }

    public Graph(){
        DISTANCE_THRESHOLD = 50.0;
        lengths = new double[1];
        vertices = new Vertex[1];

        adj = new Bag[1];
        adj[0] = new Bag<Integer>();
    }

    public void addVertex(int x, int y) {

        if(V >= vertices.length){
            Vertex[] newVertices = new Vertex[vertices.length * 2];
            for(int i = 0; i < vertices.length; i++){
                newVertices[i] = vertices[i];
            }
            vertices = newVertices;

            Bag<Integer>[] newAdj = new Bag[adj.length * 2];
            int i = 0;
            while(i < adj.length){
                newAdj[i] = adj[i];
                i++;
            }
            while(i < newAdj.length){
                newAdj[i] = new Bag<>();
                i++;
            }
            adj = newAdj;
        }

        vertices[V] = new Vertex(x, y);
        V++;
    }

    public void addEdge(int start, int end) {
        E++;
        adj[start].add(end);
        adj[end].add(start);

        if(E >= lengths.length){
            double[] newLengths = new double[lengths.length * 2];
            for(int i = 0; i < lengths.length; i++){
                newLengths[i] = lengths[i];
            }
            lengths = newLengths;
        }
        lengths[E] = computeDistance(start, end);
    }

    public void edgeCheck(){
        if(V == 1){ return;}

        for(int w = 0; w < V-1; w++){
            if(computeDistance(w, V-1) <= DISTANCE_THRESHOLD){
                this.addEdge(w, V-1);
            }
        }
    }

    public void recomputeEdges(){
        for(int v = 0; v < V; v++){
            adj[v] = new Bag<Integer>();
        }

        for(int v = 0; v < V-1; v++){
            for (int w = v+1; w < V; w++) {
                if (computeDistance(w, v) <= DISTANCE_THRESHOLD) {
                    this.addEdge(w, v);
                }
            }
        }
    }

    private double computeDistance(int v, int w){
        return Math.sqrt((vertices[v].x - vertices[w].x) * (vertices[v].x - vertices[w].x) +
                        (vertices[v].y - vertices[w].y) * (vertices[v].y - vertices[w].y));
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public void printAdj(){
        System.out.println("========= NEW PRINTOUT =========");
        for(int v = 0; v < V; v++){
            System.out.print(v+" is Adjacent to: ");
            for (int w : this.adj(v)) {
                System.out.print(w+", ");
            }
            System.out.println();
        }
    }

    public Vertex getVertex(int index){
        try{
            return vertices[index];
        }catch(Exception e){ System.out.println("Invalid Vertex: "+ e);}
        return null; //Error
    }

    public int V() { return V; }
    public int E() { return E; }
    public void setThreshold(double x){ DISTANCE_THRESHOLD = x;}
}

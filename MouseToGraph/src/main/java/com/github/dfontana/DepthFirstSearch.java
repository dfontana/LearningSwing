package com.github.dfontana;

public class DepthFirstSearch {
    Graph searchGraph;

    public DepthFirstSearch(Graph graph){
        searchGraph = graph;
    }

    public int [] findPath(int start_node, int goal_node) { // return an array of node indices
        int[] path = new int[searchGraph.E()];
        path[0] = start_node;
        return findPathHelper(path, 1, goal_node);
    }

    public int [] findPathHelper(int [] path, int num_path, int goal_node) {
        if (goal_node == path[num_path - 1]) {
            int [] ret = new int[num_path];
            for (int i=0; i<num_path; i++) ret[i] = path[i];
            return ret;  // we are done!
        }
        int [] new_nodes = connected_nodes(path, num_path);
        if (new_nodes != null) {
            for (int j=0; j<new_nodes.length; j++) {
                path[num_path] = new_nodes[j];
                int [] test = findPathHelper(path, num_path + 1, goal_node);
                if (test != null) {
                    if (test[test.length - 1] == goal_node) {
                        return test;
                    }
                }
            }
        }
        return null;
    }

    protected int [] connected_nodes(int [] path, int num_path) {
        // find all nodes connected to the last node on 'path'
        // that are not already on 'path'
        int [] ret = new int[searchGraph.V()];
        int num = 0;
        int last_node = path[num_path - 1];
        for (int n=0; n<searchGraph.V(); n++) {
            // see if node 'n' is already on 'path':
            boolean keep = true;
            for (int i=0; i<num_path; i++) {
                if (n == path[i]) {
                    keep = false;
                    break;
                }
            }
            boolean connected = false;
            if (keep) {
                // now see if there is a link between node 'last_node' and 'n':


                for (int w : searchGraph.adj(last_node)) {
                        if (w == n) {
                            connected = true;
                            break;
                        }
                    }

                if (connected) {
                    ret[num++] = n;
                }
            }
        }
        if (num == 0)  return null;
        int [] ret2 = new int[num];
        for (int i=0; i<num; i++) {
            ret2[i] = ret[i];
        }
        return ret2;
    }
}


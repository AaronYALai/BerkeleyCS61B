/*
* @Author: aaronlai
* @Date:   2017-07-30 14:27:54
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-07-30 15:39:38
*/

public class PrimMST {

    private int[] edgeTo;
    private double[] distTo;
    private NodePriorityQueue pq;
    private boolean[] marked;

    public PrimMST(GraphW graph) {
        int nodeNum = graph.nodeCount();
        edgeTo = new int[nodeNum];
        distTo = new double[nodeNum];
        marked = new boolean[nodeNum];
        pq = new NodePriorityQueue(nodeNum);

        int source = 0;
        double inf = Double.POSITIVE_INFINITY;
        for (int i = 0; i < nodeNum; i += 1){
            distTo[i] = inf;
        }
        distTo[source] = 0;
        pq.insert(source, distTo[source]);

        while (!pq.isEmpty()){
            int node = pq.delMin();
            scan(graph, node);
        }
    }

    private void scan(GraphW graph, int node){
        marked[node] = true;
        for (String[] tailnWeight : graph.adj(node)){
            int other = Integer.parseInt(tailnWeight[0]);

            /* already seen */
            if (marked[other]){
                continue;
            }

            double weight = Double.parseDouble(tailnWeight[1]);
            if (weight < distTo[other]){
                distTo[other] = weight;
                edgeTo[other] = node;
                if (pq.contains(other)){
                    pq.decreasePriority(other, distTo[other]);
                } else {
                    pq.insert(other, distTo[other]);
                }
            }
        }
    }

    public void print(){
        for (int i = 0; i < edgeTo.length; i += 1){
            System.out.println("Edge: (" + i + ", " + edgeTo[i] + ") ; distance: " + distTo[i]);
        }
    }
}
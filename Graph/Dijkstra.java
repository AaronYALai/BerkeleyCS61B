/*
* @Author: aaronlai
* @Date:   2017-07-30 00:18:37
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-07-30 14:24:17
*/

public class Dijkstra {

    private int source;
    private NodePriorityQueue pq;
    private double[] distTo;
    private int[] edgeTo;

    public Dijkstra(GraphW graph, int s){
        int nodeNum = graph.nodeCount();
        source = s;
        distTo = new double[nodeNum];
        edgeTo = new int[nodeNum];
        pq = new NodePriorityQueue(nodeNum);

        double inf = Double.POSITIVE_INFINITY;
        for (int i = 0; i < nodeNum; i += 1){
            distTo[i] = inf;
            pq.insert(i, distTo[i]);
        }
        distTo[s] = 0;
        pq.decreasePriority(s, 0);

        while (!pq.isEmpty()){
            int node = pq.delMin();
            for (String[] tailnWeight : graph.adj(node)){
                relax(node, tailnWeight);
            }
        }
    }

    private void relax(int head, String[] tailnWeight){
        int tail = Integer.parseInt(tailnWeight[0]);
        double weight = Double.parseDouble(tailnWeight[1]);

        if (distTo[tail] > distTo[head] + weight){
            distTo[tail] = distTo[head] + weight;
            edgeTo[tail] = head;

            /* If tail still active in PQ, decrease priority */
            if (pq.contains(tail)){
                pq.decreasePriority(tail, distTo[tail]);
            }
        }

    }

    public void pathTo(int target){
        findPath(target);
    }

    private void findPath(int target){
        if (target != source){
            findPath(edgeTo[target]);
            System.out.println("=> " + target + ", dist: " + distTo[target]);
        } else {
            System.out.println(target);
        }
    }
}
/*
* @Author: aaronlai
* @Date:   2017-07-30 12:36:48
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-07-30 21:43:36
*/

public class GraphW {

    /* Linked List of Edges */
    private class Edge{
        public int head;
        public int tail;
        public double weight;
        public Edge next;

        public Edge(int node1, int node2, double w){
            head = node1;
            tail = node2;
            weight = w;
            next = null;
        }
    }

    public int size;
    private Edge rootEdge;
    private boolean directedG;

    public GraphW(boolean directed){
        directedG = directed;
        rootEdge = null;
    }

    public void add(int head, int tail, double w){
        if (rootEdge == null){
            rootEdge = new Edge(head, tail, w);
            if (!directedG){
                rootEdge.next = new Edge(tail, head, w);
            }
        } else {
            Edge edge = rootEdge;

            while (edge.next != null){
                edge = edge.next;
            }
            edge.next = new Edge(head, tail, w);
            if (!directedG){
                edge.next.next = new Edge(tail, head, w);
            }
        }
        size += 1;
    }

    public int nodeCount(){
        int maxNode = 0;
        Edge edge = rootEdge;

        while (edge != null){
            if (edge.head > maxNode){
                maxNode = edge.head;
            }
            if (edge.tail > maxNode){
                maxNode = edge.tail;
            }
            edge = edge.next;
        }
        return (maxNode + 1);
    }

    public String[][] adj(int node){
        String[][] adjList = new String[size * 2][2];
        int wizard = 0;

        Edge edge = rootEdge;
        while (edge != null){
            if (edge.head == node){
                adjList[wizard][0] = Integer.toString(edge.tail);
                adjList[wizard][1] = Double.toString(edge.weight);
                wizard += 1;
            }
            edge = edge.next;
        }

        String[][] adjNodes = new String[wizard][2];
        System.arraycopy(adjList, 0, adjNodes, 0, wizard);

        return adjNodes;
    }

    public String[][] edges(){
        String[][] edges = new String[size * 2][3];
        int wizard = 0;
        Edge edge = rootEdge;

        while (edge != null){
            edges[wizard][0] = Integer.toString(edge.head);
            edges[wizard][1] = Integer.toString(edge.tail);
            edges[wizard][2] = Double.toString(edge.weight);

            edge = edge.next;
            wizard += 1;
        }

        return edges;
    }

    public void print(){
        Edge edge = rootEdge;

        while (edge != null){
            String nodePair = "(" + Integer.toString(edge.head) + ", " + Integer.toString(edge.tail) + ", " + Double.toString(edge.weight) + ")";
            System.out.println(nodePair);
            edge = edge.next;
        }
    }
}
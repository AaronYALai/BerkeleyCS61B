/*
* @Author: aaronlai
* @Date:   2017-07-29 16:02:15
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-07-29 18:10:14
*/

public class Graph {

    /* Linked List of Edges */
    private class Edge{
        public int head;
        public int tail;
        public Edge next;

        public Edge(int node1, int node2){
            head = node1;
            tail = node2;
            next = null;
        }
    }

    public int size;
    private Edge rootEdge;

    public Graph(){
        rootEdge = null;
    }

    public void add(int head, int tail){
        if (rootEdge == null){
            rootEdge = new Edge(head, tail);
        } else {
            Edge edge = rootEdge;

            while (edge.next != null){
                edge = edge.next;
            }
            edge.next = new Edge(head, tail);
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

    public int[] adj(int node){
        int[] adjList = new int[size];
        int wizard = 0;

        Edge edge = rootEdge;
        while (edge != null){
            if (edge.head == node){
                adjList[wizard] = edge.tail;
                wizard += 1;
            }
            edge = edge.next;
        }

        int[] adjNodes = new int[wizard];
        System.arraycopy(adjList, 0, adjNodes, 0, wizard);

        /* insertion sort */
        for (int i = 0; i < adjNodes.length; i += 1){
            int ind = i;
            while (ind > 0){
                if (adjNodes[ind] < adjNodes[ind - 1]){
                    int n = adjNodes[ind];
                    adjNodes[ind] = adjNodes[ind - 1];
                    adjNodes[ind - 1] = n;
                    ind -= 1;
                } else {
                    break;
                }
            }
        }
        return adjNodes;
    }

    public void print(){
        Edge edge = rootEdge;

        while (edge != null){
            String nodePair = "(" + Integer.toString(edge.head) + ", " + Integer.toString(edge.tail) + ")";
            System.out.println(nodePair);
            edge = edge.next;
        }
    }
}
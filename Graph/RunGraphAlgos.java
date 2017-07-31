/*
* @Author: aaronlai
* @Date:   2017-07-29 16:02:57
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-07-30 21:42:58
*/

public class RunGraphAlgos {

    public static String newline = System.getProperty("line.separator");

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.add(0, 1);
        graph.add(1, 3);
        graph.add(3, 5);
        graph.add(0, 2);
        graph.add(0, 4);
        graph.add(4, 5);
        graph.add(4, 2);
        graph.add(2, 5);
        graph.add(2, 3);
        graph.add(0, 3);
        graph.add(1, 4);

        System.out.println("Now graph G:");
        graph.print();

        System.out.println(newline + "Graph size:" + graph.size);

        System.out.println(newline + "Adjacent nodes of 0:");
        for (int node : graph.adj(0)){
            System.out.println(node);
        }

        DepthFirstSearch dfs = new DepthFirstSearch(graph, 0);
        System.out.println(newline + "Depth first search: from 0 to 5:");
        dfs.pathTo(5);

        TopoSort topoSort = new TopoSort(graph);
        System.out.println(newline + "Topological sorting:");
        String nodes = "start";
        for (int node : topoSort.sorting()){
            nodes += " => ";
            nodes += Integer.toString(node);
        }
        System.out.println(nodes);

        IterativeDFS iterDFS = new IterativeDFS(graph, 0);
        System.out.println(newline + "Iterative Depth first search: from 0 to 5:");
        iterDFS.pathTo(5);

        /* Edge Weighted Graph */
        GraphW graphW = new GraphW(false);
        graphW.add(0, 1, 10.0);
        graphW.add(1, 3, 1.5);
        graphW.add(3, 5, 5.0);
        graphW.add(0, 2, 3.0);
        graphW.add(0, 4, 2.0);
        graphW.add(4, 5, 12.0);
        graphW.add(4, 2, 0.5);
        graphW.add(2, 5, 7.0);
        graphW.add(2, 3, 8.5);
        graphW.add(0, 3, 6.0);
        graphW.add(1, 4, 0.5);

        System.out.println(newline + newline + "Now weighted, undirected graph G:");
        graphW.print();

        System.out.println(newline + "Graph size:" + graphW.size);

        System.out.println(newline + "Adjacent nodes and their weights of 0:");
        for (String[] tailnWeight : graphW.adj(0)){
            System.out.println(tailnWeight[0] + ", " + tailnWeight[1]);
        }

        Dijkstra dijk = new Dijkstra(graphW, 0);
        System.out.println(newline + "Dijkstra with source node 0:");
        dijk.pathTo(5);

        PrimMST prim = new PrimMST(graphW);
        System.out.println(newline + "Prim's Minimum Spanning Tree:");
        prim.print();

        KruskalMST kruskal = new KruskalMST(graphW);
        System.out.println(newline + "Kruskal's Minimum Spanning Tree:");
        kruskal.print();
    }
}
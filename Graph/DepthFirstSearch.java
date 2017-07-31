/*
* @Author: aaronlai
* @Date:   2017-07-29 16:02:31
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-07-29 18:19:53
*/

public class DepthFirstSearch {

    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    public DepthFirstSearch(Graph graph, int s){
        int nodeNum = graph.nodeCount();
        marked = new boolean[nodeNum];
        edgeTo = new int[nodeNum];
        source = s;

        dfs(graph, source);
    }

    private void dfs(Graph graph, int node){
        marked[node] = true;

        for (int w : graph.adj(node)){
            if (!marked[w]){
                edgeTo[w] = node;
                dfs(graph, w);
            }
        }
    }

    public void pathTo(int target){
        findPath(target);
    }

    private void findPath(int target){
        if (target != source){
            findPath(edgeTo[target]);
            System.out.println("=> " + target);
        } else {
            System.out.println(target);
        }
    }

}
/*
* @Author: aaronlai
* @Date:   2017-07-29 18:20:22
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-07-29 18:45:15
*/

public class TopoSort {

    private class Stack{

        private int wizard;
        private int[] storage;

        public Stack(int length){
            storage = new int[length];
            wizard = 0;
        }

        public void push(int item){
            storage[wizard] = item;
            wizard += 1;
        }

        public int[] getItemList(){
            int[] itemList = new int[wizard];
            for (int i = 0; i < wizard; i += 1){
                itemList[i] = storage[wizard - i - 1];
            }
            return itemList;
        }
    }

    private boolean[] marked;
    private int[] edgeTo;
    private Stack stack;

    public TopoSort(Graph graph){
        int nodeNum = graph.nodeCount();
        marked = new boolean[nodeNum];
        edgeTo = new int[nodeNum];
        stack = new Stack(nodeNum);

        /* perform DFS on each unmarked node */
        for (int node = 0; node < nodeNum; node += 1){
            if (!marked[node]){
                dfs(graph, node);
            }
        }
    }

    private void dfs(Graph graph, int node){
        marked[node] = true;

        for (int w : graph.adj(node)){
            if (!marked[w]){
                edgeTo[w] = node;
                dfs(graph, w);
            }
        }
        stack.push(node);
    }

    public int[] sorting(){
        return stack.getItemList();
    }
}
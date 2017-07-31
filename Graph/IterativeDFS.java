/*
* @Author: aaronlai
* @Date:   2017-07-29 18:46:46
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-07-29 21:09:29
*/

public class IterativeDFS {

    /* Stack implemented by array */
    private class Stack{

        private int[] storage;
        private int size;

        public Stack(int length){
            storage = new int[length];
            size = 0;
        }

        public void push(int item){
            storage[size] = item;
            size += 1;
        }

        public int pop(){
            size -= 1;
            return storage[size];
        }
    }

    private boolean[] marked;
    private int[] edgeTo;
    private int source;
    private Stack stack;

    public IterativeDFS(Graph graph, int s){
        int nodeNum = graph.nodeCount();
        source = s;
        marked = new boolean[nodeNum];
        edgeTo = new int[nodeNum];
        stack = new Stack(nodeNum);

        stack.push(source);
        while (stack.size != 0){
            int node = stack.pop();
            marked[node] = true;
            for (int other : graph.adj(node)){
                if (!marked[other]){
                    edgeTo[other] = node;
                    stack.push(other);
                }
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
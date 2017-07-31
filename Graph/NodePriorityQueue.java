/*
* @Author: aaronlai
* @Date:   2017-07-30 12:53:15
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-07-30 15:37:54
*/

public class NodePriorityQueue {

    /* where the node is stored */
    private int[] nodesToPriority;
    /* which node owns priority */
    private int[] priorityToNodes;
    private double[] priority;
    private int size;

    /* sort the nodes from largest to smallest priorities */
    public NodePriorityQueue(int length){
        nodesToPriority = new int[length];
        for (int i = 0; i < length; i += 1){
            nodesToPriority[i] = -1;
        }
        priorityToNodes = new int[length];
        priority = new double[length];
        size = 0;
    }

    public void insert(int node, double score){
        nodesToPriority[node] = size;
        priorityToNodes[size] = node;
        priority[size] = score;
        size += 1;

        /* insertion sort */
        int wizard = size - 1;
        while (wizard > 0 && priority[wizard] > priority[wizard - 1]){
            double p = priority[wizard];
            priority[wizard] = priority[wizard - 1];
            priority[wizard - 1] = p;

            int n = priorityToNodes[wizard];
            priorityToNodes[wizard] = priorityToNodes[wizard - 1];
            priorityToNodes[wizard - 1] = n;

            nodesToPriority[priorityToNodes[wizard]] = wizard;
            nodesToPriority[priorityToNodes[wizard - 1]] = wizard - 1;

            wizard -= 1;
        }
    }

    public void print(){
        for (int i = 0; i < nodesToPriority.length; i += 1){
            System.out.println("(" + nodesToPriority[i] + ", " + priorityToNodes[i] + ", " + priority[i] + ")");
        }
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public int delMin(){
        size -= 1;
        nodesToPriority[priorityToNodes[size]] = -1;
        return priorityToNodes[size];
    }

    public boolean contains(int node){
        return (nodesToPriority[node] != -1);
    }

    public void decreasePriority(int node, double newScore){
        int wizard = nodesToPriority[node];
        priority[wizard] = newScore;

        /* reverse insertion sort */
        while (wizard + 1 < size && priority[wizard] < priority[wizard + 1]){
            double p = priority[wizard];
            priority[wizard] = priority[wizard + 1];
            priority[wizard + 1] = p;

            int n = priorityToNodes[wizard];
            priorityToNodes[wizard] = priorityToNodes[wizard + 1];
            priorityToNodes[wizard + 1] = n;

            nodesToPriority[priorityToNodes[wizard]] = wizard;
            nodesToPriority[priorityToNodes[wizard + 1]] = wizard + 1;

            wizard += 1;
        }
    }

}
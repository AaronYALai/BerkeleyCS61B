/*
* @Author: aaronlai
* @Date:   2017-07-30 15:40:57
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-07-30 21:50:47
*/

public class KruskalMST {

    private class QuickUnion {

        private int[] parent;

        public QuickUnion(int length) {
            parent = new int[length];
            for (int i = 0; i < length; i += 1){
                parent[i] = i;
            }
        }

        private int findRoot(int p){
            while (parent[p] != p){
                p = parent[p];
            }
            return p;
        }

        public boolean isConnect(int p, int q){
            return (findRoot(p) == findRoot(q));
        }

        public void connect(int p, int q){
            int rootp = findRoot(p);
            int rootq = findRoot(q);
            parent[rootp] = rootq;
        }
    }

    private QuickUnion qun;
    private String[][] edges;
    private int[] edgeIndexes;

    public KruskalMST(GraphW graph) {
        int nodeNum = graph.nodeCount();
        qun = new QuickUnion(nodeNum);
        edgeIndexes = new int[nodeNum - 1];
        edges = graph.edges();

        /* Sort edges by weights */
        for (int i = 0; i < edges.length; i += 1){
            int wizard = i;
            while (wizard > 0 && Double.parseDouble(edges[wizard][2]) < Double.parseDouble(edges[wizard - 1][2])){
                String[] sl = edges[wizard];
                edges[wizard] = edges[wizard - 1];
                edges[wizard - 1] = sl;
                wizard -= 1;
            }
        }

        /* relaxation */
        int wizard = 0;
        for (int i = 0; i < edges.length; i += 1){
            int head = Integer.parseInt(edges[i][0]);
            int tail = Integer.parseInt(edges[i][1]);
            if (!qun.isConnect(head, tail)){
                qun.connect(head, tail);
                edgeIndexes[wizard] = i;
                wizard += 1;

                if (wizard >= nodeNum){
                    break;
                }
            }
        }
    }

    public void print(){
        for (int i : edgeIndexes){
            System.out.println("Edge: (" + edges[i][0] + ", " + edges[i][1] + ", " + edges[i][2] + ")");
        }
    }
}
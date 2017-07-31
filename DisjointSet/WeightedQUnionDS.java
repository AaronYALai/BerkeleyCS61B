/*
* @Author: aaronlai
* @Date:   2017-07-04 16:21:22
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-07-04 17:03:06
*/

public class WeightedQUnionDS implements DisjointSets{
    private int[] parent;
    private int[] depth;

    /* O(N) */
    public WeightedQUnionDS(int N){
        parent = new int[N];
        depth = new int[N];
        for (int i = 0; i < N; i++){
            parent[i] = i;
            depth[i] = 1;
        }
    }

    /* private callback function: fine the ROOT ! */
    private int findRoot(int p){
        // while (p != parent[p]){
        //     p = parent[p];
        // }

        /* Add Path Compression:
        tie all nodes passed through to the ROOT
        => iterated log scale lg* N
        Implementation: Using Recursion !!! recursive up and down !!! */
        int nodeParent = parent[p];
        if (p == parent[p]){
            return p;
        } else {
            parent[p] = findRoot(parent[p]);
            return parent[p];
        }
    }

    /* need to iterate through the array ! => O(N) */
    public void connect(int p, int q){
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);
        if (depth[pRoot] == depth[qRoot]){
            depth[pRoot] += 1;
            parent[qRoot] = pRoot;
        } else if (depth[pRoot] < depth[qRoot]){
            parent[pRoot] = qRoot;
        } else {
            parent[qRoot] = pRoot;
        }
        return;
    }

    /* very fast */
    public boolean isConnected(int p, int q){
        return (findRoot(p) == findRoot(q));
    }

    public static void main(String[] args) {
        QuickUnion qf = new QuickUnion(10);
        qf.connect(1, 2);
        qf.connect(1, 3);
        qf.connect(2, 4);
        qf.connect(0, 3);
        System.out.println(qf.isConnected(0, 4));
        System.out.println(qf.isConnected(3, 6));
    }
}

/*
* @Author: aaronlai
* @Date:   2017-07-04 15:50:50
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-07-04 16:22:01
*/

public class QuickUnion implements DisjointSets{
    private int[] parent;

    /* O(N) */
    public QuickUnion(int N){
        parent = new int[N];
        for (int i = 0; i < N; i++){
            parent[i] = i;
        }
    }

    /* private callback function: fine the ROOT ! */
    private int findRoot(int p){
        while (p != parent[p]){
            p = parent[p];
        }
        return p;
    }

    /* need to iterate through the array ! => O(N) */
    public void connect(int p, int q){
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);
        parent[qRoot] = pRoot;
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


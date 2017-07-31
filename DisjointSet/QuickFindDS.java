/*
* @Author: aaronlai
* @Date:   2017-07-04 15:41:49
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-07-04 15:50:25
*/

public class QuickFindDS implements DisjointSets {

    private int[] id;

    /* O(N) */
    public QuickFindDS(int N){
        id = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
        }
    }

    /* need to iterate through the array ! => O(N) */
    public void connect(int p, int q){
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++){
            if (id[i] == pid){
                id[i] = qid;
            }
        }
        return;
    }

    /* very fast */
    public boolean isConnected(int p, int q){
        return (id[p] == id[q]);
    }

    public static void main(String[] args) {
        QuickFindDS qf = new QuickFindDS(10);
        qf.connect(1, 2);
        qf.connect(1, 3);
        qf.connect(2, 4);
        qf.connect(0, 3);
        System.out.println(qf.isConnected(0, 4));
        System.out.println(qf.isConnected(3, 6));
    }
}
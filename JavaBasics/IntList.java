/*
* @Author: aaronlai
* @Date:   2017-06-08 17:28:32
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-06-22 14:05:37
*/

// public class IntList {
//     public int first;
//     public IntList rest;

//     public static void main(String[] args) {
//         IntList L = new IntList();
//         L.first = 5;
//         L.rest = null;

//         L.rest = new IntList();
//         L.rest.first = 10;

//         L.rest.rest = new IntList();
//         L.rest.rest.first = 15;
//     }
// }

/* dynamic list ver. 2 */

public class IntList {
    public int first;
    public IntList rest;

    /* class */
    public IntList(int f, IntList r){
        first = f;
        rest = r;
    }

    /* return the size of the list by recursion */
    public int size(){
        if (rest == null){
            return 1;
        }
        return 1 + this.rest.size();
    }

    /* return the size of the list by iteration */
    public int iterativeSize(){
        IntList p = this;  /* copy by values */
        int totalSize = 0;
        while (p != null){
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    /* get i-th element - iterative */
    public int get(int i){
        int k = i;
        IntList p = this;
        while (k != 0){
            p = p.rest;
            k -= 1;
        }
        return p.first;
    }

    /* get i-th element - iterative */
    public int get_recur(int i){
        if (i == 0){
            return this.first;
        }
        return this.rest.get(i - 1);
    }

    /* Usage */
    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);

        System.out.println(L.size());
        System.out.println(L.iterativeSize());
        System.out.println(L.get(1));
        System.out.println(L.get_recur(1));
        /* arbitrary length */
    }
}

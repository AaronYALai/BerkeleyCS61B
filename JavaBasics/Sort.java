/*
* @Author: aaronlai
* @Date:   2017-06-26 14:39:13
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-06-26 16:01:33
*/

public class Sort {

    /* return the index of the smallest string. */
    private static int indexSmallest(String[] inputs, int k){
        int minDex = k;
        /* for loop */
        for (int i = k; i < inputs.length; i += 1){
            /* String comparison => cannot use "<" */
            int cmp = inputs[i].compareTo(inputs[minDex]);

            if (cmp < 0){
                minDex = i;
            }
        }
        return minDex;
    }

    private static void swap(String[] inputs, int a, int b){
        String tmp = inputs[a];
        inputs[a] = inputs[b];
        inputs[b] = tmp;
    }

    /* private recursive helper method */
    private static String[] sort(String[] inputs, int k){
        if (k == inputs.length){
            return inputs;
        }

        // find smallest item
        int minDex = indexSmallest(inputs, k);

        // move smallest to front
        swap(inputs, k, minDex);

        // sort rest of the stuff
        sort(inputs, k + 1);

        return inputs;
    }

    /* Return inputs in sorted order, selection sort */
    public static String[] sort(String[] inputs){
        /* no array slicing in Java */
        return sort(inputs, 0);
    }

    public static void print(String[] a){

    }

    public static void main(String[] args) {
        /* list => {...} */
        String[] inputs = {"milvia", "zero", "josh", "trump", "aaron"};
        sort(inputs);
        System.out.println(inputs[0]);
        System.out.println(indexSmallest(inputs, 3));
    }
}
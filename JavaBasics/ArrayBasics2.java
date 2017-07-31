/*
* @Author: aaronlai
* @Date:   2017-06-25 00:09:21
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-06-25 00:17:50
*/

public class ArrayBasics2 {
    public static void main(String[] args) {
        int[][] pascalsTri;
        /* create 4 boxes, each is null (empty array)*/
        pascalsTri = new int[4][];
        int[] rowZero = pascalsTri[0];

        pascalsTri[0] = new int[]{1};
        pascalsTri[1] = new int[]{1, 1};
        pascalsTri[2] = new int[]{1, 2, 1};
        pascalsTri[3] = new int[]{1, 3, 3, 1};
        /** rowTwo points to the pascalsTri !
        Can modify the original data **/
        int[] rowTwo = pascalsTri[2];
        rowTwo[1] = -5;

        int[][] matrix;
        matrix = new int[4][];
        /* create 5 total arrays */
        matrix = new int[4][4];

        /* literal notation to initialize */
        int[][] pascalsAgain = new int[][]{{1}, {1, 1}, {1, 2, 1}};
    }
}
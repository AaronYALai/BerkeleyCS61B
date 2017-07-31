/*
* @Author: aaronlai
* @Date:   2017-06-24 23:49:40
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-06-25 00:02:03
*/

public class ArrayBasics {
    public static void main(String[] args) {
        /* memory: 64 bits * 3 */
        int[] z = null;
        int[] x, y;

        x = new int[]{1, 2, 3 ,4 ,5};
        y = x;
        x = new int[]{-1, 3, 4, 6, 7};
        y = new int[3];
        z = new int[0];  /* empty array */
        int xL = x.length;

        String[] s = new String[6];
        s[4] = "kkk";
        s[x[3] - x[1]] = "muff";

        int[] b = {9, 10, 11};

        /** copy 2 values of array1 start from
        pos 0 to array2 start from pos 3 **/
        System.arraycopy(b, 0, x, 3, 2);
        System.out.println(x);
        System.out.println(s);
    }
}
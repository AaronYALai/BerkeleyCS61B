/*
* @Author: aaronlai
* @Date:   2017-06-29 00:33:54
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-06-29 00:36:47
*/

/* Higher Order Function: take function as inputs */
public class HoFDemo {
    public static int do_twice(IntFunction f, int x) {
        return f.apply(f.apply(x));
    }

    public static void main(String[] args){
        /* instantiate */
        IntFunction tenX = new TenX();
        System.out.println(do_twice(tenX, 2));
    }
}
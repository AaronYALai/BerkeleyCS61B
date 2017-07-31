/*
* @Author: aaronlai
* @Date:   2017-05-27 22:34:17
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-05-27 22:39:58
*/

public class Argsdemo {
    public static void main(String[] args) {
        int N = args.length;
        int i = 0;
        int sum = 0;
        while (i < N){
            sum = sum + Integer.parseInt(args[i]);
            i = i + 1;
        }
        System.out.println(sum);
    }
}
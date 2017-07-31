/*
* @Author: aaronlai
* @Date:   2017-06-26 12:43:45
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-06-26 13:22:43
*/

public class SpeedTestList {
    public static void main(String[] args) {
        GenericAList<String> L = new GenericAList<String>();
        int i = 0;
        String s = "s";
        int j = 0;

        while (i < 100000){
            L.addLast(s);
            i = i + 1;
        }

        while (j < 100){
            L.removeLast();
            j = j + 1;
        }     
    }
}
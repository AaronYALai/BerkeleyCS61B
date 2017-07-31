/*
* @Author: aaronlai
* @Date:   2017-07-02 21:06:23
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-07-02 21:50:57
*/


public class IterationDemo{
    public static void main(String[] args) {
        ArrayMap<String, Integer> am = new ArrayMap<String, Integer>();

        am.put("hello", 5);
        am.put("hola", 6);
        am.put("konigiwa", 7);

        /* Instantiated a not-static nested class: use instance name before "new"
        denoting that this class is associated with class ArrayMap*/
        ArrayMap.KeyIterator ami = am.new KeyIterator();

        while (ami.hasNext()){
            System.out.println(ami.next());
        }

        /* better version: directly iterate through */
        /* need "iterator()" method to use "for-each" */
        for (String s : am){
            System.out.println(s);
        }

    }
}
/*
* @Author: aaronlai
* @Date:   2017-07-23 00:06:18
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-07-23 01:04:54
*/

public class RunULLMap {
    public static void main(String[] args) {
        ULLMap<Integer, String> ullMapObj = new ULLMap<Integer, String>();
        ullMapObj.put(5, "hello");
        ullMapObj.put(6, "yo");
        ullMapObj.put(7, "ao");
        ullMapObj.put(2, "poo");
        ullMapObj.put(5, "foo");
        ullMapObj.put(8, "quova");
        ullMapObj.put(1, "joo");

        System.out.println(ullMapObj.size());
        System.out.println(ullMapObj.containsKey(9));
        System.out.println(ullMapObj.containsKey(5));
        System.out.println(ullMapObj.get(5));

        ullMapObj.clear(5);
        ullMapObj.clear(1);
        System.out.println(ullMapObj.size());
        System.out.println(ullMapObj.containsKey(5));
        System.out.println(ullMapObj.get(7));

        ULLMap.ULLMapIter ullMapIter = ullMapObj.new ULLMapIter();
        while (ullMapIter.hasNext()){
            System.out.println(ullMapIter.next());
        }

        for (Integer i : ullMapObj){
            System.out.println(i);
        }
    }
}
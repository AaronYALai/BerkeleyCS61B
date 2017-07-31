/*
* @Author: aaronlai
* @Date:   2017-06-26 18:25:31
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-06-26 20:12:00
*/

public class WordUtils {
    /* method overloading: 
    public static String longest(GenericAList<String> list){
        int maxDex = 0;
        for (int i = 0; i < list.size(); i += 1){
            String longestString = list.get(maxDex);
            String nowString = list.get(i);

            if (nowString.length() > longestString.length()){
                maxDex = i;
            }
        }
        return list.get(maxDex);
    }


    public static String longest(DynSLList<String> list){
        int maxDex = 0;
        for (int i = 0; i < list.size(); i += 1){
            String longestString = list.get(maxDex);
            String nowString = list.get(i);

            if (nowString.length() > longestString.length()){
                maxDex = i;
            }
        }
        return list.get(maxDex);
    }
    */

    /* Using Inheritance */
    public static String longest(ListBase<String> list){
        int maxDex = 0;
        for (int i = 0; i < list.size(); i += 1){
            String longestString = list.get(maxDex);
            String nowString = list.get(i);

            if (nowString.length() > longestString.length()){
                maxDex = i;
            }
        }
        return list.get(maxDex);
    }

    public static void main(String[] args) {
        // GenericAList<String> someList = new GenericAList<String>();
        ListBase<String> someList = new GenericAList<String>();
        someList.addLast("afk");
        someList.addLast("pot");
        someList.addLast("watching");
        someList.print();
        System.out.println(longest(someList));

        // DynSLList<String> someList2 = new DynSLList<String>();
        ListBase<String> someList2 = new DynSLList<String>();
        someList2.addLast("afk");
        someList2.addLast("pot");
        someList2.addLast("watching");
        someList2.print();
        System.out.println(longest(someList2));
    }

}
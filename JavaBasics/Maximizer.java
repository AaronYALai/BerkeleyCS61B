/*
* @Author: aaronlai
* @Date:   2017-06-29 10:02:49
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-06-29 12:40:54
*/

import java.util.Comparator;


public class Maximizer {
    /* OurComparable Version */
    // public static OurComparable max(OurComparable[] items){
    //     int maxDex = 0;
    //     for (int i = 0; i < items.length; i += 1){
    //         int cmp = items[i].compareTo(items[maxDex]);
    //         if (cmp > 0){
    //             maxDex = i;
    //         }
    //     }
    //     return items[maxDex];
    // }

    /* Using built-in Comparable */
    public static Comparable max(Comparable[] items){
        int maxDex = 0;
        for (int i = 0; i < items.length; i += 1){
            int cmp = items[i].compareTo(items[maxDex]);
            if (cmp > 0){
                maxDex = i;
            }
        }
        return items[maxDex];
    }

    public static void main(String[] args){
        Cat c1 = new Cat("A", 4);
        Cat c2 = new Cat("B", 1);
        Cat c3 = new Cat("C", 9);
        Cat[] cats = new Cat[]{c1, c2, c3};
        /* still have a casting here ! */
        Cat maxCat = (Cat) max(cats);
        maxCat.meow();

        /* old way */
        // Cat.NameComparator nc = new Cat.NameComparator();
        /* class NameComparator is private, cannot be used ! */
        Comparator<Cat> nc = Cat.getNameComparator();
        if (nc.compare(c1, c2) > 0){ //c1 comes later than c2
            c1.meow();
        } else {
            c2.meow();
        }
    }
}
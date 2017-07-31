/*
* @Author: aaronlai
* @Date:   2017-06-29 10:04:59
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-06-29 12:38:43
*/

import java.util.Comparator;

// public class Cat implements OurComparable {
/* Use built-in Comparable in Java */
public class Cat implements Comparable<Cat> {

    private String name;
    public int size;

    public Cat(String n, int w) {
        name = n;
        size = w;
    }

    public void meow(){
        System.out.println(name + " says: meow");
    }

    /* Returns negative if this cat is less than o */

    // public int compareTo(Object o){
        /* Object class has no "size", need to "Cast" first
         => may cause runtime error, try to avoid casting */
        // Cat othercat = (Cat) o;

    public int compareTo(Cat othercat){
        /* no need to cast anymore */

        /* 1st version */
        // if (this.size < othercat.size){
        //     return -1;
        // } else if (this.size == othercat.size){
        //     return 0;
        // }
        // return 1;

        /* improved */
        return this.size - othercat.size;
    }

    /* Dont need to instantiate Cat to use it => be static */
    private static class NameComparator implements Comparator<Cat>{
        public int compare(Cat c1, Cat c2){
            return c1.name.compareTo(c2.name);
        }
    }

    public static Comparator<Cat> getNameComparator(){
        return new NameComparator();
    }
}

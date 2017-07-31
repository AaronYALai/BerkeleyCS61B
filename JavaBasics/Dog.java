/*
* @Author: aaronlai
* @Date:   2017-05-27 15:06:46
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-05-27 16:17:33
*/

public class Dog {
    public int kg;
    public static String name = "hi";

    public Dog(int w) {
        kg = w;
    }

    public void makeNoise() {
        if (kg < 10){
            System.out.println("Bark!");
        } else if (kg < 30) {
            System.out.println("Nwwww!");
        } else {
            System.out.println("Woooof!");
        }
    }

    public static Dog maxDog(Dog d1, Dog d2){
        if (d1.kg > d2.kg){
            return d1;
        }
        return d2;
    }

    public Dog maxDog(Dog d2) {
        if (this.kg > d2.kg){
            return this;
        }
        return d2;
    }
}

/* non static class => create instances */
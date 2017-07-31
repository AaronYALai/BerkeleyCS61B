/*
* @Author: aaronlai
* @Date:   2017-05-27 15:08:20
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-05-27 16:17:20
*/

public class Launchgod {
    public static void main(String[] args) {
        Dog[] dogs = new Dog[2]; /* static size array */
        dogs[0] = new Dog(13);
        dogs[1] = new Dog(35);
        dogs[0].makeNoise();
        dogs[1].makeNoise();

        Dog bigger = Dog.maxDog(dogs[0], dogs[1]);
        bigger.makeNoise();

        Dog b2 = dogs[1].maxDog(dogs[0]);
        b2.makeNoise();
        System.out.println(dogs[0].name);
    }
}
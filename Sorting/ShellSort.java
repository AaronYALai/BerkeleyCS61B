/*
* @Author: aaronlai
* @Date:   2017-07-26 16:47:32
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-07-26 17:37:36
*/

import java.lang.Math;

public class ShellSort<Item extends Comparable<Item>> {

    private int numOfSwap;
    private Item[] content;

    public ShellSort(Item[] inputs){
        content = (Item[]) new Comparable[inputs.length];
        System.arraycopy(inputs, 0, content, 0, inputs.length);
        numOfSwap = 0;
    }

    public Item[] doSort(){
        Double logN = new Double(Math.log(content.length));
        int k = logN.intValue();

        for (int pow = k; pow >= 0; pow -= 1){
            int stepsize = int2Pow(pow);

            for (int i = 0; i < content.length; i += 1){
                insertion(i, stepsize);
            }
        }

        return content;
    }

    private int int2Pow(int n){
        int result = 1;
        while (n > 0){
            result *= 2;
            n -= 1;
        }
        return result;
    }

    private void insertion(int index, int stepsize){
        if (index >= stepsize){
            int cmp = content[index].compareTo(content[index - stepsize]);
            if (cmp < 0){
                swap(index, index - stepsize);
                insertion(index - stepsize, stepsize);
            }
        }
    }

    private void swap(int index1, int index2){
        Item obj = content[index1];
        content[index1] = content[index2];
        content[index2] = obj;
        numOfSwap += 1;
    }

    public void print(){
        for (Item item : content){
            System.out.println(item);
        }
        System.out.println("number of swap:" + Integer.toString(numOfSwap));
    }

}
/*
* @Author: aaronlai
* @Date:   2017-07-26 13:13:51
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-07-26 17:38:59
*/

public class InsertionSort<Item extends Comparable<Item>> {

    private int numOfSwap;
    private Item[] content;

    public InsertionSort(Item[] inputs){
        content = (Item[]) new Comparable[inputs.length];
        System.arraycopy(inputs, 0, content, 0, inputs.length);
        numOfSwap = 0;
    }

    public Item[] doSort(){
        for (int i = 0; i < content.length; i += 1){
            insertion(i);
        }

        return content;
    }

    private void insertion(int index){
        if (index < 1){
            return;
        }

        int cmp = content[index].compareTo(content[index - 1]);
        if (cmp < 0){
            swap(index, index - 1);
            insertion(index - 1);
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
        System.out.println("Number of Swap:" + Integer.toString(numOfSwap));
    }
}
/*
* @Author: aaronlai
* @Date:   2017-07-26 17:39:23
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-07-26 21:13:32
*/

/* Based on "Partitioning": all lefts are smaller, rights are larger */
public class QuickSort<Item extends Comparable<Item>> {

    private int numOfSwap;
    private Item[] content;

    public QuickSort(Item[] inputs){
        content = (Item[]) new Comparable[inputs.length];
        System.arraycopy(inputs, 0, content, 0, inputs.length);
        numOfSwap = 0;
    }

    public Item[] doSort(){
        partitionSort(0, content.length);
        return content;
    }

    private void partitionSort(int start, int end){
        if (end - start < 2){
            return;
        }

        int pivot = randomPick(start, end);
        swap(pivot, start);

        int smallLover = start + 1;
        int largeLover = end - 1;

        while (smallLover != largeLover){
            /* check and move smallLover */
            while (content[smallLover].compareTo(content[start]) <= 0
                && smallLover < largeLover){
                smallLover += 1;
            }

            /* check and move largeLover */
            while (content[largeLover].compareTo(content[start]) > 0
                && smallLover < largeLover){
                largeLover -= 1;
            }

            swap(smallLover, largeLover);

            if (smallLover < largeLover){
                smallLover += 1;
            }
            
            if (smallLover < largeLover){
                largeLover -= 1;
            }
        }

        /* Swap the pivot back to the right pos */
        if (content[start].compareTo(content[smallLover]) >= 0){
            pivot = smallLover;
        } else {
            pivot = smallLover - 1;
        }
        swap(start, pivot);

        partitionSort(start, pivot);
        partitionSort(pivot + 1, end);
    }

    private int randomPick(int start, int end){
        return start;
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
/*
* @Author: aaronlai
* @Date:   2017-07-25 15:18:08
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-07-26 15:39:47
*/

public class MergeSort<Item extends Comparable<Item>> {

    private Item[] content;

    public MergeSort(Item[] inputs){
        content = (Item[]) new Comparable[inputs.length];
        System.arraycopy(inputs, 0, content, 0, inputs.length);
    }

    public Item[] doSort(){
        mergeSort(0, content.length);
        /* Generic Comparable Array: using Comparable[] to initialize */
        Item[] sorted = (Item[]) new Comparable[content.length];
        System.arraycopy(content, 0, sorted, 0, content.length);
        return sorted;
    }

    public void print(){
        for (Item item : content){
            System.out.println(item);
        }
    }

    private void mergeSort(int start, int end){
        if (end - start < 2){
            return;
        }
        int breakpoint = (end + start) / 2;
        mergeSort(start, breakpoint);
        mergeSort(breakpoint, end);
        merge(start, breakpoint, end);
    }

    private void merge(int start, int breakpoint, int end){
        int wizard1 = start;
        int wizard2 = breakpoint;
        Item[] merged = (Item[]) new Comparable[end - start];

        for (int i = 0; i < (end - start); i += 1){
            if (wizard1 >= breakpoint){
                merged[i] = content[wizard2];
                wizard2 += 1;  
            } else if (wizard2 >= end){
                merged[i] = content[wizard1];
                wizard1 += 1;
            } else if (content[wizard1].compareTo(content[wizard2]) < 0){
                merged[i] = content[wizard1];
                wizard1 += 1;
            } else {
                merged[i] = content[wizard2];
                wizard2 += 1;  
            }
        }

        System.arraycopy(merged, 0, content, start, end - start);
    }
}
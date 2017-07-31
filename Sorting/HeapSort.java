/*
* @Author: aaronlai
* @Date:   2017-07-26 13:24:47
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-07-26 15:48:34
*/

/*
Use a single array to represent a heap 
left_child(k) = 2*k; right_child(k) = 2*k + 1
*/
public class HeapSort<Item extends Comparable<Item>> {

    public Item[] content;
    private int size;

    public HeapSort(Item[] inputs){
        size = inputs.length;
        content = (Item[]) new Comparable[size + 1];
        System.arraycopy(inputs, 0, content, 1, size);
        heapify();
    }

    public Item[] doSort(){
        Item[] sorted = (Item[]) new Comparable[content.length - 1];

        for (int i = 0; i < sorted.length; i += 1){
            sorted[i] = removeSmallest();
        }

        System.arraycopy(sorted, 0, content, 1, sorted.length);
        return sorted;
    }

    /* make content array a heap */
    private void heapify(){
        for (int j = content.length - 1; j > 0; j -= 1){
            sink(j);
        }
    }

    private Item removeSmallest(){
        Item returnItem = content[1];
        content[1] = content[size];
        content[size] = null;
        size -= 1;
        /* size decreases before sinking !! */
        sink(1);
        return returnItem;
    }

    private void sink(int index){
        if (2 * index > size){
            /* no child */
            return;
        } else if (2 * index == size){
            /* one child */
            int cmp = content[index].compareTo(content[2 * index]);

            if (cmp > 0){
                swap(index, 2 * index);
            }
        } else {
            /* two child */
            int cmp1 = content[index].compareTo(content[2 * index]);
            int cmp2 = content[index].compareTo(content[2 * index + 1]);

            if (cmp1 > 0 || cmp2 > 0){
                if (content[2 * index].compareTo(content[2 * index + 1]) < 0){
                    swap(index, 2 * index);
                    sink(2 * index);
                } else {
                    swap(index, 2 * index + 1);
                    sink(2 * index + 1);
                }
            }
        }
    }

    private void swap(int index1, int index2){
        Item obj = content[index1];
        content[index1] = content[index2];
        content[index2] = obj;
    }

    public void print(){
        for (Item item : content){
            System.out.println(item);
        }
    }
}
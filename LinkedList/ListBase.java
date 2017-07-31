/*
* @Author: aaronlai
* @Date:   2017-06-26 19:06:46
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-06-26 20:03:55
*/

public interface ListBase<Item> {
    public void addLast(Item x);

    public void addFirst(Item x);

    public Item getLast();

    public Item getFirst();

    public Item get(int i);

    public int size();

    public Item removeLast();

    // public void Insert(Item x, int positon);

    default public void print(){
        // int i = 0;
        // while (i < size()){
        //     System.out.print(get(i) + " ");
        //     i += 1;
        // }

        /* one-line for-loop implementation */
        for (int i = 0; i < size(); i = i + 1){
            System.out.print(get(i) + " ");
        }
    }
}
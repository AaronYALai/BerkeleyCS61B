/*
* @Author: aaronlai
* @Date:   2017-07-26 13:07:11
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-07-26 21:17:30
*/

public class RunSorting {
    public static void main(String[] args) {
        Integer[] input1 = new Integer[]{8, 3, 6, 2, 5, 2, 5, 12, 4, 0, 4, 6, 9, 0, 12, 4, 11};
        String[] input2 = new String[]{"l", "E", "m", "w", "n", "g", "E", "j", "e", "v", "o", "A", "v", "l", "s", "a"};

        MergeSort<Integer> mst = new MergeSort<Integer>(input1);
        mst.doSort();
        mst.print();

        MergeSort<String> mst2 = new MergeSort<String>(input2);
        mst2.doSort();
        mst2.print();

        HeapSort<Integer> hpst = new HeapSort<Integer>(input1);
        hpst.doSort();
        hpst.print();

        HeapSort<String> hpst2 = new HeapSort<String>(input2);
        hpst2.doSort();
        hpst2.print();

        InsertionSort<Integer> inst = new InsertionSort<Integer>(input1);
        inst.doSort();
        inst.print();

        InsertionSort<String> inst2 = new InsertionSort<String>(input2);
        inst2.doSort();
        inst2.print();

        ShellSort<Integer> shst = new ShellSort<Integer>(input1);
        shst.doSort();
        shst.print();

        ShellSort<String> shst2 = new ShellSort<String>(input2);
        shst2.doSort();
        shst2.print();

        QuickSort<Integer> qust = new QuickSort<Integer>(input1);
        qust.doSort();
        qust.print();

        QuickSort<String> qust2 = new QuickSort<String>(input2);
        qust2.doSort();
        qust2.print();

        System.out.println("Input1:");
        for (int it : input1){
            System.out.println(it);
        }
    }
}
/*
* @Author: aaronlai
* @Date:   2017-07-28 19:33:59
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-07-29 02:04:02
*/

public class MSDRadixSort {

    private String[] content;
    private int strLen;

    private class LinkedNode{

        public LinkedNode next;
        public String key;
        public int count;

        public LinkedNode(){
            key = null;
        }
    }

    public MSDRadixSort(String[] items){
        content = items;
        strLen = items[0].length();
    }

    public String[] doSort(){
        msdSort(0, content.length, 0);
        return content;
    }

    private void msdSort(int start, int end, int index){
        if (end - start <= 1 || index >= strLen){
            return;
        }

        LinkedNode root = new LinkedNode();
        String[] inputs = new String[end - start];
        System.arraycopy(content, start, inputs, 0, end - start);

        /* counting */
        for (String str : inputs){
            String element = Character.toString(str.charAt(index));
            addStr(root, element);
        }

        /* sorting */
        String[] sortedStr = sortedStringNodes(root);
        Integer[] startedPos = new Integer[sortedStr.length];

        int wizard = 0;
        for (int i = 0; i < sortedStr.length; i += 1){
            startedPos[i] = wizard;
            wizard += findStrCount(root, sortedStr[i]);
        }

        // for (String s : sortedStr){
        //     System.out.println(s);
        // }

        /* primitive array will not copy to a new one */
        Integer[] wizards = new Integer[startedPos.length];
        System.arraycopy(startedPos, 0, wizards, 0, startedPos.length);
        String[] result = new String[inputs.length];
        for (String str : inputs){
            String element = Character.toString(str.charAt(index));

            int windex = -1;
            for (int i = 0; i < sortedStr.length; i += 1){
                if (sortedStr[i].compareTo(element) == 0){
                    windex = i;
                    break;
                }
            }

            result[wizards[windex]] = str;
            wizards[windex] += 1;
        }
        System.arraycopy(result, 0, content, start, end - start);

        /* recursively msdSort */
        for (int i = 0; i < startedPos.length; i += 1){
            if (i + 1 < startedPos.length){
                msdSort(start + startedPos[i], start + startedPos[i + 1], index + 1);
            } else {
                msdSort(start + startedPos[i], end, index + 1);
            }   
        }
    }

    private void addStr(LinkedNode node, String str){
        if (node.key == null){
            node.key = str;
            node.count = 1;
            node.next = new LinkedNode();
        } else if (node.key.compareTo(str) == 0){
            node.count += 1;
        } else {
            addStr(node.next, str);
        }
    }

    private int findStrCount(LinkedNode node, String str){
        if (node.key == null){
            return 0;
        } else if (node.key == str){
            return node.count;
        } else {
            return findStrCount(node.next, str);
        }
    }

    private String[] sortedStringNodes(LinkedNode node){
        int nodeLen = lengthNode(node);
        String[] nodeList = new String[nodeLen];

        int wizard = 0;
        while (node.key != null){
            nodeList[wizard] = node.key;
            wizard += 1;
            node = node.next;
        }

        nodeList = sorting(nodeList);
        return nodeList;
    }

    private String[] sorting(String[] strings){
        /* insertion sort */
        for (int i = 0; i < strings.length; i += 1){
            int wizard = i;
            while (wizard > 0 && strings[wizard].compareTo(strings[wizard - 1]) < 0){
                String s = strings[wizard];
                strings[wizard] = strings[wizard - 1];
                strings[wizard - 1] = s;
                wizard -= 1;
            }
        }
        return strings;
    }

    private int lengthNode(LinkedNode node){
        if (node.key == null){
            return 0;
        } else {
            return 1 + lengthNode(node.next);
        }
    }

    public void print(){
        for (String str : content){
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        String[] inputs = new String[]{"abe", "abd", "abf", "aaq", "aal", "aaa", "acc", "acp",
         "bba", "bbs", "bbd", "cbc", "cba", "cbg", "cca", "ccv", "ccg", "bck", "bcv", "baa", "caq"};
        MSDRadixSort msdRadix = new MSDRadixSort(inputs);
        msdRadix.doSort();
        msdRadix.print();
    }
}
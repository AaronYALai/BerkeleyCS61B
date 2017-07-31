/*
* @Author: aaronlai
* @Date:   2017-07-29 14:44:52
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-07-29 15:59:46
*/

import java.util.Map;
import java.util.TreeMap;

public class TrieSet {

    private class Node{
        boolean exists;
        Map<Character, Node> links;

        public Node(){
            links = new TreeMap<Character, Node>();
            exists = false;
        }
    }

    private Node root;

    public TrieSet(){
        root = new Node();
    }

    public void put(String key){
        putIn(root, key, 0);
    }

    private Node putIn(Node node, String key, int index){
        if (node == null){
            node = new Node();
        }

        if (index == key.length()){
            node.exists = true;
            return node;
        }

        char c = key.charAt(index);
        Node next = putIn(node.links.get(c), key, index + 1);
        node.links.put(c, next);
        return node;
    }

    public boolean isContainsKey(String key){
        Node node = get(root, key, 0);
        if (node == null){
            return false;
        }
        return node.exists;
    }

    private Node get(Node node, String key, int index){
        if (node == null){
            return null;
        }

        if (index == key.length()){
            return node;
        }

        char c = key.charAt(index);
        return get(node.links.get(c), key, index + 1);
    }

    public String[] keyPrefix(String prefix){
        String[] strings = findPrefix(root, prefix, 0);

        int length = 0;
        for (String s: strings){
            if (s == null){
                break;
            }
            length += 1;
        }

        String[] keys = new String[length];
        System.arraycopy(strings, 0, keys, 0, length);

        return keys;
    }

    private String[] findPrefix(Node node, String prefix, int index){
        String[] strList = new String[100];
        int wizard = 0;

        if (index < prefix.length()){
            Character c = prefix.charAt(index);
            String[] strs = findPrefix(node.links.get(c), prefix, index + 1);
            for (String str : strs){
                if (str != null){
                    strList[wizard] = Character.toString(c) + str;
                    wizard += 1;
                }
            }
        } else {
            if (node.exists){
                strList[wizard] = "";
                wizard += 1;
            }

            for (Character c : node.links.keySet()){
                String[] strs = findPrefix(node.links.get(c), prefix, index + 1);
                for (String str : strs){
                    if (str != null){
                        strList[wizard] = Character.toString(c) + str;
                        wizard += 1;
                    }
                }
            }
        }

        return strList;
    }

    public void print(){
        nodeTraverse(root, "");
    }

    private void nodeTraverse(Node node, String runningStr){
        if (node.exists){
            System.out.println(runningStr);
        }

        for (Character c : node.links.keySet()){
            nodeTraverse(node.links.get(c), runningStr + Character.toString(c));
        }
    }

    public static void main(String[] args) {
        TrieSet trie = new TrieSet();
        trie.put("apple");
        trie.put("app");
        trie.put("a");
        trie.put("apply");
        trie.put("apollo");
        trie.put("are");
        trie.put("aaron");
        System.out.println(trie.isContainsKey("app"));
        System.out.println(trie.isContainsKey("appl"));
        System.out.println(trie.isContainsKey("ball"));
        System.out.println(trie.isContainsKey("aaron"));
        trie.print();

        System.out.println("Find keys with prefix: app");
        String[] keysPrefix = trie.keyPrefix("app");
        for (String s : keysPrefix){
            System.out.println(s);
        }
    }
}
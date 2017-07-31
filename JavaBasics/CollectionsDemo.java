/*
* @Author: aaronlai
* @Date:   2017-06-29 18:10:40
* @Last Modified by:   aaronlai
* @Last Modified time: 2017-06-29 18:54:47
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.io.*;


public class CollectionsDemo {

    public static String cleanString(String s){
        return s.toLowerCase().replaceAll("[^a-z]", "");
    }

    public static List<String> getWords(){
        List<String> words = new ArrayList<String>();
        words.add("a");
        words.add("b");
        words.add("c");
        words.add("b");
        words.add("a");
        return words;
    }

    public static int countUniqueWords(List<String> words){
        // /* better version */
        // Set<String> wordSet = new HashSet<>();
        // for (String ithword : words){
        //     wordSet.add(ithword);
        // }

        Set<String> wordSet = new HashSet<>(words);

        return wordSet.size();
    }

    public static Map<String, Integer> collectWordCount(List<String> words, List<String> targets){
        Map<String, Integer> counts = new HashMap<String, Integer>();

        /* make a note we have seen none of words */
        for (String t : targets){
            counts.put(t, 0);
        }

        for (String s : words){
            /* check if the word exists */
            if (counts.containsKey(s)){
                int oldCount = counts.get(s);
                counts.put(s, oldCount + 1);         
            }
        }
        return counts;
    }


    public static void main(String[] args) throws IOException {
        List<String> w = getWords();
        System.out.println(countUniqueWords(w));

        List<String> targets = new ArrayList<String>();
        targets.add("a");
        targets.add("c");
        targets.add("d");

        System.out.println(collectWordCount(w, targets));
    }
}
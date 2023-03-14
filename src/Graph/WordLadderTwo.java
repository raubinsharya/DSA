package Graph;

import java.util.*;

// GFG  https://practice.geeksforgeeks.org/problems/word-ladder-ii/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=word-ladder-ii
// Leetcode : https://leetcode.com/problems/word-ladder-ii/description/
public class WordLadderTwo {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> set = new HashSet<>(wordList);
        Queue<List<String>> queue = new LinkedList<>();
        List<String> levelList = new ArrayList<>();
        levelList.add(beginWord);
        queue.offer(levelList);
        set.remove(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> cache = new HashSet<>();
            while (size-- > 0) {
                List<String> list = queue.poll();
                String word = list.get(list.size() - 1);
                if (word.equals(endWord)) {
                    result.add(list);
                }
                for (int i = 0; i < word.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char arr[] = word.toCharArray();
                        arr[i] = c;
                        String newWord = new String(arr);
                        if (set.contains(newWord)) {
                            cache.add(newWord);
                            List<String> temp = new ArrayList<>(list);
                            temp.add(newWord);
                            queue.offer(temp);
                        }
                    }
                }
            }
            set.removeAll(cache); // after end of level remove all the matching word from set
        }
        return result;
    }

    // GFG
    public ArrayList<ArrayList<String>> findSequences(String beginWord, String endWord, String[] wordList) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < wordList.length; i++) set.add(wordList[i]);
        Queue<ArrayList<String>> queue = new LinkedList<>();
        ArrayList<String> levelList = new ArrayList<>();
        levelList.add(beginWord);
        queue.offer(levelList);
        set.remove(beginWord);
        boolean flag = false;
        while (!queue.isEmpty() && !flag) {
            int size = queue.size();
            Set<String> cache = new HashSet<>();
            while (size-- > 0) {
                ArrayList<String> list = queue.poll();
                String word = list.get(list.size() - 1);
                if (word.equals(endWord)) {
                    result.add(list);
                    flag = true;
                }
                for (int i = 0; i < word.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char arr[] = word.toCharArray();
                        arr[i] = c;
                        String newWord = new String(arr);
                        if (set.contains(newWord)) {
                            cache.add(newWord);
                            ArrayList<String> temp = new ArrayList<>(list);
                            temp.add(newWord);
                            queue.offer(temp);
                        }
                    }
                }
            }
            set.removeAll(cache);
        }
        return result;
    }
}

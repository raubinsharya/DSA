package Graph;

import Utils.Pair;

import java.util.*;

// https://leetcode.com/problems/word-ladder/description/

public class WordLadderOne {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < wordList.size(); i++) set.add(wordList.get(i));
        queue.offer(new Pair<>(beginWord, 1));
        set.remove(beginWord);
        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String word = pair.first;
            int step = pair.second;
            if (word.equals(endWord)) return step;
            for (int i = 0; i < word.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char arr[] = word.toCharArray();
                    arr[i] = c;
                    String newWord = new String(arr);
                    if (set.contains(newWord)) {
                        set.remove(newWord);
                        queue.offer(new Pair<>(newWord, step + 1));
                    }
                }
            }

        }
        return 0;
    }

    public int wordLadderLength(String beginWord, String endWord, String[] wordList) {
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < wordList.length; i++) set.add(wordList[i]);
        queue.offer(new Pair<>(beginWord, 1));
        set.remove(beginWord);
        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String word = pair.first;
            int step = pair.second;
            if (word.equals(endWord)) return step;
            for (int i = 0; i < word.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char arr[] = word.toCharArray();
                    arr[i] = c;
                    String newWord = new String(arr);
                    if (set.contains(newWord)) set.remove(newWord);
                    queue.offer(new Pair<>(newWord, step + 1));
                }
            }

        }
        return 0;
    }
}

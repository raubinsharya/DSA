package General;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
//https://leetcode.com/problems/vowel-spellchecker/description/
public class VowelSpellChecker {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> words = new HashSet<>();
        HashMap<String, String> hm = new HashMap<>();
        HashMap<String, String> ori = new HashMap<>();
        for (String word : wordlist) {
            words.add(word);
            ori.putIfAbsent(word.toLowerCase(), word);
            String vowel = word.toLowerCase().replaceAll("[aeiouAEIOU]", "#");
            hm.putIfAbsent(vowel, word);
        }
        for (int i = 0; i < queries.length; i++) {
            String word = queries[i];
            String encode = word.toLowerCase().replaceAll("[aeiouAEIOU]", "#");
            if (words.contains(word)) continue;
            else if (ori.containsKey(word.toLowerCase())) {
                queries[i] = ori.get(word.toLowerCase());
            } else if (hm.containsKey(encode)) {
                queries[i] = hm.get(encode);
            } else queries[i] = "";
        }
        return queries;
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {

    /*
    // 第一直觉的做法，O(mn), bad!
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        for (String s: strs) {
            Map<Character, Integer> keymap = new HashMap<>();
            char[] chars = s.toCharArray();
            for (char c: chars) {
                if (keymap.get(c) == null) {
                    keymap.put(c, 1);
                } else {
                    keymap.put(c, keymap.get(c) + 1);
                }
            }
            if (map.get(keymap) == null) {
                map.put(keymap, new ArrayList<>());
            }
            map.get(keymap).add(s);
        }
        for (List<String> list: map.values()) {
            res.add(list);
        }
        return res;
    } */

    
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (map.get(key) == null) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        for (List<String> list: map.values()) {
            res.add(list);
        }
        return res;
    } 

    /*
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

        Map<Long, List<String>> map = new HashMap<>();
        for (String s: strs) {
            char[] chars = s.toCharArray();
            long key = 1L;
            for (char c: chars) {
                key *= primes[c - 'a'];
            }

            if (map.get(key) == null) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        for (List<String> list: map.values()) {
            res.add(list);
        }
        return res;
    } */

    /*
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>(); 
        for (String s: strs) {
            int[] counts = new int[26];
            char[] chars = s.toCharArray();
            
            for (char c: chars) {
                counts[c - 'a']++;
            }
            
            String key = "";
            for (int i = 0; i < 26; i++) {
                key += counts[i] + "#";
            }
            if (map.get(key) == null) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        
        for (List<String> list: map.values()) {
            res.add(list);
        }
        return res;
    } */
}
// @lc code=end


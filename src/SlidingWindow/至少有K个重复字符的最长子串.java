package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class 至少有K个重复字符的最长子串 {
    public static void main(String[] args){
        String s = "bbaaacbd";
        int k = 3;
        System.out.println(new 至少有K个重复字符的最长子串().longestSubstring(s, k));
    }
    public int longestSubstring(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        int res = 0;
        int n = charArray.length;
        int le = 0, ri = 0;
        for (int i = 0; i < n; i++) {
            map.put(charArray[i], map.getOrDefault(charArray[i], 0) + 1);
        }
        boolean check = true;
        for (int i = 0; i < n; i++) {
            if(map.get(charArray[i]) < k) check = false;
        }
        if(check) return n;
        while (ri < n) {
            if (map.get(charArray[ri]) < k) {
                res = Math.max(res, longestSubstring(s.substring(le, ri), k));
                le = ri + 1;
            }
            ri++;
        }
        res = Math.max(res, longestSubstring(s.substring(le, ri), k));
        return res;
    }


}

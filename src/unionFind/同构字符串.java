package unionFind;

import com.sun.org.apache.xalan.internal.xsltc.dom.SortingIterator;

import java.util.HashMap;
import java.util.Map;

public class 同构字符串 {
    public static void main(String[] args){
        String s = "egg";
        String t = "add";
        boolean isomorphic = isIsomorphic(s, t);
        System.out.println(isomorphic);
    }
    public static boolean isIsomorphic(String s, String t) {
        if(s == null || t == null) return false;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                if (map.containsValue(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i),t.charAt(i));
            }else {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}

package March;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 分隔回文串 {
    public static void main(String[] args){

    }
    int len;
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        char[] c = s.toCharArray();
        len = s.length();
        if(len == 0) return res;
        LinkedList<String> path = new LinkedList<>();
        dfs(c,0,res,path);
        return res;
    }
    //递归回溯
    public void dfs(char[] c, int index, List<List<String>> res, LinkedList<String> path) {
        if(len == index) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = index; i < len; i++) {
            //判断当前字符串是回文，如果不是后移，
            if(!check(c,index,i)) continue;
            //如果是判断添加
            path.addLast(new String(c,index,i+1-index));
            //判断后面字符串是回文不,如果是的话会一直递归到尾，则全部加入结果集
            dfs(c, i + 1, res, path);
            //如果不是会进入到这一步，删除前面加入的字符串。
            path.removeLast();
        }
    }

    public boolean check(char[] c,int le, int ri) {
        while (le < ri) {
            if (c[le] != c[ri]) {
                return false;
            }
            le++;
            ri--;
        }
        return true;
    }
}

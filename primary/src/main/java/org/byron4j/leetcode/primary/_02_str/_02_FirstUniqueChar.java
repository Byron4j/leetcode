package org.byron4j.leetcode.primary._02_str;

/**
 * 字符串中的第一个唯一字符
 * <pre>
 *     给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 * </pre>
 */
public class _02_FirstUniqueChar {
    public int firstUniqChar(String s) {
        int length = s.length();
        int[] arr = new int[26]; // 小写
        int idx = -1;
        boolean flag = false;
        for (int i = 0; i < length; i++) {
            if( arr[s.charAt(i) - 97] == 0 ){
                flag = false;
                inner:for (int j = 0; j < length; j++) {
                    if (j!= i && s.charAt(i) == s.charAt(j)) {
                        // 记录、终止
                        arr[s.charAt(i) - 97] = 1;
                        flag = true;
                        break inner;
                    }
                }
                if(!flag){
                    return i;
                }
            }else{
                continue;
            }

        }

        return idx;

    }

    public static void main(String[] args) {
        _02_FirstUniqueChar firstUniqueChar = new _02_FirstUniqueChar();
        System.out.println(firstUniqueChar.firstUniqChar("leetcode"));
    }
}

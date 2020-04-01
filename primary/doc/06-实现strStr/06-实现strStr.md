#  实现 strStr()

[leetcode](https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/38/)



## 题目要求

实现 [strStr()](https://baike.baidu.com/item/strstr/811469) 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  **-1**。

**示例 1:**

```
输入: haystack = "hello", needle = "ll"
输出: 2
```

**示例 2:**

```
输入: haystack = "aaaaa", needle = "bba"
输出: -1
```

**说明:**

当 `needle` 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 `needle` 是空字符串时我们应当返回 0 。这与C语言的 [strstr()](https://baike.baidu.com/item/strstr/811469) 以及 Java的 [indexOf()](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#indexOf(java.lang.String)) 定义相符。




## 代码实现



```java
public int strStr(String haystack, String needle) {
        if( null == needle || "".equals(needle.trim())){
            return 0;
        }
        char[] haystacks = haystack.toCharArray();
        char[] needles = needle.toCharArray();
        // 最大的索引位置
        // hello
        // ll
        int max = haystacks.length - needles.length + 1;
        char first = needles[0];
        for (int i = 0; i < max; i++) {
            if( first ==  haystacks[i]){
                // 第一个匹配，则继续往后面找
                int j = i+1;  // haystacks的指针
                int end = j+needles.length-1;  // 最后一位匹配的索引值
                for (int k=1;  // needles的指针
                     j < end && haystacks[j]==needles[k];
                     j++,k++) {
                    // none
                }
                if( j == end ){
                    return i;
                }
            }
        }

        return -1;

    }
```


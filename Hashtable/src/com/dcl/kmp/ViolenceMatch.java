package com.dcl.kmp;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.DeflaterOutputStream;

/**
 * @author dcl
 * @date 2020/5/10 - 0:34
 */
public class ViolenceMatch {
    public static void main(String[] args) {
        String str1 = "为了爱一个人，放下所有，爱一个人，放弃一切，真的值得吗？";
        System.out.println(str1.length());

        String str2 = "爱一个人";
        System.out.println(str2.length());
        List<Integer> index= violenceMatch2(str1, str2);
        System.out.println(index.toString());
    }
    //暴力匹配算法
    public static int violenceMatch(String str1,String str2){
        char[] s1 = str1.toCharArray();

        char[] s2 = str2.toCharArray();
        int i = 0;
        int j = 0;
        while (i<s1.length-s2.length+1){
            while (s1[i] == s2[j]){
                if (j == s2.length-1){
                    return i-j;
                }
                i++;
                j++;
            }
            i = i - j + 1;
            j = 0;
        }
        return -1;
    }

    //暴力匹配算法
    public static List<Integer> violenceMatch2(String str1, String str2){
        char[] s1 = str1.toCharArray();

        char[] s2 = str2.toCharArray();
        int i = 0;
        int j = 0;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        while (i<s1.length-s2.length+1){
            count ++;
            while (s1[i] == s2[j]){
                if (j == s2.length-1){
                    list.add(i-j);
                    break;
                }
                i++;
                j++;
            }
            i = i - j + 1;
            j = 0;
        }
        System.out.println(count);
        return list;
    }
}


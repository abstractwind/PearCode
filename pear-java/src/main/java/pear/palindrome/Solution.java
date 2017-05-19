package pear.palindrome;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-palindrome/#/description
 * @author pei.lv
 */
public class Solution {
    private Map<String,Integer> charNumMap = new HashMap<String,Integer>(1010);
    
    public int longestPalindrome(String s) {
        int length = s.length();
        // 字母计数
        for(int i = 0; i< length; i++){
            char c = s.charAt(i);
            if(charNumMap.containsKey(String.valueOf(c))){
                Integer num = charNumMap.get(String.valueOf(c));
                charNumMap.put(String.valueOf(c), ++num);
            }else{
                charNumMap.put(String.valueOf(c), 1);
            }
        }
        
        int count = 0;
        boolean isSingle = false;
        // 遍历其中为偶数的字母
        Set<String> keySet = charNumMap.keySet();
        for(String key:keySet){
            Integer num = charNumMap.get(key);
            if(num % 2 == 0) {
                count = count + num;
            }else{
                isSingle = true;
                if(num > 1){
                    count = count + num - 1;
                }
            }
        }
        return isSingle ? (count + 1) : count;
    }
    
}

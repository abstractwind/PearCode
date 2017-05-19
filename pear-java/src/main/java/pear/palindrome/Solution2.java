package pear.palindrome;

/**
 * https://leetcode.com/problems/longest-palindrome/#/description
 * @author pei.lv
 */
public class Solution2 {
    
    public int longestPalindrome(String s) {
        int length = s.length();
        char[] chars = new char[128];
        // 字母计数
        for(int i = 0; i< length; i++){
            chars[s.charAt(i)]++;
        }
        
        int count = 0;
        boolean isSingle = false;

        for(int num:chars){
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

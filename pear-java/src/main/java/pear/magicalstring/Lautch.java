package pear.magicalstring;

/**
 * https://leetcode.com/problems/longest-palindrome/#/description
 * 
 * @author pei.lv
 */
public class Lautch {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.magicalString(1)); // return 1
        
        System.out.println(solution.magicalString(4)); // return 2
        
        System.out.println(solution.magicalString(6)); // return 3
        
        System.out.println(solution.magicalString(7)); // return 4
    }

}

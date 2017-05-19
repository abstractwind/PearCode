package pear.magicalstring;

import java.util.Arrays;

/**
 * 
 * @author pei.lv
 */
public class Solution {

    public int magicalString(int n) {
        int tail = 2;
        int point = tail;
        int breakCount = 3;
        int[] result = new int[11000];
        result[0] = 1;
        result[1] = 2;
        result[2] = 2;
        if (n <= 3) return n==0?0:1;
        while (true) {
            if (result[tail] == 2) {
                int count = result[point] == 1 ? 2 : 1;
                result[++point] = result[++point] = count;
                breakCount = breakCount + 2;
            }
            if (result[tail] == 1) {
                int count = (result[point] == 1 ? 2 : 1);
                result[++point] = count;
                breakCount++;
            }
            if (breakCount >= n) break;
            tail++;
        }
        
        int count = 0;
        for(int i = 0;i< n ;i++){
            if(result[i] == 1) count++;
        }

        return count;
    }

}

package com.example.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 7：
 * 给出一个 32 位的有符号整数，
 * 你需要将这个整数中每位上的数字进行反转。
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，
 * 则其数值范围为 [−231,  231 − 1]。请根据这个假设，
 * 如果反转后整数溢出那么就返回 0。
 */
public class reverse {
    public static void main(String[] args) {
        reverse(2147483647);//2147483648
        rev(123);
        isPalindrome(121);

    }

    //这个是精简版
    private static int rev(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        /**
         * long -->向int类型转换
         */
        return (int) res == res ? (int) res : 0;
    }

    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int t = x % 10;
            int newRes = res * 10 + t;
            //如果数字溢出，直接返回0
            /**
             * 这步要结合上面的一步考虑 就是上面的数学变形
             * 但是经过int强转了
             */
            if ((newRes - t) / 10 != res) {
                return 0;
            }
            res = newRes;
            x = x / 10;
        }
        return res;
    }


    public static boolean isPalindrome(int x) {
        //1、能否被10 整除
        //2、是否为负数
        //3、创建list集合size
        //1==size-1
        //2 ==size-2
        //...
        //1、能否被10 整除
        //2、是否为负数
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int cur = 0;
        while(x > cur ) {
            cur = cur * 10 + x % 10;
            x /= 10;
        }
        return x == cur || x == cur / 10;
    }
}

package com.bandi.arrays;

import java.util.Stack;

import com.bandi.util.Utils;

/**
 * 
 * https://leetcode.com/problems/product-of-array-except-self/
 * 
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of
 * all the elements of nums except nums[i].
 * 
 * Solve it without division and in O(n).
 * 
 * For example, given [1,2,3,4], return [24,12,8,6]
 * 
 * @author kishore.bandi
 *
 */
public class ProductExceptSelf {

    public static void main(String[] args) {
        Utils.printArray(productExceptSelf(new int[] { 1, 2, 3, 4}));
    }

    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] finalArray = new int[nums.length];
        Stack<Integer> productValuesSoFar = new Stack<>();

        for (int value : nums) {
            if (productValuesSoFar.isEmpty()) {
                productValuesSoFar.push(value);
            } else {
                productValuesSoFar.push(productValuesSoFar.peek() * value);
            }
        }

        productValuesSoFar.pop(); // lose out last value as its the overall product
        int reverseProduct = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (productValuesSoFar.isEmpty()) {
                // When there is only one element left.
                productValuesSoFar.push(1);
            }
            if (i == nums.length - 1) {
                finalArray[i] = productValuesSoFar.pop();
            } else {
                finalArray[i] = productValuesSoFar.pop() * reverseProduct;
            }
            reverseProduct *= nums[i];
        }

        return finalArray;
    }

}

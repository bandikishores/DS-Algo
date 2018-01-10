package com.bandi.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/116/array-and-strings/828/
 * 
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * 
 * For example, Given the following matrix:
 * 
 * [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ]
 * 
 * You should return [1,2,3,6,9,8,7,4,5].
 * 
 * @author kishore.bandi
 *
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] matrix = new int[m][];
        for (int i = 0; i < m; i++) {
            matrix[i] = new int[n];
        }
        int count = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = count++;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println("");
        }

        spiralOrder(matrix).stream().forEach(value -> System.out.print(value + ","));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralList = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return spiralList;
        }
        int imax =  matrix.length - 1, imin = 1, jmax =matrix[0].length - 1, jmin = 0, current = 1 /* 0 = i, 1 = j*/,
                i = 0, j = 0, direction = 0/* 0 = forward, 1 = backward*/;
        int size = matrix[0].length * matrix.length;
        for (int k = 0; k < size; k++) {
            if (current == 0) { // ith turn
                if (direction == 0) { // forward
                    spiralList.add(matrix[i++][j]);
                    if (i > imax) {
                        imax--;
                        i--;
                        j--;
                        current = 1;
                        direction = 1;
                    }
                } else { // backward
                    spiralList.add(matrix[i--][j]);
                    if (i < imin) {
                        imin++;
                        i++;
                        j++;
                        current = 1;
                        direction = 0;
                    }
                }
            } else { // jth turn
                if (direction == 0) { // forward
                    spiralList.add(matrix[i][j++]);
                    if (j > jmax) {
                        jmax--;
                        j--;
                        i++;
                        current = 0;
                    }
                } else { // backward
                    spiralList.add(matrix[i][j--]);
                    if (j < jmin) {
                        jmin++;
                        j++;
                        i--;
                        current = 0;
                    }
                }
            }
        }
        return spiralList;
    }

}

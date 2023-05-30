package idv.paul.leetcode.dp;

/*
Easy
https://leetcode.com/problems/pascals-triangle/
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle_118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>(numRows);
        List<Integer> prev = Collections.singletonList(1);
        rows.add(prev);

        for (int x=1; x<numRows; ++x) {
            List<Integer> row = new ArrayList<>(x+1);
            // head
            row.add(1);
            for (int y=0; y<x-1; ++y) {
                row.add(prev.get(y) + prev.get(y+1));
            }
            // tail
            row.add(1);
            rows.add(row);
            prev = row;
        }

        return rows;
    }

    public static void main(String... argv) {
        List<List<Integer>> triangle = generate(10);
        for (List<Integer> row : triangle) {
            System.out.println(row);
        }
    }
}

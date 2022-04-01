package com.demo.assessment.Problems;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
        };
        int startRow = 0;
        int endRow = array.length - 1;
        int startColumn = 0;
        int endColumn = array[0].length - 1;

        List<Integer> list = new ArrayList<>();
        getRectangleList(array, list, startRow, endRow, startColumn, endColumn);
        System.out.println(list);
    }

    private static void getRectangleList(int[][] array, List<Integer> list, int startRow, int endRow, int startColumn, int endColumn) {

        if (startRow > endRow || startColumn > endColumn)
            return;

        for (int i = startColumn; i <= endColumn; i++) {
            list.add(array[startRow][i]);
        }
        for (int i = startRow + 1; i <= endRow; i++) {
            list.add(array[i][endColumn]);
        }
        for (int i = endColumn - 1; i >= startColumn; i--) {
            if (startRow == endRow) break;
            list.add(array[endRow][i]);
        }
        for (int i = endRow - 1; i >= startRow + 1; i--) {
            if (endColumn == startColumn) break;
            list.add(array[i][startColumn]);
        }
        getRectangleList(array, list, startRow + 1, endRow - 1, startColumn + 1, endColumn - 1);
    }
}

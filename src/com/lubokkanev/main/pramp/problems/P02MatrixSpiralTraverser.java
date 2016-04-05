package com.lubokkanev.main.pramp.problems;

public class P02MatrixSpiralTraverser {
    private int[][] matrix;
    private Integer left;
    private Integer right;
    private Integer top;
    private Integer bottom;


    public P02MatrixSpiralTraverser(int[][] matrix) {
        this.matrix = matrix;

        left = 0;
        right = 0;
        top = 0;
        bottom = 0;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public String traverseMatrix() {
        resetIndices();
        String result = "";

        while (left <= right && top <= bottom) {
            result += getTraverseCycle();
        }

        return result;
    }

    private String getTraverseCycle() {
        return getTraversedLeftToRight() +
                getTraversedTopToBottom() +
                getTraversedRightToLeft() +
                getTraversedBottomToTop();
    }

    private String getTraversedLeftToRight() {
        String result = "";
        if (left <= right && top <= bottom) {
            for (int i = left; i <= right; ++i) {
                result += Integer.toString(matrix[top][i]) + ' ';
            }
        }

        top += 1;
        return result;
    }

    private String getTraversedRightToLeft() {
        String result = "";
        if (left <= right && top <= bottom) {
            for (int i = right; i >= left; --i) {
                result += Integer.toString(matrix[bottom][i]) + ' ';
            }
        }

        bottom -= 1;
        return result;
    }

    private String getTraversedTopToBottom() {
        String result = "";
        if (left <= right && top <= bottom) {
            for (int i = top; i <= bottom; ++i) {
                result += Integer.toString(matrix[i][right]) + ' ';
            }
        }

        right -= 1;
        return result;
    }

    private String getTraversedBottomToTop() {
        String result = "";
        if (left <= right && top <= bottom) {
            for (int i = bottom; i >= top; --i) {
                result += Integer.toString(matrix[i][left]) + ' ';
            }
        }

        left += 1;
        return result;
    }

    private void resetIndices() {
        left = 0;
        top = 0;
        right = matrix[0].length - 1;
        bottom = matrix.length - 1;
    }
}

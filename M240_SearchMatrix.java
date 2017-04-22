/**
 * Created by yangjiawei on 2017/4/22.
 */
public class M240_SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) row--;
            else if (matrix[row][col] < target) col++;
        }
        return false;
    }
}

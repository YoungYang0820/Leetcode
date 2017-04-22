/**
 * Created by yangjiawei on 2017/4/22.
 */
public class M74_SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int targetRow = matrix.length - 1;
        if (targetRow < 0) return false;
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] > target) {
                targetRow = i - 1;
                break;
            }
        }
        for (int i = 0; i < matrix[targetRow].length; i++) {
            if (matrix[targetRow][i] == target) return true;
            if (matrix[targetRow][i] > target) return false;
        }
        return false;
    }
}

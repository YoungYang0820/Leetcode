/**
 * Created by yangjiawei on 2017/5/7.
 */
public class E566_ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null) return null;
        int matrixRow = nums.length;
        int matrixCol = nums[0].length;
        if (matrixCol * matrixRow != r * c) return nums;
        int[][] matrix = new int[r][c];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = nums[index / matrixCol][index % matrixCol];
                index++;
            }
        }
        return matrix;
    }
}

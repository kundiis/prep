package Graph;

/**
 * Created by km on 5/27/18.
 */
public class FindMaze {

    // init matrix with size
    private int[][] matrix = new int[10][];

    // 1 is a block, 2 is start, 3 is end
    public void dfs(int row, int column){

        if(matrix[row][column] == 3){
            throw new RuntimeException("Found the item"); // found the item
        }
        if( row > matrix.length || column > matrix.length || row < 0 || column < 0 || matrix[row][column] == 1){
            return; // out of map or a wall found
        }

        dfs(row+1, column); // down
        dfs(row, column+1); // right

        dfs(row, column-1); // left
        dfs(row-1, column); // up

    }
}

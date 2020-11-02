public class PercolationDFSFast extends PercolationDFS {
    public PercolationDFSFast(int size){
        super(size);
    }

    @Override
    public void updateOnOpen(int row, int col){
        if(row == 0)
            dfs(row,col);
        if(inBounds(row-1,col) && isFull(row-1,col)){
            dfs(row,col);
        }
        if(inBounds(row+1,col) && isFull(row+1,col)){
            dfs(row,col);
        }
        if(inBounds(row,col-1) && isFull(row,col-1)){
            dfs(row,col);
        }
        if(inBounds(row,col+1) && isFull(row,col+1)){
            dfs(row,col);
        }
    }
}

/*
	/**
	 * Determine if (row,col) is valid for given grid
	 * @param row specifies row
	 * @param col specifies column
	 * @return true if (row,col) on grid, false otherwise

protected boolean inBounds(int row, int col) {
    if (row < 0 || row >= myGrid.length) return false;
    if (col < 0 || col >= myGrid[0].length) return false;
    return true;
}
 */


import java.util.LinkedList;
import java.util.Queue;

public class PercolationBFS extends PercolationDFSFast{
    public PercolationBFS(int size){
        super(size);
    }
    @Override
    public void updateOnOpen(int row, int col) {

        /*Queue<int[]> q = new LinkedList<>();

        if(row == 0) {
            myGrid[row][col] = FULL;
            q.add(new int[]{row,col});
        }
        if(inBounds(row-1,col) && isFull(row-1,col)){
            myGrid[row][col] = FULL;
            myGrid[row-1][col] = FULL;
            q.add(new int[]{row,col});
        }
        if(inBounds(row+1,col) && isFull(row+1,col)){
            myGrid[row][col] = FULL;
            myGrid[row+1][col] = FULL;
            q.add(new int[]{row,col});
        }
        if(inBounds(row,col-1) && isFull(row,col-1)){
            myGrid[row][col] = FULL;
            myGrid[row][col-1] = FULL;
            q.add(new int[]{row,col});
        }
        if(inBounds(row,col+1) && isFull(row,col+1)){
            myGrid[row][col] = FULL;
            myGrid[row][col+1] = FULL;
            q.add(new int[]{row,col});
        }*/
    }
}
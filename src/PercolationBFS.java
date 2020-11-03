import java.util.LinkedList;
import java.util.Queue;

public class PercolationBFS extends PercolationDFSFast{
    public PercolationBFS(int size){
        super(size);
    }

    @Override
    protected void dfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        myGrid[row][col] = FULL;
        q.add(new int[] {row,col});

        while(q.size() != 0){
            int[] p = q.remove();
            row = p[0];
            col = p[1];

            if(inBounds(row-1,col) && isOpen(row-1,col) && myGrid[row-1][col] != FULL){
                myGrid[row-1][col] = FULL;
                q.add(new int[]{row-1,col});
            }
            if(inBounds(row+1,col) && isOpen(row+1,col) && myGrid[row+1][col] != FULL){
                myGrid[row+1][col] = FULL;
                q.add(new int[]{row+1,col});
            }
            if(inBounds(row,col-1) && isOpen(row,col-1)  && myGrid[row][col-1] != FULL){
                myGrid[row][col-1] = FULL;
                q.add(new int[]{row,col-1});
            }
            if(inBounds(row,col+1) && isOpen(row,col+1) && myGrid[row][col+1] != FULL){
                myGrid[row][col+1] = FULL;
                q.add(new int[]{row,col+1});
            }
        }
    }

}

/*@Override
    public void updateOnOpen(int row, int col) {
        /*Queue<int[]> qp = new LinkedList<>();

        while(qp.size()!=0){
            int[] p = qp.remove();
            for(int i = 0; i < myGrid.length; i++){
                int row_new = p[0] + myGrid[i];
                int col_new = p[1] + myGrid[i];
                if(inBounds(row,col) && myGrid[row][col]){
                    qp.add(new int[]{row,col});
                    myGrid[row][col] = FULL;
                }
            }
        }


    }*/
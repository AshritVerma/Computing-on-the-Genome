import java.util.Arrays;

public class PercolationUF implements IPercolate {
    private IUnionFind myFinder;
    private boolean[][] myGrid;
    private final int VTOP;
    private final int VBOTTOM;
    private int myOpenCount;

    public PercolationUF(IUnionFind finder, int size) {
        finder.initialize(size*size+2);
        myFinder = finder;
        myGrid = new boolean[size][size];
        VTOP = size*size;
        VBOTTOM = size*size+1;
        myOpenCount = 0;
    }

    @Override
    public void open(int row, int col) {
        if (! inBounds(row,col))
            throw new IndexOutOfBoundsException(String.format("(%d,%d) not in bounds", row,col));
        if(myGrid[row][col] != true){
            myGrid[row][col] = true;

            int num = row*myGrid.length+col;
            int neighbor1 = row*myGrid.length+col+1;
            int neighbor2 = row*myGrid.length+col-1;
            int neighbor3 = (row+1)*myGrid.length+col;
            int neighbor4 = (row-1)*myGrid.length+col;

            if(row == 0)
                myFinder.union(num,VTOP);
            if(row == myGrid.length)
                myFinder.union(num,VBOTTOM);
            if(inBounds(row,col-1) && isOpen(row,col-1))
                myFinder.union(num,neighbor2);
            if(inBounds(row,col+1) && isOpen(row, col+1))
                myFinder.union(num,neighbor1);
            if(inBounds(row+1,col) && isOpen(row+1,col))
                myFinder.union(num,neighbor3);
            if(inBounds(row-1,col) && isOpen(row-1,col))
                myFinder.union(num,neighbor4);
        }
        myOpenCount ++;
    }

    @Override
    public boolean isOpen(int row, int col) {
        if (! inBounds(row,col))
            throw new IndexOutOfBoundsException(String.format("(%d,%d) not in bounds", row,col));
        return myGrid[row][col];
    }

    @Override
    public boolean isFull(int row, int col) {
        if (! inBounds(row,col))
            throw new IndexOutOfBoundsException(String.format("(%d,%d) not in bounds", row,col));

        int num = row*myGrid.length+col;
        boolean boo = myFinder.connected(num,VTOP);

        return boo;
    }

    @Override
    public boolean percolates() {
        if(myFinder.connected(VTOP,VBOTTOM))
            return true;
        return false;
    }

    @Override
    public int numberOfOpenSites() {
        return myOpenCount;
    }

    protected boolean inBounds(int row, int col) {
        if (row < 0 || row >= myGrid.length) return false;
        if (col < 0 || col >= myGrid[0].length) return false;
        return true;
    }
}

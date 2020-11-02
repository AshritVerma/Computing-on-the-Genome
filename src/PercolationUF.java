public class PercolationUF implements IPercolate {
    @Override
    public void open(int row, int col) {

    }

    @Override
    public boolean isOpen(int row, int col) {
        return false;
    }

    @Override
    public boolean isFull(int row, int col) {
        return false;
    }

    @Override
    public boolean percolates() {
        return false;
    }

    @Override
    public int numberOfOpenSites() {
        return 0;
    }
}

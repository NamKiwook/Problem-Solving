public class FenwickTree {
    private int[] tree;
    public FenwickTree (int n) {
        tree = new int[n+1];
    }
    public int sum(int index) {
        int result = 0;
        while(index > 0) {
            result += tree[index];
            index -= (index & -index);
        }
        return result;
    }
    public int sum(int left, int right) {
        if(left > right)
            return 0;

        return sum(right) - sum(left - 1);
    }

    public void update(int index, int diff) {
        while(index < tree.length) {
            tree[index] += diff;
            index += (index & -index);
        }
    }
}

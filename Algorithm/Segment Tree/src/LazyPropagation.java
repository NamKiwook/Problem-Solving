public class LazyPropagation extends SegmentTree {
    private int[] lazy;
    public LazyPropagation(int[] arr, int n) {
        super(arr, n);
        lazy = new int[n * 4];
    }

    @Override
    public int sum(int left, int right, int node, int rangeL, int rangeR) {
        updateLazy(left,right,node);

        if (rangeL >= right || rangeR <= left)
            return 0;

        if (rangeL <= left && rangeR >= right)
            return segmentArr[node];

        int mid = (left + right) / 2;
        return sum(left, mid, node * 2, rangeL, rangeR) + sum(mid + 1, right, node * 2 + 1, rangeL, rangeR);
    }

    public void updateLazy(int left, int right, int node) {
        if (lazy[node] == 0)
            return;
        segmentArr[node] += (right - left + 1) * lazy[node];
        if (left != right) {
            lazy[node * 2] = lazy[node];
            lazy[node * 2 + 1] = lazy[node];
        }
        lazy[node] = 0;
    }

    public void updateRange(int left, int right, int node, int rangeL, int rangeR, int diff) {
        updateLazy(left, right, node);
        if (right < rangeL || rangeR < left)
            return;
        if (rangeL <= left && right <= rangeR) {
            segmentArr[node] += (right - left + 1) * diff;
            if (left != right) {
                lazy[node * 2] += diff;
                lazy[node * 2 + 1] += diff;
            }
            return;
        }
        int mid = (left + right) / 2;
        updateRange(left, mid, node * 2, rangeL, rangeR, diff);
        updateRange(mid + 1, right, node * 2 + 1, rangeL, rangeR, diff);
        segmentArr[node] = segmentArr[node * 2] + segmentArr[node * 2 + 1];
    }
}

public class SegmentTree {
    private int[] orginArr;
    protected int[] segmentArr; // The array that stores segment tree nodes

    public SegmentTree(int[] arr, int n) {
        segmentArr = new int[n * 4];
        orginArr = arr;
        init(0, n - 1, 1);
    }

    private int init(int left, int right, int node) {

        if (left == right) {

            return segmentArr[node] = orginArr[left];
        }

        int mid = (left + right) / 2;

        segmentArr[node] += init(left, mid, node * 2);
        segmentArr[node] += init(mid + 1, right, node * 2 + 1);

        return segmentArr[node];
    }

    public void update(int left, int right, int node, int index, int diff) {
        if(!(left <= index && index <= right)) {
            return;
        }
        segmentArr[node] += diff;

        if(left != right) {
            int mid = (left + right) / 2;
            update(left, mid, node * 2, index, diff);
            update(mid + 1, right, node * 2 + 1, index, diff);
        }
    }

    public int sum(int left, int right, int node, int rangeL, int rangeR) {
        if (rangeL >= right || rangeR <= left)
            return 0;

        if (rangeL <= left && rangeR >= right)
            return segmentArr[node];

        int mid = (left + right) / 2;
        return sum(left, mid, node * 2, rangeL, rangeR) + sum(mid + 1, right, node * 2 + 1, rangeL, rangeR);
    }

    public int[] getSegmentArray() {
        return segmentArr;
    }

}

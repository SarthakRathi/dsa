import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MinHeap {
    List<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    public MinHeap(int[] nums) {
        heap = new ArrayList<>();
        for (int num : nums) {
            heap.add(num);
        }
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    public int peek() {
        if (heap.size() == 0) {
            return Integer.MIN_VALUE;
        }
        return heap.get(0);
    }

    public void heapify(int index) {
        int size = heap.size();
        int smallest = index;
        int l = 2 * index + 1;
        int r = 2 * index + 2;

        if (l < size && heap.get(l) < heap.get(smallest)) {
            smallest = l;
        }

        if (r < size && heap.get(r) < heap.get(smallest)) {
            smallest = r;
        }

        if (smallest != index) {
            Collections.swap(heap, index, smallest);
            heapify(smallest);
        }
    }

    public void insert(int val) {
        heap.add(val);
        int index = heap.size() - 1;
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(parent) > heap.get(index)) {
                Collections.swap(heap, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    public int pop() {
        if (heap.size() == 0) {
            return Integer.MIN_VALUE;
        }
        int min = heap.get(0);
        int last = heap.size() - 1;
        heap.set(0, heap.get(last));
        heap.remove(last);
        if (!heap.isEmpty()) {
            heapify(0);
        }
        return min;
    }

    public void print() {
        for (Integer num : heap) {
            System.out.println(num);
        }
    }
}

class Main2 {
    public static void main(String[] args) {
        MinHeap mh = new MinHeap();
        mh.insert(100);
        mh.insert(300);
        mh.insert(200);
        System.out.println(mh.peek());
        mh.pop();
        System.out.println(mh.peek());
        mh.print();
    }
}

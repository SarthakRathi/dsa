import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MaxHeap {
    List<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    public MaxHeap(int[] nums) {
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
        int largest = index;
        int l = 2 * index + 1;
        int r = 2 * index + 2;

        if (l < size && heap.get(l) > heap.get(largest)) {
            largest = l;
        }

        if (r < size && heap.get(r) > heap.get(largest)) {
            largest = r;
        }

        if (largest != index) {
            Collections.swap(heap, index, largest);
            heapify(largest);
        }
    }

    public void insert(int val) {
        heap.add(val);
        int index = heap.size() - 1;
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(parent) < heap.get(index)) {
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
        int max = heap.get(0);
        int last = heap.size() - 1;
        heap.set(0, heap.get(last));
        heap.remove(last);
        if (!heap.isEmpty()) {
            heapify(0);
        }
        return max;
    }

    public void print() {
        for (Integer num : heap) {
            System.out.println(num);
        }
    }
}

class Main {
    public static void main(String[] args) {
        MaxHeap mh = new MaxHeap();
        mh.insert(100);
        mh.insert(300);
        mh.insert(200);
        System.out.println(mh.peek());
        mh.pop();
        System.out.println(mh.peek());
        mh.print();
    }
}

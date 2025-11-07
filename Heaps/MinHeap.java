import java.util.ArrayList;
public class MinHeap{
    private ArrayList<Integer> heap;
    public MinHeap(){
        heap = new ArrayList<>();
    }
    private int parent(int i) {
        return i-1/2;
    }
    private int leftChild(int i) {
        return 2*i +1;
    }
    private int rightChild(int i) {
        return 2*i +2;
    }
    private void swap(int i, int j){
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    public void insert(int val){
        heap.add(val);
        heapifyUp(heap.size() - 1);
    }
    private void heapifyUp(int i){
        while(i>0 && heap.get(i) < heap.get(parent(i))){
            swap(i,parent(i));
            i = parent(i);
        }
    }
    public int extractMin(){
        if(heap.size() == 0) throw new IllegalStateException("Heap is empty");
        int min = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapifyDown(0);
        return min;
    }
    private void heapifyDown(int i){
        int smallest = i;
        int left = leftChild(i);
        int right = rightChild(i);
        if(left < heap.size() && heap.get(left) < heap.get(smallest)){
            smallest = left;
        }
        if(right < heap.size() && heap.get(right) < heap.get(smallest)){
            smallest = right;
        }
        if(smallest != i){
            swap(i, smallest);
            heapifyDown(smallest);
        }
    }
    public int getMin(){
        if(heap.size() == 0) throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }
    public int size(){
        return heap.size();
    }
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(8);
        minHeap.insert(1);
        System.out.println("Minimum: " + minHeap.getMin()); // Output: Minimum: 1
        System.out.println("Extracted Minimum: " + minHeap.extractMin()); // Output: Extracted Minimum: 1
        System.out.println("New Minimum: " + minHeap.getMin()); // Output: New Minimum: 3
    }
}

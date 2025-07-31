import java.util.*;


public class HeapImpl<T> implements Heap<T>{


    public List<T> heap;
    Comparator<T> comparator;

    HeapImpl(Comparator<T> comparator){
        this.heap = new ArrayList<>();
        this.comparator = comparator;
    }

    HeapImpl(List<T> list ,Comparator<T> comparator){
        this.heap = new ArrayList<>();
        this.comparator = comparator;

        heapify(list);
        
    }

    public void add(T val){

        heap.add(val);

        int i = heap.size()-1;
        
        upheap(i);
    
    }

    public T poll(){

        if (isEmpty())
            throw new RuntimeException("Empty Heap");

        T res = heap.get(0);

        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int i  = 0;

        downheap(i);

        return res;

    }

    public T peek(){
        if (isEmpty()) 
            throw new RuntimeException("Empty Heap");
            
        return heap.get(0);
    }

    public void heapify(List<T> list){

        clear();

        int n  = list.size();

        for(T obj : list)
            heap.add(obj);
        
        for(int i = (n/2) -1 ; i>=0 ; i--)
            downheap(i);

    }

    public int size(){
        return heap.size();
    }

    public boolean isEmpty(){
        return heap.isEmpty();
    }

    private int getParent(int i){
        return (i-1)/2;
    }

    private int getLeftChild(int i){
        return i * 2 + 1;
    }
        
    private int getRightChild(int i){
        return i * 2 + 2;
    }

    private void swap(int i , int j){
        T temp = heap.get(i);
        heap.set(i,heap.get(j));
        heap.set(j,temp);
    }

    private void  upheap(int i){

        int parent = getParent(i);

        while (comparator.compare(heap.get(i),heap.get(parent)) < 0){
            swap(i,parent);
            i = parent;
            parent = getParent(parent);
        }

    }

    private void downheap(int i){
        
        int size = heap.size();

        while (true){

            int smallest = i;

            int l = getLeftChild(i);
            int r = getRightChild(i);

            if (l<size && comparator.compare(heap.get(l),heap.get(smallest)) < 0)
                smallest = l;

            if (r<size && comparator.compare(heap.get(r),heap.get(smallest)) < 0)
                smallest = r;
            
            if (i==smallest)
                break;
            
            swap(i,smallest);
            i = smallest;
        }

    }

    public void clear(){
        heap.clear();
    }

    public String toString(){
        return heap.toString();
    }

}
import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GenericStack {
    private LinkedList<Integer> list;
    Lock lock = new ReentrantLock();

    public synchronized void push(Integer i) {
        lock.lock();
        list.add(i);
        lock.unlock();
    }

    public synchronized Integer pop() {
        lock.lock();
        Integer o = list.get(list.size()-1);
        list.remove(list.size()-1);
        lock.unlock();
        return o;
    }
    public Integer peek() {
        return list.get(list.size()-1);
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }
}

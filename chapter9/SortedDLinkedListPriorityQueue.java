package chapter9;

import my.util.DLinkedList;
import my.util.DNode;

public class SortedDLinkedListPriorityQueue<T> implements PriorityQueue<T> {

    private static class Entry<T> implements Comparable<Entry<T>> {
        final int priority;
        final T data;
        Entry(int priority, T data) {
            this.priority = priority;
            this.data = data;
        }

        @Override
        public int compareTo(Entry<T> o) {
            return o.priority - this.priority;
        }
    }

    private final DLinkedList<Entry<T>> list;

    public SortedDLinkedListPriorityQueue() {
        list = new DLinkedList<>();
    }

    @Override
    public void enqueue(int priority, T data) {
        Entry<T> newEntry = new Entry<>(priority, data);
        if (isEmpty()) {
            list.add(newEntry);
            return;
        }
        // TODO: find insertion point and insert so list is sorted by priority ASC
        // Algorithm: make sure first item in DLinkedList is highest priority
        // Start at first and traverse until higher priority
        // Insert new item before the one just found
        DNode<Entry<T>> curr = list.get(0);
        while (curr != null) {
            if (priority < curr.getData().priority) {
                list.addBefore(curr, newEntry);
                break;
            }
            curr = curr.getNext();
        }
    }

    @Override
    public T dequeue() throws Exception {
        // TODO: removeFirst()
        return null;
    }

    @Override
    public T front() throws Exception {
        // TODO: peek head
        return null;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}

package my.util;

public class DLinkedList<T> {

    private DNode<T> head;
    private DNode<T> tail;
    private int size;

    public DLinkedList() {

    }
    /*
    return null if i is invalid
     */
    public DNode<T> get(int i) {
        if (i > size || i < 0)
            return null;

        if (i < size/2) {
            //Start at head
            DNode<T> n = head;
            for (int j = 0; j < i; j++) {
                n = n.getNext();
            }
            return n;

        } else {
            //Start at tail
            DNode<T> n = tail;
            for (int j = 0; j < size - i - 1; j++) {
                n = n.getPrev();
            }
            return n;

        }
    }
    // need to break the connection between node and whatever its current "next" is
    public void addAfter(DNode<T> node, T data) {
        if (node==tail) {
            add(data);          // already adds at the tail
        } else if (node==null) {
            addFirst(data);     // already adds at the head
        } else {
            // normal case where we are not adding at the beginning or the end
            // the constructor alone lets us set the prev and next for the new node
            DNode<T> newnode = new DNode<>(node, node.getNext(), data);                

            // But we need to update the prev on the node we are being added before
            node.getNext().setPrev(newnode);

            // And we need to update the next on the node we are being added after
            node.setNext(newnode);
            size++;
        }
    }

    public DNode<T> addFirst(T data) {
        DNode<T> newnode = new DNode<>(null, head, data);
        if (size==0) {
            tail=newnode;
        } else {
            head.setPrev(newnode);
            newnode.setNext(head);
        }
        // unconditionally, we have a new tail
        // AND our size has increased by 1
        size++;        
        head = newnode;
        return newnode;
    }

    public DNode<T> add(T data) {
        DNode<T> newnode = new DNode<>(tail, null, data);
        if (size==0) {
            head=newnode;
        } else {
            tail.setNext(newnode);
            newnode.setPrev(tail);
        }
        // unconditionally, we have a new tail
        // AND our size has increased by 1
        size++;        
        tail = newnode;
        return newnode;
    }

    @Override
    public String toString() {
        return "DLinkedList [head=" + head + ", tail=" + tail + ", size=" + size + "]";
    }
    /**
     * Returns null if list is empty
     * Otherwise last node
     * @return
     */
    public DNode<T> removeLast() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            DNode<T> n = tail;
            head = null;
            tail = null;
            size--;
            return n;
        }
        // only make it here if a normal list
        DNode<T> oldtail = tail;
        tail.getPrev().setNext(null);
        tail = tail.getPrev();
        size--;

        if (size == 1) {
            head = tail;
        }
        return oldtail;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
}
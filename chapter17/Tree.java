package chapter17;

public class Tree<E> {

    protected int size = 0;
    protected Node<E> root = null;

    public Tree(E rootData) {
        root = new Node<>(null, rootData);
        size = 1;
    }
    
}

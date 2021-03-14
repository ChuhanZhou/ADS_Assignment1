public class LinkedList<T> implements List<T> {

    private Node<T> head;
    private int size;

    public LinkedList()
    {
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addToFront(T data) {
        Node<T> newHead = new Node<>(data);
        newHead.setNext(head);
        head = newHead;
        size++;
    }

    @Override
    public T removeFirst() throws EmptyListException {
        if (size==0)
        {
            throw new EmptyListException();
        }
        else
        {
            T headData = head.getData();
            head = head.getNext();
            size--;
            return headData;
        }
    }
}

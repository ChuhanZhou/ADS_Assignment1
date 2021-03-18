import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NodeTest<T> {
    T data;
    Node node = new Node(data);
    Node<T> next;

    @Test
    public void setData() {
        T d = null;
        Node node = new Node(d);
        node.setData(d);
        assertEquals(d, node.getData());

    }

    @Test
    public void getData() {
        assertEquals(data, node.getData());
    }

    @Test
    public void setNext() {
        Node<T> n = new Node<T>(data);
        n.setNext(n);
        assertEquals(n, n.getNext());
    }

    @Test
    public void getNext() {

        assertEquals(next, node.getNext());
    }
}

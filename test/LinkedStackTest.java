import org.junit.jupiter.api.Assertions;
import org.junit.Test;


import java.util.EmptyStackException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LinkedStackTest<T> {
    LinkedList<T> list;
    LinkedStack<T> l = new LinkedStack<>();

    @Test
    public void isEmpty() {
        LinkedStack<T> l1 = new LinkedStack<>();

        assertEquals(l1.isEmpty(),l.isEmpty());
    }

    @Test
    public void push() {
        T elm = null;
        
        l.push(elm);
        assertEquals(null,l.pop());
    }

    @Test
    public void pop() throws EmptyStackException {
        Assertions.assertThrows(EmptyStackException.class, () -> {
          T elm1=null;

          l.push(elm1);

           l.pop();
           l.pop();
        });
    }
}

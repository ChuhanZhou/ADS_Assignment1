import org.graalvm.compiler.debug.Assertions;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LinkedListTest<T>
{
  Node<T> head;
  int size =5;

  LinkedList<T> l=new LinkedList<>();

  @Test
  public void isEmpty(){
    assertTrue(size==0);
  }

  @Test
  public void size() {
    assertEquals(size,l.size());
}
  public void addToFront() {

   T data =null;
    Node<T> newHead = new Node<>(data);
    newHead.setNext(head);
    head = newHead;
    assertEquals(data,newHead.getData());
  }

  public void removeFirst() throws EmptyListException
  {
    Assertions.assertThrows(EmptyListException.class, () -> {
      size = 0;
    });
  }
}

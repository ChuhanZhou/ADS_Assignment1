import org.graalvm.compiler.debug.Assertions;
import org.junit.Test;


import java.util.EmptyStackException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LinkedStackTest<T>
{
  LinkedList<T> list;
  LinkedStack<T> l=new LinkedStack<>();
  @Test
  public void isEmpty() {

    assertTrue(list.isEmpty());
  }

  @Test
  public void push() {
    T e=null;
    LinkedList<T> l=new LinkedList<>();
    list.addToFront(e);
    assertEquals(e,list.size());
  }

  @Test
  public void pop() throws EmptyStackException
  {
    Assertions.assertThrows(EmptyStackException.class,()->{
       list.removeFirst();
    });
  }
}

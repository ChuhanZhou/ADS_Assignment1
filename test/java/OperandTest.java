import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OperandTest
{
  int value=5;
  Operand operand=new Operand(value);
  @Test
  public void getValue(){
    assertEquals(value,operand.getValue());
  }
}

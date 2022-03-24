package com.mytechexp.junittest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class CalculatorTest {
   /*
   This substitutions can easily coded like below
   Calculator calc=new Calculator();
    DataSupplier supplier=new DataSupplier();
    DataSupplier suppliermock=mock(DataSupplier.class);*/
   @InjectMocks
    Calculator calc=new Calculator();
   @Mock
    DataSupplier suppliermock;
    @Test
    public void testCaluate() {
        int result = calc.add(new int[]{1, 2, 3});
        assertEquals(6, result);
    }
  /*
   Basic way of doing with actual method call
   @Test
    public void testCaluateWithStubSupplier(){
        int result=calc.add(supplier.getData());
        assertEquals(6,result);
    }*/
    @Test
    public void testCaluateWithMock() {
        when(suppliermock.getData()).thenReturn(new int[]{1,2});
        assertEquals(3, calc.addWithService());
    }
}

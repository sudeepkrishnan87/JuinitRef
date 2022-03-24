package com.mytechexp.junittest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class TestOnJavaList {
    List<String> list =mock(List.class);
    @Test
    public void simpleListMock()
    {
      when(list.size()).thenReturn(1);
      assertEquals(1,list.size());
    }
    @Test
    public void simpleListMockMultipleCall()
    {
        when(list.size()).thenReturn(1).thenReturn(2);
        assertEquals(1,list.size());
        assertEquals(2,list.size());
    }

    @Test
    public void simpleListMockWithGetters() {
        when(list.get(0)).thenReturn("test1");
        assertEquals("test1",list.get(0));
    }
    @Test
    public void simpleListMockWithAnyArgument() {
        when(list.get(anyInt())).thenReturn("test1");
        assertEquals("test1",list.get(100));
    }

    @Test
    public void verifytheMethodCalls()
    {
        list.get(1);
        verify(list).get(1);
        verify(list,times(1)).get(anyInt());

        list.get(2);
        verify(list).get(2);
        verify(list,times(2)).get(anyInt());

        verify(list,never()).get(100);
        verify(list,atLeastOnce()).get(anyInt());

    }
    /*
        Writing test case to capture the parameter passed
        * */
    @Test
    public void argumentCaptureTest()
    {
        list.add("test");

        ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
        verify(list).add(captor.capture());
        assertEquals("test",captor.getValue());
    }

    @Test
    public void multipleArgumentCaptureTest()
    {
        list.add("test");
        list.add("test2");
        ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
        verify(list,atLeastOnce()).add(captor.capture());
        List<String> capturedList=captor.getAllValues();
        assertEquals("test",capturedList.get(0));
        assertEquals("test2",capturedList.get(1));

    }

}

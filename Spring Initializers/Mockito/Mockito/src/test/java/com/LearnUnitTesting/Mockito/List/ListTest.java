package com.LearnUnitTesting.Mockito.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@SuppressWarnings("rawtypes")
class ListTest {

	@Test
	void multipleReturn() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(3).thenReturn(2);
		assertEquals(3,listMock.size());
		assertEquals(2,listMock.size());
		assertEquals(2,listMock.size());
	}
	
	@Test
	void specificParam() {
		List listMock = mock(List.class);
		when(listMock.get(0)).thenReturn("String1");
		assertEquals("String1",listMock.get(0));
		assertEquals(null,listMock.get(1));
	}

	@Test
	void genericParam() {
		List listMock = mock(List.class);
		when(listMock.get(Mockito.anyInt())).thenReturn("String1");
		assertEquals("String1",listMock.get(0));
		assertEquals("String1",listMock.get(1));
	}
}

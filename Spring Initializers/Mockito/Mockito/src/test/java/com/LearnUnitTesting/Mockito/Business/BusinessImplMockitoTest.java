package com.LearnUnitTesting.Mockito.Business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BusinessImplMockitoTest {

	@Mock
	DataService dataServiceMock;
	
	@InjectMocks
	BusinessImpl businessImpl;
	
	@Test
	void findGreatestOfData() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25,35,45,65});
		assertEquals(65,businessImpl.findTheGreatestFromAllData());
	}
	
	@Test
	void findGreatestOfOneData() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {65});
		assertEquals(65,businessImpl.findTheGreatestFromAllData());
	}
}

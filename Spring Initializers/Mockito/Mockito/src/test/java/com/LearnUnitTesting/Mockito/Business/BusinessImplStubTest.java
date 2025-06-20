package com.LearnUnitTesting.Mockito.Business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BusinessImplStubTest {

	@Test
	void findGreatestOfData() {
		DataServiceStub1 dataServiceStub1 = new DataServiceStub1();
		BusinessImpl businessImpl = new BusinessImpl(dataServiceStub1);
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(65,result);
	}
	
	@Test
	void findGreatestOfSingleData() {
		DataServiceStub2 dataServiceStub2 = new DataServiceStub2();
		BusinessImpl businessImpl = new BusinessImpl(dataServiceStub2);
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(65,result);
	}

}

class DataServiceStub1 implements DataService{
	@Override
	public int[] retrieveAllData() {
		return new int[] {25,35,45,65};
	}
}

class DataServiceStub2 implements DataService{
	@Override
	public int[] retrieveAllData() {
		return new int[] {65};
	}
}

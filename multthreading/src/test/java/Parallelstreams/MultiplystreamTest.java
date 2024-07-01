package Parallelstreams;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import learnjava.util.DataSet;

class MultiplystreamTest {
	Multiplystream m = new Multiplystream();
	@RepeatedTest(5)
	void multiplyusigstrema() {
		int size =100000;
		ArrayList <Integer> arrlist = DataSet.generateArrayList(size);
		List<Integer> resultList = m.multiplyusigstrema(arrlist);
		assertEquals(size,resultList.size());
	}

}

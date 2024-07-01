package Parallelstreams;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import learnjava.util.DataSet;

class ParallelstreamexampleTest {
	
	Parallelstreamexample parallelstreamexample = new Parallelstreamexample();

	@Test
	void stringTransform() {
		List<String> inputlist = DataSet.namesList();
		List<String> resultlist = parallelstreamexample.stringTransform(inputlist);
	
		assertEquals(4,resultlist.size());
		resultlist.forEach(name->assertTrue(name.contains("-")));
		
	}

}

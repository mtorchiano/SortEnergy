package it.polito.softeng.sort.test;

import it.polito.softeng.sort.PowerSortExperiment;
import junit.framework.TestCase;

public class testIntSortNamed extends TestCase {
	
	
	
	public void testQuick(){

		PowerSortExperiment pse = new PowerSortExperiment("quick",50000,PowerSortExperiment.SortingType.RANDOM1);
		pse.KEEP_RESULTS=true;
		pse.setMarkerLength(10);
		pse.runExperiment();
		
		assertAllSorted(pse);
		
	}

	public void testMerge(){
		PowerSortExperiment pse = new PowerSortExperiment("merge",50000,PowerSortExperiment.SortingType.RANDOM1);
		pse.KEEP_RESULTS=true;
		pse.setMarkerLength(10);
		pse.runExperiment();
		
		assertAllSorted(pse);
		
	}

	public void testBubble(){
		PowerSortExperiment pse = new PowerSortExperiment("bubble",5000,PowerSortExperiment.SortingType.RANDOM1);
		pse.KEEP_RESULTS=true;
		pse.setMarkerLength(10);
		pse.runExperiment();
		
		assertAllSorted(pse);
		
	}

	public void testCounting(){
		PowerSortExperiment.SortingType type = PowerSortExperiment.SortingType.values()[2];
		
		System.out.println(type);
			
		PowerSortExperiment pse = new PowerSortExperiment("counting",50000,PowerSortExperiment.SortingType.RANDOM1);
		pse.KEEP_RESULTS=true;
		pse.setMarkerLength(10);
		pse.runExperiment();
		
		assertAllSorted(pse);
		
	}

	
	public void testQuickSort(){

		PowerSortExperiment pse = new PowerSortExperiment("Quick Sort",50000,PowerSortExperiment.SortingType.RANDOM1);
		pse.KEEP_RESULTS=true;
		pse.setMarkerLength(10);
		pse.runExperiment();
		
		assertAllSorted(pse);
		
	}

	private void assertAllSorted(PowerSortExperiment experiment) {
		for(int i=0; i<experiment.results.length; ++i){
			int prev=-1;
			for(int j=0; j<experiment.results[i].length; ++j){
				assertTrue("Wrong order of element " + j + " in repica " + i,
							experiment.results[i][j]>=prev);
				prev = experiment.results[i][j];
			}
		}
	}

}

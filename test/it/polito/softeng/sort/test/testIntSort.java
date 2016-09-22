package it.polito.softeng.sort.test;
import java.util.Arrays;

import it.polito.softeng.sort.Bubblesort;
import it.polito.softeng.sort.Countingsort;
import it.polito.softeng.sort.IntSortAlgorithm;
import it.polito.softeng.sort.Mergesort;
import it.polito.softeng.sort.PowerSortExperiment;
import it.polito.softeng.sort.Quicksort;
import junit.framework.TestCase;

public class testIntSort extends TestCase {
	
	
	public void testMultiple(){
		
		class Ident extends IntSortAlgorithm{

			public void sort(int[] a) {
				// do nothing...
			}
			
		}
		
		Ident sorter = new Ident();

		PowerSortExperiment pse = new PowerSortExperiment(sorter,5,PowerSortExperiment.SortingType.SORTED);
		pse.KEEP_RESULTS=true;
		pse.setMarkerLength(10);
		
		
		pse.runExperiment();
		
		assertAllSorted(pse);	}
	
	public void testBIMerge(){
		class Merge extends IntSortAlgorithm{

			public void sort(int[] a) {
				Arrays.sort(a);
			}
			
		}
		
		IntSortAlgorithm sorter = new Merge();
		PowerSortExperiment pse = new PowerSortExperiment(sorter,50000,PowerSortExperiment.SortingType.RANDOM1);
		pse.KEEP_RESULTS=true;
		pse.setMarkerLength(10);
		pse.runExperiment();
		
		assertAllSorted(pse);
		
	}
	
	public void testQuick(){

		IntSortAlgorithm sorter = new Quicksort();
		PowerSortExperiment pse = new PowerSortExperiment(sorter,50000,PowerSortExperiment.SortingType.RANDOM1);
		pse.KEEP_RESULTS=true;
		pse.setMarkerLength(10);
		pse.runExperiment();
		
		assertAllSorted(pse);
		
	}

	public void testMerge(){
		IntSortAlgorithm sorter = new Mergesort();
		PowerSortExperiment pse = new PowerSortExperiment(sorter,50000,PowerSortExperiment.SortingType.RANDOM1);
		pse.KEEP_RESULTS=true;
		pse.setMarkerLength(10);
		pse.runExperiment();
		
		assertAllSorted(pse);
		
	}

	public void testBubble(){
		IntSortAlgorithm sorter = new Bubblesort();
		PowerSortExperiment pse = new PowerSortExperiment(sorter,5000,PowerSortExperiment.SortingType.RANDOM1);
		pse.KEEP_RESULTS=true;
		pse.setMarkerLength(10);
		pse.runExperiment();
		
		assertAllSorted(pse);
		
	}

	public void testCounting(){
		IntSortAlgorithm sorter = new Countingsort();
		PowerSortExperiment pse = new PowerSortExperiment(sorter,50000,PowerSortExperiment.SortingType.RANDOM1);
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

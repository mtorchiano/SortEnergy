package it.polito.softeng.sort.test;
import java.util.Arrays;

import it.polito.softeng.sort.Countingsort;
import junit.framework.TestCase;

public class testCounting extends TestCase {
	
	public void testBasic(){
		
		Countingsort s = new Countingsort();
	
		int[] a = {4,3,6,3,3,2};
			
		s.sort(a);
		
		System.out.println(Arrays.toString(a));
	}

}
